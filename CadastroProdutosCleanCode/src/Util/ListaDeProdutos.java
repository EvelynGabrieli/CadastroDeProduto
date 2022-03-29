package Util;

import java.util.ArrayList;
import java.util.List;

import Modelos.Produto;

public class ListaDeProdutos {

	private static List<Produto> ListaDeProdutos = new ArrayList<Produto>();
	public static List<Produto> getInstance(){
		return ListaDeProdutos;
	}
}

//Classe que faz a função da lista