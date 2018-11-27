package SistemaCorporativo;

public class PrestarContas {
	
	private int codigoConta;
	private String cartao;
	private String contaDoMes;
	private int status;
	private int codigoFuncionario;
	private int contaTipo;
	private Funcionario funcionario;
	private ContaDespesa despesa;
	private String perfilDescricao, statusDescricao;
	
	public PrestarContas(String cartao, String contaDoMes, int status,
			int codigoFuncionario, int contaTipo) {
		super();
		this.cartao = cartao;
		this.contaDoMes = contaDoMes;
		this.status = status;
		this.codigoFuncionario = codigoFuncionario;
		this.contaTipo = contaTipo;
	}
	
	public PrestarContas(Funcionario funcionario, String perfilDescricao, String statusDescricao, ContaDespesa despesa) {
		this.funcionario = funcionario;
		this.perfilDescricao = perfilDescricao;
		this.statusDescricao = statusDescricao;
		this.despesa = despesa;
	}
	
	public PrestarContas() {}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public ContaDespesa getDespesa() {
		return despesa;
	}

	public void setDespesa(ContaDespesa despesa) {
		this.despesa = despesa;
	}

	public String getPerfilDescricao() {
		return perfilDescricao;
	}

	public void setPerfilDescricao(String perfilDescricao) {
		this.perfilDescricao = perfilDescricao;
	}

	public String getStatusDescricao() {
		return statusDescricao;
	}

	public void setStatusDescricao(String statusDescricao) {
		this.statusDescricao = statusDescricao;
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

	public int getCodigoFuncionario() {
		return codigoFuncionario;
	}

	public void setCodigoFuncionario(int codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}
	
	public int getContaTipo() {
		return contaTipo;
	}

	public void setContaTipo(int contaTipo) {
		this.contaTipo = contaTipo;
	}
	
	//comentario
	
}
