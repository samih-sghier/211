

import java.awt.Color;
import java.util.Scanner;

public class BatchArtMaker {

	public static void main(String[] args) {

		Scanner console = new Scanner(System.in);
		System.out.println("What mode of art would you like to generate (circle / ...)? ");
		String artMode = console.next();
		System.out.println("What bird number would you like to start at? ");
		int startNum = console.nextInt();
		System.out.println("What bird number would you like to end at? ");
		int endNum = console.nextInt();
		System.out.println("How many columns of dots would you like? ");
		int numDotColumns = console.nextInt();
		System.out.println("How many rows of dots would you like? ");
		int numDotRows = console.nextInt();
		System.out.println("What dot size? ");
		int dotSize = console.nextInt();
		System.out.println("What canvas width for output of the art? ");
		int canvasWidth = console.nextInt();
		System.out.println("What canvas height for output of the art? ");
		int canvasHeight = console.nextInt();
		
		
		DrawingPanel photoPanel = new DrawingPanel(1, 70);
		DrawingPanel canvas = new DrawingPanel(canvasHeight,canvasWidth);
		canvas.setBackground(Color.DARK_GRAY);
		
for (int i = startNum ; i<=endNum ; i++ ){
	String fileNameWithPath = "images1/bird" + i + ".jpg";
	photoPanel.loadImageAndResizeWindow(fileNameWithPath);

	
	ArtMaker.makeArt( photoPanel,  canvas,  numDotRows,  numDotColumns,
			 dotSize, artMode) ;
	canvas.saveImageWithoutErrors("images1/bird" + i + ".png");
	
	canvas.clear();
}
		// TODO: fill in code here to convert a whole range of birdX.jpg images into 
		// art_birdX.png images. 
		// (Remember the image files are all stored in the images/ subfolder)

		
	}
}
