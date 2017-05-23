import java.util.Random;


public class FrontierPriorityQueue implements Frontier{
    private MyHeap frontier;


    public FrontierPriorityQueue(){
	frontier = new MyHeap(false);
    }

    public void add(Location lugar){
	frontier.add(lugar);
    }

    public Location next(){
	return frontier.remove();
    }

    public boolean hasNext(){
	return frontier.getSize() != 0;
    }

    public String toString(){
	return frontier.toStringTree();
    }


    public static void main(String[] args){
	FrontierPriorityQueue test = new FrontierPriorityQueue();
	test.add(new Location(4, 5, null, 1, 3, false));
	System.out.println(test);
	Random randgen = new Random();
	for(int i = 0; i < 11; i++){
	    test.add(new Location(randgen.nextInt(100), randgen.nextInt(100), null, randgen.nextInt(100), randgen.nextInt(100), true));
	    System.out.println(test);
	}
	while(test.hasNext()){
	    System.out.println(test.next());
	}
    }
}
