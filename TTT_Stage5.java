package SimpleTicTacToe;

import java.util.Scanner;

public class TTT_Stage5 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char[][] xoxo = new char[3][3];
		String gridStart = "         ";

		// START filling initial array
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				xoxo[i][j] = gridStart.charAt((i * 3) + j);

			}

		}
		// END filling initial array

		// START Initial Grid print
		System.out.println("---------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				System.out.print(xoxo[i][j] + " ");
			}
			System.out.println("|");
		}
		System.out.println("---------");
		// END Initial Grid print

		// Initialize variables
		Scanner CoordinateInput = new Scanner(System.in);
		boolean isOccupied = true;
		String yCellString;
		String xCellString;
		int xCell = 0;
		int yCell = 0;

		boolean yIsNumber = false;
		boolean xIsNumber = false;
		boolean yIsWithinRange = false;
		boolean xIsWithinRange = false;
		boolean oHasThreeInARow = false;
		boolean xHasThreeInARow = false;

		boolean gameCompleted = false;

		char player = 'X';

		// START game
		do {
			do {
				// numbers?
				do {
					yCellString = CoordinateInput.next();
					if (!yCellString.matches("\\d+") && !yCellString.matches("-\\d+")) {
						System.out.println("You should enter numbers!");
//						System.out.println("yIsNumber = " + yIsNumber);
						yIsNumber = false;
					} else {
						yCell = Integer.parseInt(yCellString);
						yIsNumber = true;
						if (yCell < 1 || yCell > 3) {
							System.out.println("Coordinates should be from 1 to 3!");
//							System.out.println("yIsWithinRange = " + yIsWithinRange);
							yIsWithinRange = false;
						} else {
							yIsWithinRange = true;
						}
					}

					xCellString = CoordinateInput.next();
					if (!xCellString.matches("\\d+") && !xCellString.matches("-\\d+")) {
						System.out.println("You should enter numbers!");
//						System.out.println("xIsNumber = " + xIsNumber);
						xIsNumber = false;
					} else {
						xCell = Integer.parseInt(xCellString);
						xIsNumber = true;
						if (xCell < 1 || xCell > 3) {
							System.out.println("Coordinates should be from 1 to 3!");
//							System.out.println("xIsWithinRange = " + xIsWithinRange);
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
					xoxo[yCell - 1][xCell - 1] = player;
				} else {
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

			// Impossible?
			if (xCount - oCount >= 2 || oCount - xCount >= 2 || (xHasThreeInARow == true && oHasThreeInARow == true)) {
				System.out.println("Impossible");
				gameCompleted = true;
			} else

			// Draw?
			if ((xHasThreeInARow == false && oHasThreeInARow == false) && emptyCount == 0) {
				System.out.println("Draw");
				gameCompleted = true;
			} else

			// Who is the winner?
			if (xHasThreeInARow == true) {
				System.out.println("X wins");
				gameCompleted = true;
			} else if (oHasThreeInARow == true) {
				System.out.println("O wins");
				gameCompleted = true;
			}

			if (xHasThreeInARow || oHasThreeInARow) {
				gameCompleted = true;

			}

			if (oCount < xCount) {
				player = 'O';
			} else {
				player = 'X';
			}

		} while (!gameCompleted);

		// END game
	}

}
