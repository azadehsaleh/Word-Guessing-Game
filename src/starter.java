import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class starter {
	public static void main(String[] arge) {
		
		Scanner keyboardInput = new Scanner(System.in);

		int choice = menu();
		switch(choice) {
		case 1:
		startGame();
		break;
		case 2:
		loadResuts();
		break;
		case 3:
		System.out.println("See you next time.");
		break;
		default:
			System.out.println("Start again and choose between 1,2,3");
		
		}
			
//		System.out.println(Arrays.toString(dashes));
		
	}
	public static void startGame() {
		Scanner keyboardInput = new Scanner(System.in);

		int chanses = 7;
		String secretWord = generateSecretWord();
		char[] theWord = new char[secretWord.length()];
		for(int i=0; i<secretWord.length(); i++) {
			theWord[i] = secretWord.charAt(i);
		}
		int level = 1;
//		boolean correctLetter = false;
		char[] currentGuess = new char[secretWord.length()];
		
		for(int i=0; i<currentGuess.length; i++) {
			currentGuess[i] = '-';
		}

		while(chanses > 0 && currentGuess != theWord) {
			System.out.println("Current Level: " + level);
			System.out.println("Chances remaining: " + chanses);
			System.out.println("Secret Word: " + Arrays.toString(currentGuess));
			
			
			System.out.println( "\nGuess a letter: ");
			char g = keyboardInput.next().charAt(0);
			System.out.println("You guessed " + g);
			
			currentGuess = checkTheLetter(g, theWord, currentGuess);
			System.out.println(Arrays.toString(currentGuess));
			System.out.println(theWord);
			System.out.println(currentGuess);
			chanses-=1;
		}
		
	}

	public static String generateSecretWord() {
		String[] wordList = {"ottawa", "vienna", "london", "paris", "tibilisi", "berlin", "tokyo", "tehran", "rome", "mexico", "madrid", "toronto"};
		Random i = new Random();
		String w = wordList[i.nextInt(12)] ;
		return w;
	}
	public static void loadResuts() {

		System.out.println("Saved results are: ");

	}

	public static char[] checkTheLetter(char g, char[] sw, char[] guess) {
//		String[] n = new String[sw.length()];
		for(int i=0; i<sw.length; i++) {
			if(sw[i] == g) {
				guess[i] = g;
			}else {
//				n[i] = "- ";
			}
		}
		return guess;		
	}
	
	public static int menu() {
		Scanner keyboardInput = new Scanner(System.in);

		System.out.println("Welcome to my game\nEnter the number of your choice\n1. Start Game\n2. Results of previous Games\n3. Exit");
		int i = keyboardInput.nextInt();
		return i;
	}

}
