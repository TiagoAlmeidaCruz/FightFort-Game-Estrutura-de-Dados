package GAME;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Magia {
	
	private int x, y;
	
	private Image imagem;
	private boolean isVisivel;
	private int largura, altura;
	private  static final int LARGURA_TELA = 800;
	private  static final int VELOCIDADE = 2;
	
	private int golpe = 60/5;
	
	private int score = 500;
	

	public Magia(int x, int y){
		this.x = x;
		this.y = y;
		
		ImageIcon referencia = new ImageIcon("rec\\stmagia.png");
		imagem = referencia.getImage();
		
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
		
		
		
		isVisivel = true;		
	}
	
	public void mexer(){
		
		this.x += VELOCIDADE;
		if(this.x > LARGURA_TELA){
			isVisivel = false;  
		}
		
	}

	public int getLargura() {
		return largura;
	}

	public int getAltura() {
		return altura;
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

	public int getX() {
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

	public static int getLarguraTela() {
		return LARGURA_TELA;
	}

	public static int getVelocidade() {
		return VELOCIDADE;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setImagem(Image imagem) {
		this.imagem = imagem;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	

}
