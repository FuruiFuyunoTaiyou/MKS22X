import java.util.*;
import java.io.*;

public class Maze{
    private char[][] maze;
    private boolean animate;

    public void setAnimate(boolean b){
	animate = b;
    }

    public void clearTerminal(){
	System.out.println("\033[2J\033[1;1H");
    }

    private void wait(int millis){
	try{
	    Thread.sleep(millis);
	}catch(InterruptedException e){
	}
    }
	
    public Maze(String filename){
	try{
	    Scanner input = new Scanner(new File(filename));
	    //determines dimensions & checks number of E and S the ugly-but-should-work way
	    int rowCount = 0;
	    int colCount = 0;
	    int eCount = 0;
	    int sCount = 0;
	    while(input.hasNextLine()){
		String inputLine = input.nextLine();
		colCount = inputLine.length();
		for(int i = 0; i < colCount; i++){
		    if(inputLine.charAt(i) == 'E'){
			eCount++;
		    }else if(inputLine.charAt(i) == 'S'){
			sCount++;
		    }
		}
		rowCount++;
	    }
	    if(eCount != 1){
		System.out.println("Error: There is not exactly 1 E in the maze");
		System.exit(0);
	    }else if(sCount != 1){
		System.out.println("Error: There is not exactly 1 S in the maze");
		System.exit(0);
	    }
	    maze = new char[rowCount][colCount];
	    //loads maze
	    input = new Scanner(new File(filename));
	    int row = 0;
	    while(input.hasNextLine()){
		String inputLine = input.nextLine();
		for(int col = 0; col < inputLine.length(); col++){
		    maze[row][col] = inputLine.charAt(col);
		}
		row++; 
	    }
	}catch(FileNotFoundException e){
	    System.out.println("Error: File not found");
	    System.exit(0);
	}
	animate = false;
    }
    
    private int[] moves(){
	int[] moves = {-1, 0, 0, 1, 1, 0, 0, -1};
	return moves;
    }
    
    public boolean solve(){
        int startr = -1, startc = -1;
	for(int r = 0; r < maze.length; r++){
	    for(int c = 0; c < maze[0].length; c++){
		if(maze[r][c] == 'S'){
		    startr = r;
		    startc = c;
		}
	    }
	}
	maze[startr][startc] = ' ';
	return solve(startr, startc);
    }
    
    private boolean solve(int row, int col){
	if(animate){
	    System.out.println("\033[2J\033[1;1H"+this);
	    wait(20);
	}
	if(maze[row][col] == 'E'){
	    return true;
	}else{
	    for(int iMoveRow = 0, iMoveCol = 1; iMoveRow < moves().length - 1; iMoveRow += 2, iMoveCol += 2){
		int moveRow = moves()[iMoveRow];
		int moveCol = moves()[iMoveCol];
		if(maze[row + moveRow][col + moveCol] !='#' &&
		   maze[row + moveRow][col + moveCol] !='@'){
		    maze[row][col] = '@';
		    if(solve(row + moveRow, col + moveCol)){
			return true;
		    }else{
			maze[row][col] = '.';
		    }
		}
	    }
	    return false;
	}
    }
    
    public String toString(){
	String mazePrint = "";
	for(int r = 0; r < maze.length; r++){
	    for(int c = 0; c < maze[0].length; c++){
		mazePrint += maze[r][c];
	    }
	    mazePrint += "\n";
	}
	return mazePrint;
    }



    public static void main(String[] args){
	Maze maze0 = new Maze("data4.dat");
	maze0.clearTerminal();
	//maze0.setAnimate(true);
	maze0.solve();
	Maze maze1 = new Maze("data2.dat");
	maze1.clearTerminal();
	//maze1.setAnimate(true);
	maze1.solve();
	Maze maze2 = new Maze("data3.dat");
	maze2.clearTerminal();
	//maze2.setAnimate(true);
	maze2.solve();
	System.out.println(maze0);
	System.out.println(maze1);
	System.out.println(maze2);
    }
}
