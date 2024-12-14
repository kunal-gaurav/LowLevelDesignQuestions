package ChessGame;

public class ChessPieceFactory {

	private Move diagonalMove;
	private Move starightMove;

	public ChessPieceFactory() {
		this.diagonalMove = new DiagonalMove();
		this.starightMove = new StraightMove();
	}

	public Piece createChessPiece(char color, char type) {
		Piece piece;
		switch (type) {
		case 'K':
			piece = new KingPiece(color, type);
			break;
		case 'Q':
			piece = new Piece(color, type, new Move[] { starightMove, diagonalMove });
			break;
		case 'H':
			piece = new KnightPiece(color, type);
			break;
		case 'B':
			piece = new Piece(color, type, new Move[] { diagonalMove });
			break;
		case 'R':
			piece = new Piece(color, type, new Move[] { starightMove });
			break;
		case 'P':
			piece = new PawnPiece(color, type);
			break;
		default:
			piece = new Piece(color, type);
		}
		return piece;
	}

}
