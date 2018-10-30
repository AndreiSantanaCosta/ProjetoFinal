package SistemaCorporativo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.*;
import javax.swing.JOptionPane;

import Conexao.Conexao;

public class Funcionario {
	
	private int codigoFuncionario;
	private String nome;
	private String cpf;
	private String rg;
	private int perfilFuncionario;
	private int responsavel;
	private String email;
	private String senha;
	private String dataCadastro;
	private String login;
	private Connection conn;
	private boolean verificaLogin;

	public Funcionario() {
		
	}
	
	public Funcionario(Connection conn) {
		this.conn = conn;
	}
	public Funcionario(String nome, String senha, String email, String login, String rg, String cpf, int responsavel, int perfil) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.perfilFuncionario = perfil;
		this.responsavel = responsavel;
		this.email = email;
		this.senha = senha;
		this.login = login;
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
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getLogin() {
		return login;
	}
	
	public boolean getVerificaLogin() {
		return verificaLogin;
	}

	public void setVerificaLogin(boolean verificaLogin) {
		this.verificaLogin = verificaLogin;
	}
	
	public void loginFuncionario( String login, String senha) {
		PreparedStatement stmt = null;
		try {
			String sql = "SELECT * FROM funcionario WHERE fun_login  = ? AND fun_senha = ?";
			stmt = this.conn.prepareStatement(sql);
			stmt.setString(1, login);
			stmt.setString(2, senha);
		
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				this.verificaLogin = true;
				setCodigoFuncionario(result.getInt(1));
				setNome(result.getString(2));
				setPerfilFuncionario(result.getInt(8));
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	//=>Insert de Funcionario
	public void insertFuncionario() {
		Conexao conection = new Conexao();
		
		//=> Query de INSERT
		String sql = "INSERT INTO funcionario (fun_nome, fun_senha, fun_login, fun_rg ,"
				+ "fun_cpf, fun_data_cadastro,fun_responsavel, fun_perfil, fun_email)"
							+ "VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			Connection con = conection.getConexaoMYSQL();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, getNome());
			stmt.setString(2, getSenha());
			stmt.setString(3, getLogin());
			stmt.setString(4, getRg());
			stmt.setString(5, getCpf());
			stmt.setString(6, "2018-01-01");
			stmt.setInt(7, getResponsavel());
			stmt.setInt(8, getPerfilFuncionario());
			stmt.setString(9, getEmail());
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Registrado com Sucesso");
			conection.closeConexaoMYSQL();
		}catch(SQLException e) {
			System.out.println(e.getErrorCode() + "\n" + e.getMessage() + "\n" + e.getCause());
		}
		
	}
	
}
