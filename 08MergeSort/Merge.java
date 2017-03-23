public class Merge{
    private static void merge(int[] a, int[] b, int[] destination){
	int aI = 0;
	int bI = 0;
	int destI = 0;
	while(aI < a.length && bI < b.length){ 
	    if(a[aI] <= b[bI]){
		destination[destI] = a[aI];
		aI++;
	    }else{
		destination[destI] = b[bI];
		bI++;
	    }
	    destI++;
	}
	for(; aI < a.length; aI++, destI++){
	    destination[destI] = a[aI];
	}
	for(; bI < b.length; bI++, destI++){
	    destination[destI] = b[bI];
	}
    }

    public static void mergesort(int[] ary){
	//if(ary.length == 1){
	    //-----------------------------------------------------------------
	//}else{
	if(ary.length > 1){
	    int[] left = new int[ary.length / 2];
	    int[] right = new int[ary.length - left.length]; //hm, don't these variables need to be referenced/refilled later?
	    for(int i = 0; i < left.length; i++){
		left[i] = ary[i];
	    }
	    for(int i = 0; i < right.length; i++){
		right[i] = ary[i + left.length];
	    }
	    mergesort(left);
	    mergesort(right);
	    merge(left, right, ary);
	}
    }



    public static void main(String[] args){
	/*
	int[] test0 = {};
	int[] test1 = {};
	int[] test2 = new int[test0.length + test1.length];
	merge(test0, test1, test2);
	for(int i = 0; i < test2.length; i++){
	    System.out.print(test2[i] + " ");
	}
	*/

	int[] test0 = {19, 20, 13, 15, 7, 8, 0, 1, -1, 5, 3, 18, 17, 12, 2, 11, 4, 14, 6, 9, 10, 16, 18};
	mergesort(test0);
	for(int i = 0; i < test0.length; i++){
	    System.out.print(test0[i] + " ");
	}
    }
}
