import java.util.*;

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
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("Invalid Index");
	}else{
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
    }

    public int get(int index){
	return getNode(index).value;
    }

    public int indexOf(int value){
	for(int i = 0; i < size(); i++){
	    if(get(i) == value){
		return i;
	    }
	}
	return -1;
    }

    public int set(int index, int newValue){
	LNode current = getNode(index);
	int oldValue = current.value;
	current.value = newValue;
	return oldValue;
    }

    public boolean add(int value){
	if(start == null){
	    start = new LNode(value);
	    end = start;
	}else{
	    end.linkNext(new LNode(value));
	    end.next.linkPrev(end);
	    end = end.next;
	}
	size++;
	return true;
    }

    private void addBefore(LNode location, LNode TBA){
	if(location.prev == null){
	    TBA.next = location;
	    location.prev = TBA;
	    start = TBA;
	}else{
	    TBA.next = location;
	    TBA.prev = location.prev;
	    location.prev = TBA;
	    TBA.prev.next = TBA;
	}
	size++;
    }

    private void addAfter(LNode location, LNode TBA){ //TBA = toBeAdded
	if(location.next == null){
	    TBA.prev = location;
	    location.next = TBA;
	    end = TBA;
	}else{
	    TBA.prev = location;
	    TBA.next = location.next;
	    location.next = TBA;
	    TBA.next.prev = TBA;
	}
	size++;
    }

    public void add(int index, int value){
	if(index < 0 || index > size()){
	    throw new IndexOutOfBoundsException("Invalid Index");
	}else if(size() == 0 || index == size()){
	    add(value);
	}else{
	    addBefore(getNode(index), new LNode(value));
	}
    }

    private void remove(LNode node){
	if(node.prev == null && node.next == null){
	    start = null;
	    end = null;
	}else if(node.prev == null){
	    start = node.next;
	    start.prev = null;
	}else if(node.next == null){
	    node.prev.next = null;
	    end = node.prev;
	}else{
	    node.prev.next = node.next;
	    node.next.prev = node.prev;
	}
	size--;
    }

    public int remove(int index){
	LNode target = getNode(index);
	remove(target);
	return target.value;
    }

    public String toString(){
	String printVer = "[";
	if(size > 0){
	     printVer += " ";
	    LNode current = start;
	    printVer += current.value;
	    current = current.next;
	    for(int i = 1; i < size; i++, current = current.next){
		printVer += ", " + current.value;
	    }
	}
	printVer += "]";
	return printVer;
    }

    public String debugToString(){
	String printVer = "[";
	if(size > 0){
	     printVer += " ";
	    LNode current = start;
	    printVer += current;
	    current = current.next;
	    for(int i = 1; i < size; i++, current = current.next){
		printVer += ", " + current;
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

	public String toString(){
	    String debugRep = "(";
	    if(prev == null){
		debugRep += "null";
	    }else{
		debugRep += prev.value;
	    }
	    debugRep += ") " + value + " (";
	    if(next == null){
		debugRep += "null";
	    }else{
		debugRep += next.value;
	    }
	    return debugRep + ")";
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
	for(int i = 0; i <= test0.size(); i += 2){
	    test0.add(i, 8);
	}
	System.out.println(test0);
	System.out.println(test0.debugToString());
	System.out.println(test0.indexOf(0));
	System.out.println(test0.indexOf(302));
	for(int i = 0; i < test0.size(); i++){
	    test0.remove(i);
	    System.out.println(test0);
	}
    }
}
