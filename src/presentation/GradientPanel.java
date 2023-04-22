package presentation;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GradientPanel extends JPanel {
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(new GradientPaint(0, 0, Color.BLUE, 0, getHeight(), Color.WHITE));
		g2d.fillRect(0, 0, getWidth(), getHeight());
	}
}
