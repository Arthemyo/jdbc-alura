package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Produto;

public class ProdutoDAO {
	
	private Connection connection;
	
	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void salvarProduto(Produto produto) throws SQLException {
		String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)";
		
		try(PreparedStatement pstm = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			
			pstm.execute();
			
			try(ResultSet rst = pstm.getGeneratedKeys()){
				
				while(rst.next()) {
					produto.setId(rst.getInt(1));
				}
				
			}
		}
	}
	
	public List<Produto> listarProduto() throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();
		
		String sql = "SELECT id, nome, descricao FROM PRODUTO";
		
		try(PreparedStatement pstm = this.connection.prepareStatement(sql)){
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()){
				while(rst.next()) {
					Produto product = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4));
					
					produtos.add(product);
				}
			}
		}
		
		return produtos;
		
	}
	
}
