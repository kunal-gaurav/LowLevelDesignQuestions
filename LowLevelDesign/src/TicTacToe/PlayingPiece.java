package TicTacToe;

public class PlayingPiece {
	
	PlayingSymbol symbol;

	public PlayingPiece(PlayingSymbol symbol) {
		super();
		this.symbol = symbol;
	}

	PlayingSymbol getSymbol() {
		return this.symbol;
	}
}
