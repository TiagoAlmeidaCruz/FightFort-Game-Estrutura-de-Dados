package GAME;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
// importação do java pacode de janelas estendidas
//importação do java pacode para colocar botoes

public class Janelas extends JFrame {
	// Construtor, incluir todas as telas do game. Jframe da classe Swing para trabalhar com as imagens 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Janelas() {
		
		JMenuBar barraMenu = new JMenuBar();
		
		JMenu menu = new JMenu("Menu");
		
		JMenuItem sobre = new JMenuItem("Sobre");
		
		JMenuItem controles = new JMenuItem("Controles");
		
		sobre.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Game Fight TED, desenvovido por Tiago Almeida", "Informações", JOptionPane.INFORMATION_MESSAGE);
			}		
			
		});
		
		controles.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ImageIcon i = new ImageIcon("rec/controlesf.png");  
				JLabel label = new JLabel(i);  
				JOptionPane.showMessageDialog(null,label , "Controles", 1);  			
			}		
			
		});

		JMenuItem sair = new JMenuItem("Sair");
		sair.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				System.exit(0);;}	
		});
		

	
		menu.add(sobre);
		menu.add(new JSeparator());
		menu.add(controles);
		menu.add(new JSeparator());
		menu.add(sair);
		barraMenu.add(menu);
		
		setJMenuBar(barraMenu);
		
		add(new Fase());
   
		setTitle("FightED");
		// titulo da janela. não tem tipo pois esta dentro do construtor e
		// implicitamente tem .this.

		setResizable(false);
		// Para o usuario não maximizar ou diminuir a tela

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// metodo que feixa a janela da aplicação.
		
		setSize(800, 385);
		// Tamanhoda janela setSize(800, 336);

		setVisible(true);
		//visibilidade da janela
		setLocationRelativeTo(null);
		// local onde a janela vai aparecer (null aparece no centro)
	}

	public static void main(String[] args) {
		new Janelas();
		//criação do objeto janela
	

	}

}
