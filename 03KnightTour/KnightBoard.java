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
	    for(int r = 0; r <= board.length / 2; r++){
		for(int c = 0; c <= board[0].length / 2; c++){
		    addKnight(r, c, level);
		    //----------------------------------------------------------------------------------------------
		    //System.out.println(this);
		    //----------------------------------------------------------------------------------------------
		    if(solveH(r, c, level + 1)){
			return true;
		    }else{
			removeKnight(r, c);
			//------------------------------------------------------------------------------------------
			//System.out.println(this);
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
		//System.out.println("moveRow: " + moveRow + " moveCol: " + moveCol);
		//------------------------------------------------------------------------------------------
		if(row + moveRow >= 0 &&
		   row + moveRow < board.length &&
		   col + moveCol >= 0 &&
		   col + moveCol < board[0].length &&
		   board[row + moveRow][col + moveCol] == 0){
		    addKnight(row + moveRow, col + moveCol, level);
		    //----------------------------------------------------------------------------------------------
		    //System.out.println(this);
		    //----------------------------------------------------------------------------------------------
		    if(solveH(row + moveRow, col + moveCol, level + 1)){
			return true;
		    }else{
			removeKnight(row + moveRow, col + moveCol); //<- BTW, this was why it didn't work; b/c the previous statement was:
			//removeKnight(row, col); -_-
			//------------------------------------------------------------------------------------------
			//System.out.println(this);
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
	/*KnightBoard board3x4 = new KnightBoard(3, 4);
	System.out.println(board3x4);
	board3x4.solve();
	System.out.println(board3x4);
	KnightBoard board3x7 = new KnightBoard(3, 7);
	board3x7.solve();
	System.out.println(board3x7);
	KnightBoard board4x5 = new KnightBoard(4, 5);
	board4x5.solve();
	System.out.println(board4x5); */
	KnightBoard board6x7 = new KnightBoard(6, 7);
	board6x7.solve();
	System.out.println(board6x7);
	KnightBoard board7x7 = new KnightBoard(7, 7);
	board7x7.solve();
	System.out.println(board7x7); /*
	KnightBoard board2x2 = new KnightBoard(2, 2);
	board2x2.solve();
	System.out.println(board2x2);
	KnightBoard board1x1 = new KnightBoard(1, 1);
	board1x1.solve();
	System.out.println(board1x1); */
	KnightBoard board8x7 = new KnightBoard(8, 7);
	board8x7.solve();
	System.out.println(board8x7);
	KnightBoard board8x8 = new KnightBoard(8, 8);
	board8x8.solve();
	System.out.println(board8x8);
	KnightBoard board7x9 = new KnightBoard(7, 9);
	board7x9.solve();
	System.out.println(board7x9);
	KnightBoard board9x5 = new KnightBoard(9, 5);
	board9x5.solve();
	System.out.println(board9x5);
	KnightBoard board10x5 = new KnightBoard(10, 5);
	board10x5.solve();
	System.out.println(board10x5);
	KnightBoard board8x9 = new KnightBoard(8, 9);
	board8x9.solve();
	System.out.println(board8x9);
	KnightBoard board9x6 = new KnightBoard(9, 6);
	board9x6.solve();
	System.out.println(board9x6);
	KnightBoard board9x7 = new KnightBoard(9, 7);
	board9x7.solve();
	System.out.println(board9x7);
    }
}
