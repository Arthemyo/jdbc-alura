package br.com.alura.jdbc;
import java.sql.SQLException;

public class TestaPoolConexoes {
	
	public static void main(String[] args) throws SQLException {
		ConnectionFactory conFactory = new ConnectionFactory();
		
		for (int i = 1; i < 20; i++) {
			conFactory.recuperaConexao();
			System.out.println("Conexão: " + i);
		}
	}
	
}
