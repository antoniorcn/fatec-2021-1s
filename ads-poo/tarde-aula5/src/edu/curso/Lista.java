package edu.curso;

public class Lista<T> {
	class No<TNo> { 
		No<TNo> proximo;
		TNo carga;
	}
	
	private No<T> raiz;
	private No<T> temp;
	
	Lista() { 
		raiz = new No<T>();
		temp = raiz;
	}
	
	public void adicionar(T carga) { 
		temp.proximo = new No<T>();
		temp = temp.proximo;
		temp.carga = carga;
	}
	
	public void listarElementos() { 
		No<T> tmp = raiz.proximo;
		while (tmp != null) { 
			System.out.println(tmp.carga);
			tmp = tmp.proximo;
		}
	}
	
	
	public static void main(String[] args) {
		Lista<String> lista = new Lista<>();
		lista.adicionar("A");
		lista.adicionar("B");
		lista.adicionar("C");
		lista.listarElementos();
		
	}

}
