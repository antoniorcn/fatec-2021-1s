package edu.fatec;

public class TesteStrings {
	
	public static void main(String[] args) {
		
		String a = "A";    // "A"
		String b = "B";
		String c = a;
		String d = "A";    // "A"
		String e = d + ""; // "A"
		String f = "A";
		
		if (a == e) { 
			System.out.println("A � igual a E");
		} else { 
			System.out.println("A � diferente de E");
		}
		
	}

}
