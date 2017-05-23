import java.util.Stack;


public class FrontierStack implements Frontier{
    private Stack<Location> frontier;

    public FrontierStack(){
	frontier = new Stack<Location>();
    }

    public void add(Location lugar){
	frontier.push(lugar);
    }

    public Location next(){
	return frontier.pop();
    }

    public boolean hasNext(){
	return !frontier.empty();
    }


    public static void main(String[] args){
	FrontierStack test = new FrontierStack();
	test.add(new Location(2, 2, null, 0, 4, false));
	test.add(new Location(2, 3, null, 100, 2, false));
	test.add(new Location(2, 2, null, 0, 4, false));
	test.add(new Location(2, 3, null, 100, 2, false));
	while(test.hasNext()){
	    System.out.println(test.next());
	}
	test.add(new Location(2, 2, null, 0, 4, false));
	System.out.println(test.next());
	test.add(new Location(2, 3, null, 100, 2, false));
	System.out.println(test.next());
	System.out.println(test.next());
    }
}
