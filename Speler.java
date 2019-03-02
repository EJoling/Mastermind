import java.util.Scanner;

public class Speler {

	static boolean InvoerenMogelijk = true;
	static boolean gestopt = false;
	static String spelerInvoer;
	
	void spelen() {
	
			while(InvoerenMogelijk == true && gestopt == false && MastermindSpel.aantalBeurten >0) {
				invoeren();
				
				MastermindSpel.gokCheck();
	
	
			}//end while
	
	
	}//end methode spelen
	
	static void invoeren() {
		System.out.println("Toets je invoer in: ");
		Scanner scanner = new Scanner(System.in);
		spelerInvoer = scanner.nextLine();
		MastermindSpel.invoerControleren(spelerInvoer);
	}
	
//	als een speler stopt is het spel voorbij
	static void stoppen() {
		Speler.gestopt = true;
		System.out.println("Het spel is gestopt");
	}//end methode stoppen
	
}//end class Speler
