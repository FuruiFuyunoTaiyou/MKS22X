//Guidance for solveH(col) received from: http://www.geeksforgeeks.org/backtracking-set-3-n-queen-problem/

public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    
    public QueenBoard(int size){
	board = new int[size][size];
	solutionCount = -1;
    }

    private void addQueen(int r, int c){
	board[r][c] = 1;
    }

    private void removeQueen(int r, int c){
	board[r][c] = 0;
    }

    //!------------------------------------------------------------------------
    private boolean newQNoConflict(int row, int col){
	for(int c = 0; c < col; c++){
	    if(board[row][c] == 1){
		return false;
	    }
	}
	for(int c = col - 1, r = row - 1; c >= 0 && r >= 0; c--, r--){
	    if(board[r][c] == 1){
		return false;
	    }
	}
	for(int c = col - 1; c >= 0 && row + col - c < board.length; c--){
	    if(board[row + col - c][c] == 1){
		return false;
	    }
	}
	return true;
    }

    private boolean solveH(int col){
        if(col >= board.length){
	    return true;
	}else{
	    for(int row = 0; row < board.length; row++){
		if(newQNoConflict(row, col)){
		    addQueen(row, col);
		    if(solveH(col + 1)){
			return true;
		    }else{
			removeQueen(row, col);
		    }
		}
	    }
	    return false;
	}
    }
    
    public void solve(){
	solveH(0);
    }

    /*//!----------------------------------------------------------------------
    public void countSolutions(){

    }
    */

    public int getSolutionCount(){
    	return solutionCount;
    }
    
    public String toString(){
    	String boardInPrint = "";
	for(int row = 0; row < board.length; row++){
	    for(int col = 0; col < board.length; col++){
		if(board[row][col] == 1){
		    boardInPrint += "Q ";
		}else{
		    boardInPrint += "_ ";
		}
	    }
	    boardInPrint += '\n';
	}
	return boardInPrint;
    }



    public static void main(String[] args){
	QueenBoard board20 = new QueenBoard(20);
	System.out.println(board20);
	//board4.addQueen(0,1);
	board20.solve();
	System.out.println(board20);
    }
}
