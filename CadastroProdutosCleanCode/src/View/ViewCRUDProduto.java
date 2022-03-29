package View;

import java.io.BufferedReader;
import java.io.IOException;



import Modelos.Produto;

import Util.ListaDeProdutos;

public class ViewCRUDProduto {
	//Menu para o usuario escolher a opção desejada
	public static int ViewMenuPrincipal(BufferedReader reader) throws NumberFormatException, IOException {

		System.out.println("1- Cadastro de Produtos");
		System.out.println("2- Listar Produtos");
		System.out.println("3- Deletar Produto");
		System.out.println("4- Editar Produto");
		System.out.println("5- Sair");

		return Integer.parseInt(reader.readLine());		

	}
	//
	public static String[] ViewSalvarproduto(BufferedReader reader) throws IOException {
		String[] menuProduto = {"Nome do Produto", "Categoria", "Marca" ,  "Preço"};

		String[] cadastroProduto = {"", "", "", ""};

		for(int i=0; i<cadastroProduto.length; i++) {
			System.out.println(menuProduto[i]);
			cadastroProduto[i] = reader.readLine();

		}
		return cadastroProduto;
	}
	//Para escolher o qual produto cadastrado na lista que deseja excluir ou deletar
	public static int ViewMenuListaIndexada (String editar_deletar, BufferedReader reader) throws NumberFormatException, IOException {
		for(int i=0;i<ListaDeProdutos.getInstance().size();i++)
			System.out.println(i+" - " + ListaDeProdutos.getInstance().get(i));

		System.out.println();
		System.out.println("Dentre a lista acima, escolha que deseja " + editar_deletar);

		return Integer.parseInt(reader.readLine());


	}
	//Se a opção for editar, nesse campo o usuario deve escolher qual atributo que deseja alterar e digitar o novo valor
	public static String[] ViewOpcaoEdicao(BufferedReader reader) throws IOException {
		String[] dadosEditados = {"",""};

		System.out.println("Escolha o atributo que deseja alterar: ");
		System.out.println("1 - Nome do produto");
		System.out.println("2 - Categoria");
		System.out.println("3 - Marca");
		System.out.println("4 - Preço");


		dadosEditados[0] = reader.readLine();                                                                     
		System.out.println("Escreva o novo valor do atributo: ");
		dadosEditados[1] = reader.readLine();

		return dadosEditados;
	}

	//Nesse campo mostra a lista pronta para o leitor
	public static void ViewListaDeProdutosEditada() {

		for(Produto a: ListaDeProdutos.getInstance()) {
			System.out.println("-------------Produto-------------");
			System.out.println("Nome: " + a.getNome());
			System.out.println("Categoria: " + a.getCategoria());
			System.out.println("Marca: " +  a.getMarca().getNomeMarca());		
			System.out.println("Preço:" + a.getMarca().getPreco());			
			System.out.println("------------------------------");

		}

	}

	//Método para mostrar uma mensagem quando encerra cada opção
	public static void ViewMsgFinal(int op) {


		String[] msgFinal = {"Produto cadastrado com sucesso!",
				"Produto deletado com sucesso!",
				"Produto editado com sucesso!",
		"Fim do programa"};

		System.out.println(msgFinal[op]);

	}
}

