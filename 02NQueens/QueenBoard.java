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
	boolean valid = true;
	/*for(int c = 0; c < col; c++){
	    if(){

	    }
	    }*/
	return valid;
    }

    //!---------------------------------
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

    //!------------------------------------------------------------------------
    public String toString(){
    	String boardInPrint = "";
	for(int row = 0; row < board.length; row++){
	    for(int col = 0; col < board.length; col++){
		if(board[row][col] == 1){
		    boardInPrint += 'Q';
		}else{
		    boardInPrint += '_';
		}
	    }
	    boardInPrint += '\n';
	}
	return boardInPrint;
    }



    public static void main(String[] args){
	QueenBoard board4 = new QueenBoard(4);
	System.out.println(board4);
    }
}
