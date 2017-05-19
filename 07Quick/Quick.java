public class Quick{
    public static int quickselect(int[] data, int k){
	int start = 0;
	int end = data.length - 1;
	while(true){
	    int[] newPivotIs = Partition.part3way(data, start, end);
	    if(newPivotIs[0] > k){
		end = newPivotIs[0] - 1;
	    }else if(newPivotIs[1] < k){
		start = newPivotIs[1] + 1;
	    }else{
		return data[newPivotIs[0]];
	    }
	}
    }

    public static void quicksort(int[] a){
	qsh(a, 0, a.length - 1);
    }

    private static void qsh(int[] ary, int start, int end){
	if(end > start){ //check condition
	    int[] pivotIs = Partition.part3way(ary, start, end);
	    qsh(ary, start, pivotIs[0] - 1);
	    qsh(ary, pivotIs[1] + 1, end);
	}
    }    


    public static void main(String[] args){
	/*
	int[] ary = {2, 10, 15, 23, 0, 5};
	System.out.println(quickselect( ary , 0 ) + " should return 0");
	System.out.println(quickselect( ary , 1 ) + " should return 2");
	System.out.println(quickselect( ary , 2 ) + " should return 5");
	System.out.println(quickselect( ary , 3 ) + " should return 10");
	System.out.println(quickselect( ary , 4 ) + " should return 15");
	System.out.println(quickselect( ary , 5 ) + " should return 23");
	
	int[] test0 = {111, 999, 999, -888, 333, 0, 00, -22, 222, 555, 1001, 5, 3, 666, 7777, 1000000, 20000, -333, 222};
	for(int i = 0; i < test0.length; i++){
	    System.out.println(i + "th smallest: " + quickselect(test0, i));
	    }
	
	int[] test1 = {0};
	int[] test2 = {};
	System.out.println("0th smallest: " + quickselect(test1, 0));
	*/

	/*
	//int[] test3 = {111, 999, 999, -888, 333, 0, 00, -22, 222, 555, 1001, 5, 3, 666, 7777, 1000000, 20000, -333, 222};
	int[] test3 = new int[1000];
	quicksort(test3);
	for(int i : test3){
	    System.out.print(i + " ");
	}
	*/

	
    }
}
