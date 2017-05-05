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

    private int childLI(int nodeI){ //what if the array is not large enough for children? or the node has no parent? I think it might be better to handle invalid values before/when using it.
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

    private void pushUp(int nodeI){ //recursive, unless you want to modify nodeI
	//only node w/o parent is the one with index 1 or when parent i is 0
	if(nodeI != 1 && heap[nodeI].compareTo(heap[parent(nodeI)]) * constant > 0){
	    swap(nodeI, parent(nodeI));
	    pushUp(parent(nodeI));
	}
    }

    private void pushDown(int nodeI){
	//only node w/o child on left or right is if... childLI or childRI is > size

    }

    public void add(String s){ //if it was a minHeap?
	size++;
	if(size >= heap.length){
	    resize();
	}
	heap[size] = s;
	pushUp(size);
	//---------------------------------------------------------------------
	System.out.println(this);
	//
    }

    public String remove(){

	return "Vale!";
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


    public static void main(String[] args){
	MyHeap test = new MyHeap();
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
	
    }
}
