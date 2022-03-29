package Modelos;

public class Produto {

		private String nome;
		private String categoria;
		private Marca marca;
		
		
		public Produto(String dados) {
			
			String[] atributos = dados.split(",");
			
			String[] nome = atributos[1].split(":");
			String[] categoria = atributos[2].split(":");
			
			Marca marcaProduto = new Marca(atributos);
			
			this.nome = nome[1].trim();
			this.categoria = categoria[1].trim();
			this.marca = marcaProduto;

		}
		public Produto() {
			
		}
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public String getCategoria() {
			return categoria;
		}
		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}
		public Marca getMarca() {
			return marca;
		}
		public void setMarca(Marca marca) {
			this.marca = marca;
		}
		@Override
		public String toString() {
			return  "Produto, Nome: " + nome + ", Categoria: " + categoria + ", Marca: " + marca;
		}
		
		
}
