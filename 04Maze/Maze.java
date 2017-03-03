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
	throws FileNotFoundException{
	    Scanner input = new Scanner(new File(filename));
	    //determines dimensions the ugly-but-should-work way---------------
	    //also check for exactly 1 E & S ASAP------------------------------
	    int row = 0;
	    int col = 0;
	    int eCount = 0;
	    int sCount = 0;
	    while(input.hasNextLine()){
		String inputLine = input.nextLine();
		//-------------------------------------------------------------
		
		row++;
	    }
	    //loads maze
	    int row = 0;
	    while(input.hasNextLine()){
		String inputLine = input.nextLine();
		for(int col = 0; col < inputLine.length(); col++){
		    maze[row][col] = inputLine.charAt(col);
		}
		row++; 
	    }
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
	    }
	    mazePrint += "\n";
	}
	return mazePrint;
    }



    public static void main(String[] args){
	Maze maze0 = new Maze("data1.dat");
	clearTerminal();
	maze0.setAnimate(true);
	
    }
}
