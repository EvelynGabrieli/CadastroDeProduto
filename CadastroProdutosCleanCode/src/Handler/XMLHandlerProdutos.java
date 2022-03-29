package Handler;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import Modelos.Marca;
import Modelos.Produto;
import Util.ListaDeProdutos;



public class XMLHandlerProdutos extends DefaultHandler {
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	
	}

	private StringBuilder texto;
	Produto produtos;
	Marca marcas;


	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("produto")) {
			produtos = new Produto();
			marcas = new Marca();
		}else {
			texto = new StringBuilder();
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if(qName.equals("nome")){


			produtos.setNome(texto.toString());

		}else if (qName.equals("categoria")) {
			produtos.setCategoria(texto.toString());

		}else if (qName.equals("marcaNome")) {
			marcas.setNomeMarca(texto.toString());

		}else if (qName.equals("preco")) {
			
			marcas.setPreco(Integer.parseInt(texto.toString()));
			
			produtos.setMarca(marcas);
			
			
			ListaDeProdutos.getInstance().add(produtos);
		}


	}


	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		texto.append(ch, start, length);


	}

	@Override
	public void error(SAXParseException e) throws SAXException {

	}

}
