package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.recuperaConexao();
		con.setAutoCommit(false);
		
		PreparedStatement pst = con.prepareStatement("SELECT id, nome, descricao FROM produto");
		pst.execute();
		
		ResultSet rst = pst.getResultSet();
		
		while(rst.next()){
			Integer id = rst.getInt("ID");
			String nome = rst.getString("NOME");
			String desc = rst.getString("DESCRICAO");
			
			System.out.println("id: " + id);
			System.out.println("nome: " + nome);
			System.out.println("descricao: " + desc);
		}
		
		con.commit();
		
		con.close();
		pst.close();

	}

}
