package GAME;

public class Jogador implements Comparable<Jogador>{
	private String nome;
	private int pontuação;
	
	public Jogador(String nome, int pontuação){
		super();
		this.nome = nome;
		this.pontuação = pontuação;
		
	}
	
public int getPontuação(){
	return pontuação;
}	

public void setPontuação(int pont){
	this.pontuação = pont;
}

public String getNome(){
	return nome;
}

public void setNome(String name){
	this.nome = name;
}

public int compareTo(Jogador jogador) {
	// TODO Auto-generated method stub
	if(this.pontuação<jogador.pontuação){
		return 1;
	}
	else if(this.pontuação>jogador.pontuação){
		return -1;
		
	}
	return this.getNome().compareToIgnoreCase(jogador.getNome());
}

}
