package dados;

import java.io.*;

@SuppressWarnings("serial")
public class Linguas implements Serializable {

	/**
	 * a string with language to be used.
	 */
	private String linguagem;
	/**
	 * a string with the title of the html page.
	 */
	private String jogosolimpicos;
	/**
	 * a string with the listing for the head table.
	 */
	private String listagem;
	/**
	 * a string with the classification for the head table.
	 */
	private String classificacao;
	/**
	 * a string with the position for the presentation table.
	 */
	private String posicao;
	/**
	 * a string with the name for the presentation table.
	 */
	private String nome;
	/**
	 * a string with the gold for the presentation table.
	 */
	private String ouro;
	/**
	 * a string with the silver for the presentation table.
	 */
	private String prata;
	/**
	 * a string with the bronze for the presentation table.
	 */
	private String bronze;
	/**
	 * a string with the of type of classification.
	 */
	private String atleta;
	/**
	 * a string with the of type of classification.
	 */
	private String modalidade;
	/**
	 * a string with the of type of classification.
	 */
	private String disciplina;
	/**
	 * a string with the of type of classification.
	 */
	private String pais;
	/**
	 * a string with the date name for the presentation table.
	 */
	private String data;

	/**
	 * Main constructor of the class Language. This constructor assigns the
	 * language that will be used to show on screen.
	 * 
	 * @param linguagem
	 *            sets the language
	 * @param jogosolimpicos
	 *            sets the word "Olympic Games" on another language depending on
	 *            the language
	 * @param listagem
	 *            sets the word "Listing" on another language depending on the
	 *            language
	 * @param classificacao
	 *            sets the word "Classification" on another language depending
	 *            on the language
	 * @param posicao
	 *            sets the word "Position" on another language depending on the
	 *            language
	 * @param nome
	 *            sets the word "Name" on another language depending on the
	 *            language
	 * @param ouro
	 *            sets the word "Gold" on another language depending on the
	 *            language
	 * @param prata
	 *            sets the word "Silver" on another language depending on the
	 *            language
	 * @param bronze
	 *            sets the word "Bronze" on another language depending on the
	 *            language
	 * @param atleta
	 *            sets the word "Athlete" on another language depending on the
	 *            language
	 * @param modalidade
	 *            sets the word "Sport" on another language depending on the
	 *            language
	 * @param disciplina
	 *            sets the word "Competition" on another language depending on
	 *            the language
	 * @param pais
	 *            sets the word "Country" on another language depending on the
	 *            language
	 * @param data
	 *            sets the word "Emission Date" on another language depending on
	 *            the language
	 */
	public Linguas(String linguagem, String jogosolimpicos, String listagem, String classificacao, String posicao, String nome, String ouro, String prata, String bronze, String atleta, String modalidade, String disciplina, String pais, String data) {

		setLinguagem(linguagem);
		setJogosOlimpicos(jogosolimpicos);
		setListagem(listagem);
		setClassificacao(classificacao);
		setPosicao(posicao);
		setNome(nome);
		setOuro(ouro);
		setPrata(prata);
		setBronze(bronze);
		setAtleta(atleta);
		setModalidade(modalidade);
		setDisciplina(disciplina);
		setPais(pais);
		setData(data);

	}

	/**
	 * Sets the language of the file.
	 * 
	 * @param linguagem
	 *            the language of the file.
	 */
	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}

	/**
	 * Sets the String Olympic Games on title of the page depending on the
	 * language.
	 * 
	 * @param jogosolimpicos
	 */
	public void setJogosOlimpicos(String jogosolimpicos) {
		this.jogosolimpicos = jogosolimpicos;
	}

	/**
	 * Sets the String listing depending on the language.
	 * 
	 * @param listagem
	 */
	public void setListagem(String listagem) {
		this.listagem = listagem;
	}

	/**
	 * Sets the String Classification depending on the language.
	 * 
	 * @param classificacao
	 */
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	/**
	 * Sets the String Position depending on the language.
	 * 
	 * @param posicao
	 */
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	/**
	 * Sets the String Emission Date depending on the language.
	 * 
	 * @param data
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * Gets the String Emission Date depending on the language.
	 * 
	 * @return data;
	 */
	public String getData() {
		return data;
	}

	/**
	 * Gets the String Name depending on the language.
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Sets the String Gold depending on the language.
	 * 
	 * @param ouro
	 */
	public void setOuro(String ouro) {
		this.ouro = ouro;
	}

	/**
	 * Sets the String Silver depending on the language.
	 * 
	 * @param prata
	 */
	public void setPrata(String prata) {
		this.prata = prata;
	}

	/**
	 * Sets the String Bronze depending on the language.
	 * 
	 * @param bronze
	 */
	public void setBronze(String bronze) {
		this.bronze = bronze;
	}

	/**
	 * Gets the String Athlete depending on the language.
	 * 
	 * @return athlete.
	 */
	public String getAtleta() {
		return atleta;
	}

	/**
	 * Sets the String Athlete depending on the language.
	 * 
	 * @param atleta
	 */
	public void setAtleta(String atleta) {
		this.atleta = atleta;
	}

	/**
	 * Gets the String Sport depending on the language.
	 * 
	 * @return sport
	 */
	public String getModalidade() {
		return modalidade;
	}

	/**
	 * Sets the String Sport depending on the language.
	 * 
	 * @param modalidade
	 */
	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	/**
	 * Gets the Competition String depending on the language.
	 * 
	 * @return competition.
	 */
	public String getDisciplina() {
		return disciplina;
	}

	/**
	 * Sets the String Competition depending on the language.
	 * 
	 * @param disciplina
	 */
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	/**
	 * Gets the String Country depending on the language.
	 * 
	 * @return country.
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * Sets the String Country depending on the language.
	 * 
	 * @param pais
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * Gets the language for the file.
	 * 
	 * @return language.
	 */
	public String getLinguagem() {

		return linguagem;
	}

	/**
	 * Gets the String Olympic Games depending on the language.
	 * 
	 * @return olympic games.
	 */
	public String getJogosOlimpicos() {

		return jogosolimpicos;
	}

	/**
	 * Gets the String Listing depending on the language.
	 * 
	 * @return listing.
	 */
	public String getListagem() {
		return listagem;
	}

	/**
	 * Gets the String Classification depending on the language.
	 * 
	 * @return classification.
	 */
	public String getClassificacao() {
		return classificacao;
	}

	/**
	 * Gets the String Position depending on the language.
	 * 
	 * @return position.
	 */
	public String getPosicao() {
		return posicao;
	}

	/**
	 * Gets the String Name depending on the language.
	 * 
	 * @return name.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Gets the String Gold depending on the language.
	 * 
	 * @return gold.
	 */
	public String getOuro() {
		return ouro;
	}

	/**
	 * Gets the String Silver depending on the language.
	 * 
	 * @return silver.
	 */
	public String getPrata() {
		return prata;
	}

	/**
	 * Gets the String Bronze depending on the language.
	 * 
	 * @return bronze.
	 */
	public String getBronze() {
		return bronze;
	}

	public String toString() {

		return String.format("%s", linguagem);
	}

}
