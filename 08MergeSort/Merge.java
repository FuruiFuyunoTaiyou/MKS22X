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

    /*public static void mergesort(int[] ary){

      }*/



    public static void main(String[] args){
	int[] test0 = {};
	int[] test1 = {};
	int[] test2 = new int[test0.length + test1.length];
	merge(test0, test1, test2);
	for(int i = 0; i < test2.length; i++){
	    System.out.print(test2[i] + " ");
	}
    }
}
