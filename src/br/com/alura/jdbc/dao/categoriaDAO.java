package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Categoria;

public class categoriaDAO {
	
	private Connection connection;
	
	public categoriaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Categoria> listar()throws SQLException {
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		String sql = "SELECT id, nome FROM CATEGORIA;";
		
		try(PreparedStatement psm = this.connection.prepareStatement(sql)){
			psm.execute();
			
			try(ResultSet rst = psm.getResultSet()){
				while(rst.next()) {
					Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
					
					categorias.add(categoria);
				}
			}
		}
		
		return categorias;
	}
}
