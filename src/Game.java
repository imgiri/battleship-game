/**
 * @Author         : Giri Liyangi
 * @name           : Game
 * @CreateDate     : 07 Nov 2023
 * @Description    : Represents the main method to execute the Battleship game.<br>
 * 					 Collects player names.<br>
 * 					 Initializes game boards and players.<br>
 * 					 Randomly places battleships on the boards.<br>
 * 					 Executes the main game loop, taking turns until the game is over.<br>
 * 					 Determines the winner based on scores.<br>
 * 					 Prints the result of the game.
 * @Version        : 1.0
 * @LastModifiedBy :
 * @LastModifiedDate:
 */


import java.util.Scanner;

public class Game {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// Collect Player 1's name.
		System.out.println("Enter Player 1's name: ");
		String player_name1 = scanner.nextLine();
		
		// Create the game board and Player 1.
		Board board = new Board(10,10);
		Player player1 = new Player(player_name1, board);
		
		// Collect Player 2's name.
		System.out.println("Enter Player 2's name: ");
		String player_name2 = scanner.nextLine();

		// Create Player 2.
		Player player2 = new Player(player_name2, board);

		// Randomly place battleships on the board.
		board.randomlyPlaceBattleshipsOfType();
		
		// Game iteration
		boolean gameOver = false;
        Player currentPlayer = player1;
                
        //Set remaining ship count which has been placed on board
        board.setRemainingShips(6);
                
        while (!gameOver) {
        	// Display the game board (with hidden ships)
        	System.out.println(currentPlayer.getBoard());
        	
        	// Execute the player's turn.
        	boolean check = currentPlayer.takeTurn();
	
	        // Check if the game is over and determine the winner.
	        if (check) {
	        	gameOver = true;
	        	
	        	if(player1.getScore() > player2.getScore()) {
	        		System.out.println(player1.getName() + " has won!");
	        	}else if(player1.getScore() < player2.getScore()){
	        		System.out.println(player2.getName() + " has won!");
	        	}else {
	        		System.out.println("Game Drawn");
	        	}
	            
	        }
	
	        // Switch to the other player for the next turn.
	        if(currentPlayer == player1) {
	        	currentPlayer = player2;
	        }else {
	        	currentPlayer = player1;
	        }
	        
        }
        scanner.close();

	}
	
}

