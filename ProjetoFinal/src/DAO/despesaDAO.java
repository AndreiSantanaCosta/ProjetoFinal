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
	
	private ArrayList<ContaDespesa> ArrayDespesas = new ArrayList<ContaDespesa>();
	ContaDespesa despesaA = new ContaDespesa();
	public void saveDespesaArrayList(ContaDespesa despesa) {
		try{
			ArrayDespesas.add(despesa);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void inserirDespesa() {
		Conexao conection = new Conexao();
		try {
			this.getCodigoConta();
			PreparedStatement stmt = null;
			Connection con = conection.getConexaoMYSQL();
			
			//=> Query de INSERT
			String sql = "INSERT INTO conta_despesa (despesa_data, despesa_valor, despesa_descricao,"
					+ "despesa_conta_id, categoria_id)"
								+ "VALUES(?,?,?,?,?)";
			System.out.println(ArrayDespesas.size());
			for(int i = 0; i < ArrayDespesas.size(); i++ ) {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, ArrayDespesas.get(i).getDespesaData());
				stmt.setDouble(2, ArrayDespesas.get(i).getDespesaValor());
				stmt.setString(3, ArrayDespesas.get(i).getDespesaDescricao());
				stmt.setInt(4, despesaA.getContaId());
				stmt.setInt(5, ArrayDespesas.get(i).getCategoria());
				stmt.execute();
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
			String sql = "SELECT conta_id FROM presta_conta ORDER BY conta_id DESC LIMIT 0,1";
		
		try {
			Connection con = conection.getConexaoMYSQL();
			stmt = con.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				despesaA.setContaId(result.getInt(1));
			}
			
		}catch(SQLException e) {
			
			System.out.println(e);
			
		}catch (Exception e) {
			conection.closeConexaoMYSQL();
			System.out.println(e);
		}
	}
}
