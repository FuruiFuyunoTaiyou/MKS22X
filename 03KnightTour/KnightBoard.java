public class KnightBoard{
    private int[][] board;

    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
    }

    private void addKnight(int row, int col, int level){
	board[row][col] = level;
    }

    private void removeKnight(int row, int col){
	board[row][col] = 0;
    }
    
    private int[] moves(){
	int[] moves = {1, 2, 2, 1, 2, -1, 1, -2, -1, -2, -2, -1, -2, 1, -1, 2};
	return moves;
    }

    //--------------------------------------------------------------------------------------------------------------
    private boolean solveH(int row ,int col, int level){
	if(level > board.length * board[0].length){
	    return true;
	}else if(level == 1){
	    for(int r = 0; r < board.length; r++){
		for(int c = 0; c < board[0].length; c++){
		    addKnight(r, c, level);
		    //----------------------------------------------------------------------------------------------
		    System.out.println(this);
		    //----------------------------------------------------------------------------------------------
		    if(solveH(r, c, level + 1)){
			return true;
		    }else{
			removeKnight(r, c);
			//------------------------------------------------------------------------------------------
			System.out.println(this);
			//------------------------------------------------------------------------------------------
		    }
		}
	    }
	    return false;
	}else{
	    for(int iMoveRow = 0,  iMoveCol = 1; iMoveRow < moves().length - 1; iMoveRow += 2, iMoveCol += 2){
		int moveRow = moves()[iMoveRow];
		int moveCol = moves()[iMoveCol];
		//------------------------------------------------------------------------------------------
		System.out.println("moveRow: " + moveRow + " moveCol: " + moveCol);
		//------------------------------------------------------------------------------------------
		if(row + moveRow >= 0 &&
		   row + moveRow < board.length &&
		   col + moveCol >= 0 &&
		   col + moveCol < board[0].length &&
		   board[row + moveRow][col + moveCol] == 0){
		    addKnight(row + moveRow, col + moveCol, level);
		    //----------------------------------------------------------------------------------------------
		    System.out.println(this);
		    //----------------------------------------------------------------------------------------------
		    if(solveH(row + moveRow, col + moveCol, level + 1)){
			return true;
		    }else{
			removeKnight(row, col);
			//------------------------------------------------------------------------------------------
			System.out.println(this);
			//------------------------------------------------------------------------------------------
		    }
		}
	    }
	    return false;
	}
    }

    public void solve(){
	solveH(0, 0, 1);
    }

    public String toString(){
	String printedBoard = "";
	//int maxLvl = board.length * board[0].length;
	for(int row = 0; row < board.length; row++){
	    for(int col = 0; col < board[0].length; col++){
		if(board[row][col] == 0){
		    //return printedBoard;
		    //return "unsolved/no solution";
		    printedBoard += " 0 ";
		}else if(board[row][col] / 10 == 0){
		    printedBoard += " " + board[row][col] + " ";
		}else{
		    printedBoard += board[row][col] + " ";
		}
	    }
	    printedBoard += "\n";
	}
	return printedBoard;
    }



    public static void main(String[] args){
	KnightBoard board4x5 = new KnightBoard(4, 5);
	System.out.println(board4x5);
	board4x5.solve();
	System.out.println(board4x5);
    }
}
