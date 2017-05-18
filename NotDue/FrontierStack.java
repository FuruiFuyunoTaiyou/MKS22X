public class FrontierStack implements Frontier{
    private Stack<Location> frontier;

    public FrontierStack(Maze maze){
	frontier = new Stack(); //add start
	frontier.add(new Location(maze.getStart().getRow(), maze.getStart().getCol(), null, 0, ));
    }

    public void add(Location lugar){

    }

    public Location next(){

    }

    public boolean hasNext(){

    }


    public static void main(String[] args){

    }
}
