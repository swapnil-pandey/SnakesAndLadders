/**
 * Class for unit testing
 *//*
package game;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public final class TestClass {
	private Game game;
	
	@BeforeMethod
	public void setUp() {
		game = new Game();
	}

	@AfterMethod
	public void refresh() {
		game = null;
	}
	
	@Test
	public void createTwoPlayers() {
		final int expectedPlayers = 2;
		final int numberOfPlayers = game.decideTurns(2).size();	
		Assert.assertEquals(expectedPlayers, numberOfPlayers);
	}
	
	@Test
	public void checkPosition() {
		ArrayList<Player> playerList = new ArrayList<Player>();
		playerList.add(new Player(1));
		playerList.add(new Player(2));
		playerList.get(0).setCurrPos(game.playerPosition(playerList.get(0), 5));
		playerList.get(1).setCurrPos(game.playerPosition(playerList.get(1), 6));
		playerList.get(0).setCurrPos(game.playerPosition(playerList.get(0), 3));
		playerList.get(1).setCurrPos(game.playerPosition(playerList.get(1), 4));
		playerList.get(0).setCurrPos(game.playerPosition(playerList.get(0), 5));
		playerList.get(1).setCurrPos(game.playerPosition(playerList.get(1), 2));
		
		final int player1Position = playerList.get(0).getCurrPos();
		final int player2Position = playerList.get(1).getCurrPos();
		
		final int expectedPlayer1Position = 60;
		final int expectedPlayer2Position = 14;
		
		Assert.assertEquals(player1Position, expectedPlayer1Position);
		Assert.assertEquals(player2Position, expectedPlayer2Position);
	}
	
}
*/