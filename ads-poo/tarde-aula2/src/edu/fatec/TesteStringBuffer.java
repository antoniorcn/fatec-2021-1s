package edu.fatec;

public class TesteStringBuffer {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println("Inicio do programa");
		StringBuffer texto = new StringBuffer("");
		// String texto = "";
		for (int i = 0; i < 100000; i++) { 
			texto.append(i);
			// texto += ".";
		}
		System.out.println(texto);
		long end = System.currentTimeMillis();
		long dif = end - start;
		System.out.printf("Demorou %5.2f segundos \n", dif / 1000.0);
		System.out.println("Fim do programa");
	}
}
