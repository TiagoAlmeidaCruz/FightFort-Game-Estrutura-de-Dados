package GAME;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
//atualiza a tela

public class Fase extends JPanel implements ActionListener {
	// colocar o fundo no ConteinerDeJanelas..

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image fundo;
	private Timer timer;
	private Lutador lutadorA;
	private Inimigo inimigoA;
	private Strike nStrike;
	private boolean emJogo;	
	private int contreinicio =0;
	private Sound som;
	
	//pode ser na fase ou no lutador mais não atualiza coretamente o ranking.
	private String player1 = null;
	private String player2 = null;
	private int pontuaçãoP1 = 0;
	private int pontuaçãoP2 = 0;

	public static int LIFEINIMIGO = 300;
	
	public static int LIFELUTADOR = 300;
	
	public static int SCORELUTADOR = 0;

	public static int SCOREINIMIGO = 0;
	
	public static int POWERINIMIGO = 150;
	
	public static int POWERLUTADOR = 150;
	
	
	
	public Fase() {
		
		while (player1 == null || player1.equals("")) {
			
			player1 = JOptionPane.showInputDialog("Qual o seu nome Jogador 1?");
		
			if (player1 == null || player1.equals("")) {
		
			JOptionPane.showMessageDialog(null,"Você não respondeu a pergunta Jogador 1.");
		
			 }
			}
			
		JOptionPane.showMessageDialog(null, "                 Bom Jogo ! \nSeu lutador é Shang Tshung - " + player1);
		
		while (player2 == null || player2.equals("")) {
			
			player2 = JOptionPane.showInputDialog("Qual o seu nome Jogador 2?");
		
			if (player2 == null || player2.equals("")) {
		
			JOptionPane.showMessageDialog(null,"Você não respondeu a pergunta Jogador 2.");
		
			 }
		
			}
		
		JOptionPane.showMessageDialog(null, "                 Bom Jogo ! \nSeu lutador é Akuma - " + player2);

		setDoubleBuffered(true);
		// retirar risco das telas no delay

		setFocusable(true);
		// foca as imagens.

		addKeyListener(new TecladoAdapter());
		// toda vez que receber o teclado chama o adapter
        
		if(contreinicio == 0){
		ImageIcon referencia = new ImageIcon("rec\\fundo.gif");
		fundo = referencia.getImage();
        }
		emJogo = false;
		
		lutadorA = new Lutador();
		// instanciando o objeto lutador1;

		inimigoA = new Inimigo();

		nStrike = new Strike();
		
		som = new Sound("rec\\mkremix.wav");

		timer = new Timer(5, this);

		som.play();
		
		timer.start();
		// inicialização do timer.
	}

	public void paint(Graphics g) {
		// metodo para pintar a tela
		Graphics2D graficos = (Graphics2D) g;
		// Faz um Casting para ser utilizado
		
		if (emJogo) {
			
		graficos.drawImage(fundo, 0, 0, null);
		// 0 , 0 é o X e Y null imagem Estatica		
			
		ImageIcon foto = new ImageIcon("rec\\facetoface.png");	
	    graficos.drawImage(foto.getImage(), 320 , 3, null);
	
		graficos.drawImage(lutadorA.getImagem(), lutadorA.getX(),
				lutadorA.getY(), this);
		// criação e repintura do lutador

		graficos.drawImage(inimigoA.getImagem(), inimigoA.getX(),
				inimigoA.getY(), this);	
	   
		graficos.drawImage(nStrike.getImagem(), nStrike.getX(),
				nStrike.getY(), this);

		List<Magia> magiaA = lutadorA.getMagiaA();

		for (int i = 0; i < magiaA.size(); i++) {

			Magia m = (Magia) magiaA.get(i);
			graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
		}
			//Desenhar Nome LutadorA.
			graficos.setColor(Color.YELLOW);  
			graficos.setFont(new Font("Comic Sans MS",Font.BOLD,20));  
			graficos.drawString("Shang Tsung - "+getPlayer1(), 10, 40);
			
			//Desenhar Scores LutadorA..
			graficos.setColor(Color.YELLOW);  
			graficos.setFont(new Font("Comic Sans MS",Font.BOLD,20));  
			graficos.drawString("Scores:"+ SCORELUTADOR, 10, 90);

			//Desenhar POWER LutadorA
		    //POWER sem cor	
		    graficos.setColor(new Color(255,250,250)); //muda a cor!   
		    graficos.drawRect(10, 320, 150, 10); //desenha um retângulo sem preenchimento 
		  
		   // POWER com cor
		    graficos.setColor(new Color(30,144,255)); //   
		    graficos.fillRect(10, 320, POWERLUTADOR, 10);//Desenhando um retângulo preenchido!

		    //Desenhar Life LutadorA
		    //life sem cor	
		    graficos.setColor(new Color(255,250,250)); //muda a cor!   
		    graficos.drawRect(10, 50, 300, 20); //desenha um retângulo sem preenchimento 
		  
		   // life com cor
		    graficos.setColor(new Color(0,255,0)); //   
		    graficos.fillRect(310, 50, -300, 20);//Desenhando um retângulo preenchido! 
          
		  //_______________________________________________________________________________________  
		    
		  //Desenhar Nome InimigoA.
		    graficos.setColor(Color.YELLOW);  
		    graficos.setFont(new Font("Comic Sans MS",Font.BOLD,20));  
		  	graficos.drawString("Akuma - "+getPlayer2(), 480, 40);
		  	
		 //Desenhar Scores inimigoA.
		   graficos.setColor(Color.YELLOW);  
		   graficos.setFont(new Font("Comic Sans MS",Font.BOLD,20));  
		   graficos.drawString(SCOREINIMIGO +":Scores", 700, 90);	
		   
			//Desenhar POWER InimigoA
		    //POWER sem cor	
		    graficos.setColor(new Color(255,250,250)); //muda a cor!   
		    graficos.drawRect(630, 320, 150, 10); //desenha um retângulo sem preenchimento 
		  
		   // POWER com cor
		    graficos.setColor(new Color(30,144,255)); //   
		    graficos.fillRect(630, 320, POWERINIMIGO, 10);//Desenhando um retângulo preenchido!
		   
		    
		    //Desenhar Life InimigoA
		    //life sem cor
		    graficos.setColor(new Color(255,250,250)); //muda a cor!   
		    graficos.drawRect(480, 50, 300, 20); //desenha um retângulo sem preenchimento 
		    
		    // life com cor
		    graficos.setColor(new Color(0,255,0)); //   
		    graficos.fillRect(480, 50, LIFEINIMIGO , 20);//Desenhando um retângulo preenchido! 
		    //graficos.fillRect(310, 50, -300, 20);//Desenhando um retângulo preenchido!  
		    //valor negativo para o life cair da esquerda para a direita..
		    //10,50,300,20..

		   if (POWERLUTADOR <=0){
		       magiaA.clear();
		       POWERLUTADOR = 0;
		    } 
		}
		
		else{
			ImageIcon capaJogo = new ImageIcon("rec\\Capa.png");	
			graficos.drawImage(capaJogo.getImage(), 0 , 0, null);	
		}
		
		if (LIFEINIMIGO <=0){	

			emJogo = false;
			som.stop();
			ImageIcon lutadorWin = new ImageIcon("rec\\raking.png");	
			graficos.drawImage(lutadorWin.getImage(), 0 , 0, null);
			lutadorA.setDx(0);
			setPontuaçãoP1(SCORELUTADOR);
		
			graficos.setColor(Color.WHITE);  
			graficos.setFont(new Font("Comic Sans MS",Font.BOLD,28));  
			graficos.drawString(getPlayer1()+" - "+getPontuaçãoP1()+"- Scores", 420, 80);
			
			graficos.setColor(Color.RED);  
			graficos.setFont(new Font("Comic Sans MS",Font.BOLD,28));  
			graficos.drawString(getPlayer1()+" - "+getPontuaçãoP1()+"- Scores", 423, 80);
			  
		} 
		
		g.dispose();		
		// lipar proxima pintura.
	}
	
	//metodo static de interface Action Listener
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub mexe a nave
		// metodo obrigatorio para implemetar o ActionListener pois a interface
		// obriga
		// Atalho (alt s v)


		List<Magia> magiaA = lutadorA.getMagiaA();

		for (int i = 0; i < magiaA.size(); i++) {

			Magia m = (Magia) magiaA.get(i);

			if (m.isVisivel()) {
				m.mexer();
			} else {
				magiaA.remove(i);
			}
		}
				
		lutadorA.mexer();
		// ação do usuario

		inimigoA.mexer();

		nStrike.mexer();
        
		checarColisao();

		repaint();
		// cria a animação a imagem é repintada na tela, sobrepoe a imagem  antiga.
	}

	public void checarColisao() {
		Rectangle formaLutador = lutadorA.getBounds();
		Rectangle formaMagia;
		Rectangle formaStrike = nStrike.getBounds();
		Rectangle formaInimigo = inimigoA.getBounds();
				
		List<Magia> magiaA = lutadorA.getMagiaA();

		for (int i = 0; i < magiaA.size(); i++) {
			Magia tempMagia = magiaA.get(i);
			formaMagia = tempMagia.getBounds();
			
			if(formaMagia.intersects(formaInimigo)){
				//testar se o inimigo esta bloqueando.
				if(inimigoA.isBloq() == true){
				LIFEINIMIGO -= (tempMagia.getGolpe() - (tempMagia.getGolpe()*0.10)) ;
				SCORELUTADOR += tempMagia.getScore()/2;
				}else{
				LIFEINIMIGO -= tempMagia.getGolpe();
				SCORELUTADOR += tempMagia.getScore();
				}
				tempMagia.setVisivel(false);
				POWERLUTADOR-= lutadorA.getSoltarpower();
			}	
		} 
		
	   if(formaLutador.intersects(formaInimigo)){
		    //testar se o inimigo esta bloqueando
		    if(inimigoA.isBloq() == true){
		    LIFEINIMIGO -=  (lutadorA.getGolpe() - (lutadorA.getGolpe()*0.10));
		    SCORELUTADOR += (lutadorA.getScore() - (lutadorA.getScore()*0.10));
		    }else{
		    LIFEINIMIGO -=  lutadorA.getGolpe();
			SCORELUTADOR += lutadorA.getScore();	
		    }
		    
		    //metodo antigo para não ultrapassar
		    /*if(lutadorA.getX() >= inimigoA.getX()){
				inimigoA.setX(lutadorA.getX()+5);
			}*/
		   
		    //para não ultrapassar, e empurar o inimigo.
		    lutadorA.setX(lutadorA.getX() - 2);
			inimigoA.setX(inimigoA.getX() + 2);
			
		    formaLutador = new Rectangle(lutadorA.getX(), lutadorA.getY(),
					this.getWidth() - 10, this.getHeight());
			formaInimigo = new Rectangle(inimigoA.getX(), inimigoA.getY(),
					inimigoA.getLargura() - 10, inimigoA.getAltura());	   
		    }
	   
	   if(formaStrike.intersects(formaInimigo)){
		  //testar se o inimigo esta bloqueando
		   if(inimigoA.isBloq() == true){
		  LIFEINIMIGO -= (nStrike.getGolpe() - (nStrike.getGolpe()*0.10));
		  SCORELUTADOR += nStrike.getScore() - 2;
		   }else{
		  LIFEINIMIGO -= nStrike.getGolpe();
		  SCORELUTADOR += nStrike.getScore();			   
		   }
	   } 
	}
	
	private class TecladoAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub.
			
			if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){	
				emJogo = false;
				lutadorA = new Lutador();
				nStrike = new Strike();
				inimigoA = new Inimigo();
				LIFEINIMIGO = 300;
				LIFELUTADOR = 300;
				SCOREINIMIGO = 0;
				SCORELUTADOR = 0;
				POWERLUTADOR = 150;
				
				//tem que ser esse, pois o play continua de onde parou a musica e esse reinicia a tal.
				//tocarMusica(musica, 999);	
				
				//adiciona quantas vezes voi reiniciado
				contreinicio++;
                //escolhe pela quanrtidade de reinicio e muda o fundo.
				if(contreinicio == 1){
				ImageIcon referencia = new ImageIcon("rec\\fundo2.gif");
				fundo = referencia.getImage();
				som = new Sound("rec\\sfremix.wav");
				som.play();
				}
				
				if(contreinicio == 2){
					ImageIcon referencia = new ImageIcon("rec\\fundo3.gif");
					fundo = referencia.getImage();
					som = new Sound("rec\\Eminem - Survival.wav");
					som.play();
					}
				if(contreinicio == 3){
					ImageIcon referencia = new ImageIcon("rec\\fundo4.gif");
					fundo = referencia.getImage();
					som = new Sound("rec\\T.OK BEATS.wav");
					som.play();
					}
				if(contreinicio == 4){
					ImageIcon referencia = new ImageIcon("rec\\fundo.gif");
					fundo = referencia.getImage();
					contreinicio =0;
					som = new Sound("rec\\mkremix.wav");
					som.play();
					}
		
				
			}
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				emJogo = true;

				
				//para mostrar o Ranking de Jogadores Atualizado..
				List <Jogador> play = new ArrayList<Jogador>();
				play.add(new Jogador ("Braga",7000));
				play.add(new Jogador ("Gleison",5000));
				play.add(new Jogador ("Paulo",3000));
				play.add(new Jogador ("Liliana",6000));
				play.add(new Jogador (getPlayer1(),getPontuaçãoP1()));
				
				
				Collections.sort(play);
				System.out.println("---------------Ranking---------------:");
				for(Jogador p : play){
			    System.out.println("Jogador: "+p.getNome()+"  -  Tem: "+p.getPontuação()+"  -  Pontos.");

				}
				
				System.out.println("");

			
			}	
			lutadorA.keyPressed(e);
			inimigoA.keyPressed(e);
			nStrike.keyPressed(e);		
		}
		
		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			lutadorA.keyReleased(arg0);
			// pega o listener na fase e movimenta o personagem pelos eventos do teclado.
			inimigoA.keyReleased(arg0);
			nStrike.keyReleased(arg0);	
		}
	}

	public String getPlayer1() {
		return player1;
	}

	public void setPlayer1(String player1) {
		this.player1 = player1;
	}
	
	

	public String getPlayer2() {
		return player2;
	}

	public void setPlayer2(String player2) {
		this.player2 = player2;
	}

	public int getPontuaçãoP1() {
		return pontuaçãoP1;
	}

	public void setPontuaçãoP1(int pontuaçãoP1) {
		this.pontuaçãoP1 = pontuaçãoP1;
	}

	public int getPontuaçãoP2() {
		return pontuaçãoP2;
	}

	public void setPontuaçãoP2(int pontuaçãoP2) {
		this.pontuaçãoP2 = pontuaçãoP2;
	}
	
	
}