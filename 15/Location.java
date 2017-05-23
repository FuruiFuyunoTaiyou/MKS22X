public class Location implements Comparable<Location>{
    private int row;
    private int col;
    private Location previous;
    private int distToStart; //steps from beginning (so not Euclidean)
    private int distToGoal;
    private boolean aStar;


    public Location(int r, int c, Location previous, int distToStart, int distToGoal, boolean aStar){
	row = r;
	col = c;
	this.previous = previous;
	this.distToStart = distToStart;
	this.distToGoal = distToGoal;
	this.aStar = aStar;
    }

    public int getRow(){
	return row;
    }

    public int getCol(){
	return col;
    }

    public Location getPrevious(){
	return previous;
    }

    public int getDistToStart(){
	return distToStart;
    }

    public int getDistToGoal(){
	return distToGoal;
    }

    public int compareTo(Location lugar){
	if(aStar){
	    return (this.getDistToStart() + this.getDistToGoal()) - (lugar.getDistToStart() + lugar.getDistToGoal());
	}else{
	    return this.getDistToGoal() - lugar.getDistToGoal();
	}
    }

    public String toString(){ //change this
	return "(" + getRow() + ", " + getCol() + ")[" + getDistToGoal() + ", " + (getDistToStart() + getDistToGoal()) + "]";
    }


    public static void main(String[] args){
	Location a = new Location(2, 2, null, 0, 4, false);
	Location b = new Location(2, 3, null, 100, 2, false);
	System.out.println("a: " + a.getDistToStart() + " " + a.getDistToGoal() + " b: " + b.getDistToStart() + " " + b.getDistToGoal() + " => " + a.compareTo(b));
    }
}
