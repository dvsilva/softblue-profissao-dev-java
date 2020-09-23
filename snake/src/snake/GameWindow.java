package snake;

import java.awt.Graphics;

import javax.swing.JFrame;

public class GameWindow extends JFrame {

	private static final long serialVersionUID = 600781221350167842L;

	private Renderer renderer;

	public GameWindow() {
		renderer = new Renderer();

		setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		setResizable(false);
		setTitle(Constants.WINDOW_TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		renderer.render(g);
	}

	public Renderer getRenderer() {
		return this.renderer;
	}

}