package edu.curso;

public class TesteNative {
	
	volatile String teste = "123";
	
	public native void computarDados(int i1, int i2, int i3);
	
	public void executar() { 
		System.out.println(teste);
		computarDados(40, 50, 90);
	}
	
	public static void main(String[] args) {
		TesteNative nat = new TesteNative();
		nat.executar();
	}

}
