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
	    //-----------------------------------------------------------------
	}
    }
	
    /*-----------------------------------------------------------------------
    public Maze(String filename){
	
    }

    public boolean solve(){
        
    }
    
    private boolean solve(int row, int col){
	if(animate){
	    System.out.println("\033[2J\033[1;1H"+this);
	    wait(20);
	}
	
    }
    //-----------------------------------------------------------------------*/
    


    public static void main(String[] args){
    }
}
