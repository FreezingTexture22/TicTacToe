package SimpleTicTacToe;

import java.util.InputMismatchException;
import java.util.Scanner; // Import the Scanner class

/*

The program should work as follows:

Get the initial 3x3 grid from the input as in the previous stages. 
Here the user should input 9 symbols representing the field, for example, _XXOO_OX_.

Output this 3x3 grid as in the previous stages.

Prompt the user to make a move. The user should input 2 coordinate numbers 
that represent the cell where they want to place their X, for example, 1 1.

Analyze user input. If the input is incorrect, inform the user why their input is wrong:
- Print This cell is occupied! Choose another one! if the cell is not empty.
- Print You should enter numbers! if the user enters non-numeric symbols in the coordinates input.
- Print Coordinates should be from 1 to 3! if the user enters coordinates outside the game grid.

Keep prompting the user to enter the coordinates until the user input is valid.

If the input is correct, update the grid 
to include the user's move and print the updated grid to the console.

To summarize, you need to output the field 2 times: 
1) before the user's move (based on the first line of input) and 
2) after the user has entered valid coordinates (then you need to update the grid to include that move).

*/

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String symbols = "start";
		char[][] xoxo = new char[3][3];

		// Checking if input OK (contain only X, O and _ symbols).
		boolean inputOk = false;

		while (inputOk == false) {
			symbols = input.next().replace('_', ' ');

			// Loop for symbols check - X, O or _ . If NOT - awaiting for new input
			for (int i = 0; i < symbols.length(); i++) {
				if (symbols.charAt(i) != 'X' && symbols.charAt(i) != 'O' && symbols.charAt(i) != ' ') {
					break;
				} else {
					inputOk = true;
				}

			}

		}

		// filling initial array
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				xoxo[i][j] = symbols.charAt((i * 3) + j);

			}

		}

		// Grid print start (1st print)
		System.out.println("---------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				System.out.print(xoxo[i][j] + " ");
			}
			System.out.println("|");
		}
		System.out.println("---------");
		// Grid print end (1st print)

		// input of 2 coordinate numbers
		Scanner CoordinateInput = new Scanner(System.in);
		boolean isOccupied = true;
		String yCellString;
		String xCellString;
		int xCell = 0;
		int yCell = 0;

		boolean yIsNumber = false;
		boolean xIsNumber = false;
//		boolean isWithinRange = false;
		boolean yIsWithinRange = false;
		boolean xIsWithinRange = false;
//		boolean yMessageWrongNumberPrinted = false;
//		boolean yMessageWrongRangePrinted = false;
//		boolean xMessageWrongNumberPrinted = false;
//		boolean xMessageWrongRangePrinted = false;

		// check conditions

		do {
			// numbers?
			do {
				yCellString = CoordinateInput.next();
				if (!yCellString.matches("\\d+") && !yCellString.matches("-\\d+")) {
					System.out.println("You should enter numbers!");
//					System.out.println("yIsNumber = " + yIsNumber);
					yIsNumber = false;
				} else {
					yCell = Integer.parseInt(yCellString);
					yIsNumber = true;
					if (yCell < 1 || yCell > 3) {
						System.out.println("Coordinates should be from 1 to 3!");
//						System.out.println("yIsWithinRange = " + yIsWithinRange);
						yIsWithinRange = false;
					} else {
						yIsWithinRange = true;
					}
				}

				xCellString = CoordinateInput.next();
				if (!xCellString.matches("\\d+") && !xCellString.matches("-\\d+")) {
					System.out.println("You should enter numbers!");
//					System.out.println("xIsNumber = " + xIsNumber);
					xIsNumber = false;
				} else {
					xCell = Integer.parseInt(xCellString);
					xIsNumber = true;
					if (xCell < 1 || xCell > 3) {
						System.out.println("Coordinates should be from 1 to 3!");
//						System.out.println("xIsWithinRange = " + xIsWithinRange);
						xIsWithinRange = false;
					} else {
						xIsWithinRange = true;
					}
				}

				// do, while condition is TRUE (i.e. any of vars is FALSE)
			} while (!yIsNumber || !xIsNumber || !yIsWithinRange || !xIsWithinRange);

			// check if cell is occupied

			if (xoxo[yCell - 1][xCell - 1] == ' ') {
				isOccupied = false;
				xoxo[yCell - 1][xCell - 1] = 'X';
			}

			if (isOccupied == true) {
				System.out.println("This cell is occupied! Choose another one!");
			}

		} while (isOccupied == true);

		// Grid print start (2nd input)
		System.out.println("---------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				System.out.print(xoxo[i][j] + " ");
			}
			System.out.println("|");
		}
		System.out.println("---------");
		// Grid print end (2nd input)

		// Analyzing result:
		int xCount = 0; // quantity of Xs
		int oCount = 0; // quantity of Os
		int emptyCount = 0; // quantity of empty spaces
		boolean xHasThreeInARow = false;
		boolean oHasThreeInARow = false;

		// START Counting quantities
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				if (xoxo[i][j] == 'X') {
					xCount++;
				} else if (xoxo[i][j] == 'O') {
					oCount++;
				} else if (xoxo[i][j] == ' ') {
					emptyCount++;
				}
			}
		}
		// END Counting quantities
		


//RESULTS DOWN THERE, just uncomment
		// xHasThreeInARow?
		// check diagonals
		if (xoxo[0][0] == 'X' && xoxo[1][1] == 'X' && xoxo[2][2] == 'X') {
			xHasThreeInARow = true;

		} else if (xoxo[0][2] == 'X' && xoxo[1][1] == 'X' && xoxo[2][0] == 'X') {
			xHasThreeInARow = true;

		}

		// if diagonals have no three-in-a-row - check horizontal and vertical
		if (xHasThreeInARow == false) {
			for (int i = 0; i < 3; i++) {
				if (xoxo[i][0] == 'X' && xoxo[i][1] == 'X' && xoxo[i][2] == 'X') {
					xHasThreeInARow = true;
					break;
				} else {
					if (xoxo[0][i] == 'X' && xoxo[1][i] == 'X' && xoxo[2][i] == 'X') {
						xHasThreeInARow = true;
						break;
					}
				}

			}
		}
		



		// oHasThreeInARow?
		// check diagonals
		if (xoxo[0][0] == 'O' && xoxo[1][1] == 'O' && xoxo[2][2] == 'O') {
			oHasThreeInARow = true;

		} else if (xoxo[0][2] == 'O' && xoxo[1][1] == 'O' && xoxo[2][0] == 'O') {
			oHasThreeInARow = true;

		}

		// if diagonals have no three-in-a-row - check horizontal and vertical
		if (oHasThreeInARow == false) {
			for (int i = 0; i < 3; i++) {
				if (xoxo[i][0] == 'O' && xoxo[i][1] == 'O' && xoxo[i][2] == 'O') {
					oHasThreeInARow = true;
					break;
				} else {
					if (xoxo[0][i] == 'O' && xoxo[1][i] == 'O' && xoxo[2][i] == 'O') {
						oHasThreeInARow = true;
						break;
					}
				}

			}
		}

		System.out.println("xHasThreeInARow? " + xHasThreeInARow);
		System.out.println("oHasThreeInARow? " + oHasThreeInARow);

		
		// Impossible?
		if (xCount - oCount >= 2 || oCount - xCount >= 2 || (xHasThreeInARow == true && oHasThreeInARow == true)) {
			System.out.println("Impossible");
		} else

		// Game not finished?
		if ((xHasThreeInARow == false && oHasThreeInARow == false) && emptyCount > 0) {
			System.out.println("Game not finished");
		} else

		// Draw?
		if ((xHasThreeInARow == false && oHasThreeInARow == false) && emptyCount == 0) {
			System.out.println("Draw");
		} else

		// Who is the winner?
		if (xHasThreeInARow == true) {
			System.out.println("X wins");
		} else {
			System.out.println("O wins");
		}

	}
}
