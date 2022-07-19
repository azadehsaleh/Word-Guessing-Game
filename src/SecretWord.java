
public class SecretWord {
// Properties
	String wordArray;
	String WordSoFar="";
	private String actualWord;
	
	
// constructor
	public SecretWord(String actualWord) {
		
		 this.actualWord = actualWord;
	}
	public String getActualWord() {
		return this.actualWord;
	}
	public void setActualWord(String actualWord) {
		this.actualWord = actualWord;
	}

 
	public void toString(boolean checkGuess, String letterGuess) {
		boolean messagePrintCorrect = false;
		boolean messagePrintWrong = false;
		boolean letterExist=false;
				if (checkGuess == true) {
					if (messagePrintCorrect == false) {
						System.out.println("CORRECT:  " + letterGuess + " is in the word!"); 
						messagePrintCorrect = true;
					}
				 else if (letterExist == false && messagePrintCorrect == false && messagePrintWrong == false) {
			 System.out.println("WRONG:  " + letterGuess + " is not in the word!"); 
		        }
					System.out.print(this.WordSoFar);
				}
	//	return WordSoFar;
		
	}
	
	public boolean containLetter(String letterGuess, int i) {
		boolean letterExist=false;
		 if (letterGuess.equalsIgnoreCase(Character.toString(this.actualWord.charAt(i)))) {
				
				 letterExist = true;	
		 }
		if (letterExist == false) {
			
		 return false;
		 }	else {
			 return true;
		 }
	
	}
	
	public boolean hasLettersRemaining(String WordSoFar) {
		if (WordSoFar == this.actualWord) {
			return true;
		} else {
			return false;
		}
		
	}
}

