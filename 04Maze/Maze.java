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
	    //----------------------------MSG?---------------------------------
	}
    }
	
    ///*-----------------------------------------------------------------------
    public Maze(String filename){
	try{
	    Scanner input = new Scanner(new File(filename));
	    //determines dimensions the ugly-but-should-work way---------------
	    //also check for exactly 1 E & S ASAP------------------------------
	    int rowCount = 0;
	    int colCount = 0;
	    int eCount = 0;
	    int sCount = 0;
	    while(input.hasNextLine()){
		String inputLine = input.nextLine();
		//System.out.println(inputLine); //----------------------------
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
		//System.out.println(inputLine); //----------------------------
		for(int col = 0; col < inputLine.length(); col++){
		    maze[row][col] = inputLine.charAt(col);
		}
		row++; 
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File not found");
	    System.exit(0);
	}
	animate = false;
    }
    
    /*-----------------------------------------------------------------------
    public boolean solve(){
        
    }
    
    private boolean solve(int row, int col){
	if(animate){
	    System.out.println("\033[2J\033[1;1H"+this);
	    wait(20);
	}
	
    }
    //-----------------------------------------------------------------------*/
    
    public String toString(){
	String mazePrint = "";
	for(int r = 0; r < maze.length; r++){
	    for(int c = 0; c < maze[0].length; c++){
		mazePrint += maze[r][c];
		//System.out.println(maze[r][c]); //---------------------------
	    }
	    mazePrint += "\n";
	}
	return mazePrint;
    }



    public static void main(String[] args){
	Maze maze0 = new Maze("data1.dat");
	maze0.clearTerminal();
	maze0.setAnimate(true);
	//System.out.println(maze0.maze[0][0]);
	//System.out.println(maze0);
	
    }
}
