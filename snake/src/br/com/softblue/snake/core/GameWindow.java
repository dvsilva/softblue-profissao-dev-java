package br.com.softblue.snake.core;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import br.com.softblue.snake.graphics.Renderer;
import br.com.softblue.snake.scene.Snake;
import br.com.softblue.snake.util.Constants;

public class GameWindow extends JFrame implements KeyListener {

	private static final long serialVersionUID = 600781221350167842L;

	private Renderer renderer;
	private Snake snake;

	private Image buffer;
	private Graphics gImage;
	
	private Rectangle drawingArea;

	private long lastKeyboardEventType;

	public GameWindow(Snake snake) {
		this.snake = snake;

		setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		setResizable(false);
		setTitle(Constants.WINDOW_TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

		// problema do flicker - double buffering
		// o repaint coloca no buffer (imagem) e o java renderiza
		// enquanto desenha e ao mesmo tempo chega informação
		buffer = createImage(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		gImage = buffer.getGraphics();
		renderer = new Renderer(gImage);

		addKeyListener(this);
		defineDrawingArea();
	}

	@Override
	public void paint(Graphics gScreen) {
		if(gImage == null && renderer == null)
			return;
		
		renderer.render();
		gScreen.drawImage(buffer, 0, 0, null);
	}

	private void defineDrawingArea() {
		int realHeight = (int) getContentPane().getSize().getHeight();
		int upperY = Constants.WINDOW_HEIGHT - realHeight;
		drawingArea = new Rectangle(0, upperY, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT - upperY);
	}
	
	public Rectangle getDrawingArea() {
		return drawingArea;
	}

	public Renderer getRenderer() {
		return this.renderer;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		long now = System.currentTimeMillis();
		
		if(now - lastKeyboardEventType < 40)
			return;
		
		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_UP) {
			snake.up();
		} else if (keyCode == KeyEvent.VK_DOWN) {
			snake.down();
		} else if (keyCode == KeyEvent.VK_LEFT) {
			snake.left();
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			snake.right();
		} else if (keyCode == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		
		lastKeyboardEventType = now;
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}