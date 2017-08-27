package leetCode;

//TODO 有问题，待解决
public class KnightTour {
	
	public static void main(String[] args) {
		knightTour();
	}
	
	public static void knightTour() {
		int[][] chessBoard = new int[8][8];
		for(int i = 0; i < 8; i++) 
			for(int j = 0; j < 8; j++) 
				chessBoard[i][j] = 0;
		
		knightTour(chessBoard, 1, new Position());
	}
	
	public static void knightTour(int[][] chessBoard, int nextStep, Position position) {
		
		//TODO 终止条件要想好
		if(position.columns == 0 && position.rows == 0 && nextStep > 1) {
			if(nextStep >= 63) {
				printBoard(chessBoard);
			}
			return;	
		} 
		System.out.print(nextStep);
		for(int i = 0; i < 8; i++) {
			
			//System.out.println(canMove(position, i, chessBoard));
			
			if(canMove(position, i, chessBoard)) {
				move(position, i);
				chessBoard[position.rows][position.columns] = nextStep;
				nextStep++;
				
				//printBoard(chessBoard);
				
				knightTour(chessBoard, nextStep, position);
				
				moveBack(position, i);
				chessBoard[position.rows][position.columns] = 0;
				nextStep--;
			}
		}
			
		
		
		
		
		
	}
	
	public static void printBoard(int[][] chessBoard) {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				System.out.print(chessBoard[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static boolean isSuccessful(int[][] chessBoard) {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(i == 0 && j == 0)	continue;
				
				if(chessBoard[i][j] == -1)
					return false;
			}
		}
			
		return true;
	}
	
	public static boolean canMove(Position position, int i, int[][] chessBoard) {
		Position temp = new Position();
		temp.columns = position.columns;
		temp.rows = position.rows;
		
		move(temp, i);
		
		//System.out.println(temp.rows + " " + temp.columns);
		
		if(temp.columns >= 8 || temp.rows >= 8 || temp.columns < 0 || temp.rows < 0)
			return false;
		
		if(chessBoard[temp.rows][temp.columns] != 0) {
			if(temp.rows == 0 && temp.columns == 0)
				return true;
			else
				return false;
		}
			
		
		return true;
	}
	
	public static void move(Position position, int i) {
		switch(i) {
		case 0:
			position.columns += 2;
			position.rows += 1;
			break;
		case 1:
			position.columns += 2;
			position.rows -= 1;
			break;
		case 2:
			position.columns -= 2;
			position.rows += 1;
			break;
		case 3:
			position.columns -= 2;
			position.rows -= 1;
			break;
		case 4:
			position.columns += 1;
			position.rows += 2;
			break;
		case 5:
			position.columns += 1;
			position.rows -= 2;
			break;
		case 6:
			position.columns -= 1;
			position.rows += 2;
			break;
		case 7:
			position.columns -= 1;
			position.rows -= 2;
			break;
		}
	}
	
	public static void moveBack(Position position, int i) {
		switch(i) {
		case 0:
			position.columns -= 2;
			position.rows -= 1;
			break;
		case 1:
			position.columns -= 2;
			position.rows += 1;
			break;
		case 2:
			position.columns += 2;
			position.rows -= 1;
			break;
		case 3:
			position.columns += 2;
			position.rows += 1;
			break;
		case 4:
			position.columns -= 1;
			position.rows -= 2;
			break;
		case 5:
			position.columns -= 1;
			position.rows += 2;
			break;
		case 6:
			position.columns += 1;
			position.rows -= 2;
			break;
		case 7:
			position.columns += 1;
			position.rows += 2;
			break;
		}
	}
	
	private static class Position {
		public int rows = 0;
		public int columns = 0;
	}
}
