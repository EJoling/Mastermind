import java.util.Random;


public class MastermindSpel{
		
	static String code = "";
	static char[] codeKopie = new char[4];
	static int aantalBeurten = 12;
	static Speler speler;
	static int AantalCorrect;
	static int AantalAanwezig;
	
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
				
	}//end invoerControleren

	// Controle op gokCheck: zitten de letters erin op de juiste plek, erin op een andere plek of er niet in
	static void gokCheck() {
		if(Speler.gestopt != true) {
			System.out.println("De code wordt gecheckt.");
			MastermindSpel.AantalCorrect = 0;
			MastermindSpel.AantalAanwezig = 0;
			MastermindSpel.codeKopie = MastermindSpel.code.toCharArray();
			for (int i=0; i<Speler.spelerInvoer.length();i++) {
				checkLetterOpGoedePlek(i);
			}//end for loop
		
			for (int i=0; i<Speler.spelerInvoer.length();i++) {
				checkLetterAanwezig(i);
			}//end for loop
			
			for (char element:MastermindSpel.codeKopie) {
				switch(element) {
				case'Z': 
					MastermindSpel.AantalCorrect++;
					break;
				case'W': 
					MastermindSpel.AantalAanwezig++;
					break;
				}//end switch
			}//end for
			
			
			
			if (MastermindSpel.AantalCorrect == 4) {
				System.out.println("Goed gedaan, je hebt de code gekraakt!");
				Speler.gestopt = true;
			}//end if
			else if(MastermindSpel.AantalCorrect < 4 && MastermindSpel.AantalCorrect != 0) {
				System.out.println("Aantal letters op de goede plek: "+MastermindSpel.AantalCorrect+ ".");
			}//end else if1
			
			
			if (MastermindSpel.AantalAanwezig <= 4 && MastermindSpel.AantalAanwezig != 0) {
				System.out.println("Aantal letters wel in de code aanwezig, maar op een andere plek: "+MastermindSpel.AantalAanwezig+ " .");
			}//end else if1
			
			if(MastermindSpel.AantalCorrect == 0 && MastermindSpel.AantalAanwezig == 0) {
				System.out.println("Helaas, van de letters die je hebt ingevoerd staat er niks in de te raden code.");
			}//end else if3
			
//			Print om te testen
			for(int i =0 ; i < MastermindSpel.codeKopie.length ; i++) {
				System.out.print(MastermindSpel.codeKopie[i]);
			}
				System.out.println("");
			
		aantalBeurten--;
		System.out.println("Dit was beurt " + (12-aantalBeurten) + ". Je hebt nog "+aantalBeurten+" beurten om de juiste code te raden.");
		}//end if
	}//end methode gokCheck
	
	
	// Checkt of de letter in spelerInvoer op dezelfde plek staat als in de code
	//verander dan die letter in codeKopie in Z zodat de volgende letter deze niet nogmaals beoordeelt
	static void checkLetterOpGoedePlek(int i) {
			if (Speler.spelerInvoer.charAt(i) == MastermindSpel.codeKopie[i]) {
				MastermindSpel.codeKopie[i] = 'Z';
			}//end if
	}//end methode checkLetterOpGoedePlek

	// Checkt of de letter in spelerInvoer wel in de code staat, maar niet op dezelfde plek: 
	//verandert dan deze letter in codeKopie in W zodat de volgende letter deze niet nogmaals beoordeelt
	static void checkLetterAanwezig(int i) {
		for(int j =0; j < MastermindSpel.codeKopie.length; j++) {
			if (Speler.spelerInvoer.charAt(i) == MastermindSpel.codeKopie[j]){
				MastermindSpel.codeKopie[i] = 'W';
				break;
			}//end if
		}//end for
	}//end methode checkLetterAanwezig

	


	
}//end class MastermindSpel
