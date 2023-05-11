package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		

		try(Connection con = connectionFactory.recuperaConexao()){
			con.setAutoCommit(false);
			
			try(PreparedStatement pst = con.prepareStatement("INSERT INTO produto (nome, descricao) VALUES (?, ?)",
					Statement.RETURN_GENERATED_KEYS);) {
				
				
				adicionaVariavel("TV", "TV SAMSUNG", pst);
				adicionaVariavel("RELOGIO", "RELOGIO ROLEX", pst);
				
				con.commit();
				con.close();
		
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				con.rollback();
			}
		}
		
		
		
		
	}
	
	public static void adicionaVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {

		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		stm.execute();

		
		
		try(ResultSet rst = stm.getGeneratedKeys()){
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("Produto criado com ID: " + id);
			}
		}
		

	}

}
