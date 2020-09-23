package snake;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Renderer {

	private List<Drawable> drawables;

	public Renderer() {
		drawables = new ArrayList<Drawable>();
	}

	public void render(Graphics g) {
		for (Drawable d : drawables)
			d.draw(g);
	}

	public void add(Drawable d) {
		drawables.add(d);
	}

	public void remover(Drawable d) {
		drawables.remove(d);
	}

}
