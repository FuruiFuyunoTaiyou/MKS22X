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

    public static int[] part3way(int[] data, int start, int end){
	Random randgen = new Random();
	int pivotIndexI = randgen.nextInt(end - start + 1) + start;
	int pivot = data[pivotIndexI];
	int[] pivotIndices = new int[2];
	int i = start;
	int lt = start;
	int gt = end;
	swap(data, lt, pivotIndexI);
	while(i <= gt){
	    if(data[i] < pivot){
		swap(data, lt, i);
		i++;
		lt++;
	    }else if(data[i] == pivot){
		i++;
	    }else{
		swap(data, gt, i);
		gt--;
	    }
	}
	pivotIndices[0] = lt;
	pivotIndices[1] = gt;
	return pivotIndices;
    }


    
    public static void main(String[] args){
	/*int[] test = {8, 6, 7, 5, 3, 0, 9, -22};
	//int[] test = {999,999,999,4,1,0,3,2,999,999,999};
	System.out.println("Final pivot position: " + part(test, 0, test.length - 1));
	//System.out.println("Final pivot position: " + part(test, 2, 5));
	for(int i = 0; i < test.length; i++){
	    System.out.print(test[i] + ", ");
	    }*/

	/*---------------------------------------------------------------------
	Random randgen = new Random();
	int[] test = new int[randgen.nextInt(100)];
	int numCorrect = 0;
	for(int i = 0; i < test.length; i++){
	    test[i] = randgen.nextInt() * (randgen.nextInt(2) + 1) * -1;
	}
	int[] key = new int[test.length];
	for(int x = 0; x < test.length; x++){
	    key[x] = test[x];
	}
	sort[key];
	/*for(int z = 0; z < ; z++){
	    int returnedI = part(test, 0, test.length - 1);
	    if(test[returnedI] == key[returnedI]){
		numCorrect++;
	    }
	    }*/
	//System.out.println("Success: " + numCorrect
	
	int[] test = {203, 4, 0, 999, 1000, 0, 333, 999, 4, 203, 333, 333, 1111, 0};
	int[] range = new int[2];
	range = part3way(test, 0, test.length - 1);
	System.out.println("Pivot range: " + range[0] + " -> " + range[1]);
	for(int i = 0; i < test.length; i++){
	    System.out.print(test[i] + ", ");
	}
    }
}
