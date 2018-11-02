package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Conexao.Conexao;
import SistemaCorporativo.ContaDespesa;

public class despesaDAO {
	
	private ArrayList<ContaDespesa> ArrayDespesas;
	ContaDespesa despesa;
	
	public void saveDespesaArrayList(ContaDespesa despesa) {
		ArrayDespesas.add(despesa);
	}
	
	public void inserirDespesa() {
		Conexao conection = new Conexao();
		try {
			this.getCodigoConta();
			PreparedStatement stmt = null;
			Connection con = conection.getConexaoMYSQL();
			
			//=> Query de INSERT
			String sql = "INSERT INTO conta_despesa (despesa_data, despesa_valor, despesa_descricao,"
					+ "despesa_conta_id, despesa_categoria)"
								+ "VALUES(?,?,?,?,?)";
			
			for(ContaDespesa despesaArray : ArrayDespesas) {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, despesaArray.getDespesaData());
				stmt.setDouble(2, despesaArray.getDespesaValor());
				stmt.setString(3, despesaArray.getDespesaDescricao());
				stmt.setInt(4, despesa.getContaId());
				stmt.setInt(5, despesaArray.getCategoria());
				stmt.executeQuery();
			}
			conection.closeConexaoMYSQL();
		}catch(Exception e) {
			conection.closeConexaoMYSQL();
			System.out.println(e);
		}
	}
	
	private void getCodigoConta() {
		Conexao conection = new Conexao();
		PreparedStatement stmt = null;		
		despesa = new ContaDespesa();
			String sql = "";
		
		try {
			Connection con = conection.getConexaoMYSQL();
			stmt = con.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				despesa.setContaId(result.getInt(1));
			}
			
		}catch(SQLException e) {
			
			System.out.println(e);
			
		}catch (Exception e) {
			conection.closeConexaoMYSQL();
			System.out.println(e);
		}
	}
}
