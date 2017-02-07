public class Recursion{ 
    public static String name(){
	return "Chen,Winnie";
    }

    private static double sqrtHelper(double n, double guess){
	double error = Math.abs(Math.sqrt(n) - guess) / Math.sqrt(n);
	if(error < 0.00001){
	    return guess;
	}else{
	    return sqrtHelper(n, (n / guess + guess) / 2);
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
    }
}
