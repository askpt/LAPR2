package jogosolimpicos;

import listaligada.*;

public class Atleta {

  private String nome;
  private String codPais;
  private int numid;
  private static int num;
  private Pais pais;
  private Modalidade mod;
  private ListaLigada prova = new ListaLigada();
  
  	public Atleta(String nome, Modalidade mod, Pais pais){
  		
  		this.numid = ++num;
  	}
  	
  	public void setNome(String nome){
  		
  		this.nome = nome;
  	}
  	
  	public String getNome(){
  		
  		return nome;
  	}

  	
  	  	
}
