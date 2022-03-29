package Aplica��o;
//manipula��o do objeto

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import BancoDeDados.ManipulacaoArquivoTXT;
import BancoDeDados.ManipulacaoArquivoXML;
import Modelos.Marca;
import Modelos.Produto;
import Util.ListaDeProdutos;
import View.ViewCRUDProduto;



public class CRUDProduto {


	public static void SalvarProduto(BufferedReader reader) throws IOException, ParserConfigurationException, TransformerException, SAXException{ //Objeto criado sem utilizar o "new", e sim o static.

		Produto produto = new Produto();
		Marca marca = new Marca();

		String[] cadastroProduto = ViewCRUDProduto.ViewSalvarproduto(reader);
		
			 
		produto.setNome(cadastroProduto[0]);
		produto.setCategoria(cadastroProduto[1]);
		marca.setNomeMarca(cadastroProduto[2]);
		marca.setPreco(Integer.parseInt(cadastroProduto[3]));
		produto.setMarca(marca);
				
		ListaDeProdutos.getInstance().add(produto);
				

		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarArquivoXML();
		ViewCRUDProduto.ViewMsgFinal(0);



	}	

	//M�todo para mostrar a lista das informa��es que foram cadastradas


	public static void ListarProdutoSalvos() throws UnsupportedEncodingException, FileNotFoundException, ParserConfigurationException, SAXException, IOException {
		ListaDeProdutos.getInstance().clear();

		ManipulacaoArquivoXML.LerArquivoXML();

		ViewCRUDProduto.ViewListaDeProdutosEditada();
	}

	//M�todo para deletar a informa��o da lista
	public static void DeletarProduto(BufferedReader reader) throws NumberFormatException, IOException, TransformerException, ParserConfigurationException, SAXException{

		int indice = ViewCRUDProduto.ViewMenuListaIndexada("deletar", reader);

		ListaDeProdutos.getInstance().remove(indice);

		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.LerArquivoXML();
		ViewCRUDProduto.ViewMsgFinal(1);
	}


	//Op��o de editar alguma informa��o que est� na lista
	public static void EditarProduto (BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException, SAXException{

		int indice = ViewCRUDProduto.ViewMenuListaIndexada("editar", reader);
		String[] dadosEditados = {"",""};
		Produto produtos = ListaDeProdutos.getInstance().get(indice);

		dadosEditados = ViewCRUDProduto.ViewOpcaoEdicao(reader);
		

		switch(Integer.parseInt(dadosEditados[0])) {
		case 1:
			produtos.setNome(dadosEditados[1]);
			break;
		case 2:
			produtos.setCategoria(dadosEditados[1]);
			break;
		case 3:
			produtos.getMarca().setNomeMarca(dadosEditados[1]);
			break;
		case 4:
			produtos.getMarca().setPreco(Integer.parseInt(dadosEditados[1]));
			break;
			

	}

		ListaDeProdutos.getInstance().set(indice, produtos);
		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.LerArquivoXML();
		ViewCRUDProduto.ViewMsgFinal(2);


	}
}

