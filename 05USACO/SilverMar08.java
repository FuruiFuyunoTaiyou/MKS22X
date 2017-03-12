import java.util.Scanner;
import java.io.*;

public class SilverMar08{
    private static int[][][] board;
    private static int numSecs;
    private static int rStart;
    private static int cStart;
    private static int rEnd;
    private static int cEnd;

    public SilverMar08(String filename) throws FileNotFoundException{
	int numRows, numCols/*, numSecs, rStart, cStart, rEnd, cEnd*/;
	Scanner input = new Scanner(new File(filename));
	Scanner input0 = new Scanner(input.nextLine());
	numRows = input0.nextInt();
	numCols = input0.nextInt();
	numSecs = input0.nextInt();
	board = new int[numRows][numCols][2];
	for(int r = 0; r < numRows; r++){
	    String[] input1 = input.nextLine().split("");
	    for(int c = 0; c < input1.length; c++){
		if(input1[c].equals("*")){
		    board[r][c][0] = -1;
		}else{
		    board[r][c][0] = 0;
		}
	    }
	}
	Scanner input2 = new Scanner(input.nextLine());
	rStart = input2.nextInt();
	cStart = input2.nextInt();
	rEnd = input2.nextInt();
	cEnd = input2.nextInt();
    }

    public int calcWays(int rowStart, int colStart, int rowEnd, int colEnd, int numSeconds){
	board[rowStart - 1][colStart - 1][0] = 1;
	for(int time = 0; time < numSeconds; time++){
	    for(int row = 0; row < board.length; row++){
		for(int col = 0; col < board[0].length; col++){
		    //boolean up = false, down = false, left = false, right = false;
		    if(board[row][col][0] != -1){
			if(row != 0 && board[row - 1][col][0] != -1){
			    //up = true;
			    board[row][col][1] += board[row - 1][col][0];
			}
			if(col != 0 && board[row][col - 1][0] != -1){
			    //left = true;
			    board[row][col][1] += board[row][col - 1][0];
			}
			if(row != board.length - 1 && board[row + 1][col][0] != -1){
			    //down = true;
			    board[row][col][1] += board[row + 1][col][0];
			}
			if(col != board[0].length - 1 && board[row][col + 1][0] != -1){
			    //right = true;
			    board[row][col][1] += board[row][col + 1][0];
			}
		    }else{
			board[row][col][1] = -1;
		    }
		}
	    }
	    for(int r = 0; r < board.length; r++){
		for(int c = 0; c < board[0].length; c++){
		    board[r][c][0] = board[r][c][1];
		    board[r][c][1] = 0;
		    //
		    //System.out.print(board[r][c][0] + " ");
		}
		//
		//System.out.println();
	    }
	    //
	    //System.out.println();
	}
	return board[rowEnd - 1][colEnd - 1][0];
    }

    public static int runSilver(String filename) throws FileNotFoundException{
	SilverMar08 creation = new SilverMar08(filename);
	return creation.calcWays(rStart, cStart, rEnd, cEnd, numSecs);
    }



    public static void main(String[] args) throws FileNotFoundException{
	//for(int x = 1; x <= 10; x++){
	//int x = 1;
	//System.out.println(runSilver("ctravel." + x + ".in"));
	//}
    }
}
