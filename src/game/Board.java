/**
 * Class for the board with the positions of snakes and ladders
 */
package game;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Board {

	//The position a player has to reach to win the game
	final int WIN_CONDITION = 100;

	//To store the positions of snakes and ladders on the board
	private Map<Integer, Integer> snakes = new HashMap<>();
	private Map<Integer, Integer> ladders = new HashMap<>();

	public Map<Integer, Integer> getSnakes() {
		return snakes;
	}

	public Map<Integer, Integer> getLadders() {
		return ladders;
	}

	/**
	 * Constructor to initialise the board.
	 */
	public Board() {
		snakes.put(99, 7);
		snakes.put(92, 35);
		snakes.put(78, 39);
		snakes.put(73, 53);
		snakes.put(37, 17);
		snakes.put(31, 14);

		ladders.put(5, 25);
		ladders.put(10, 29);
		ladders.put(28, 55);
		ladders.put(22, 41);
		ladders.put(44, 95);
		ladders.put(70, 89);
		ladders.put(79, 81);
	}

	/**
	 * Method simulating the rolling of dice
	 * @return The number obtained on the dice.
	 */
	int rollDice() {
		return new Random().nextInt(6) + 1;
	}
}
