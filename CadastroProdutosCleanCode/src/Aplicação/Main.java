package Aplicação;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import View.ViewCRUDProduto;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException, SAXException {


		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		//Leitura da opção que o usuario escolher
		int menu = 0;
		while (menu != 5) {

			//Mostrar as opções do menu para que usuario coloque a opção desejada
			menu = ViewCRUDProduto.ViewMenuPrincipal(reader);

			switch (menu) {
			case 1:
				CRUDProduto.SalvarProduto(reader);
				break;

			case 2:
				CRUDProduto.ListarProdutoSalvos();
				break;

			case 3:
				CRUDProduto.DeletarProduto(reader);
				break;

			case 4:
				CRUDProduto.EditarProduto(reader);
				break;
			case 5:
				ViewCRUDProduto.ViewMsgFinal(3);
			}

		}

	}
}
