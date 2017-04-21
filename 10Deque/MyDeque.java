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
	for(int i = first; i <= last; i++){
	    copy[i] = original[i % original.length];
	}
	return copy;
    }

    public void addFirst(String ele){
	if(ele != null){

	}
    }

    public void addLast(String ele){
	if(ele != null){
	    if(arr[last % arr.length] == null){
		arr[first] = ele;
	    }else if(arr[(last + 1) % arr.length] == null){
		arr[(last + 1) % arr.length] = ele;
		last++;
	    }else{
		arr = expand(arr);
		addLast(ele);
	    }
	}
    }

    public String removeFirst(){

	return "HONMAKA";
    }

    public String removeLast(){

	return "HONMAKA";
    }

    public String getFirst(){

	return "HONMAKA";
    }

    public String getLast(){

	return "HONMAKA";
    }

    public String toString(){
	String printVer = "[";
	//INSTEAD OF LENGTH, CALCULATE FROM FIRST - LAST ----------------------
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
	test0.first = 5;
	test0.last = 5;
	test0.addLast("A");
	System.out.println(test0.last + ":" + test0);
	test0.addLast("B");
	System.out.println(test0.last + ":" + test0);
	test0.addLast("C");
	System.out.println(test0.last + ":" + test0);
	test0.addLast("D");
	System.out.println(test0.last + ":" + test0);
	test0.addLast("E");
	System.out.println(test0.last + ":" + test0);
	test0.addLast("F");
	System.out.println(test0.last + ":" + test0);
	test0.addLast("G");
	System.out.println(test0.last + ":" + test0);
	test0.addLast("H");
	System.out.println(test0.last + ":" + test0);
	test0.addLast("I");
	System.out.println(test0.last + ":" + test0);
	test0.addLast("J");
	System.out.println(test0.last + ":" + test0);
	test0.addLast("K");
	System.out.println(test0.last + ":" + test0);
	test0.addLast("L");
	System.out.println(test0.last + ":" + test0);
    }
}
