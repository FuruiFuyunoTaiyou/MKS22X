public class MyLinkedList{
    private LNode start;
    private int size;
    private LNode end;

    public MyLinkedList(){
	start = null;
	size = 0;
	end = null;
    }

    public int size(){
	return size;
    }

    /*
    public int get(int index){
	LNode current = start;
	if(index < size/2){
	    for(int i = 0; i < index; i++){
		current = current.next;
	    }
	}else{
	    for(int i = 
	}
	return 
    }
    */

    public boolean add(int value){ //include exceptions thrown after done with minimum
	if(start == null){
	    start = new LNode(value);
	    end = start;
	}else{
	    end.linkNext(new LNode(value));
	    end.next.linkPrev(end);
	    end = end.next;
	}
	size++;
	return true; //check documentation for when it'd return false
    }

    public String toString(){
	//Temp (i.e. not-elegant) Soln:
	String printVer = "[";
	if(size > 0){
	     printVer += " ";
	    LNode current = start;
	    //Temp Soln for Formatting:
	    printVer += current.value;
	    current = current.next;
	    for(int i = 1; i < size; i++, current = current.next){
		printVer += ", " + current.value;
	    }
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
	System.out.println("Size: " + test0.size() + "\n" + test0);
	test0.add(4);
	System.out.println("Size: " + test0.size() + "\n" + test0);
	test0.add(-1);
	System.out.println("Size: " + test0.size() + "\n" + test0);
	test0.add(0);
	System.out.println("Size: " + test0.size() + "\n" + test0);

    }
}
