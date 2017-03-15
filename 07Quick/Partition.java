import java.util.*;

public class Partition{
    //swap method from last semester
    private static void swap(int[] data, int indexCurrent, int indexOfCurrentSmallest){
	int currentSmallest = data[indexOfCurrentSmallest];
	data[indexOfCurrentSmallest] = data[indexCurrent];
	data[indexCurrent] = currentSmallest;
    }
    
    public static int part(int[] data, int start, int end){
	Random randgen = new Random();
	int pivotIndexI = randgen.nextInt(end - start + 1) + start;
	int pivot = data[pivotIndexI];
	int rightmostI = end;
	int numSmaller = 0;
	for(int i = start; i < end + 1; i++){
	    if(data[i] <= pivot){
		numSmaller++;
	    }
	}
	numSmaller--;
	int pivotIndexF = start + numSmaller;
	swap(data, pivotIndexI, pivotIndexF);
	for(int i = start; i < pivotIndexF; i++){
	    if(data[i] > pivot){
	        swap(data, i, rightmostI);
		rightmostI--;
		i--;
	    }
	}
	return pivotIndexF;
    }


    
    public static void main(String[] args){
	int[] test = {8, 6, 7, 5, 3, 0, 9, -22};
	//int[] test = {999,999,999,4,1,0,3,2,999,999,999};
	System.out.println("Final pivot position: " + part(test, 0, test.length - 1));
	//System.out.println("Final pivot position: " + part(test, 2, 5));
	for(int i = 0; i < test.length; i++){
	    System.out.print(test[i] + ", ");
	}
    }
}
