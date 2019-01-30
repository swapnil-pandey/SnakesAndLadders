import java.util.HashMap;
import java.util.Map;

public class SnakesAndLadders {

	final static int WIN_CONDITION = 100;

	Map<Integer, Integer> snakes = new HashMap<>();
	Map<Integer, Integer> ladders = new HashMap<>();
	
	public SnakesAndLadders() {
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
}

class RunGame {
	public static void main(String[] args) {

	}
}
