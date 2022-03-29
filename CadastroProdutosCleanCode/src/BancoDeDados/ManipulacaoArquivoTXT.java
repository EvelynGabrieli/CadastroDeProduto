package BancoDeDados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import Modelos.Produto;
import Util.ListaDeProdutos;


public class ManipulacaoArquivoTXT {
	private static String nomeDoArquivo = "ProdutosCadastrados.txt";

	public static void SalvarArquivoTXT() throws IOException { //Escreve e salva as informa��es do usuario no TXT

		try(BufferedWriter buffer = new BufferedWriter(new FileWriter(nomeDoArquivo));
				PrintWriter pw = new PrintWriter(buffer)){
			for(Produto a: ListaDeProdutos.getInstance()) {
				pw.println(a);
			}

		}
	}
	//Esse metodo ele tem a fun��o de ler e carregar na lista
	public static void LerArquivoTXT() throws FileNotFoundException, IOException {


		try(FileWriter arq = new FileWriter(nomeDoArquivo, true)){};

		String line;

		try(BufferedReader reader = new BufferedReader(new FileReader(nomeDoArquivo)))  { 

			while((line = reader.readLine())!= null && !"" .equals(line)) { //A fun��o dele � comparar objetos, para ver se est� em branco ou vazia
				Produto produto = new Produto(line);
				ListaDeProdutos.getInstance().add(produto);
			}
		} 


	}

}
