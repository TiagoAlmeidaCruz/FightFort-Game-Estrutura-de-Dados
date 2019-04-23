package GAME;

public class Jogador implements Comparable<Jogador>{
	private String nome;
	private int pontua��o;
	
	public Jogador(String nome, int pontua��o){
		super();
		this.nome = nome;
		this.pontua��o = pontua��o;
		
	}
	
public int getPontua��o(){
	return pontua��o;
}	

public void setPontua��o(int pont){
	this.pontua��o = pont;
}

public String getNome(){
	return nome;
}

public void setNome(String name){
	this.nome = name;
}

public int compareTo(Jogador jogador) {
	// TODO Auto-generated method stub
	if(this.pontua��o<jogador.pontua��o){
		return 1;
	}
	else if(this.pontua��o>jogador.pontua��o){
		return -1;
		
	}
	return this.getNome().compareToIgnoreCase(jogador.getNome());
}

}
