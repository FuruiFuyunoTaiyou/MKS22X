import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String args[]) throws FileNotFoundException{
	Scanner input = new Scanner(new File("data1.dat"));
	while(input.hasNextLine()){
	    System.out.println(input.nextLine());
	}
	
        //Mr. K's
	/*File text = new File("input.txt");
        Scanner in = new Scanner(text);
        //int lineNumber = 1;
        while(in.hasNextLine()){
            String line = in.nextLine();
            System.out.println(line);
        }
	*/

	//Alt
	/*Scanner in = new Scanner(new File("WordList.txt"));
	    while(in.hasNext()){
		String word = in.next();
		String wordUpperCase = word.toUpperCase();
		dictWordList.add(wordUpperCase);
	    }
	*/
    }   
}
