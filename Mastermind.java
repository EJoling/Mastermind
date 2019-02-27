import java.util.Random;
import java.util.Scanner;

public class Mastermind {
	
	public static void main (String[] args) {
		System.out.println("Welkom bij Mastermind! Probeer de code van vier letters te raden. Gebruik de letters a, b, c, d, e, f. Letters mogen vaker voorkomen.");
		MastermindSpel spel = new MastermindSpel();
		
		for(int i=0;i<4;i++) {
		System.out.print(spel.code[i]);
		}//end for
		System.out.println("");
		Speler joost = new Speler();
		joost.spelen();
		
		for (int i=0; i<4;i++) {
			if (Speler.spelerInvoer.charAt(i) == spel.code[i]) { 
				System.out.print(0);
			}
			else if(Speler.spelerInvoer.charAt(i) == spel.code[i+1]) {
				System.out.print("+");
			}
			
			else{
					System.out.print("X");
				}//end ifelse
	
		
		}//end for loop
		
		
	}//end main

}//end class Mastermind





class MastermindSpel{
		
	char code[] = new char[4];
		
//	constructor geeft bij elk nieuw spel een code
		MastermindSpel() {
		char codeArray[] = {'a','b','c','d','e','f'};
			for(int i =0; i<4;i++) {
				Random letter = new Random();
				int letterIndex = letter.nextInt(6);
				code [i] = codeArray[letterIndex]; 
			}//end for loop
		}//end constructor MastermindSpel

//	methode om te controleren of de invoer reglementair is
	static void invoerControleren(String codeGok) {
		boolean invoerGeldig = true;
		
			//	controle op stoppen
				if(codeGok.charAt(0) == 'q') {
					invoerGeldig = false;
					MastermindSpel.stoppen();
				}//end if	
			//	controle of de code de juiste letters bevat
				for (int i=0; i<codeGok.length();i++) {
					if (codeGok.charAt(0) != 'q' && invoerGeldig == true && codeGok.charAt(i) != 'a' && codeGok.charAt(i) != 'b' && codeGok.charAt(i) != 'c' && codeGok.charAt(i) != 'd' && codeGok.charAt(i) != 'e' && codeGok.charAt(i) != 'f') {
						System.out.println("De code '"+ Speler.spelerInvoer + "' bevat onjuiste letters.");
						invoerGeldig = false;
						break;
					}//end if loop
				}//end for loop
			//	controle op lengte invoer
				if(codeGok.length() != 4 && codeGok.charAt(0) != 'q' && invoerGeldig == true) {
					System.out.println("De code '" + Speler.spelerInvoer + "' bestaat niet uit 4 letters.");
					invoerGeldig = false;
				}// end if
			//	als de code 4 letters heeft én het zijn letters van de invoer die mag dan wordt de code gecontroleerd
				if(invoerGeldig == true) {
					System.out.println("De code wordt gecheckt. 0: letter op de juiste plaats; +: letter zit wel in de code maar niet op deze plaats; X: letter zit niet in de code");
					Speler.InvoerenMogelijk= false;
				}//end if
	}//end codeControleren

	
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
	
			while(InvoerenMogelijk == true && gestopt == false) {
				System.out.println("Toets je invoer in: ");
				Scanner scanner = new Scanner(System.in);
				spelerInvoer = scanner.nextLine();	
				MastermindSpel.invoerControleren(spelerInvoer);
	
	
	
			}//end while
	
	
	}//end methode spelen
}//end class Speler







