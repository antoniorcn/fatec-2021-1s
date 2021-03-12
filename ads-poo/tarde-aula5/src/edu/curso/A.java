package edu.curso;

import outro.pacote.B;

class A extends B {
	
	public void foo() { 
		System.out.println("foo() da classe A");
		this.j = 11;
	}

}
