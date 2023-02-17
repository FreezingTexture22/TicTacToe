package SimpleTicTacToe;

public class Test {

	public static void main(String[] args) {

		boolean xHasThreeInARow = false;
		boolean yHasThreeInARow = false;
		boolean gameCompleted = false;
		int i = 0;

		do {

//			System.out.println("Game is going on");
//			System.out.println("yHasThreeInARow = " + yHasThreeInARow);
//			System.out.println(i);
//			i++;
//			if (i == 5) {
//				yHasThreeInARow = true;
//			}
			
			
			// some code
			// game is going on
			
			if (xHasThreeInARow || yHasThreeInARow) {
				gameCompleted = true;
				System.out.println("Game completed.");
			} 

		} while (!gameCompleted);

	}
}
