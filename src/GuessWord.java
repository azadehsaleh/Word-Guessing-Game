import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class GuessWord {

	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("/Users/azadehsaleh/Desktop/words.txt"));
		Scanner keyInput = new Scanner(System.in);
		System.out.println("Welcome to WordGuess game!");
		System.out.println();
	
		showMenu(keyInput);
		
	}
	// Menu function
	public static void showMenu(Scanner keyInput) throws FileNotFoundException {
		System.out.println("  " + "\u2022" + " Start Game (Enter S)");
		System.out.println("  " + "\u2022" + " Results of Previous Games (Enter R)");
		System.out.println("  " + "\u2022" + " Exit (Enter E)");
		String menuChar= keyInput.nextLine();
		switch (menuChar.toLowerCase()) {
		case "s":
			startGame(1);
			break;
		case "r":
			System.out.println("result");
			break;
		case "e":
			System.out.println("exit");
			break;
		default:
			System.out.println("You've entered an invalid character");
			System.out.println();
			showMenu(keyInput);
			break;
	}
		
		
	}
	
	// Start Game Function
	public static void startGame(int level) throws FileNotFoundException {
		if (level == 2) {
			System.out.println("Welcome to Level "+ level);
		} else if (level == 3) {
			System.out.println("Welcome to Level "+ level);
		} else {
			System.out.println("Welcome to Level " + level);
			String wordArray=getTheSecretWord();
			guessSecretWord(wordArray,level);
		}

	}
	
	// Get the Secret Word from the file
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
	
	// Guessing the Word By Player
	public static void guessSecretWord(String wordArray, int level) {
			String wordSoFar="";
			int numChance = wordArray.length();
			System.out.println("Chance Remaining: " + numChance);
			System.out.print("Secret Word: ");
	    	//word as dashes
	        for (int i = 0; i < wordArray.length(); i++) {
	        	wordSoFar += "-";
			}
	        System.out.print(wordSoFar);
			System.out.println();	
			String letterGuess="";
			Scanner input = new Scanner(System.in);
			int numGuesses = 0;
			String wordGuess ="" ;	
	        do {
	        System.out.println(" ");
			System.out.print("Enter a letter to guess the word: ");
			letterGuess = input.nextLine();
	        System.out.println("You guessed " + letterGuess);
			numGuesses += 1;
			wordSoFar = checkLetter(letterGuess,wordArray,wordSoFar);
			
			
		//	 if (letterExist== false) {
			//		System.out.println("WRONG:  " + letterGuess + " is not in the word!");  
		//	 }
			 System.out.print(wordSoFar);		 
			 System.out.println();
			} while (!wordSoFar.equalsIgnoreCase(wordArray));
	 
	 System.out.print(wordGuess);
	}
	
	// Ckeck Letter in the Secret Word
	public static String checkLetter(String letterGuess,String wordArray,String wordSoFar) {
		boolean messagePrintCorrect = false;
		boolean messagePrintWrong = false;
		String updatedWord = "";
		boolean letterExist=false;
      
		 for(int i = 0; i < wordArray.length(); i ++) {	
			 if (letterGuess.equalsIgnoreCase(Character.toString(wordArray.charAt(i)))) {
				 letterExist = true;
				 if (messagePrintCorrect == false) {
						System.out.println("CORRECT:  " + letterGuess + " is in the word!"); 
						messagePrintCorrect = true;
				 }
				updatedWord = wordSoFar.substring(0, wordArray.indexOf(letterGuess.toLowerCase(),i)); 
				updatedWord += letterGuess.toLowerCase();												
				updatedWord += wordSoFar.substring(wordArray.indexOf(letterGuess.toLowerCase(),i)+1, wordSoFar.length());
				wordSoFar = updatedWord;	
			 } 
		
		 }
		
		 if (letterExist == false && messagePrintCorrect == false && messagePrintWrong == false) {
		 System.out.println("WRONG:  " + letterGuess + " is not in the word!"); 
		 }
		return wordSoFar;
	}
	

}
