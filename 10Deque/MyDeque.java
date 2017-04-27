import java.util.*;

public class MyDeque{
    private String[] arr;
    private int first;
    private int last;

    public MyDeque(){
	arr = new String[10];
	first = 0;
	last = 0;
    }

    private String[] expand(String[] original){
	String[] copy = new String[original.length * 2];
	for(int i = first; i <= last; i++){
	    copy[newIEq(i, copy)] = original[iEq(i)];
	}
	return copy;
    }     

    private boolean empty(){
	return first == last && arr[iEq(first)] == null;
    }

    private int iEq(int i){
	if(i % arr.length >= 0){
	    return i % arr.length;
	}else{
	    return arr.length + (i % arr.length);
	}
    }

    private int newIEq(int i, String[] copy){
	if(i % copy.length >= 0){
	    return i % copy.length;
	}else{
	    return copy.length + (i % copy.length);
	}
    }

    public void addFirst(String ele){
	if(ele != null){
	    if(empty()){
		arr[iEq(first)] = ele;
	    }else if(arr[iEq(first - 1)] == null){
		arr[iEq(first - 1)] = ele;
		first--;
	    }else{
		arr = expand(arr);
		addFirst(ele);
	    }
	}else{
	    throw new NullPointerException("Cannot add a null element");
	}
    }

    public void addLast(String ele){
	if(ele != null){
	    if(empty()){
		arr[iEq(first)] = ele;
	    }else if(arr[iEq(last + 1)] == null){
		arr[iEq(last + 1)] = ele;
		last++;
	    }else{
		arr = expand(arr);
		addLast(ele);
	    }
	}else{
	    throw new NullPointerException("Cannot add a null element");
	}
    }

    public String removeFirst(){
	if(!empty()){
	    String removed = arr[iEq(first)];
	    arr[iEq(first)] = null;
	    if(!empty()){
		first++;
	    }
	    return removed;
	}else{
	    throw new NoSuchElementException("Deque is empty");
	}
    }

    public String removeLast(){
	if(!empty()){
	    String removed = arr[iEq(last)];
	    arr[iEq(last)] = null;
	    if(!empty()){
		last--;
	    }
	    return removed;
	}else{
	    throw new NoSuchElementException("Deque is empty");
	}
    }

    public String getFirst(){

	return "HONMAKA";
    }

    public String getLast(){

	return "HONMAKA";
    }

    public String toString(){
	String printVer = "[";
	if(arr.length > 0){
	    printVer += " ";
	    for(String str : arr){
		printVer += ", " + str;
	    }
	}
	printVer += "]";
	return printVer;
    }



    public static void main(String[] args){
	MyDeque test0 = new MyDeque();
	System.out.println(test0);
	test0.first = -5;
	test0.last = -5;
	test0.addLast("A");
	System.out.println(test0.last + ":" + test0);
	test0.addLast("B");
	System.out.println(test0.last + ":" + test0);
	test0.addLast("C");
	System.out.println(test0.last + ":" + test0);
	test0.addFirst("Z");
	System.out.println(test0.first + ":" + test0);
	test0.addFirst("Y");
	System.out.println(test0.first + ":" + test0);
	test0.addFirst("X");
	System.out.println(test0.first + ":" + test0);
	test0.addFirst("W");
	System.out.println(test0.first + ":" + test0);
	test0.addFirst("V");
	System.out.println(test0.first + ":" + test0);
	test0.addFirst("U");
	System.out.println(test0.first + ":" + test0);
	test0.addFirst("T");
	System.out.println(test0.first + ":" + test0);
	test0.addFirst("S");
	System.out.println(test0.first + ":" + test0);
	test0.addLast("D");
	System.out.println(test0.last + ":" + test0);
	test0.addLast("E");
	System.out.println(test0.last + ":" + test0);
	test0.addLast("F");
	System.out.println(test0.last + ":" + test0);
	for(int i = 0; i < 15; i++){
	    System.out.println(test0.first + " & " + test0.last);
	    System.out.println(test0.removeLast() + " removed: " + test0);
	}
    }
}
