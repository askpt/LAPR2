package jogosolimpicos;

public class CodigosPais {

	private int anoInicio;
	private int anoFim;
	private String codigo;

	public CodigosPais(String codigo, int anoInicio, int anoFim) {
		setCodigo(codigo);
		setAnoInicio(anoInicio);
		setAnoFim(anoFim);
	}

	public CodigosPais(String codigo, int ano) {
		this(codigo, ano, ano);
	}

	public int getAnoInicio() {
		return anoInicio;
	}

	public int getAnoFim() {
		return anoFim;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setAnoInicio(int anoInicio) {
		this.anoInicio = anoInicio;
	}

	public void setAnoFim(int anoFim) {
		this.anoFim = anoFim;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
