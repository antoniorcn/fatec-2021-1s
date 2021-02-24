package edu.fatec;

public class TesteBuffer {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		// String texto = "";
		StringBuffer  texto = new StringBuffer("");
		for (int i = 0; i < 31000; i++) { 
			// texto += i;
			texto.append(i);
		}
		long end = System.currentTimeMillis();
		System.out.println(texto);
		long dif = end - start;
		System.out.printf("Demorou %d milisegundos\n", dif);
	}
}
