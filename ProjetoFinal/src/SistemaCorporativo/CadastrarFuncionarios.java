package SistemaCorporativo;

public class CadastrarFuncionarios {
	
	private int codigoFuncionario;
	private String nome;
	private int idade;
	private String cpf;
	private String rg;
	private String perfilFuncionario;
	private String responsavel;
	private String email;
	private String senha;

	public CadastrarFuncionarios(int codigoFuncionario, String nome, int idade, String cpf, String rg, String perfilFuncionario, String responsavel, String email,
			String senha) {
		
		this.codigoFuncionario = codigoFuncionario;
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.rg = rg;
		this.perfilFuncionario = perfilFuncionario;
		this.responsavel = responsavel;
		this.email = email;
		this.senha = senha;
	}
	

	public int getCodigoFuncionario() {
		return codigoFuncionario;
	}

	public void setCodigoFuncionario(int codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getPerfilFuncionario() {
		return perfilFuncionario;
	}

	public void setPerfilFuncionario(String perfilFuncionario) {
		this.perfilFuncionario = perfilFuncionario;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
