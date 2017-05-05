import java.util.NoSuchElementException;
import java.lang.Math;


public class MyHeap{
    private String[] heap;
    private int constant;
    private int size;


    public MyHeap(){
	heap = new String[10];
	constant = 1;
	size = 0;
    }

    public MyHeap(boolean max){
	heap = new String[10];
	size = 0;
	if(max){
	    constant = 1;
	}else{
	    constant = -1;
	}
    }

    private void resize(){
	String[] copy = new String[heap.length * 2];
	for(int i = 1; i < heap.length; i++){
	    copy[i] = heap[i];
	}
	heap = copy;
    }

    private int childLI(int nodeI){ 
	return 2 * nodeI;
    }

    private int childRI(int nodeI){
	return 2 * nodeI + 1;
    }

    private int parent(int nodeI){
	return nodeI / 2;
    }

    private void swap(int node1, int node2){
	String holder = heap[node1];
	heap[node1] = heap[node2];
	heap[node2] = holder;
    }

    private void pushUp(int nodeI){ 
	//only node w/o parent is the one with index 1 or when parent i is 0
	if(nodeI != 1 && heap[nodeI].compareTo(heap[parent(nodeI)]) * constant > 0){
	    swap(nodeI, parent(nodeI));
	    pushUp(parent(nodeI));
	}
    }

    private void pushDown(int nodeI){
	if(childRI(nodeI) <= size){
	    if(heap[nodeI].compareTo(heap[childRI(nodeI)]) * constant < 0 && heap[nodeI].compareTo(heap[childLI(nodeI)]) * constant < 0){
		if(heap[childRI(nodeI)].compareTo(heap[childLI(nodeI)]) * constant >= 0){
		    swap(nodeI, childRI(nodeI));
		    pushDown(childRI(nodeI));
		}else{
		   swap(nodeI, childLI(nodeI));
		   pushDown(childLI(nodeI)); 
		}
	    }else if(heap[nodeI].compareTo(heap[childRI(nodeI)]) * constant < 0){
		swap(nodeI, childRI(nodeI));
		pushDown(childRI(nodeI));
	    }else if(heap[nodeI].compareTo(heap[childLI(nodeI)]) * constant < 0){
		swap(nodeI, childLI(nodeI));
		pushDown(childLI(nodeI));
	    }
	}else if(childLI(nodeI) <= size && heap[nodeI].compareTo(heap[childLI(nodeI)]) * constant < 0){
	    swap(nodeI, childLI(nodeI));
	    pushDown(childLI(nodeI));
	}
    }

    public void add(String s){
	size++;
	if(size >= heap.length){
	    resize();
	}
	heap[size] = s;
	pushUp(size);
	//---------------------------------------------------------------------
	System.out.println(this.toStringTree());
	//
    }

    public String remove(){
	if(size > 0){
	    String removed = heap[1];
	    heap[1] = heap[size];
	    heap[size] = null;
	    size--;
	    pushDown(1);
	    //-----------------------------------------------------------------
	    System.out.println("removed: " + removed + " " + this.toStringTree());
	    //
	    return removed;
	}else{
	    throw new NoSuchElementException("The heap is empty.");
	}
    }

    public String peek(){

	return "Vale!";
    }

    public String toString(){
	String printVer = "[";
	if(heap.length > 0){
	    printVer += " ";
	    for(String str : heap){
		printVer += ", " + str;
	    }
	}
	printVer += "]";
	return printVer;
    }

    public String toStringTree(){
	String printVer = "";
	int i = 1;
	for(int n = 0; i <= size; n++){
	    for(int j = 0; j < Math.pow(2, n) && i <= size; j++, i++){
	        printVer += heap[i] + " ";
	    }
	    printVer += "\n";
	}
	return printVer;
    }


    public static void main(String[] args){
	MyHeap test = new MyHeap(false);
	System.out.println(test);
	test.add("a");
	test.add("b");
	test.add("abc");
	test.add("c");
	test.add("d");
	test.add("e");
	test.add("a");
	test.add("b");
	test.add("abc");
	test.add("c");
	test.add("d");
	test.add("e");
	System.out.println("-------------------------------------------------");
	for(int i = 0; i < 13; i++){
	    test.remove();
	}
    }
}
