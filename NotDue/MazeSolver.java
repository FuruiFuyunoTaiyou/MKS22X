import java.lang.Math;


public class MazeSolver{
    private Maze board;
    private boolean animate; //not so sure what to do with/for animating yet. it seems if animated, use toString(delay) and if not, just toString?()


    public MazeSolver(String filename){
	this(filename, false);
    }

    public MazeSolver(String filename, boolean animate){
	board = new Maze(filename);
	this.animate = animate; //not so sure what to do with/for animating yet
    }

    /*
    private int calcDistToStart(Location lugar){ //CAN count back using previous, but I doubt that's efficient
        
    }
    */

    private int calcDistToGoal(int r, int c){
	Location end = board.getEnd();
	return Math.abs(r - end.getRow()) + Math.abs(c - end.getCol());
    }
    
    public void solve(){
	solve(1);
    }

    public void solve(int style){
	Frontier frontier;
	int distTraveled = 0; 
	if(style == 0){
	    frontier = new FrontierStack();
	    frontier.add(new Location(getStart().getRow(), getStart().getCol(), null, distTraveled, calcDistToGoal(getStart().getRow(), getStart().getCol()), false));
	}else if(style == 1){
	    frontier = new FrontierQueue();
	    frontier.add(new Location(getStart().getRow(), getStart().getCol(), null, distTraveled, calcDistToGoal(getStart().getRow(), getStart().getCol()), false));
	}else if(style == 2){
	    frontier = new FrontierPriorityQueue();
	    frontier.add(new Location(getStart().getRow(), getStart().getCol(), null, distTraveled, calcDistToGoal(getStart().getRow(), getStart().getCol()), false));
	}else if(style == 3){
	    frontier = new FrontierPriorityQueue(); 
	    frontier.add(new Location(getStart().getRow(), getStart().getCol(), null, distTraveled, calcDistToGoal(getStart().getRow(), getStart().getCol()), true));
	}
	while(frontier.hasNext() && ){
	    Location TBExplored = frontier.next();
	    frontier
	}
    }

    public String toString(){
	if(animate){
	    return board.toString(10);
	}else{
	    return board;
	}
    }

    public static void main(String[] args){
	MazeSolver test = new MazeSolver();
	
    }
}
