
package jogosolimpicos;

public class Disciplina {

	private Modalidade	mod;
	private String		nome;

	public Disciplina( String nome , Modalidade modalidade ) {

		setNome( nome );
		setModalidade( mod );
	}

	public void setNome( String nome ) {

		this.nome = nome;
	}

	public String getNome() {

		return nome;
	}

	public Modalidade getModalidade() {

		return mod;
	}

	public void setModalidade( Modalidade mod ) {

		this.mod = mod;

	}

	public String toString() {

		return String.format( "%s" , nome );
	}

}
