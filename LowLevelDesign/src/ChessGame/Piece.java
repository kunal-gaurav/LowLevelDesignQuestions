package ChessGame;

public class Piece {

	private char color;
	private char type;
	private Move[] moves;

	public Piece(char color, char type) {
		super();
		this.color = color;
		this.type = type;
		this.moves = new Move[0];
	}

	public Piece(char color, char type, Move[] moves) {
		this(color, type);
		this.moves = moves;
	}

	public char getColor() {
		return color;
	}

	public char getType() {
		return type;
	}

	protected boolean canMove(ChessBoard chessBoard, int startRow, int startColumn, int endRow, int endColumn) {
		for (Move move : moves) {
			if (move.canMove(chessBoard, startRow, startColumn, endRow, endColumn)) {
				return true;
			}
		}
		return false;
	}

	public String getPieceName() {
		return "" + this.getColor() + this.getType();
	}

}
