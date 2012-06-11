package dados;

public class Linguas {

	private String linguagem;
	private String jogosolimpicos;
	private String listagem;
	private String classificacao;
	private String posicao;
	private String nome;
	private String ouro;
	private String prata;
	private String bronze;
	private String atleta;
	private String modalidade;
	private String disciplina;
	private String pais;
	private String data;

	public Linguas(String linguagem, String jogosolimpicos, String listagem, String classificacao, String posicao, String nome, String ouro, String prata, String bronze, String atleta, String modalidade, String disciplina, String pais, String data) {

		this(linguagem);
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

	public Linguas(String linguagem) {

		setLinguagem(linguagem);
	}

	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}

	public void setJogosOlimpicos(String jogosolimpicos) {
		this.jogosolimpicos = jogosolimpicos;
	}

	public void setListagem(String listagem) {
		this.listagem = listagem;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setOuro(String ouro) {
		this.ouro = ouro;
	}

	public void setPrata(String prata) {
		this.prata = prata;
	}

	public void setBronze(String bronze) {
		this.bronze = bronze;
	}

	public String getAtleta() {
		return atleta;
	}

	public void setAtleta(String atleta) {
		this.atleta = atleta;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getLinguagem() {

		return linguagem;
	}

	public String getJogosOlimpicos() {

		return jogosolimpicos;
	}

	public String getListagem() {
		return listagem;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public String getPosicao() {
		return posicao;
	}

	public String getNome() {
		return nome;
	}

	public String getOuro() {
		return ouro;
	}

	public String getPrata() {
		return prata;
	}

	public String getBronze() {
		return bronze;
	}
}
