public class Recursion{ 
    public static String name(){
	return "Chen,Winnie";
    }

    private static double sqrtHelper(double n, double guess){
	if(n != 0.0){
	    double error = Math.abs(Math.sqrt(n) - guess) / Math.sqrt(n);
	    //For 0, the problem is division by 0...?
	    if(error < 0.00001){
		return guess;
	    }else{
		return sqrtHelper(n, (n / guess + guess) / 2);
	    }
	}else{
	    return 0.0;
	}
    }
    
    public static double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException("Cannot take square root of negative number.");
	}else{
	    return sqrtHelper(n, 1);
	}
    }

    public static void main(String[] args){
	System.out.println(name());
	System.out.println(sqrt(100));
	System.out.println(sqrt(25));
	System.out.println(sqrt(400));
	System.out.println(sqrt(1000));
	//1.0,2.0,4.0,7.0,10.0,100.0,1024.0,-1.0,0.0
	System.out.println(sqrt(1.0));
	System.out.println(sqrt(2.0));
	System.out.println(sqrt(4.0));
	System.out.println(sqrt(7.0));
	System.out.println(sqrt(10.0));
	System.out.println(sqrt(100.0));
	System.out.println(sqrt(1024.0));
	//System.out.println(sqrt(-1.0));
	System.out.println(sqrt(0.0));
    }
}
