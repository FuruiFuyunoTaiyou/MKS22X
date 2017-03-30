public class MyLinkedList{
    private LNode start;
    private int size;

    public MyLinkedList(){
	start = null;
	size = 0;
    }

    /*
    public boolean add(int value){ //to beginning for now
	LNode newStart = new LNode(value);
	newStart.linkNext(start);
	start = newStart;
	size++;
	return true; //fix this a bit later (for possibility of it being false -- check documentation)
    }
    */

    public boolean add(int value){ //include exceptions thrown after done with minimum
	//Problem: start initialized as null. Temp Soln:
	if(start == null){
	    start = new LNode(value);
	}else{
	    LNode end = start;
	    for(int i = 1; i < size; i++){
		end = end.next;	
	    }
	    end.linkNext(new LNode(value));
	    end.next.linkPrev(end);
	}
	size++;
	return true;
    }

    public String toString(){
	String printVer = "[ ";
	LNode current = start;
	//Temp Soln for Formatting:
	printVer += current.value;
	current = current.next;
	for(int i = 1; i < size; i++, current = current.next){
	    printVer += ", " + current.value;
	}
	printVer += "]";
	return printVer;
    }

    private class LNode{
	private int value;
	private LNode next;
	private LNode prev;

	public LNode(int val){
	    value = val;
	    next = null;
	    prev = null;
	}

	public void linkNext(LNode nextNode){
	    next = nextNode;
	}

	public void linkPrev(LNode prevNode){
	    prev = prevNode;
	}
    }



    public static void main(String[] args){
	MyLinkedList test0 = new MyLinkedList();
	System.out.println(test0);
	test0.add(4);
	System.out.println(test0);
	test0.add(-1);
	System.out.println(test0);
	test0.add(0);
	System.out.println(test0);

    }
}
