import java.util.*;

public class StackCalc{
    private static boolean isOp(String str){
	return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }

    private static double apply(String op, double term2, double term1){
	if(op.equals("+")){
	    return term1 + term2;
	}else if(op.equals("-")){
	    return term1 - term2;
	}else if(op.equals("*")){
	    return term1 * term2;
	}else{
	    return term1 / term2;
	}
    }
    
    public static double eval(String str){
	String[] tokens = str.split(" ");
	Stack<Double> values = new Stack<Double>();
	for(String token : tokens){
	    if(isOp(token)){
		values.push(apply(token, values.pop(), values.pop()));
	    }else{
		values.push(Double.parseDouble(token));
	    }
	}
	return values.pop();
    }
    


    public static void main(String[] args){

    }
}
