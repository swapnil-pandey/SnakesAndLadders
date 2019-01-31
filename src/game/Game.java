/**
 * Class for the game
 */
package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Game {

	static Board board = new Board();

	/**
	 * To prompt the player to roll a dice by pressing 'r'. The player will be asked
	 * again and again till the key 'r' is pressed.
	 * 
	 * @param player Id
	 */
	private int rollDicePrompt(int playerId) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = null;
		while (true) {
			System.out.print("\nPlayer " + playerId + " enter 'r' to roll dice: ");

			try {
				input = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (input.equalsIgnoreCase("r")) {
				return board.rollDice();
			}
		}
	}

	/**
	 * To decide the turns of players. First, all players roll the die and the
	 * highest scorer will start the game first and the game continues in the
	 * descending order of the die score.
	 * 
	 * @param number of players
	 * @return list of players with proper play order
	 */
	public List<Player> decideTurns(int numPlayers) {
		List<Player> players = new ArrayList<Player>();
		List<ArrayList<Integer>> turnDecide = new ArrayList<ArrayList<Integer>>();

		for (int i = 1; i <= numPlayers; i++) {
			int roll = rollDicePrompt(i);
			System.out.println("You rolled a: " + roll);
			turnDecide.add(new ArrayList<Integer>(Arrays.asList(i, roll)));
		}
		Collections.sort(turnDecide, new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				return o2.get(1).compareTo(o1.get(1));
			}
		});
		for (ArrayList<Integer> turn : turnDecide) {
//			System.out.println(turn);
			players.add(new Player(turn.get(0)));
		}
		return players;

	}

	/**
	 * Simulate the rolling of dice turn by turn and then arriving on the final
	 * destination accordingly.
	 * 
	 * @param List of players playing the game
	 */
	private void play(List<Player> players) {
//		System.out.println(players);
		boolean won = false;
		while (!won) {
			for (int i = 0; i < players.size(); i++) {
				int roll = rollDicePrompt(players.get(i).getId());
				int newPosition = playerPosition(players.get(i), roll);
				players.get(i).setCurrPos(newPosition);
				if (players.get(i).getCurrPos() == board.WIN_CONDITION) {
					System.out.println("Game Won by Player " + players.get(i).getId());
					won = true;
					break;
				}
			}
		}
	}

	/**
	 * To calculate the position of the player after a dice roll.
	 * 
	 * @param Player rolling the dice
	 * @param The number obtained on the dice
	 * @return the final position of the player
	 */
	public int playerPosition(Player player, int roll) {
		int position = player.getCurrPos() + roll;

		if (position > board.WIN_CONDITION)
			return player.getCurrPos();

		else if (board.getSnakes().containsKey(position) == true) {
			System.out.println("Swallowed by snake :( ");
			return board.getSnakes().get(position);
		}

		else if (board.getLadders().containsKey(position) == true) {
			System.out.println("Climb up the ladder :)");
			return board.getLadders().get(position);
		}

		return position;
	}

	/**
	 * To start the game of snakes and ladders
	 */
	private void startGame() {
		int numPlayers;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			try {
				System.out.print("Enter Number of players: ");
				numPlayers = Integer.parseInt(br.readLine());
				break;
			} catch (NumberFormatException | IOException e) {
				System.out.println("Please enter the number of players correctly!");
			}
		}
		List<Player> players = decideTurns(numPlayers);
		System.out.println("\nPlayer "+players.get(0).getId()+" goes first");
		play(players);

	}

	public static void main(String[] args) {
		Game game = new Game();
		game.startGame();
	}

}
