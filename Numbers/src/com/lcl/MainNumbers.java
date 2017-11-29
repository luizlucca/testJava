package com.lcl;
import java.util.Scanner;

public class MainNumbers {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);  // Leitura do console
		System.out.println("Enter a number A: ");
		Integer a = reader.nextInt(); // Leitura do numero A
		
		System.out.println("Enter a number B: ");
		Integer b = reader.nextInt(); // Leitura do numero B		
		reader.close(); 
		
		//processa os numeros de acordo com o descrito no exercicio 
		Integer result = processNumbers(a,b);
		
		System.out.println("Result: " + result );
		
	}

	/**
	 * A ideia eh converter os numeros em String e ir intercalando os caracteres.
	 * O tamanho a percorrer as strings dos numeros sempre eh o menor entre eles.
	 * Se sobrar caracters, pego o que sobrou do maior e concateno no valor a ser retornado (substring).
	 * 
	 * @param a Primeiro inteiro
	 * @param b Segundo inteiro
	 * @return O número de acordo com o descrito no exercicio
	 */
	private static Integer processNumbers(Integer a, Integer b) {
		String aStr = a.toString(); 
		String bStr = b.toString();
		String c="";
		
		if(aStr.length() < bStr.length()) {
			for(int i=0; i< aStr.length(); i++) {
				c += aStr.charAt(i);
				c += bStr.charAt(i);
			}
			c+= bStr.substring(aStr.length() , bStr.length());
		}
		else if(bStr.length() < aStr.length()) {
			for(int i=0; i< bStr.length(); i++) {
				c += aStr.charAt(i);
				c += bStr.charAt(i);
			}
			c+= aStr.substring(bStr.length() , aStr.length());
		}
		else {
			for(int i=0; i< bStr.length(); i++) {
				c += aStr.charAt(i);
				c += bStr.charAt(i);
			}
		}
		
		//Apos a intercalacao, transformo a String em numero. Se o numero > 1000000, retorna -1
		Integer cInt = Integer.parseInt(c);
		if(cInt>1000000) {
			return -1;
		}else {
			return cInt;
		}
	}
	
}
