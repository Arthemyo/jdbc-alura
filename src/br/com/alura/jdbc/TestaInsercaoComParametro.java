package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.recuperaConexao();
		
		String nome = "TECLADO'";
		String desc = "TECLADO MECANICO); DELETE FROM PRODUTO;";
		
		PreparedStatement pst = con.prepareStatement("INSERT INTO produto (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
		
		pst.setString(1, nome);
		pst.setString(2, desc);
		
		pst.execute();
		
		ResultSet rst = pst.getGeneratedKeys();
		
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("Produto criado com ID: " + id);
		}
		
		con.close();

	}

}
