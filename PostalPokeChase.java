// TODO: <-- Expand the comment header up here and fill it in!
/**
 * This program is a game about catching a new Pokemon who will perform 
 * mail delivery for the wizarding world.
 *  
 * @author Lucas Simon, Alyssa Nestor, and Samih Sghier
 * @date October 19, 2016
 * 
 * Does this program meet all the assignment specifications? Yes
 *
 * Follow-up: if you had more time to work on this program, what would you do?
 * 
 * If working in a pair, briefly explain EACH author's contribution to the project:
 * Each person worked on every part together for problem solving, typing, and debugging
 * an equal amount. As a result, it was difficult to determine who did what. 
 * 
 * I was assisted by: 
 * Abbey (Sunday tutor) helped us debug our Stampachu creature 
 * when it was randomly moving around the drawingPanel.  
 * 
 * Ta Quang Minh helped us increase the 
 * time in our countdown timer once the user scores.
 *   
 * I gave assistance to: N/A
 *   
 * Brief reflection on what you learned from this programming assignment
 * and whether or not you enjoyed it:
 * 
 * This project has given us a lot of experience using procedural decomposition because the game was somewhat complicated
 * to write. Splitting the project up into smaller pieces which made the project much easier to accomplish. We gained experience 
 * using while loops and also using booleans in the while loop. All group members definitely enjoyed making and playing the game
 * as well. 
 *   
 */

import java.awt.*;
import java.util.Random;

public class PostalPokeChase {
	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(800, 600);
		Graphics g = panel.getGraphics();

		panel.setBackground(Color.LIGHT_GRAY);
		g.setFont(new Font("SansSerif", Font.BOLD, 20));
		g.drawString("Click the mouse to start the chase.", 255, 300);
		g.drawString("Score at least 20 points to WIN!", 270, 325);
		while (!panel.checkMouseClicked()) {
			panel.sleep(100);
		}
		panel.clear();
		int pokeballX = 300;
		int pokeballY = 300;

		int time = 500;
		int countdownNumber = 6;
		// This while loop runs the timer before the game starts
		while (time > 0) {

			if (time % 100 == 0) {
				countdownNumber--;
			}
			g.setFont(new Font("Monospaced", Font.PLAIN, 12));
			g.drawString("Game will start in: " + countdownNumber, 600, 50);
			drawPokeball(panel, g, pokeballX, pokeballY);
			panel.sleep(10);
			int speed = 0;

			pokeballX = pokeballXCoordinate(panel, pokeballX, speed);
			pokeballY = pokeballYCoordinate(panel, pokeballY, speed);
			time--;
			panel.clear();

		}
		// This calculates the random coordinates for the stampachu
		Random rand = new Random();
		int currentStampX = 0;
		int currentStampY = 60;
		int destStampX = rand.nextInt(740);
		int destStampY = rand.nextInt(560) + 40;

		time = 1000;
		int countdownNumberGame = 11;

		int score = 0;
		// This while loop runs the game itself
		while (panel.isVisible() && time > 0) {
			panel.clear();
			if (time % 100 == 0) {
				countdownNumberGame--;
			}
			// This updates the score, time, and stampachu coordinates once the
			// user scores
			if (score(pokeballX, pokeballY, currentStampX, currentStampY)) {
				score++;
				time += 100;
				countdownNumberGame++;
				currentStampX = destStampX;
				currentStampY = destStampY;
				drawStampachu(panel, g, currentStampX, currentStampY);
				destStampX = rand.nextInt(740);
				destStampY = rand.nextInt(560) + 40;
			}
			g.drawString("Time Remaining: " + countdownNumberGame, 600, 50);
			g.drawString("Score: " + score, 660, 65);
			// Once the stampachu gets within 2 pixels of its destination, it
			// calculates a new destination
			if (Math.abs(currentStampX - destStampX) <= 2 && Math.abs(currentStampY - destStampY) <= 2) {
				destStampX = rand.nextInt(740);
				destStampY = rand.nextInt(560) + 40;

			}

			// These if statements move the stampachu to its new destination
			if (destStampX < currentStampX && destStampY < currentStampY) {
				currentStampX = currentStampX - 2;
				currentStampY = currentStampY - 2;
			} else if (destStampX > currentStampX && destStampY > currentStampY) {
				currentStampX = currentStampX + 2;
				currentStampY = currentStampY + 2;
			} else if (destStampX > currentStampX && destStampY < currentStampY) {
				currentStampX = currentStampX + 2;
				currentStampY = currentStampY - 2;
			} else if (destStampX < currentStampX && destStampY > currentStampY) {
				currentStampX = currentStampX - 2;
				currentStampY = currentStampY + 2;
			} else {
				currentStampX = destStampX;
				currentStampY = destStampY;

			}
			drawStampachu(panel, g, currentStampX, currentStampY);

			drawPokeball(panel, g, pokeballX, pokeballY);

			int speed = 0;

			pokeballX = pokeballXCoordinate(panel, pokeballX, speed);
			pokeballY = pokeballYCoordinate(panel, pokeballY, speed);

			panel.sleep(10);
			time--;
		}
		panel.clear();
		g.setFont(new Font("SansSerif", Font.BOLD, 20));
		if (score >= 20) {
			g.drawString("You WIN!", 330, 300);
		} else {
			g.drawString("You LOSE! Try Again.", 300, 300);
		}

	}

	// This method draws the pokeball
	public static void drawPokeball(DrawingPanel panel, Graphics g, int pokeballX, int pokeballY) {
		g.setColor(Color.BLACK);
		g.fillOval(pokeballX, pokeballY, 30, 30);
		g.setColor(Color.RED);
		g.fillArc(pokeballX, pokeballY, 30, 30, 0, 180);
		g.setColor(Color.WHITE);
		g.fillArc(pokeballX, pokeballY, 30, 30, 0, -180);
		g.setColor(Color.BLACK);
		g.fillOval(pokeballX + 11, pokeballY + 11, 8, 8);
		g.drawLine(pokeballX, pokeballY + 15, pokeballX + 15, pokeballY + 15);
		g.drawLine(pokeballX + 15, pokeballY + 15, pokeballX + 30, pokeballY + 15);

	}

	// This method draws the Stampachu
	public static void drawStampachu(DrawingPanel panel, Graphics g, int currentStampX, int currentStampY) {
		g.fillRect(currentStampX, currentStampY, 30, 10);
		g.fillRect(currentStampX + 10, currentStampY - 12, 7, 12);
		g.fillOval(currentStampX + 10, currentStampY - 20, 7, 7);

	}

	// This method helps the pokeball follow the cursor along the x-axis
	public static int pokeballXCoordinate(DrawingPanel panel, int pokeballX, int speed) {
		speed += 1;
		if (panel.getMouseX() < pokeballX) {
			pokeballX = (pokeballX - 2) - speed;
		} else if (panel.getMouseX() > pokeballX) {
			pokeballX = (pokeballX + 2) + speed;
		} else {
			pokeballX = pokeballX;
		}
		return pokeballX;
	}

	// This method helps the pokeball follow the cursor along the y-axis
	public static int pokeballYCoordinate(DrawingPanel panel, int pokeballY, int speed) {
		speed += 1;
		if (panel.getMouseY() < pokeballY) {
			pokeballY = (pokeballY - 2) - speed;
		} else if (panel.getMouseY() > pokeballY) {
			pokeballY = (pokeballY + 2) + speed;
		} else {
			pokeballY = pokeballY;
		}

		return pokeballY;
	}

	// This method determines of the center of the pokeball is within
	// the bottom rectangle of the stampachu and returns true
	public static boolean score(int pokeballX, int pokeballY, int currentStampX, int currentStampY) {
		if ((pokeballX + 15 >= currentStampX && pokeballX + 15 <= currentStampX + 30)
				&& (pokeballY + 15 >= currentStampY && pokeballY + 15 <= currentStampY + 10)) {
			return true;
		} else {
			return false;
		}
	}
}