package ChessGame;

public class KingPiece extends Piece {

	public KingPiece(char color, char type) {
		super(color, type);
	}

	public boolean canMove(ChessBoard chessBoard, int startRow, int startColumn, int endRow, int endColumn) {
		int rowDelta = Math.abs(startRow - endRow);
		int columnDelta = Math.abs(startColumn - endColumn);
		if (rowDelta <= 1 && columnDelta <= 1) {
			return true;
		}
		return false;
	}

}
