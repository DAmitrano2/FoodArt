package model.immagine;

public class ImmagineBean {

	private int idImmagine;
	private String pathName;
	private int idProdotto;
	
	public ImmagineBean() {
		this.idImmagine = -1;
	}

	public int getIdImmagine() {
		return idImmagine;
	}

	public void setIdImmagine(int idImmagine) {
		this.idImmagine = idImmagine;
	}

	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	public int getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}
}
