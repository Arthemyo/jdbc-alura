     package default_packge;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.ConnectionFactory;
import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.modelo.Produto;

public class TestaIncercaoEListagemDeProdutos {

	public static void main(String[] args) throws SQLException {
		
		Produto comoda = new Produto("CÔMODA", "CÔMODA VERTICAL");
		
		try (Connection connection = new ConnectionFactory().recuperaConexao()){
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			produtoDAO.salvarProduto(comoda);
			
			List<Produto> listaProdutos = produtoDAO.listarProduto();
			listaProdutos.stream().forEach(ip -> System.out.println(ip));
			
		} 
	}

}
