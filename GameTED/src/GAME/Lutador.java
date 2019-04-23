
package GAME;


import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Lutador {

	private int x, y;
	// private pois as cordenadas x,y são só do lutador

	private int dx, dy;
	// cordenadas para o deslocamento nas cordenadas.

	private int altura, largura;
	// para definir a posição da magia.
	
	private boolean isVisivel;

	private Image imagem;
	// Para mostrar a imagem do jogador

	private int golpe;
	
	private int score;
    
    private int soltarpower;
    
    //private String player1 = null;
    
    private int pontuação;
    
    	
	private List<Magia> magiaA;
	// capacidade do lutador soltar magia, usa <List> que é de alocamento
	// dinamico. adiciona os elementos substituindo vetor
	

	public Lutador() {
		// construtor para definir imagem e local do Lutador
		ImageIcon referencia = new ImageIcon("rec\\stparado.gif");
		// metodo para capturar a imagem da pasta rec - RecursodoJogo

		imagem = referencia.getImage();
		// imagem recebe o conteudo da pasta
		
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
		
		isVisivel = true;

		magiaA = new ArrayList<Magia>();
		// instanciando a lista de magias, nessa hora não usa List e sim
		// ArrayList com a mesma parametrização Magia, assim podendo adcionar
		// magias.

		this.x = 100;
		this.y = 180;
		// definição da altura e largura referenciado pelo tamanho da imagem
		
		this.pontuação = 0;
		
		
		
		/*while (player1 == null || player1.equals("")) {
			
		player1 = JOptionPane.showInputDialog("Qual o seu nome Jogador 1?");
	
		if (player1 == null || player1.equals("")) {
	
		JOptionPane.showMessageDialog(null,"Você não respondeu a pergunta Jogador 1.");
	
		 }
		}
		
	JOptionPane.showMessageDialog(null, "                 Bom Jogo ! \nSeu lutador é Shang Tshung - " + player1);	*/
		
	}
	
	public void mexer() {
		// dx e dy e o que eu adcionar para a movimentação
		
		// System.out.println(x + ", " +y);(descobrir cordenadas para o
		// personagem não passar o tamanho da tela

		x += dx;// -2 a 680.
		y += dy;// 1 a 200.

		if (this.x < 1) {
			x = 1;
		}

		if (this.x > 725) {
			x = 725;
		}
		if (this.y < 0) {
			y = 0;
		}

	    if (this.y > 2) {
			// controla as bordas da janela
			y = 180;
	    }

	}
	

	public void keyPressed(KeyEvent tecla) {
		// metodo que recebe as funçoes do teclado. Cada tecla tem um codigo
		// especifico da tabela ASCII..

		int codigo = tecla.getKeyCode();
		// recebe a tecla do metodo getKeyCode.
		
		
		/*if (codigo == KeyEvent.VK_SPACE) {
			soltaMagia();
			
		}*/
		
		/*if (codigo == KeyEvent.VK_J) {
			ImageIcon referencia = new ImageIcon("rec\\stsoltarmagia.png");
			imagem = referencia.getImage();	
			//decrementar do life do inimigo.	
		}*/
		
		if (tecla.getKeyCode() == KeyEvent.VK_SPACE) {
			if (tecla.isControlDown()){
				if (tecla.isShiftDown()){
			soltaMagia();
			ImageIcon referencia = new ImageIcon("rec\\stsoltarmagia.png");
			imagem = referencia.getImage();
			soltarpower = 15;
			
				}
			}
		}

		
		if (codigo == KeyEvent.VK_U) {
			ImageIcon referencia = new ImageIcon("rec\\stsocofraco.png");
			imagem = referencia.getImage();
			golpe = 20/20;
			score = 200/20;		
		}
		
		if (codigo == KeyEvent.VK_O) {
			ImageIcon referencia = new ImageIcon("rec\\stsocoforte.png");
			imagem = referencia.getImage();	
			golpe = 30/20;
			score = 200/20;
		}

		if (codigo == KeyEvent.VK_I) {
			ImageIcon referencia = new ImageIcon("rec\\stchutefraco.png");
			imagem = referencia.getImage();	
			golpe = 20/20;
			score = 250/20;			
		}
		
		if (codigo == KeyEvent.VK_P)  {
			ImageIcon referencia = new ImageIcon("rec\\stchuteforte.png");
			imagem = referencia.getImage();	
			golpe = 45/20;
			score = 250/20;
		}
		
		if (codigo == KeyEvent.VK_W) {
			// mexe nas cordenadas como em um eixo carteziano..
			ImageIcon referencia = new ImageIcon("rec\\stpulo.png");
			imagem = referencia.getImage();
			dy = -2;
		}

		if (codigo == KeyEvent.VK_S) {
			ImageIcon referencia = new ImageIcon("rec\\stagachado.png");
			imagem = referencia.getImage();
		    dy = 2;
		}
		if (codigo == KeyEvent.VK_A) {
			ImageIcon referencia = new ImageIcon("rec\\sttraz.gif");
			imagem = referencia.getImage();
			dx = -2;
		}

		if (codigo == KeyEvent.VK_D) {
			dx = 2;
			ImageIcon referencia = new ImageIcon("rec\\stfrente.gif");
			imagem = referencia.getImage();			
		}	
			
	}
	
	public void keyReleased(KeyEvent tecla) {
		// codigo para para o objeto anular o movimento infinito...

		int codigo = tecla.getKeyCode();
		
		if (codigo == KeyEvent.VK_SPACE) {
			ImageIcon referencia = new ImageIcon("rec\\stparado.gif");
			imagem = referencia.getImage();
			dy = 0;
			golpe = 0;
			score = 0;
		}
		
		if (codigo == KeyEvent.VK_I) {
			ImageIcon referencia = new ImageIcon("rec\\stparado.gif");
			imagem = referencia.getImage();
			dy = 0;	
			golpe = 0;
			score = 0;
		}
		
		if (codigo == KeyEvent.VK_U) {
			ImageIcon referencia = new ImageIcon("rec\\stparado.gif");
			imagem = referencia.getImage();
			dy = 0;	
			golpe = 0;
			score = 0;
	
		}
		
		if (codigo == KeyEvent.VK_O) {
			ImageIcon referencia = new ImageIcon("rec\\stparado.gif");
			imagem = referencia.getImage();
			dy = 0;
			golpe = 0;
			score = 0;
			
		}
		
		if (codigo == KeyEvent.VK_P) {
			ImageIcon referencia = new ImageIcon("rec\\stparado.gif");
			imagem = referencia.getImage();
			dy = 0;	
			golpe = 0;
			score = 0;
		}
		
		if (codigo == KeyEvent.VK_W) {
			
			ImageIcon referencia = new ImageIcon("rec\\stparado.gif");
			imagem = referencia.getImage();
			dy = 2;
			golpe = 0;
			score = 0;
		}
		if (codigo == KeyEvent.VK_S) {
			ImageIcon referencia = new ImageIcon("rec\\stparado.gif");
			imagem = referencia.getImage();
			dy = 2;
			golpe = 0;
			score = 0;
		}
      
		if (codigo == KeyEvent.VK_A) {
			ImageIcon referencia = new ImageIcon("rec\\stparado.gif");
			imagem = referencia.getImage();
			dx = 0;
			golpe = 0;
			score = 0;
		}

		if (codigo == KeyEvent.VK_D) {
			ImageIcon referencia = new ImageIcon("rec\\stparado.gif");
			imagem = referencia.getImage();
			dx = 0;
			golpe = 0;
			score = 0;
		}
	}
	
	public List<Magia> getMagiaA() {
		return magiaA;
	}
	
	public int getX() {
		// Get para pegar as cordenadas da image do lutador.
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		//Set para alterar as cordenadas da image do lutador.
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public Image getImagem() {
		return imagem;
	}
	
	public void setImagem(Image imagem) {
		this.imagem = imagem;
	}

	public boolean isVisivel() {
		return isVisivel;
	}
	
	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}
	
	public void soltaMagia(){
		this.magiaA.add(new Magia(x + largura , y + altura -120 ));
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, largura, altura);	
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public int getGolpe() {
		return golpe;
	}

	public void setGolpe(int golpe) {
		this.golpe = golpe;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setMagiaA(List<Magia> magiaA) {
		this.magiaA = magiaA;
	}

	public int getSoltarpower() {
		return soltarpower;
	}

	public void setSoltarpower(int soltarpower) {
		this.soltarpower = soltarpower;
	}

	public int getPontuação() {
		return pontuação;
	}

	public void setPontuação(int pontuação) {
		this.pontuação = pontuação;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}		
}

