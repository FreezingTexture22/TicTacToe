package SimpleTicTacToe;
import java.util.Scanner;  // Import the Scanner class

public class Stage2 {

	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		String symbols = "start";
		//symbols = input.next();
		//System.out.println("Input: " + symbols);
		//System.out.println("Input length: " + symbols.length());
		
		//Checking if input OK (contain only X, O and _ symbols).
		boolean ifInputOk = false;
		//System.out.println("ifInputOk = " + ifInputOk);
		
		while (ifInputOk == false) {
			symbols = input.next();
			
			for (int i = 0; i < symbols.length(); i++) {
				if (symbols.charAt(i) != 'X' && symbols.charAt(i) != 'O' && symbols.charAt(i) != '_') {
					System.out.println("Input = " + symbols);
					System.out.println("Wrong index at = " + i);
					
				} else {
					ifInputOk = true;
				}
				
				//System.out.println("IF stopped");
			}
			
			//System.out.println("FOR stopped");
			
		}
		
		System.out.println("---------");
		//System.out.println("WHILE stopped");
		
		//System.out.println("Input = " + symbols);
		//System.out.println("All is good!");
		
		/*
		char [] tictac = new char [9];
		
		for (int i = 0; i < symbols.length(); i++) {
			tictac[i] = symbols.charAt(i);
		}
		
		
		
		for (int i = 0; i < 9; i+=3) {
			System.out.print("| ");
			
			for (int k = 0; k < 3; k++) {
				System.out.print(tictac[i+k] + " ");
			}
				
			System.out.println("|");
		}
		
		*/
		
		/*
			for (int i = 0; i < 9; i+=3) {
				System.out.print("| ");
					for (int j = 0; j < 3; j++) {
					System.out.print(symbols.charAt(i+j));
						if (j < 2) {
							System.out.print(" ");
						}
				}
				System.out.println(" |");
			}
			
			*/
		
		
		System.out.println("| " + symbols.charAt(0) + " " + symbols.charAt(1) + " " + symbols.charAt(2) + " |");
		System.out.println("| " + symbols.charAt(3) + " " + symbols.charAt(4) + " " + symbols.charAt(5) + " |");
		System.out.println("| " + symbols.charAt(6) + " " + symbols.charAt(7) + " " + symbols.charAt(8) + " |");
		
		System.out.println("---------");

		
	}

	

}

