package GAME;


import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Inimigo {

	private int x, y;
	// private pois as cordenadas x,y são do lutador1
	
	private int largura, altura;
	
	private int dx, dy;
	
	private Image imagem;
	
	private boolean isVisivel;
	
	//testar bloqueio
	private boolean bloq;
	
	//private String player2 = null;
	

	public Inimigo() {
		// construtor para definir imagem e local do Lutador.

		ImageIcon referencia = new ImageIcon("rec\\Iparado.gif");
		// metodo para capturar a imagem da pasta RecursodoJogo
       //antigo - ImageIcon referencia = new ImageIcon("rec\\Akuma.gif");
		imagem = referencia.getImage();
		// imagem recebe o conteudo da pasta.

		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
		
		this.x = 550;
		this.y = 40;
		//inicialização da variavel
        this.bloq = false;
		/*while (player2 == null || player2.equals("")) {
	
		player2 = JOptionPane.showInputDialog("Qual o seu nome Jogador 2?");
	
		if (player2 == null || player2.equals("")) {
	
		JOptionPane.showMessageDialog(null,"Você não respondeu a pergunta Jogador 2.");
	
		 }
	
		}
	
	JOptionPane.showMessageDialog(null, "                 Bom Jogo ! \nSeu lutador é Akuma - " + player2);*/
		
	}
	
	
	public void mexer() {
		// dx e dy e o que eu adcionar para a movimentação
		// System.out.println(x + ", " +y);(descobrir cordenadas para o
		// personagem não passar o tamanho da tela.

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
			// controla as bordas da janela..
			y = 180;
	    }
	    
	}

	public void keyPressed(KeyEvent tecla) {
		// metodo que recebe as funçoes do teclado. Cada tecla tem um codigo
		// especifico da tabela ASCII

		int codigo = tecla.getKeyCode();
		// recebe a tecla do metodo getKeyCode

		//if (codigo == KeyEvent.VK_SPACE) {
			// metodo para adicionar a tecla espaço a magia
			//soltarMagia();
		//}
        for(int i =0 ; i < 1; i++){
		if (codigo == KeyEvent.VK_UP) {
			// mexe nas cordenadas como em um eixo carteziano..
			dy = -2;
		}
        }

		if (codigo == KeyEvent.VK_DOWN) {
			dy = 2;
		}
		for(int i =0 ; i < 1; i++){
		if (codigo == KeyEvent.VK_LEFT) {
			ImageIcon referencia = new ImageIcon("rec\\Iandarfrente.gif");
			imagem = referencia.getImage();
			dx = -2;
		}
		}

		if (codigo == KeyEvent.VK_RIGHT) {
			ImageIcon referencia = new ImageIcon("rec\\Iandartraz.gif");
			imagem = referencia.getImage();
			dx = 2;
		}
		if (codigo == KeyEvent.VK_NUMPAD1) {
			ImageIcon referencia = new ImageIcon("rec\\akbloc.gif");
			imagem = referencia.getImage();
			dy = 2;
			bloq = true;
		}
	}

	public void keyReleased(KeyEvent tecla) {
		// codigo para para o objeto anular o movimento infinito

		int codigo = tecla.getKeyCode();
		
		if (codigo == KeyEvent.VK_UP) {
			ImageIcon referencia = new ImageIcon("rec\\Iparado.gif");
			imagem = referencia.getImage();
			dy = 0;
		}
		if (codigo == KeyEvent.VK_DOWN) {
			ImageIcon referencia = new ImageIcon("rec\\Iparado.gif");
			imagem = referencia.getImage();
			dy = 0;
		}
		if (codigo == KeyEvent.VK_LEFT) {
			ImageIcon referencia = new ImageIcon("rec\\Iparado.gif");
			imagem = referencia.getImage();
			dx = 0;
		}

		if (codigo == KeyEvent.VK_RIGHT) {
			ImageIcon referencia = new ImageIcon("rec\\Iparado.gif");
			imagem = referencia.getImage();
			dx = 0;
		}
		
		if (codigo == KeyEvent.VK_NUMPAD1) {
			ImageIcon referencia = new ImageIcon("rec\\Iparado.gif");
			imagem = referencia.getImage();
			dy = 0;
			bloq = false;
			
		}
	}
    

	public int getLargura() {
		return largura;
	}
	
	public int getAltura() {
		return altura;
	}


	public int getX() {
		// Get para pegar as cordenadas e image do lutador
		return x;
	}

	public int getY() {
		return y;
	}
    
	
	public void setX(int x) {
		this.x = x;
	}

	public Image getImagem() {
		return imagem;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, largura, altura);
		
	}
	public boolean isVisivel() {
		return isVisivel;
	}
	
	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}


	public void setY(int y) {
		this.y = y;
	}


	public boolean isBloq() {
		return bloq;
	}


	public void setBloq(boolean bloq) {
		this.bloq = bloq;
	}
	

}

