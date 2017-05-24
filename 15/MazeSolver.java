import java.lang.Math;
import java.util.ArrayList;


public class MazeSolver{
    private Maze board;
    private boolean animate; //not so sure what to do with/for animating yet. it seems if animated, use toString(delay) and if not, just toString()? In the solve() funct?


    public MazeSolver(String filename){
	this(filename, false);
    }

    public MazeSolver(String filename, boolean animate){
	board = new Maze(filename);
	this.animate = animate; //not so sure what to do with/for animating yet
    }

    private int calcDistToGoal(int r, int c){
	Location end = board.getEnd();
	return Math.abs(r - end.getRow()) + Math.abs(c - end.getCol());
    }

    private ArrayList<Location> getValidNeighbors(Location lugar){ //----------
	int[] moves = {-1, 0, 0, 1, 1, 0, 0, -1};
	ArrayList<Location> possible = new ArrayList<Location>();
	for(int iMoveRow = 0, iMoveCol = 1; iMoveRow < moves.length - 1; iMoveRow += 2, iMoveCol += 2){
	    int moveRow = moves[iMoveRow];
	    int moveCol = moves[iMoveCol];
	    if(board.get(lugar.getRow() + moveRow, lugar.getCol() + moveCol) == ' '){
		possible.add(new Location(lugar.getRow() + moveRow, lugar.getCol() + moveCol, lugar, lugar.getDistToStart() + 1, calcDistToGoal(lugar.getRow() + moveRow, lugar.getCol() + moveCol), lugar.getAStar()));
	    }
	}
	return possible;
    }

    private boolean isEnd(Location lugar){ 
	return lugar.getRow() == board.getEnd().getRow() && lugar.getCol() == board.getEnd().getCol();
    }
    
    public void solve(){
	solve(1);
    }

    public void solve(int style){
	Frontier frontier = new FrontierStack(); //error if style not 0 - 3?
	Location mazeStart = board.getStart();
	if(style == 0){
	    frontier = new FrontierStack();
	    frontier.add(new Location(mazeStart.getRow(), mazeStart.getCol(), null, 0, calcDistToGoal(mazeStart.getRow(), mazeStart.getCol()), false));
	}else if(style == 1){
	    frontier = new FrontierQueue();
	    frontier.add(new Location(mazeStart.getRow(), mazeStart.getCol(), null, 0, calcDistToGoal(mazeStart.getRow(), mazeStart.getCol()), false));
	}else if(style == 2){
	    frontier = new FrontierPriorityQueue();
	    frontier.add(new Location(mazeStart.getRow(), mazeStart.getCol(), null, 0, calcDistToGoal(mazeStart.getRow(), mazeStart.getCol()), false));
	}else if(style == 3){
	    frontier = new FrontierPriorityQueue(); 
	    frontier.add(new Location(mazeStart.getRow(), mazeStart.getCol(), null, 0, calcDistToGoal(mazeStart.getRow(), mazeStart.getCol()), true));
	}
	boolean done = false;
	while(frontier.hasNext() && !done){ 
	    if(animate){
		System.out.println(this);
	    }
	    Location TBExplored = frontier.next();
	    if(!isEnd(TBExplored)){
		board.set(TBExplored.getRow(), TBExplored.getCol(), '.');
		for(Location lugar : getValidNeighbors(TBExplored)){ 
		    frontier.add(lugar);
		    board.set(lugar.getRow(), lugar.getCol(), '?');
		}		     
	    }else{
		Location pathPart = TBExplored;
		board.set(TBExplored.getRow(), TBExplored.getCol(), 'E');
		while(pathPart.getPrevious().getRow() != mazeStart.getRow() && pathPart.getPrevious().getCol() != mazeStart.getCol()){
		    pathPart = pathPart.getPrevious();
		    board.set(pathPart.getRow(), pathPart.getCol(), '@');
		}
		//-------------------going back to start-----------------------
		pathPart = pathPart.getPrevious();
		board.set(pathPart.getRow(),pathPart.getCol(), 'S');
		done = true;
	    }
	}
	//--------------------------what to do at end?-------------------------
	
    }

    public String toString(){
	if(animate){
	    return board.toString(40);
	}else{
	    return board.toString();
	}
    }

    public static void main(String[] args){
	MazeSolver test = new MazeSolver("data1.txt"/*, true*/);
	MazeSolver test1 = new MazeSolver("data2.txt"/*, true*/);
	MazeSolver test2 = new MazeSolver("data3.txt"/*, true*/);
	//MazeSolver test3 = new MazeSolver("data4.txt"/*, true*/);
	//MazeSolver test4 = new MazeSolver("data5.txt"/*, true*/);
	System.out.println(test);
	test.solve(3);
	System.out.println(test);
	System.out.println(test1);
	test1.solve(3);
	System.out.println(test1);
	System.out.println(test2);
	test2.solve(3);
	System.out.println(test2);/*
	System.out.println(test3);
	test3.solve(3);
	System.out.println(test3);
	System.out.println(test4);
	test4.solve(3);
	System.out.println(test4);*/
    }
}
