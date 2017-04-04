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

    private LNode getNode(int index){
	LNode current = start;
	if(index <= size/2){
	    for(int i = 0; i < index; i++){
		current = current.next;
	    }
	}else{
	    current = end;
	    for(int i = size - 1; i > index; i--){
		current = current.prev;
	    }
	}
	return current;
    }

    public int get(int index){
	return getNode(index).value;
    }

    public int set(int index, int newValue){
	LNode current = getNode(index);
	int oldValue = current.value;
	current.value = newValue;
	return oldValue;
    }

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
	test0.add(-1);
	test0.add(0);
	test0.add(1000);
	test0.add(2000);
	test0.add(1000);
	System.out.println("Size: " + test0.size() + "\n" + test0);
	for(int i = 0; i < test0.size(); i++){
	    System.out.println(i + "th element: " + test0.get(i));
	}
	System.out.println(test0.set(0, 3000) + " -> 3000");
	System.out.println(test0);
    }
}
