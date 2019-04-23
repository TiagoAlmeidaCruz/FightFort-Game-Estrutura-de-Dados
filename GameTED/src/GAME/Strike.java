package GAME;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;


import javax.swing.ImageIcon;


public class Strike {

	private int x, y;
	// private pois as cordenadas x,y são do lutador1

	private int dx, dy;
	// cordenadas para o deslocamento nas cordenadas
	
	private int altura, largura;
	// para definir a posição da magia.
	
	private boolean isVisivel;

	private Image imagem;
	
	private int golpe = 75/60;
	
	private int score = 750/91;
	
	private static final int LARGURA_TELA = 800;
	// Largura para não atravesar a tela (isso e uma Constante final).

	
	public Strike() {
		// construtor para definir imagem e local do Strike

		ImageIcon referencia = new ImageIcon("rec\\Liu.gif");
		// metodo para capturar a imagem da pasta RecursodoJogo
		imagem = referencia.getImage();
		// imagem recebe o conteudo da pasta
		
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);

		this.x = -200;
		this.y = 170;
		
		isVisivel = true;

	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public void mexer() {
	// dx e dy e o que eu adcionar para a movimentação

		x += dx;
		y += dy;
        
		if (this.x > LARGURA_TELA) {
			isVisivel = false;
		}
	}

	public void keyPressed(KeyEvent tecla) {
		// metodo que recebe as funçoes do teclado. Cada tecla tem um codigo
		// especifico da tabela ASCII

		//int codigo = tecla.getKeyCode();
		// recebe a tecla do metodo getKeyCode
		

		/*if (codigo == KeyEvent.VK_Z) {
			dx = 2;
		}*/	
		
	if (tecla.getKeyCode() == KeyEvent.VK_J) {
			if (tecla.isControlDown()){
				if (tecla.isAltDown()){
					dx = 2;
				}
			}
		}
	}

	
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub.		
	}
	
	public boolean isVisivel() {
		return isVisivel;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, largura, altura);	
	}

	public int getX() {
		// Get para pegar as cordenadas e image do lutador
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagem() {
		return imagem;
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

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
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

	public static int getLarguraTela() {
		return LARGURA_TELA;
	}

	public void setImagem(Image imagem) {
		this.imagem = imagem;
	}
	
	
	
}

