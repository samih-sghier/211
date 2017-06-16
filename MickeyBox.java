
/*
 * Name: Samih SGHIER
 * Date: 
 * Course: CSC 211
 * Program: Lab #3G
 * 
 * Purpose: When completed, this program will draw
 * 			Figure 3G.19 on page 223 of the text.
 */

import java.awt.*;

public class MickeyBox {

	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(220, 150);
		panel.setBackground(Color.YELLOW);
		Graphics g = panel.getGraphics();
		g.setColor(Color.blue);
		g.fillOval(50, 25, 40, 40);
		g.fillOval(130, 25, 40, 40);
		g.setColor(Color.RED);
		g.fillRect(70, 45, 80, 80);
		g.setColor(Color.black);
		g.drawLine(70, 85, 150, 85);

	}
}
