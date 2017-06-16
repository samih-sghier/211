import java.util.Scanner;

/* 
 * This program simulates owls racing!
 * 
 * Fill in all of the following information before submitting.
 * 
 * Samih SGHIER
 * 
 * 
 * I was assisted by:  Pr.Forrest  
 *  
 *   
 * I gave assistance to: Faisal Nawaz
 *  
 *   
 * Brief reflection on what you learned from this programming assignment,
 *  what was the most challenging part, and whether or not you enjoyed it:
 *    The most challenging part must be the 
 *
 */
public class OwlRacingProject1 {

	public static final Scanner CONSOLE = new Scanner(System.in);

	public static void main(String[] args) {

		System.out
				.println("Welcome to the owl race track! Good luck to every participant on this race may the odds be on your favor ");
		System.out.println();
		System.out.print("How many owls will be doing distance trials today? ");
		// the following code waits until the user has typed in a number and hit
		// ENTER,
		// and then the number they typed gets assigned to the
		// numOwlsRacingToday variable.
		int numOwlsRacingToday = CONSOLE.nextInt();
		CONSOLE.nextLine(); // <-- needed because the owl names entered later
							// start on the next line.

		for (int i = 1; i <= numOwlsRacingToday; i++) {
			racing1();
		}
		System.out.println(" Nice effort ! Promising participants , Thank you for racing today see you next time !");

		// TODO: For each owl (i.e. repeat numOwlsRacingToday times)
		// *call* a static method (you'll need to create one below)
		// that will handles the job of racing ONE owl.

		// TODO: After all owls have flown, display some story-ending text.
	}

	// TODO: create another (helper) static method here that will accomplish
	// racing ONE owl.
	// Racing one owl consists of:
	// - asking the user to enter the owl's name (see
	// - calculating how far that owl will go
	// - showing the owl flight animation that goes that distance.
	public static void racing1() {
		System.out.println(" What is the name of the owl racing?");
		String owlName = CONSOLE.nextLine();
		int owlNameLen = owlName.length();

		int dots = owlNameLen * 107 % 41 + 10;
		int distance = dots ;
		System.out.println();
		for (int dotstofly = 0; dotstofly <= dots; dotstofly++) {
			pauseShort();
			scrollConsole();
			for (int i = 0; i <= dotstofly; i++) {
				System.out.print(".");
			}
			System.out.println("*v* <-- " + owlName); 

		

		} System.out.println(" You have flew a distance of  " + distance
				+ " Furlongs");
	}

	public static void pauseShort() {
		try {
			Thread.sleep(200); // 200 milliseconds = 0.2 seconds
		} catch (InterruptedException ex) {
		}
	}public static void scrollConsole() {
		for (int i = 1; i <= 10; i++) {
			System.out.println();
		}
	}
}