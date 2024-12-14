package ChessGame;

public class PawnPiece extends Piece {

	public PawnPiece(char color, char type) {
		super(color, type);
	}

	public boolean canMove(ChessBoard chessBoard, int startRow, int startColumn, int endRow, int endColumn) {

		Piece pawn = chessBoard.getPiece(startRow, startColumn);
		if (null == chessBoard.getPiece(endRow, endColumn)) {
			if (startColumn != endColumn) {
				return false;
			}
			if ((pawn.getColor() == 'B' && endRow - startRow == -1)
					|| (pawn.getColor() == 'W' && endRow - startRow == 1)) {
				return true;
			}

		} else {
			if (Math.abs(endColumn - startColumn) != 1) {
				return false;
			}
			if ((pawn.getColor() == 'B' && endRow - startRow == -1)
					|| (pawn.getColor() == 'W' && endRow - startRow == 1)) {
				return true;
			}
		}

		return false;
	}

}
