import java.util.*;

public class MyDeque implements Deque<String>{
    private String[] arr;
    private int first;
    private int last;

    public MyDeque(){
	arr = new String[10];
	first = 0;
	last = 0;
    }

    public int size(){
	return last - first; //change according to wrapping
    }

    public void addFirst(String ele){
	
    }

    public void addLast(String ele){

    }

    public String removeFirst(){

    }

    public String removeLast(){

    }

    public String getFirst(){

    }

    public String getLast(){

    }

    public Iterator<String> iterator(){

    }

    public Iterator<String> descendingIterator(){
	
    }

    public String toString(){
	String printVer = "[";
	if(arr.length > 0){
	    //
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
    }
}
