package SistemaCorporativo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Funcionario {
	
	private int codigoFuncionario;
	private String nome;
	private int idade;
	private String cpf;
	private String rg;
	private int perfilFuncionario;
	private int responsavel;
	private String email;
	private String senha;
	private String dataCadastro;
	
	public Funcionario(String nome, String cpf, String rg, int perfilFuncionario, int responsavel, String email,
			String senha) {
		
		this.nome = nome;
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

	public int getPerfilFuncionario() {
		return perfilFuncionario;
	}

	public void setPerfilFuncionario(int perfilFuncionario) {
		this.perfilFuncionario = perfilFuncionario;
	}

	public int getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(int responsavel) {
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
	
	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String data) {
		this.dataCadastro = data;
	}
	
	//=>Insert de Funcionario
	public void insertFuncionario(Connection conn) {
		//=> Query de INSERT
		
		String sql = "INSERT INTO "
						+ "funcionario"
							+ "VALUES(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, getNome());
			stmt.setString(2, getEmail());
			stmt.setString(3, getSenha());
			stmt.setString(4, getRg());
			stmt.setString(5, getDataCadastro());
			stmt.setInt(6, getResponsavel());
			stmt.setString(7, getCpf());
			stmt.setInt(8, getPerfilFuncionario());
			stmt.execute();
		}catch(SQLException e) {
			System.out.println(e.getErrorCode() + "\n" + e.getMessage() + "\n" + e.getCause());
		}
		
	}
	
}
