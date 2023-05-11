package default_packge;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.ConnectionFactory;
import br.com.alura.jdbc.dao.categoriaDAO;
import br.com.alura.jdbc.modelo.Categoria;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {
		
		try(Connection connection = new ConnectionFactory().recuperaConexao()){
			categoriaDAO categoriaDAO = new categoriaDAO(connection);
			List<Categoria> listaCategorias = categoriaDAO.listar();
			
			listaCategorias.stream().forEach(ip -> System.out.println(ip));
		}

	}

}
