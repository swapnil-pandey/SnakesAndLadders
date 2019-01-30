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

	public static void main(String[] args) {
		Board board = new Board();
		int numPlayers;
		boolean won = false;
		List<Player> players = new ArrayList<Player>();
		List<ArrayList<Integer>> turnDecide = new ArrayList<ArrayList<Integer>>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			try {
				System.out.print("Enter Number of players: ");
				numPlayers = Integer.parseInt(br.readLine());
				System.out.println();
				break;
			} catch (NumberFormatException | IOException e) {
				System.out.println("Please enter the number of players correctly!");
			}
		}
		for (int i = 0; i < numPlayers; i++) {
			System.out.print("Player "+(i+1)+" enter 'r' to roll dice: ");
			String input = null;
			try {
				input = br.readLine();
				System.out.println();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(input.equalsIgnoreCase("r"))	{
				int roll = board.rollDice();
				System.out.println("You rolled a: "+roll);
				turnDecide.add(new ArrayList<Integer>(Arrays.asList(i+1, roll)));
			}
			else {
				i--;
				continue;
			}
//			players.add(new Player());
		}
		Collections.sort(turnDecide, new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				return o2.get(1).compareTo(o1.get(1));
			}
		});
		System.out.println(turnDecide);
	}

}
