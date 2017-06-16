// LAB 6: Debugging the Dice Game!
// Faisal Nawaz And Samih SGHIER  

import java.util.Random;
import java.awt.*;

public class DiceGame {

	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(500,300);
		Graphics g = panel.getGraphics();
		g.setFont(new Font("Arial", Font.BOLD, 20));
		//fillCircle(g,250,150,150);
		
		//2) THEN, fix and thoroughly test the drawDie() method below
		//   does it create the right image for EVERY number of dots (1-6)?
		//drawDie(g, 150, 150, 100, 5); 
 
		
		//3) THEN, fix and thoroughly test the insideRect() method below
		//   See what points it thinks are inside a 100x100 box with top corner at 300,105
		//System.out.println(insideRect(350, 150, 300, 105, 100, 100) + " (should be TRUE)"); // 350,150 IS in the box
		//System.out.println(insideRect(399, 106, 300, 105, 100, 100) + " (should be TRUE)"); // 399,106 IS in the box
		//System.out.println(insideRect(250, 150, 300, 105, 100, 100) + " (should be FALSE)"); // 250,150 is NOT in the box
		//System.out.println(insideRect(450, 150, 300, 105, 100, 100) + " (should be FALSE)"); // 450,150 is NOT in the box
		//System.out.println(insideRect(250, 50, 300, 105, 100, 100) + " (should be FALSE)"); // 250,50 is NOT in the box
		//System.out.println(insideRect(250, 250, 300, 105, 100, 100) + " (should be FALSE)"); // 250,250 is NOT in the box 
		//System.out.println(insideRect(0, 0, 300, 100, 105, 100) + " (should be FALSE)"); // 0,0 is NOT in the box
		//System.out.println(insideRect(5000, -5000, 300, 105, 100, 100) + " (should be FALSE)"); // 5000,-5000 is NOT in the box
		
		
		//4) Finally, fix and thoroughly test the playGame() method that puts it all together!
		//    Carefully test EVERY piece of the game's functionality, as described on the Lab sheet.
		//    There are LOTS of bugs to fix in this method!
		playGame(panel, g);

	}

	
	/** Creates ONE filled circle CENTERED at (centerX,centerY) with the given RADIUS */ 
	public static void fillCircle(Graphics g, int centerX, int centerY, int radius) {
		g.fillOval(centerX-radius,centerY-radius,2*radius,2*radius);
	
	}
	
	/** Draws one die (white square with black dots) with the top left corner at (x,y), 
	 *  with side length given by *size*, and showing dieValue # of dots. 
	 */
	public static void drawDie(Graphics g, int x, int y, int size, int dieValue) {
		// draw the outside square for the die
		g.setColor(Color.WHITE);
		g.fillRect(x,y,size, size);
		g.setColor(Color.BLACK);
		g.drawRect(x,y,size, size);
	
		int dotRadius = size / 12;
		if (dieValue % 2 == 1 ) { // dice value is odd, so there's a dot in the center
			fillCircle(g, x+size/2, y+size/2, dotRadius); // make the middle dot				
		}
		if (dieValue >= 2) {
			fillCircle(g, x+size*1/4, y+size*1/4, dotRadius); // make down/right diagonal dots 
			fillCircle(g, x+size*3/4, y+size*3/4, dotRadius);
		}
		
		if  (dieValue >= 4) {
			fillCircle(g, x+size*1/4, y+size*3/4, dotRadius); // make up/left diagonal dots
			fillCircle(g, x+size*3/4, y+size*1/4, dotRadius);				
		}
		if (dieValue == 6)
		{
			fillCircle(g, x+size*1/4, y+size*1/2, dotRadius); // make the middle pair of dots 
			fillCircle(g, x+size*3/4, y+size*1/2, dotRadius); 

		}
	}
	
	/** Returns *true* if the clicked coordinates are inside the rectangle with 
	 * the given top left coordinate (x,y) and width & height, and *false* otherwise.
	 */
	public static boolean insideRect(int clickX, int clickY, int x, int y, int width, int height) {
		if (clickX >= x && clickX <= x + width 
				&& clickY >= y && clickY <= y + height) {
			return true;
		} else {
			return false;
		}
	}	

	public static void playGame(DrawingPanel panel, Graphics g) {
		
		Random randomGen = new Random();
		
		int dieOneVal = 1;
		int dieTwoVal = 1;
		int dieThreeVal = 1;
		int sum = 3;
		int numRolls = 0;
		drawDie(g,100,100,90,dieOneVal);
		drawDie(g,200,100,90,dieTwoVal);
		drawDie(g,300,100,90,dieThreeVal);

		// Note: the panel.isVisible() condition allows the program to stop running if the user closes the window
		while (panel.isVisible() && sum != 15) {
			g.setColor(Color.BLACK);
			g.drawString("Roll a sum of 15 to win!", 150, 30);
			g.drawString("Sum: " + sum, 100, 70);
			g.drawString("Rolls: " + numRolls, 300, 70);

			g.drawString("Click a die to roll that one", 130, 240);
			g.drawString("or click anywhere else to roll all three.", 80, 280);
			
			while (!panel.checkMouseClicked() && panel.isVisible()) { // NOTE: no bug in this WHILE loop!
				panel.sleep(30); // keep waiting until there is a mouse click (or the panel window gets closed)
			}
			int mouseX = panel.getMouseClickX(); // NOTE: 
			int mouseY = panel.getMouseClickY(); // no bug on these two lines either!

			if (insideRect(mouseX, mouseY, 100, 100, 90, 90)) {
				dieOneVal = randomGen.nextInt(6) + 1; // re-roll die #1
			} 
			else if (insideRect(mouseX, mouseY, 200, 100, 90, 90)) {
				dieTwoVal = randomGen.nextInt(6) + 1; // re-roll die #2
			} 
			else if (insideRect(mouseX, mouseY, 300, 100, 90, 90)) {
				dieThreeVal = randomGen.nextInt(6) + 1; // re-roll die #3 
			} 
			else  { // if they clicked ANYWHERE else, re-roll ALL three die!
				dieOneVal = randomGen.nextInt(6) + 1;
				dieTwoVal = randomGen.nextInt(6) + 1;
				dieThreeVal = randomGen.nextInt(6) + 1;
			}			
			panel.clear();			
			drawDie(g,100,100,90,dieOneVal);
			drawDie(g,200,100,90,dieTwoVal);
			drawDie(g,300,100,90,dieThreeVal);
			sum = dieOneVal + dieTwoVal + dieThreeVal;
			numRolls = numRolls + 1;
		}
		
		g.drawString("You won after " + numRolls + " rolls!", 150, 240);		
	}
}