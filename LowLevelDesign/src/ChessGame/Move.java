package ChessGame;

public interface Move {
	
	boolean canMove(ChessBoard chessBoard, int startRow, int startColumn, int endRow, int column);

}
