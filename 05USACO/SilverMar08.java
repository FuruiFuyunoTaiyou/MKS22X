import java.util.Scanner;
import java.io.*;

public class SilverMar08{
    private int[][] board;
    private int numSecs;
    private int rStart;
    private int cStart;
    private int rEnd;
    private int cEnd;

    public SilverMar08(String filename) throws FileNotFoundException{
	int numRows, numCols/*, numSecs, rStart, cStart, rEnd, cEnd*/;
	Scanner input = new Scanner(new File(filename));
	Scanner input0 = new Scanner(input.nextLine());
	numRows = input0.nextInt();
	//
	//System.out.println(numRows);
	numCols = input0.nextInt();
	//
	//System.out.println(numCols);
	numSecs = input0.nextInt();
	//
	//System.out.println(numSecs);
	board = new int[numRows][numCols];
	for(int r = 0; r < numRows; r++){
	    //Scanner input1 = new Scanner(input.nextLine());
	    //String temp = input.nextLine();
	    String[] input1 = input.nextLine().split("");
	    //String[] input1 = temp.split(" ");
	    //
	    //System.out.println(temp);
	    //for(int ctemp = 0; ctemp < numCols; ctemp++){
	    //System.out.print(input1[ctemp]);
	    //}
	    for(int c = 0; c < input1.length; c++){
		//board[r][c] = input1.nextInt();
		if(input1[c].equals("*")){
		    board[r][c] = -1;
		    //
		    //System.out.print(board[r][c]);
		}else{
		    board[r][c] = 0;
		    //
		    //System.out.print(" " + board[r][c]);
		}
	    }
	    //
	    //System.out.println();
	}
	Scanner input2 = new Scanner(input.nextLine());
	rStart = input2.nextInt();
	cStart = input2.nextInt();
	rEnd = input2.nextInt();
	cEnd = input2.nextInt();
    }

    //public int calcWays(rStart, cStart, rEnd, cEnd, numSecs){

    //}



    public static void main(String[] args) throws FileNotFoundException{
	for(int x = 1; x <= 10; x++){
	    SilverMar08 ej = new SilverMar08("ctravel." + x + ".in");
	}
    }
}
