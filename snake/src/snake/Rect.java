package snake;

import java.awt.Color;
import java.awt.Graphics;

public class Rect {

	private Color color;
	private int x;
	private int y;
	private int width;
	private int heigth;

	public Rect(Color color, int x, int y, int width, int heigth) {
		super();
		this.color = color;
		this.x = x;
		this.y = y;
		this.width = width;
		this.heigth = heigth;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeigth() {
		return heigth;
	}

	public Color getColor() {
		return color;
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, heigth);
	}

}
