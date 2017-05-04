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
	String[] copy = new String[original.length * 2];
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

    private void pushUp(int nodeI){ //recursive, unless you want to modify nodeI
	if(heap[nodeI].compareTo(parent(nodeI)) * constant > 0){

	}
    }

    private void pushDown(int nodeI){

    }

    public void add(String s){ //if it was a minHeap?
	size++;
	if(size >= heap.length){
	    resize();
	}
	heap[size] = s;
	pushUp(size);
    }

    public String remove(){

    }

    public String peek(){

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

    }
}
