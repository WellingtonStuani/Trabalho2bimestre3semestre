package br.univel.classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ArquivoUrl {
	private static final String URL = "http://www.master10.com.py/lista-txt";

	public List<String> lerUrl() {
		List<String> lista = new ArrayList<String>();
		try {
		
			URL url = new URL(URL);
			try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
				String inputLine = null;
				while ((inputLine = in.readLine()) != null) {
					lista.add(inputLine);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException("nao conectou !", e);
		}
		return lista;
	}


	public static void main(String[] args) {
		ArrayList<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		lista.add(5);


		for (Integer i : lista) {
			System.out.println(i);
		}

		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}


		lista.forEach(e ->  {
			System.out.println(e);
			int i = e + 1;
			System.out.println(i);
		});



	}


}
