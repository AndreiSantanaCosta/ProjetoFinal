package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Conexao.Conexao;
import SistemaCorporativo.Funcionario;

public class funcionarioDAO {
	
	public void loginFuncionario(Funcionario funcionario) {
		Conexao conection = new Conexao();
		PreparedStatement stmt = null;
		try {
			Connection con = conection.getConexaoMYSQL();
			String sql = "SELECT * FROM funcionario WHERE fun_login  = ? AND fun_senha = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, funcionario.getLogin());
			stmt.setString(2, funcionario.getSenha());
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				funcionario.setVerificaLogin(true);
				funcionario.setCodigoFuncionario(result.getInt(1));
				funcionario.setNome(result.getString(2));
				funcionario.setRg(result.getString(5));
				funcionario.setCpf(result.getString(6));
				funcionario.setPerfilFuncionario(result.getInt(8));
				funcionario.setEmail(result.getString(9));
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	//=>Insert de Funcionario
	public void insertFuncionario(Funcionario funcionario) {
		Conexao conection = new Conexao();
		
		//=> Query de INSERT
		String sql = "INSERT INTO funcionario (fun_nome, fun_senha, fun_login, fun_rg ,"
				+ "fun_cpf,fun_responsavel, fun_perfil, fun_email)"
							+ "VALUES(?,?,?,?,?,?,?,?)";
		try {
			Connection con = conection.getConexaoMYSQL();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getSenha());
			stmt.setString(3, funcionario.getLogin());
			stmt.setString(4, funcionario.getRg());
			stmt.setString(5, funcionario.getCpf());
			stmt.setInt(6, funcionario.getResponsavel());
			stmt.setInt(7, funcionario.getPerfilFuncionario());
			stmt.setString(8, funcionario.getEmail());
			stmt.execute();
			con.close();
			JOptionPane.showMessageDialog(null, "Registrado com Sucesso");
			conection.closeConexaoMYSQL();
		}catch(SQLException e) {
			System.out.println(e.getErrorCode() + "\n" + e.getMessage() + "\n" + e.getCause());
		}
		
	}
}
