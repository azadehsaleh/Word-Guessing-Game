
public class Level {
	//Mandatory Properties
	int levelNumber;
	String levelNumberStr = "Level ";
	SecretWord secretWord;
	int chancesRemaining ;
	String chancesRemainingStr = "Chances Remaining: ";
	
	boolean debugOn;
	
	//constructor
	public Level(int Ln, SecretWord secretWord, boolean dO ) {
		levelNumber = Ln;
		this.secretWord = secretWord;
		debugOn = dO;
		chancesRemaining = secretWord.getActualWord().length();
	}
	
	// Methods
/*	public String toString() {
		levelNumberStr += Integer.toString(levelNumber);
		chancesRemainingStr += Integer.toString(chancesRemaining);
		if (debugOn) {
			return levelNumberStr + "," + chancesRemainingStr +  " "+ secretWord.toString(secretWord.getActualWord(),"a")+ " "+ secretWord.getActualWord();
		}else {
			return levelNumberStr + "," + chancesRemainingStr + " " +  secretWord.WordSoFar;
		}
	}*/
	
	public boolean checkGuess(String letterGuess) {
		String updatedWord = "";
		boolean letterExist=false;
		
			for(int i = 0; i < this.secretWord.getActualWord().length(); i++) {
				if (this.secretWord.containLetter(letterGuess,i)){
					letterExist = true;
					updatedWord = this.secretWord.WordSoFar.substring(0, this.secretWord.getActualWord().indexOf(letterGuess.toLowerCase(),i)); 
					updatedWord += letterGuess.toLowerCase();												
					updatedWord += this.secretWord.WordSoFar.substring(this.secretWord.getActualWord().indexOf(letterGuess.toLowerCase(),i)+1, this.secretWord.WordSoFar.length());
					this.secretWord.WordSoFar = updatedWord;
					} 
				}
			if (letterExist == true) {
				
				return true;
			}else {
				
				this.chancesRemaining--;
				System.out.print(this.secretWord.WordSoFar);
			return false;
			}
			
	}
}

