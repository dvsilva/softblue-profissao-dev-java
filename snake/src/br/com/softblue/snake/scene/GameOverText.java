package br.com.softblue.snake.scene;

import static br.com.softblue.snake.util.Constants.GAME_OVER_COLOR;
import static br.com.softblue.snake.util.Constants.GAME_OVER_LOCATION;
import static br.com.softblue.snake.util.Constants.GAME_OVER_TEXT;

import br.com.softblue.snake.graphics.Text;

public class GameOverText extends Text {

	public GameOverText(int score) {
		super(String.format(GAME_OVER_TEXT, score), GAME_OVER_LOCATION, GAME_OVER_COLOR);
	}
}