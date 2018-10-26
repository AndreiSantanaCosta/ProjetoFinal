package SistemaCorporativo;

public class PrestarContas {
	
	private int codigoConta;
	private String cartao;
	private String contaDoMes;
	private int status;
	private String contaCol;
	private Funcionario codigoFuncionario;
	
	public PrestarContas(int codigoConta, String cartao, String contaDoMes, int status, String contaCol,
			Funcionario codigoFuncionario) {
		super();
		this.codigoConta = codigoConta;
		this.cartao = cartao;
		this.contaDoMes = contaDoMes;
		this.status = status;
		this.contaCol = contaCol;
		this.codigoFuncionario = codigoFuncionario;
	}

	public int getCodigoConta() {
		return codigoConta;
	}

	public void setCodigoConta(int codigoConta) {
		this.codigoConta = codigoConta;
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	public String getContaDoMes() {
		return contaDoMes;
	}

	public void setContaDoMes(String contaDoMes) {
		this.contaDoMes = contaDoMes;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getContaCol() {
		return contaCol;
	}

	public void setContaCol(String contaCol) {
		this.contaCol = contaCol;
	}

	public Funcionario getCodigoFuncionario() {
		return codigoFuncionario;
	}

	public void setCodigoFuncionario(Funcionario codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}
	
	//comentario
	
}
