package br.com.softblue.snake.util;

import java.util.List;

import br.com.softblue.snake.graphics.Rect;

public class GameUtils {

	public static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {}
	}
	
	public static void moveRects(List<Rect> rects) {
		// muda a posicao do retangulo na lista para fazer a movimentacao
		for (int index = rects.size() - 1; index >= 1; index--) {
			rects.set(index, rects.get(index -1));
		}
	}
}
