package br.com.alura.jdbc.modelo;

public class Produto {
	
	private int id;
	private String descricao;
	private String nome;
	private int categoria;
	
	public Produto(Integer id, String nome, String descricao, int categoria) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.setCategoria(categoria);
	}
	
	public Produto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

	public void setId(int id) {
		this.id = id;
		System.out.println(this.id);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("O produto é: %d %s %s", this.id, this.nome, this.descricao);
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
	
}
