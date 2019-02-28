import java.util.Random;
import java.util.Scanner;

public class Mastermind {
	
	public static void main (String[] args) {
		System.out.println("Welkom bij Mastermind! Probeer de code van vier letters te raden. Gebruik de letters a, b, c, d, e, f. Letters mogen vaker voorkomen.");
		MastermindSpel spel = new MastermindSpel();
		
		
		System.out.print(spel.code);
		System.out.println("");
		Speler joost = new Speler();
		joost.spelen();
		
		
		
	}//end main

	

}//end class Mastermind





class MastermindSpel{
		
	static String code = "";
	static String letterInCode = "";
	static int AantalBeurten;
	
//	constructor geeft bij elk nieuw spel een code
		MastermindSpel() {
			for(int i =0; i<4;i++) {
				Random r = new Random();
				int letterIndex = r.nextInt(6);
				char letter = (char)(letterIndex + 97);
				code += letter; 
				
			}//end for loop
		}//end constructor MastermindSpel

//	methode om te controleren of de invoer reglementair is
	static void invoerControleren(String codeGok) {
		boolean invoerGeldig = true;
		
			//	controle op stoppen
				if(codeGok.charAt(0) == 'q') {
					invoerGeldig = false;
					stoppen();
				}//end if	
			//	controle of de code de juiste letters bevat
				for (int i=0; i<codeGok.length();i++) {
					if (codeGok.charAt(0) != 'q' 
							&& invoerGeldig == true 
							&& codeGok.charAt(i) != 'a' 
							&& codeGok.charAt(i) != 'b' 
							&& codeGok.charAt(i) != 'c' 
							&& codeGok.charAt(i) != 'd' 
							&& codeGok.charAt(i) != 'e' 
							&& codeGok.charAt(i) != 'f') {
						
						System.out.println("De code '"+ Speler.spelerInvoer + "' bevat onjuiste letters.");
						invoerGeldig = false;
						break;
					}//end if loop
				}//end for loop
			//	controle op lengte invoer
				if(codeGok.length() != 4 
						&& codeGok.charAt(0) != 'q' 
						&& invoerGeldig == true) {
					
					System.out.println("De code '" + Speler.spelerInvoer + "' bestaat niet uit 4 letters.");
					invoerGeldig = false;
				}// end if
			//	als de code 4 letters heeft én het zijn letters van de invoer die mag dan wordt de code gecontroleerd
				if(invoerGeldig == true) {
					System.out.println("De code wordt gecheckt. 0: letter op de juiste plaats; +: letter zit wel in de code maar niet op deze plaats; X: letter zit niet in de code");
				}//end if
	}//end codeControleren

	// Controle op gokCheck: zitten de letters erin op de juiste plek, erin op een andere plek of er niet in
	static void gokCheck() {
		for (int i=0; i<4;i++) {
			checkLetterOpGoedePlek(i);
			checkLetterAanwezig(i);
			checkLetterAfwezig(i);
			}//end for loop
		System.out.println("	 lettersInCode:"+MastermindSpel.letterInCode);
		AantalBeurten++;
		System.out.println("Dit was beurt " + AantalBeurten + ". Je hebt nog "+(12-AantalBeurten)+" beurten om de code te raden.");
	}//end methode gokCheck
	
	
	// Checkt of de letter in spelerInvoer op dezelfde plek staat als in de code
	static void checkLetterOpGoedePlek(int i) {
		for(int j =0; j < Speler.spelerInvoer.length(); j++) {
			if (Speler.spelerInvoer.charAt(i) == MastermindSpel.code.charAt(i)) {
				System.out.print("0");
				letterInCode += Speler.spelerInvoer.charAt(i);
				break;
			}//end if
		}//end for
	}//end methode checkLetterOpGoedePlek

	// Checkt of de letter in spelerInvoer wel in de code staat, maar niet op dezelfde plek
	static void checkLetterAanwezig(int i) {
		for(int j =0; j < Speler.spelerInvoer.length(); j++) {
			if (Speler.spelerInvoer.charAt(i) != MastermindSpel.code.charAt(i) 
					&& Speler.spelerInvoer.charAt(i) == MastermindSpel.code.charAt(j)){
				System.out.print("+");
				break;
			}//end if
		}//end for
	}//end methode checkLetterAanwezig
	// checkt of de letter in spelerInvoer niet in de code zit.
	static void checkLetterAfwezig(int i) {
		for(int j =0; j < Speler.spelerInvoer.length(); j++) {
			if (Speler.spelerInvoer.charAt(i) != MastermindSpel.code.charAt(j)
					&& Speler.spelerInvoer.charAt(i) == MastermindSpel.code.charAt(j)){
				System.out.print("X");
				break;
			}// end if
		}//end for
	}//end methode checkLetterAfwezig
	
	
	
	
//	als een speler stopt is het spel voorbij
	static void stoppen() {
		Speler.gestopt = true;
		System.out.println("Het spel is gestopt");
	}//end methode stoppen
	
	
}//end class MastermindSpel

class Speler{
	
	static boolean InvoerenMogelijk = true;
	static boolean gestopt = false;
	static String spelerInvoer;
	
	void spelen() {
	
			while(InvoerenMogelijk == true && gestopt == false && MastermindSpel.AantalBeurten <12) {
				System.out.println("Toets je invoer in: ");
				Scanner scanner = new Scanner(System.in);
				spelerInvoer = scanner.nextLine();	
				MastermindSpel.invoerControleren(spelerInvoer);
				MastermindSpel.gokCheck();
	
	
			}//end while
	
	
	}//end methode spelen
}//end class Speler







