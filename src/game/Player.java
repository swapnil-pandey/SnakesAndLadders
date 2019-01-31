package game;

public class Player {
	private int currPos;
	private int id;

	@Override
	public String toString() {
		return "Player [currPos=" + currPos + ", id=" + id + "]";
	}

	Player(int id) {
		this.id = id;
		this.currPos = 0;
	}

	public int getCurrPos() {
		return currPos;
	}

	public void setCurrPos(int currPos) {
		this.currPos = currPos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
