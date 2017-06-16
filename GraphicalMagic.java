
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.*;

public class GraphicalMagic {

	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(350, 250);
		panel.setBackground(Color.ORANGE);
		Graphics g = panel.getGraphics();

		g.setColor(new Color(5,80,45));
		g.fillRect(45, 0, 10, 10);
		g.fillRect(40, 10, 20, 10);
		g.fillRect(35, 20, 30, 10);
		g.fillRect(30, 30, 40, 10);
		g.fillRect(25, 40, 50, 10);
		g.fillRect(20, 50, 60, 10);
		g.fillRect(15, 60, 70, 10);
		g.fillRect(10, 70, 80, 10);
		g.fillRect(5, 80, 90, 10);
		g.fillRect(0, 90, 100, 10);
		g.setColor(Color.BLACK);
		g.fillRect(40, 100, 20, 70);
		g.setColor(Color.RED);
		g.fillOval(24, 140, 10, 10);
		g.fillOval(22, 157, 10, 10);
		g.fillOval(19, 115, 10, 10);
		g.fillOval(70, 147, 10, 10);
		g.fillOval(104, 151, 10, 10);
		g.fillOval(76, 121, 10, 10);
		g.setColor(Color.BLACK);
		g.setFont(new Font("SansSerif", Font.ITALIC, 50));
		g.drawString("Fall", 175, 60);
	}
}
