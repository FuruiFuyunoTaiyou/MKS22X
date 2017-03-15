public class Quick{
    public static int quickselect(int[] data, int k){
	int start = 0;
	int end = data.length - 1;
	//boolean unmatched = true;
	//while(Partition.part(data, start, end) != k){
	//while(unmatched){
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



    public static void main(String[] args){
	int[]ary = {2, 10, 15, 23, 0, 5};
	System.out.println(quickselect( ary , 0 ) + " should return 0");
	System.out.println(quickselect( ary , 1 ) + " should return 2");
	System.out.println(quickselect( ary , 2 ) + " should return 5");
	System.out.println(quickselect( ary , 3 ) + " should return 10");
	System.out.println(quickselect( ary , 4 ) + " should return 15");
	System.out.println(quickselect( ary , 5 ) + " should return 23");
    }
}
