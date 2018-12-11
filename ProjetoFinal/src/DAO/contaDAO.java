package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.sun.org.apache.bcel.internal.classfile.Code;

import Conexao.Conexao;
import SistemaCorporativo.ContaDespesa;
import SistemaCorporativo.Funcionario;
import SistemaCorporativo.PrestarContas;

public class contaDAO {
	private ArrayList<PrestarContas> selectJtable = new ArrayList<>();
	
	public boolean cadastrarConta(PrestarContas conta) {
		Conexao conection = new Conexao();
		
		//=> Query de INSERT
		String sql = "INSERT INTO presta_conta (conta_cartao, idmes_referencia, fun_id, status_id, conta_tipo) "
			+ "VALUES(?,?,?,?,?)";
		try {
			Connection con = conection.getConexaoMYSQL();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, conta.getCartao());
			stmt.setInt(2, conta.getIdMesReferencia());
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
	
	public void saveContaArrayList(PrestarContas conta) {
		try{
			selectJtable.add(conta);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public ArrayList<PrestarContas> selectContas() {
		ResultSet rs = null;
		Conexao conection = new Conexao();
		PrestarContas conta;
		PreparedStatement stmt = null;
		Funcionario func = null;
		ContaDespesa despesa = null;
		
		String sql = "select f.fun_id, f.fun_nome,Fp.perfil_descricao, Sc.status_descricao, sum(Cd.despesa_valor) as Valor, Pc.conta_tipo, Pc.conta_id" + 
				"	from presta_conta Pc" + 
				"	inner join status_conta Sc on Sc.status_id = Pc.status_id" + 
				"	inner join funcionario f on f.fun_id = Pc.fun_id" + 
				"	inner join funcionario_perfil Fp on Fp.perfil_id = f.fun_perfil" + 
				"	inner join conta_despesa Cd on Cd.despesa_conta_id = Pc.conta_id" +
				"   inner join mes_referencia Mf on Mf.id = Pc.idmes_referencia" +
				"	where Pc.status_id = 3	" +
				"	group by (Pc.conta_id);";
			
		try {
			Connection con = conection.getConexaoMYSQL();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				func = new Funcionario();
				func.setCodigoFuncionario(rs.getInt(1));
				func.setNome(rs.getString(2));
				
				despesa = new  ContaDespesa();
				despesa.setDespesaValor(rs.getDouble(5));
				int contaTipo = rs.getInt(6);
				conta = new PrestarContas(func, rs.getString(3), contaTipo ,rs.getString(4), despesa);
				conta.setCodigoConta(rs.getInt(7));
				saveContaArrayList(conta);
			}
		}catch(SQLException e) {
			
			System.out.println(e);
			
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			conection.closeConexaoMYSQL();
		}
		
		return selectJtable;
	}
	
	public ArrayList<PrestarContas> selectContasByFunId(int funId) {
		ResultSet rs = null;
		Conexao conection = new Conexao();
		PrestarContas conta;
		PreparedStatement stmt = null;
		ContaDespesa despesa = null;
		
		String sql = "select Pc.conta_id, Mf.descricao, Sc.status_descricao, sum(Cd.despesa_valor) as Valor, Pc.conta_tipo" + 
				"					from presta_conta Pc \r\n" + 
				"					inner join status_conta Sc on Sc.status_id = Pc.status_id" + 
				"					inner join conta_despesa Cd on Cd.despesa_conta_id = Pc.conta_id" +
				"					left join mes_referencia Mf on Mf.id = Pc.idmes_referencia" + 
				"				where Pc.fun_id = ?" + 
				"				group by (Pc.conta_id)";
			
		try {
			Connection con = conection.getConexaoMYSQL();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, funId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				conta = new PrestarContas();
				despesa = new  ContaDespesa();
				
				despesa.setDespesaValor(rs.getDouble(4));
				
				conta.setDespesa(despesa);
				int contaTipo = rs.getInt(5);
				conta.setContaTipo(contaTipo);
				conta.setCodigoConta(rs.getInt(1));
				conta.setContaDoMes(rs.getString(2));
				conta.setStatusDescricao(rs.getString(3));
				
				saveContaArrayList(conta);
			}
		}catch(SQLException e) {
			
			System.out.println(e);
			
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			conection.closeConexaoMYSQL();
		}
		
		return selectJtable;
	}
	
	public PrestarContas getDadosContaById(int idConta) {
		ResultSet rs = null;
		Conexao conection = new Conexao();
		PrestarContas conta = null;
		PreparedStatement stmt = null;
		Funcionario func = null;
		ContaDespesa despesa = null;
		
		String sql = "select f.fun_id, f.fun_nome,Fp.perfil_descricao, Sc.status_descricao, sum(Cd.despesa_valor) as Valor, Pc.conta_tipo, "
				+ "	Mf.descricao, Pc.conta_id" + 
				"	from presta_conta Pc" + 
				"	inner join status_conta Sc on Sc.status_id = Pc.status_id" + 
				"	inner join funcionario f on f.fun_id = Pc.fun_id" + 
				"	inner join funcionario_perfil Fp on Fp.perfil_id = f.fun_perfil" + 
				"	inner join conta_despesa Cd on Cd.despesa_conta_id = Pc.conta_id" +
				"   right join mes_referencia Mf on Mf.id = Pc.idmes_referencia" + 
				"	where Pc.conta_id = ?" + 
				"	group by (Pc.conta_id);";
			
		try {
			Connection con = conection.getConexaoMYSQL();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idConta);
			rs = stmt.executeQuery();
			while (rs.next()) {
				func = new Funcionario();
				func.setCodigoFuncionario(rs.getInt(1));
				func.setNome(rs.getString(2));
				
				despesa = new  ContaDespesa();
				despesa.setDespesaValor(rs.getDouble(5));
				int contaTipo = rs.getInt(6);
				conta = new PrestarContas(func, rs.getString(3), contaTipo ,rs.getString(4), despesa);
				conta.setContaDoMes(rs.getString(7));
				conta.setCodigoConta(rs.getInt(8));
			}
		}catch(SQLException e) {
			
			System.out.println(e);
			
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			conection.closeConexaoMYSQL();
		}
		
		return conta;
	}
	
	public String setAlteracaoStatusConta(int contaId, int status) {
		ResultSet rs = null;
		Conexao conection = new Conexao();
		PrestarContas conta;
		PreparedStatement stmt = null;
		Funcionario func = null;
		ContaDespesa despesa = null;
		
		String sql = "UPDATE presta_conta SET status_id = ? WHERE conta_id = ?";
			
		try {
			Connection con = conection.getConexaoMYSQL();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, status);
			stmt.setInt(2, contaId);
			stmt.execute();
			con.close();
			return "Alteração realizada com sucesso.";
		}catch(SQLException e) {
			System.out.println(e);
			return "Erro ao realizar operação. Conta-te o administrador do sistema";
		}catch (Exception e) {
			System.out.println(e);
			return "Erro ao realizar operação. Conta-te o administrador do sistema.";
		}finally {
			conection.closeConexaoMYSQL();
		}
	}
	
	
}
