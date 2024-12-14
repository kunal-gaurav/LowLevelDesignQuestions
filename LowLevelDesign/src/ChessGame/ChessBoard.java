package ChessGame;

public class ChessBoard {

	private Piece[][] board;
	private int gameStatus;
	private int nextTurn;
	private ChessPieceFactory factory;
	private static final String INVALID = "invalid";

	public ChessBoard(String[][] chessBoard) {
		this.gameStatus = 0;
		this.nextTurn = 0;
		this.board = new Piece[8][8];
		this.factory = new ChessPieceFactory();
		for(int i=0; i<8; i++) {
			if(i>=2 && i<=5) {
				continue;
			}
			for(int j=0; j<8; j++) {
				char[] colorAndPieceArray = chessBoard[i][j].toCharArray();
				board[i][j] = factory.createChessPiece(colorAndPieceArray[0], colorAndPieceArray[1]);
			}
		}
	}

	public String move(int startRow, int startColumn, int endRow, int endColumn) {
		if (0 != gameStatus) {
			return INVALID;
		}
		if (!isValid(startRow, startColumn) || !isValid(endRow, endColumn)) {
			return INVALID;
		}
		Piece startPiece = getPiece(startRow, startColumn);
		if (null == startPiece || (this.nextTurn == 0 && startPiece.getColor() != 'W')
				|| (this.nextTurn == 1 && startPiece.getColor() != 'B')) {
			return INVALID;
		}
		Piece endPiece = getPiece(endRow, endColumn);
		if (null != endPiece && startPiece.getColor() == endPiece.getColor()) {
			return INVALID;
		}
		if(!startPiece.canMove(this, startRow, startColumn, endRow, endColumn)) {
			return INVALID;
		}
		this.board[endRow][endColumn] = startPiece;
		this.nextTurn = this.nextTurn==0 ? 1:0;
		if(endPiece!=null && endPiece.getType()=='K') {
			this.gameStatus = endPiece.getColor()=='B' ? 1 : 2;
		}
		if(null==endPiece) {
			return "";
		}
		return endPiece.getPieceName();
	}
	
	public int getNextTurn() {
		if(this.gameStatus==0) {
			return this.nextTurn;
		}
		return -1;
	}
	
	public int getGameStatus() {
		return this.gameStatus;
	}

	public Piece getPiece(int row, int column) {
		return board[row][column];
	}

	private boolean isValid(int row, int column) {
		return row >= 0 && row < 8 && column >= 0 && column < 8;
	}
}
