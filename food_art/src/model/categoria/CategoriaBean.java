package model.categoria;

public class CategoriaBean {

	private int idCategoria;
	private String nome;
	
	public CategoriaBean() {
		this.idCategoria = -1;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
