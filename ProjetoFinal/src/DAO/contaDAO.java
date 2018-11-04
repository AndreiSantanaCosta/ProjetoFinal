package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.sun.org.apache.bcel.internal.classfile.Code;

import Conexao.Conexao;
import SistemaCorporativo.PrestarContas;

public class contaDAO {
	
	public boolean cadastrarConta(PrestarContas conta) {
		Conexao conection = new Conexao();
		
		//=> Query de INSERT
		String sql = "INSERT INTO presta_conta (conta_cartao, conta_mes, fun_id, status_id, conta_tipo) "
			+ "VALUES(?,?,?,?,?)";
		try {
			Connection con = conection.getConexaoMYSQL();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, conta.getCartao());
			stmt.setString(2, "2018-01-01");
			stmt.setInt(3, conta.getCodigoFuncionario());
			stmt.setInt(4, conta.getStatus());
			stmt.setInt(5, conta.getContaTipo());
			stmt.execute();
			con.close();
			JOptionPane.showMessageDialog(null, "Registrado com Sucesso");
			conection.closeConexaoMYSQL();
			return true;
		}catch(SQLException e) {
			System.out.println(e.getErrorCode() + "\n" + e.getMessage() + "\n" + e.getCause());
			return false;
		}
		
	}
}
