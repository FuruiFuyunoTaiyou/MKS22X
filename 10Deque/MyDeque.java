import java.util.*;

//public class MyDeque implements Deque<String>{
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
	System.out.println(last);
	for(int i = first; i <= last; i++){
	    if(iEq(i) < iEq(first)){
	    
		//if(i % original.length >= 0){
		System.out.println(i + " -> " + (iEq(i)));
		//copy[i % original.length] = original[i % original.length];
		copy[iEq(i)] = original[iEq(i)];
	    }else{
		System.out.println(i + " -> " + (original.length + (i % original.length)) + " -> " + (copy.length + (i % original.length)));
		copy[copy.length + (i % original.length)] = original[original.length + (i % original.length)];
	    }
	}
	System.out.println(this);
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

    public void addFirst(String ele){
	if(ele != null){
	    if(empty()){
		arr[iEq(first)] = ele;
	    }else if(arr[iEq(first - 1)] == null){
		arr[iEq(first - 1)] = ele;
		first--;
			     /*
	    if(first - 1 < 0 && (first - 1) % arr.length == 0 && arr[0] == null){
		arr[0] = ele;
		first--;
	    }else if(first < 0 && first % arr.length == 0 && arr[0] == null){
		arr[0] = ele;
	    }else if(first >= 0 && arr[first % arr.length] == null){
		arr[first] = ele;
	    }else if(first < 0 && arr[arr.length + (first % arr.length)] == null){
		arr[arr.length + (first % arr.length)] = ele;
	    }else if(first - 1 < 0 && arr[arr.length + ((first - 1) % arr.length)] == null){
		arr[arr.length + ((first - 1) % arr.length)] = ele;
		first--;
	    }else if(first >= 0 && arr[(first - 1) % arr.length] == null){
		arr[(first - 1) % arr.length] = ele;
		first--;
			     */
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
	    /*
	    if(last < 0 && arr[arr.length + (last % arr.length)] == null){
		arr[arr.length + (last % arr.length)] = ele;
	    }else if(last + 1 < 0 && arr[arr.length + ((last + 1) % arr.length)] == null){
		arr[arr.length + ((last + 1) % arr.length)] = ele;
		last++;
	    }else if(last >= 0 && arr[last % arr.length] == null){
		arr[first] = ele;
	    }else if(last + 1 >= 0 && arr[(last + 1) % arr.length] == null){
		arr[(last + 1) % arr.length] = ele;
		last++;
	    */
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
	    String removed = "";
	    if(first < 0){
		removed = arr[arr.length + (first % arr.length)];
		arr[arr.length + (first % arr.length)] = null;
	    }else{
		removed = arr[first % arr.length];
		arr[first % arr.length] = null;
	    }
	    first++;
	    return removed;
	}else{
	    throw new NoSuchElementException("Deque is empty");
	}
    }

    /*public String removeLast(){
	if(!isEmpty()){
	    String removed = "";
	    removed = arr[last % arr.length];
	    arr[first % arr.length] = null;
	    first++;
	    return removed;
	}else{
	    throw new NoSuchElementException("Deque is empty");
	}
	}*/

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
	/*
	
	for(int i = 0; i < 4; i++){
	    System.out.println(test0.removeFirst() + ":" + test0);
	}
	*/
    }
}
