package model.category;

public class CategoryBean {

	private int idCategoria;
	private String nome;
	private byte[] pathName;
	
	public CategoryBean() {
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
	
	public byte[] getPathName() {
		return pathName;
	}

	public void setPathName(byte[] pathName) {
		this.pathName = pathName;
	}
}
