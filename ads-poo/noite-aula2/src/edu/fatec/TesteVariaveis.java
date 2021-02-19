package edu.fatec;

public class TesteVariaveis {

	public static void main(String[] args) {
		int a = 10;
		float b = a;
		
		double c = 56.34530000000001; // 56.3453
		float e = (float)c;
		float f = 2342.43564f;
		int d = (int)c; // 56
		
		long l1 = 20;
		
		String s1 = "123";
		int i1 = Integer.parseInt(s1);
		
		int n1 = 123;
		String s2 = String.valueOf(n1);
		
		// TesteMemoria tm = new TesteMemoria();
		float z = TesteMemoria.PI;
	}

}
