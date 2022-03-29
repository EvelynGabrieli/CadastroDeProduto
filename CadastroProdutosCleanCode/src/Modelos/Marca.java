package Modelos;

public class Marca {
	
	private String nomeMarca;
	
	private int preco;
	
	
	public String getNomeMarca() {
		return nomeMarca;
	}
	public Marca(String[] dados) {
		
		String [] nomeMarca = dados[3].split(":");
		String [] preco = dados[4].split(":");
		
		this.nomeMarca = nomeMarca[1].trim();
		this.preco = Integer.parseInt(preco[1].trim());

	}
	//Método do get
	public Marca() {
		super();
	}
	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}
	public int getPreco() {
		return preco;
	}
	public void setPreco(int i) {
		this.preco = i;
	}
	@Override
	public String toString() {
		return nomeMarca + ", Preço: " + preco;
	}
	
	

}