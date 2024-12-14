package ChessGame;

public class StraightMove implements Move {

	@Override
	public boolean canMove(ChessBoard chessBoard, int startRow, int startColumn, int endRow, int endColumn) {

		int rowDelta = startRow - endRow;
		int columnDelta = startColumn - endColumn;
		if (rowDelta != 0 && columnDelta != 0) {
			return false;
		}

		if (rowDelta == 0) {
			columnDelta = columnDelta > 0 ? -1 : 1;
			startColumn += columnDelta;
			while (startColumn != endColumn) {
				if (null != chessBoard.getPiece(startRow, startColumn)) {
					return false;
				}
				startColumn += columnDelta;
			}
		} else {
			rowDelta = rowDelta > 0 ? -1 : 1;
			startRow += rowDelta;
			while (startRow != endRow) {
				if (null != chessBoard.getPiece(startRow, startColumn)) {
					return false;
				}
				startRow += rowDelta;
			}
		}
		return true;
	}

}
