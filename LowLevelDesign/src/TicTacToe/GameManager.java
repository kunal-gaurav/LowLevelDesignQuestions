package TicTacToe;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GameManager {

	private Deque<Player> players;
	private PlayingBoard board;

	public GameManager(List<String> playersName, int size) {
		this.players = new LinkedList<>();
		Player player1 = new Player(playersName.get(0), new PlayingPiece(PlayingSymbol.O));
		Player player2 = new Player(playersName.get(1), new PlayingPiece(PlayingSymbol.X));
		this.players.add(player1);
		this.players.add(player2);
		this.board = new PlayingBoard(size);
	}

	public void playGame() {
		System.out.println("----------------Round Started------------------");
		boolean isAnyWinner = false;
		Scanner sc = new Scanner(System.in);
		String input;
		int row;
		int column;
		while (!isAnyWinner) {
			Player currentPlayer = players.pollFirst();
			board.printBoard();
			if (board.getEmptyCells().isEmpty()) {
				System.out.println("---------Game Finished. No Winner---------");
				return;
			}
			System.out.println(currentPlayer.getName() + " turns.");
			System.out.println("Enter row and column : ");
			input = sc.nextLine();
			String[] inputArray = input.split(" ");
			try {
				row = Integer.parseInt(inputArray[0]);
				column = Integer.parseInt(inputArray[1]);
			} catch (Exception e) {
				System.out.println("-----------Invalid Input. Try Again---------------");
				players.addFirst(currentPlayer);
				continue;
			}
			if (!board.add(row, column, currentPlayer.getPiece())) {
				System.out.println("-----------Invalid Cell. Try Again---------------");
				players.addFirst(currentPlayer);
				continue;
			}
			isAnyWinner = board.checkWinner(row, column, currentPlayer.getPiece().getSymbol());
			if (isAnyWinner) {
				System.out.println("------------Congratulations. " + currentPlayer.getName() + " Wins--------------");
				return;
			}
			players.addLast(currentPlayer);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;
		String player1;
		String player2;
		int size;
		while (true) {
			System.out.println("--------------Welcome to TicTacToe Game--------------------");
			System.out.print("Enter Size of Board : ");
			input = sc.nextLine();
			size = Integer.parseInt(input);
			System.out.print("Enter First Player Name : ");
			player1 = sc.nextLine();
			System.out.print("Enter Second Player Name : ");
			player2 = sc.nextLine();
			GameManager gameManager = new GameManager(Arrays.asList(player1, player2), size);
			gameManager.playGame();
			while (true) {
				System.out.print("Do You Wish to Play One More Round(Yes/No) : ");
				input = sc.nextLine();
				if ("YES".equalsIgnoreCase(input)) {
					break;
				} else if ("NO".equalsIgnoreCase(input)) {
					System.out.println("--------------Thank You------------------");
					return;
				} else {
					continue;
				}
			}
		}
	}

}
