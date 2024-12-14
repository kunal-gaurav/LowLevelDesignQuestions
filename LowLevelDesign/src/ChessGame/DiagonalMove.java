package ChessGame;

public class DiagonalMove implements Move {

	@Override
	public boolean canMove(ChessBoard chessBoard, int startRow, int startColumn, int endRow, int endColumn) {

		int rowDelta = startRow - endRow;
		int columnDelta = startColumn - endColumn;
		if (Math.abs(columnDelta) != Math.abs(rowDelta)) {
			return false;
		}
		rowDelta = rowDelta > 0 ? -1 : 1;
		columnDelta = columnDelta > 0 ? -1 : 1;
		startRow += rowDelta;
		startColumn = columnDelta;
		while (startRow != endRow) {
			if (null != chessBoard.getPiece(rowDelta, columnDelta)) {
				return false;
			}
		}
		return true;
	}

}
