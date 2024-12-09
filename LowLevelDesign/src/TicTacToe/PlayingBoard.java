package TicTacToe;

import java.util.ArrayList;
import java.util.List;

public class PlayingBoard {

	private final int size;
	private PlayingPiece[][] board;

	public PlayingBoard(int size) {
		super();
		this.size = size;
		this.board = new PlayingPiece[size][size];
	}

	public boolean add(int row, int column, PlayingPiece piece) {
		if (row < 0 || column < 0 || row >= this.size || column >= this.size) {
			return false;
		}
		if (null != board[row][column]) {
			return false;
		}
		board[row][column] = piece;
		return true;
	}

	public boolean checkWinner(int row, int column, PlayingSymbol symbol) {
		if (validateHorizontal(row, symbol) || validateVertical(column, symbol) || validateDiagonal(symbol)
				|| validateAntiDiagonal(symbol)) {
			return true;
		}
		return false;
	}

	public boolean validateDiagonal(PlayingSymbol symbol) {
		for (int i = 0, j = 0; i < size; i++, j++) {
			if (null == board[i][j] || board[i][j].getSymbol() != symbol) {
				return false;
			}
		}
		return true;
	}

	public boolean validateAntiDiagonal(PlayingSymbol symbol) {
		for (int i = 0, j = size - 1; i < size; i++, j--) {
			if (null == board[i][j] || board[i][j].getSymbol() != symbol) {
				return false;
			}
		}
		return true;
	}

	public boolean validateHorizontal(int row, PlayingSymbol symbol) {
		for (int i = 0; i < size; i++) {
			if (null == board[row][i] || board[row][i].getSymbol() != symbol) {
				return false;
			}
		}
		return true;
	}

	public boolean validateVertical(int column, PlayingSymbol symbol) {
		for (int i = 0; i < size; i++) {
			if (null == board[i][column] || board[i][column].getSymbol() != symbol) {
				return false;
			}
		}
		return true;
	}

	public void printBoard() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (null == board[i][j]) {
					System.out.print("   ");
				} else {
					System.out.print(board[i][j].getSymbol() + "  ");
				}
				if (j != size - 1) {
					System.out.print("|");
				}
			}
			if (i != size) {
				System.out.println();
				for (int k = 0; k < 11; k++) {
					System.out.print("_");
				}
				System.out.println();
			}
		}
	}

	public List<int[]> getEmptyCells() {
		List<int[]> emptyCells = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (null == board[i][j]) {
					emptyCells.add(new int[] {i, j});
				}
			}
		}
		return emptyCells;
	}

}
