package edu.curso;

import java.util.Arrays;
import java.util.List;

public class ListaLigada<T extends List<Number>, T2> {
	class No { 
		No proximo;
		T carga;
		T2 carga2;
	}
	
	No raiz = new No();
	No temp = raiz;
	
	public void adicionar(T carga, T2 carga2) { 
		temp.proximo = new No();
		temp = temp.proximo;
		temp.carga = carga;
		temp.carga2 = carga2;
	}
	
	public void mostrarTudo() { 
		No tmp = raiz;
		while(tmp.proximo != null) {
			tmp = tmp.proximo;
			System.out.print(tmp.carga);
			System.out.print(" - ");
			System.out.println(tmp.carga2);
		}
	}
	
	
	public static void main(String[] args) {
		ListaLigada<List<Number>, String> lista = new ListaLigada<>();
		
		lista.adicionar(Arrays.asList(1.0f, 2.0f), "A");
		lista.adicionar(Arrays.asList(0, 1), "B");
		lista.adicionar(Arrays.asList(100l, 200l), "C");
		
		lista.mostrarTudo();
	}
}
