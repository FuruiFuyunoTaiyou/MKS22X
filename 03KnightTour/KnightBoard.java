public class KnightBoard{
    private int[][] board;

    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
    }

    /*
    private boolean solveH(int row ,int col, int level){
	
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
		    printedBoard += " " + board[row][col];
		}else{
		    printedBoard += board[row][col];
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
