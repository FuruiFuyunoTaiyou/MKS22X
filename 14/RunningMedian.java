import java.lang.Integer;
import java.lang.Math;
import java.util.Random;
import java.util.NoSuchElementException;


public class RunningMedian{
    private MyHeap smaller;
    private MyHeap larger;


    public RunningMedian(){
	smaller = new MyHeap(true);
	larger = new MyHeap(false);
    }

    public void add(int val){ //Ah, the first time add tries to getMedian, there's nothing...
	if(smaller.getSize() + larger.getSize() == 0){
	    smaller.add(new Integer(val));
	}else if(val >= getMedian()){
	    larger.add(new Integer(val));
	}else{
	    smaller.add(new Integer(val));
	}
	if(smaller.getSize() - larger.getSize() > 1){
	    larger.add(smaller.remove());
	}else if(larger.getSize() - smaller.getSize() > 1){
	    smaller.add(larger.remove());
	}
    }

    public double getMedian(){
	if(smaller.getSize() + larger.getSize() != 0){
	    if(smaller.getSize() == larger.getSize()){
		return (smaller.peek() + larger.peek()) / 2.0;
	    }else if(smaller.getSize() > larger.getSize()){
		return smaller.peek();
	    }else{
		return larger.peek();
	    }
	}else{
	    throw new NoSuchElementException("No integers were added.");
	}
    }

    public String toString(){ //not required
	return smaller.toStringTree() + "\n-----------\n" + larger.toStringTree();
    }


    public static void main(String[] args){
	/*
	RunningMedian test = new RunningMedian();
	Random randgen = new Random();
	for(int i = 0; i < 10; i++){
	    test.add(randgen.nextInt(21));
	    System.out.println("Med: " + test.getMedian() + "\n" + test);
	}
	*/
    }
}
