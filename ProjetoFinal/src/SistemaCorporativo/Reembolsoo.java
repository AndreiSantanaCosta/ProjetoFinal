package SistemaCorporativo;

public class Reembolsoo {
	
	private int conta;
	private String data;
	private double valorPago;
	private int categoria;
	private String descricao;
	private PrestarContas codigo;
	private int status;
	private int tipoconta;
	private int codigoFuncionario;
	
	public Reembolsoo(int conta, String data, double valorPago, int categoria, String descricao, PrestarContas codigo) {
		super();
		this.conta = conta;
		this.data = data;
		this.valorPago = valorPago;
		this.categoria = categoria;
		this.descricao = descricao;
		this.codigo = codigo;
	}
	
	public Reembolsoo(String contaDoMes, int status, int tipoconta, int codigofuncionario) {
		this.data = contaDoMes;
		this.status = status;
		this.tipoconta = tipoconta;
		this.codigoFuncionario = codigofuncionario;
	}
	
	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public PrestarContas getCodigo() {
		return codigo;
	}

	public void setCodigo(PrestarContas codigo) {
		this.codigo = codigo;
	}
}
