/**
* @author          : Giri Liyangi
* @name            : Player
* @createDate      : 05 Nov 2023
* @description     : Represents a player in the Battleship game with a name, associated game board, and score.
* @version         : 1.0
* @lastModifiedBy  :
* @lastModifiedDate:
*/

import java.util.Scanner;

public class Player {
	
	// The name of the player
	private String name;
	
	// The game board associated with the player.
	private Board board;
	
	// The player's score.
	private int score;
	
	/**
    * Constructs a Player object with the specified name and an associated game board. 
    * The initial score is set to 0.
    *
    * @param name the name of the player.
    * @param board the game board associated with the player.
    */
	public Player(String name, Board board) {
		this.name = name;
		this.board = board;
		this.score = 0;
	}
	
	/**
    * Gets the name of the player.
    *
    * @return the name of the player.
    */
	public String getName() {
		return name;
	}
	
	/**
    * Gets the game board associated with the player.
    *
    * @return the game board.
    */
	public Board getBoard() {
		return board;
	}
	
	/**
    * Gets the player's score.
    *
    * @return the player's score.
    */
	public int getScore() {
		return score;
	}
	
	/**
    * Takes a turn for the player by prompting them to input a guess and processing the guess on the game board.
    *
    * @return True if the player successfully hits and sinks the final battleship, otherwise false.
    */
	public boolean takeTurn() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(name + ", enter your guess (e.g., 'x y' - where x is the row and y is the column ): ");
		
		String input = scanner.nextLine();
		String[] guess = input.split(" ");
		
		int rowGuess, columnGuess;
		
		rowGuess = Integer.parseInt(guess[0]);
		columnGuess = Integer.parseInt(guess[1]);
		
		/** Processing the player's guess:
		* If the guess has not been previously shot and the square contains a ship, register a HIT,<br>
		* mark the square as shot, take a hit on the battleship, and check if the battleship is now sunk.
		* 
		* If sunk, decrease the remaining ships and increment the player's score.
		* 
		* If the player has already attacked the square, display a message indicating a lost turn.
		* 
		* If the guess is a MISS, display a MISS and mark the square as shot.
		*/ 
		if(!board.getSquare(rowGuess, columnGuess).hasShot() && board.getSquare(rowGuess, columnGuess).hasShip()) {
			
			//Displaying a HIT
			System.out.println("\n HIT \n");
			
			// Mark the square as shot.
			board.getSquare(rowGuess, columnGuess).markAsShot();
			
			// Take a hit on the battleship in the square.
			board.getSquare(rowGuess, columnGuess).getBattleship().takeHit();
			
			//Check if the battleship in the square is now sunk.
			if(board.getSquare(rowGuess, columnGuess).getBattleship().isSunk()) {
				
				//Decrease the number of remaining ships on the board and Increment the player's score
				board.setRemainingShips(board.getRemainingShips() - 1);
				score++;
			}
		}else if(board.getSquare(rowGuess, columnGuess).hasShot()) {
			
			// If the player has already attacked the square, display a message indicating a lost turn.
			System.out.println("\n These co-ordinates have been already attacked, you lost your turn \n");
			
		}else {
			
			//Display a MISS and Mark the square as shot.
			System.out.println("\n MISS \n");
			board.getSquare(rowGuess, columnGuess).markAsShot();
		}
		
		
		
		return board.isGameOver();
		
	}
	
}
