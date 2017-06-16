/*
 * Name: Samih SGHIER
 * Date: 
 * Course: CSC 211
 * Program: Lab #3G
 * 
 * Purpose: When completed, this program will draw
 * 			Figure 3G.20 on page 224 of the text,
 *          with the added bonus of displaying your name on it!
 */

import java.awt.*;

public class MickeyBox2 {

	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(450, 150);
		panel.setBackground(Color.YELLOW);
		Graphics g = panel.getGraphics();
		
		drawFigure(g, 50, 25);
		drawFigure(g, 250, 45);
	g.setColor(new Color(5,80,45));
		g.setFont(new Font("SansSerif", Font.ITALIC, 10));
		g.drawString("Samih SGHIER", 175, 60);
	}
	/**
	 * Method drawFigure draws the figure shown in Fig .3G.20 at the given ( x,
	 * y ) position. Parameters: g is the " graphics " pen x is the x-coordinate
	 * of the upper-left corner of the left oval y is the y-coordinate of the
	 * upper-left corner of the left oval
	 */
	public static void drawFigure(Graphics g, int x, int y) {
		g.setColor(Color.blue);
		g.fillOval(x, y, 40, 40);
		g.fillOval(x + 80, y, 40, 40);
		g.setColor(Color.RED);
		g.fillRect(x + 20, y + 20, 80, 80);
		g.setColor(Color.black);
		g.drawLine(x + 20, y + 60, x + 100, y + 60);
		
	}
}