package SimpleTicTacToe;

public class Test {
///
///
	public static void main(String[] args) {

		boolean xHasThreeInARow = false;
		boolean yHasThreeInARow = false;
		boolean gameCompleted = false;
		int i = 0;

		do {

			if (xHasThreeInARow || yHasThreeInARow) {
				gameCompleted = true;
				System.out.println("Game completed.");
			}

		} while (!gameCompleted);

	}
}
