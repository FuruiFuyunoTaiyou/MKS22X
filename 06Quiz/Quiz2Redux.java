import java.util.ArrayList;

public class Quiz2Redux{
    public static ArrayList<String> combinations(String s){
	ArrayList<String> words = new ArrayList<String>();
	combinationH(s, words, 0, "");
	return words;
    }

    public static void combinationH(String s, ArrayList<String> words, int index, String combo){
	if(index >= s.length()){
	    words.add(combo);
	}else{
	    combinationH(s, words, index + 1, combo);
	    combinationH(s, words, index + 1, combo + s.charAt(index));
	}
    }



    public static void main(String[] args){
	/*ArrayList<String> print = combinations("");
	for(int i = 0; i < print.size(); i++){
	    System.out.println(print.get(i));
	    }*/
    }
}
