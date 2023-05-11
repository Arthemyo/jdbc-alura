package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		
		try(Connection con = connectionFactory.recuperaConexao();){
			con.setAutoCommit(false);
			PreparedStatement pst = null;
			try {
				pst = con.prepareStatement("DELETE FROM produto WHERE id > ?");
				
				pst.setInt(1, 2);
				pst.execute();
				
				Integer linhasModificadas = pst.getUpdateCount();
				
				System.out.println("Número de linhas modificadas: " + linhasModificadas);
				
				con.commit();
			} catch (Exception e) {
				e.printStackTrace();
				con.rollback();
			}finally {
				con.close();
			}
		}
		
	}

}
