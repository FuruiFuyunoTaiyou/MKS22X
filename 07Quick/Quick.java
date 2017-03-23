public class Quick{
    /* quickselect using old part method
    public static int quickselect(int[] data, int k){
	int start = 0;
	int end = data.length - 1;
	while(true){
	    int newPivotI = Partition.part(data, start, end);
	    if(newPivotI > k){
		end = newPivotI - 1;
	    }else if(newPivotI < k){
		start = newPivotI + 1;
	    }else{
		return data[newPivotI];
	    }
	}
    }
    */

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

    /*
    public static void quicksort(int[] a){
	
    }
    */



    public static void main(String[] args){
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
    }
}
