public class MyLinkedList{
    private LNode start;
    private int size;

    public MyLinkedList(){
	start = null;
	size = 0;
    }

    public boolean add(int value){ //to beginning for now
	LNode newStart = new LNode(value);
	newStart.linkNext(start);
	start = newStart;
	return true; //fix this a bit later (for possibility of it being false -- check documentation
    }

    public String toString(){
	String printVer= "[";
	LNode current = start;
	for(int i = 0; i < size; i++, current = current.next){
	    printVer += " " + current.value + ",";
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
    }
}
