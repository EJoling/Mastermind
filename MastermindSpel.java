import java.util.Random;


public class MastermindSpel{
		
	static  String code = "";
//	static String letterInCode = "";
	static int aantalBeurten = 12;
	static Speler speler;
	
//	constructor geeft bij elk nieuw spel een code
		MastermindSpel() {
			for(int i =0; i<4;i++) {
				Random r = new Random();
				int letterIndex = r.nextInt(6);
				char letter = (char)(letterIndex + 97);
				code += letter; 
				
			}//end for loop
		}//end constructor MastermindSpel

	static void starten(Speler s) {
		speler = s;
		System.out.println("Welkom bij Mastermind! Probeer de code van vier letters te raden. "
				+ "Gebruik de letters a, b, c, d, e, f. Letters mogen vaker voorkomen. "
				+ "Je hebt hiervoor "+aantalBeurten+" beurten.");
		speler.spelen();
	}//end class starten
		
//	methode om te controleren of de invoer reglementair is
	static void invoerControleren(String codeGok) {
		boolean invoerGeldig = false;
		
			//	controle op stoppen
				if(codeGok.charAt(0) == 'q') {
					invoerGeldig = true;
					Speler.gestopt = true;
					Speler.stoppen();
				}//end if	
				
				
			//	controle of de code de juiste letters bevat
				for (int i=0; i<codeGok.length();i++) {
					if (codeGok.charAt(0) != 'q' 
						&& codeGok.charAt(i) != 'a' 
						&& codeGok.charAt(i) != 'b' 
						&& codeGok.charAt(i) != 'c' 
						&& codeGok.charAt(i) != 'd' 
						&& codeGok.charAt(i) != 'e' 
						&& codeGok.charAt(i) != 'f') {
						
						System.out.println("De code '"+ Speler.spelerInvoer + "' bevat onjuiste letters.");
						Speler.invoeren();
						break; 
					}//end if loop
					else { 
						invoerGeldig = true;
						}//end else
					}//end for loop
				
				//	controle op lengte invoer
				if(codeGok.length() != 4 
						&& codeGok.charAt(0) != 'q' 
						&& invoerGeldig == true) {					
					System.out.println("De code '" + Speler.spelerInvoer + "' bestaat niet uit 4 letters.");
					invoerGeldig = false;
					Speler.invoeren();
				}// end if
				
				
				
			//	als de code 4 letters heeft én het zijn letters van de invoer die mag dan wordt de code gecontroleerd
				if(invoerGeldig == true && codeGok.charAt(0) != 'q') {
					System.out.println("De code wordt gecheckt. 0: letter op de juiste plaats; +: letter zit wel in de code maar niet op deze plaats; X: letter zit niet in de code");
				}//end if
	}//end invoerControleren

	// Controle op gokCheck: zitten de letters erin op de juiste plek, erin op een andere plek of er niet in
	static void gokCheck() {
		if(Speler.gestopt != true) {
			for (int i=0; i<Speler.spelerInvoer.length();i++) {
				System.out.println("gokCheck in Mm");
				checkLetterOpGoedePlek(i);
				checkLetterAanwezig(i);
				checkLetterAfwezig(i);
			}//end for loop
	//	System.out.println("	 lettersInCode:"+MastermindSpel.letterInCode);
		aantalBeurten--;
		System.out.println("");
		System.out.println("Dit was beurt " + (12-aantalBeurten) + ". Je hebt nog "+aantalBeurten+" beurten om de juiste code te raden.");
		}//end if
	}//end methode gokCheck
	
	
	// Checkt of de letter in spelerInvoer op dezelfde plek staat als in de code
	static void checkLetterOpGoedePlek(int i) {
		for(int j =0; j < Speler.spelerInvoer.length(); j++) {
			if (Speler.spelerInvoer.charAt(i) == MastermindSpel.code.charAt(i)) {
				System.out.print("0");
				//letterInCode += Speler.spelerInvoer.charAt(i);
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
					//&& Speler.spelerInvoer.charAt(i) != MastermindSpel.code.charAt(j)
					){
				System.out.print("X");
				break;
			}// end if
		}//end for
	}//end methode checkLetterAfwezig
	
	
	
	

	
}//end class MastermindSpel
