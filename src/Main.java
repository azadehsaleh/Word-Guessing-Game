import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class


public class Main {

	public static void main(String[] args) throws FileNotFoundException{ 
		//Scanner sc = new Scanner(new File("/Users/azadehsaleh/Desktop/words.txt"));
		Scanner keyInput = new Scanner(System.in);
		String resultShowMenue="";
		resultShowMenue=showMenu(keyInput);
		
		switch (resultShowMenue.toLowerCase()) {
		case "s":
			SecretWord secretWord = new SecretWord(getTheSecretWord());
			Level[] level = { 
					new Level (1, secretWord,true),
					new Level (2, secretWord,true),
					new Level (3, secretWord,true),
					};
			for (int i=0; i< secretWord.getActualWord().length(); i++) {
				secretWord.WordSoFar+="-";
			}
			Scanner input = new Scanner(System.in);
			String letterGuess="";
			System.out.print("Enter a letter to guess the word: ");
			letterGuess = input.nextLine();
			if (level[0].checkGuess(letterGuess)) {
				secretWord.toString(true,letterGuess);
				
				LocalDateTime DateTimeObj = LocalDateTime.now();
			    DateTimeFormatter DateTimeFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			    String formattedDate = DateTimeObj.format(DateTimeFormatObj);
			    System.out.println(formattedDate);
				
			}
		/*	do {
			System.out.print( secretWord.toString(secretWord.getActualWord(),letterGuess));
			 WordSoFar = secretWord.toString(secretWord.getActualWord(),input.nextLine());
			} while( !secretWord.hasLettersRemaining(WordSoFar)); */
			

			
		case "r":
			
		case "e":
			
		default:
			
			
		}
		
		
	/*	Level[] level = {
				new Level(showMenu(keyInput), secretWord, true),
				//new Level(2, new SecretWord(getTheSecretWord()),true),
			//new Level(3, new SecretWord(getTheSecretWord()),true)
		};
		System.out.println(level[0].toString());
		System.out.println(level[1].toString());
		System.out.println(level[2].toString());

*/


		}
	
	// Show Menu function
	public static String showMenu(Scanner keyInput) {
		System.out.println("  " + "\u2022" + " Start Game (Enter S)");
		System.out.println("  " + "\u2022" + " Results of Previous Games (Enter R)");
		System.out.println("  " + "\u2022" + " Exit (Enter E)");
		String menuChar= keyInput.nextLine();
		switch (menuChar.toLowerCase()) {
		case "s":
			return "s";
		case "r":
			return "r";
		case "e":
			return "e";
		default:
			System.out.println("You've entered an invalid character");
			System.out.println();
			return(showMenu(keyInput));
			
		}	
	}
	
	// Get the Secret Word from the file word.txt
	public static String getTheSecretWord() throws FileNotFoundException  {
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
       System.out.println("ignore this line --> " + wordArray[idx]);
        return (wordArray[idx].toString());
      	
	}

	


	
	
	
}
