package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	static Connection conn = null;
	
	public Conexao() {

	}

	public static Connection getConexaoMYSQL() throws SQLException{
		
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		String serverName = "localhost"; 
		String mydatabase = "sistemacorporativo";
		String porta = "3306";
		String username = "root";  
		String password = "baguvix1"; 
		String url = "jdbc:mysql://" + serverName +":" + porta + "/" + mydatabase+ "?useTimezone=true&serverTimezone=UTC&useSSL=false";
			
		conn = DriverManager.getConnection(url, username, password);	
		return conn;
	}
	
	public void closeConexaoMYSQL() {
		try {
			conn.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
