package ChessGame;

public class KnightPiece extends Piece {

	public KnightPiece(char color, char type) {
		super(color, type);
	}

	public boolean canMove(ChessBoard board, int startRow, int startColumn, int endRow, int endColumn) {
		int rowDelta = Math.abs(endRow - startRow);
		int columnDelta = Math.abs(endColumn - startColumn);
		return (rowDelta == 2 && columnDelta == 1) || (rowDelta == 1 && columnDelta == 2);
	}

}
