package edu.fatec;

public class TesteStrings {

	public static void main(String[] args) {
		String s1 = "A";		// "A"
		String s2 = null;
		System.out.println(System.identityHashCode(s1));
		
		// s1 = null;
		String s3 = s1 + "";
		System.out.println(System.identityHashCode(s3));
		String s4 = "A";
		System.out.println(System.identityHashCode(s4));
		System.gc();
		
		
		if (s1.equals(s3)) { 
			System.out.println("S1 é igual a S2");
		} else {
			System.out.println("S1 é diferente de S2");	
		}

	}

}
