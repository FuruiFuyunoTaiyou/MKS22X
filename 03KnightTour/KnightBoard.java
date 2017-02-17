public class KnightBoard{
    private int[][] board;

    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
    }

    private void addKnight(int row, int col, int level){
	board[row][col] = level;
    }

    private void removeKnight(int row, int col, int level){
	board[row][col] = 0;
    }

    /*
    private int[] moves(){
	return {1, 2, 2, 1, 2, -1, 1, -2, -1, -2, -2, -1, -2, 1, -1, 2};
    }
    
    private boolean solveH(int row ,int col, int level){
	if(level > board.length * board[0].length){
	    return true;
	}else if(level == 1){
	    for(int r = 0; r < board.length; r++){
		for(int c = 0; c < board[0].length; c++){
		    addKnight(r, c, level);
		    if(solveH(r, c, level + 1)){
			return true;
		    }else{
			removeKnight(r, c);
		    }
		}
	    }
	    return false;
	}else{
	    
	}
    }

    public void solve(){
	solveH(0, 0, 1);
    }
    */

    public String toString(){
	String printedBoard = "";
	int maxLvl = board.length * board[0].length;
	for(int row = 0; row < board.length; row++){
	    for(int col = 0; col < board[0].length; col++){
		if(board[row][col] == 0){
		    return printedBoard;
		    //return "unsolved/no solution";
		}else if(board[row][col] / 10 == 0){
		    printedBoard += " " + board[row][col] + " ";
		}else{
		    printedBoard += board[row][col] + " ";
		}
	    }
	}
	return printedBoard;
    }



    public static void main(String[] args){
	KnightBoard board4x5 = new KnightBoard(4, 5);
	System.out.println(board4x5);
	//board4x5.solve();
	System.out.println(board4x5);
    }
}
