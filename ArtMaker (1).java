// IMPORTANT.  Click the (+) at left to expand this comment and FILL OUT the header information!

/**
 * Fill in all of the following information before submitting.

 * Description: This program transforms images into simulated-Pointillist art!
 * 
 * @author Samih SGHIER
 * @date Oct 5, 2016
 * 
 * Does this program meet all the assignment specifications?   Y/N
 * If NO, then list what WORKS and what DOESN'T (known caveats) here: 
 *
 * I was assisted by:  (list persons/sources if applicable) 
 *  (Explain the contribution) Pr.Forrest , Vecna
 * 
 * I gave assistance to: (list classmates if applicable)
 * (Explain how you assisted)
 * 
 *   
 * Brief reflection on what you learned from this programming assignment
 *  and whether or not you enjoyed it:
 */

import java.awt.*;
import java.util.Scanner;

public class ArtMaker {

	public static void main(String[] args) {

		Scanner Console = new Scanner(System.in);

		// TODO: *Eventually* you want to read your variables in from the
		// console,
		// but you might want to just set variables directly while you're
		// testing
		// so you don't have to type in a bunch of things every time you want to
		// test!
		System.out.print("Please type in  the name of the image: ");
		String fileName = Console.nextLine();
		

		System.out.print("What mode of art would you like to make ");
		String dotMode = Console.nextLine();
		System.out.print("Please type in the number of rows you would like");
		int numDotRows = Console.nextInt();
		System.out.print("Please type in the number of column you would like ");
		int numDotCol = Console.nextInt();
		System.out.print("Please type in the diameter  of dots you would like ");
		int diameter = Console.nextInt();
		System.out.print("Please type in the width you would like");
		int width = Console.nextInt();
		System.out.print("Please type in the height you would like ");
		int height = Console.nextInt();

		DrawingPanel canvasPanel = new DrawingPanel(width, height);
		canvasPanel.setBackground(Color.DARK_GRAY);

		// The file path includes the folder name... that is, Java must look for
		// the
		// image file inside the "images" subfolder, instead of the main project
		// folder.

		// TODO: when you prompt the user for the mode, be sure to tell them
		// their choices!
		// TODO: create more variables to store data from the user,
		// IN THE EXACT ORDER specified in the assignment sheet.

		// TODO: Create a DrawingPanel for the new art canvas with
		// the width and height of this panel as specified above

		// TODO: Create a DrawingPanel to hold the original photograph image
		String fileNameWithPath = "images/" + fileName;
		DrawingPanel photoPanel = new DrawingPanel(1, 60);
		photoPanel.loadImageAndResizeWindow(fileNameWithPath);
		
		makeArt(photoPanel, canvasPanel, numDotRows, numDotCol, diameter, dotMode);
		
	}

	// TODO: You should put a /** */ comment here explaining what this method
	// does, and what each parameter means.
	// make art  paints the image from the photoPanel using dots on the canvasPanel
	public static void makeArt(DrawingPanel photoPanel, DrawingPanel canvasPanel, int numDotRows, int numDotCol,
			int diameter, String dotMode) {
		// TODO: Fill in this method (see Assignment Sheet for details).
		Graphics g = canvasPanel.getGraphics();
		
		int x = (canvasPanel.getWidth() - diameter * numDotCol) / numDotCol;
		int y = (canvasPanel.getHeight() - diameter * numDotRows) / numDotRows;
		
		for (int row = 0; row < numDotRows; row++) {
			for (int column = 0; column < numDotCol; column++) {
				g.setColor(photoPanel.getColorAtPixel(photoPanel.getWidth() * column / numDotCol,
						photoPanel.getHeight() * row / numDotRows));
				
				 if (dotMode.equals("circle")) {
					g.fillOval((diameter + x) * column, (diameter + x) * row, diameter, diameter);
				}else if (dotMode.equals("rectangle")) {
					g.fillRect((diameter + y) * column, (diameter + y) * row, diameter, diameter);}
			}

		}
	}
}
	
