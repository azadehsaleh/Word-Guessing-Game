import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class RandomWord {
	public static void main(String[] args) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("/Users/azadehsaleh/Desktop/words.txt"));
   	    List <String> wordlist = new ArrayList <String> ();
        while (sc.hasNextLine())     
            {
        	 String word = sc.next(); 
        	 wordlist.add(word);
        	 String[] wordList = word.split(" ");
            }
        //size of list  
        int list_size = wordlist.size();  
        //creating string array  
        String[] wordArray = new String[list_size];  
        //converting to string array  
        wordlist.toArray(wordArray);  
        int idx = new Random().nextInt(wordArray.length);
        System.out.print(wordArray[idx]);
    }
}
