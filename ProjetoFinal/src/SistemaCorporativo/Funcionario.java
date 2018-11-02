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
	
	
	
}
