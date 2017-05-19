import java.util.*;
import java.util.LinkedList;
import java.util.Random;


public class FrontierQueue implements Frontier{
    private Queue<Location> frontier;

    public FrontierQueue(){
	frontier = new LinkedList<Location>();
    }

    public void add(Location lugar){
	frontier.add(lugar);
    }

    public Location next(){
	return frontier.remove();
    }

    public boolean hasNext(){
	return ((LinkedList<Location>)frontier).size() != 0;
    }

    ///*
    public String toString(){
	String printVer = "";
	for(Location l : frontier){
	    printVer += "; " + l.getRow() + ", " + l.getCol() + "\n";
	}
	return printVer;
    }
    //*/


    public static void main(String[] args){
	FrontierQueue test = new FrontierQueue();
	test.add(new Location(4, 5, null, 1, 3, false));
	System.out.println(test);
	Random randgen = new Random();
	for(int i = 0; i < 4; i++){
	    test.add(new Location(randgen.nextInt(100), randgen.nextInt(100), test.next(), randgen.nextInt(100), randgen.nextInt(100), false));
	    System.out.println(test);
	}
    }
}
