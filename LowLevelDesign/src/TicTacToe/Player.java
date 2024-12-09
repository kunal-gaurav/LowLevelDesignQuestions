package TicTacToe;

public class Player {

	private final String name;
	private final PlayingPiece piece;
	
	public Player(String name, PlayingPiece symbol) {
		super();
		this.name = name;
		this.piece = symbol;
	}

	public String getName() {
		return name;
	}

	public PlayingPiece getPiece() {
		return this.piece;
	}
	
}
