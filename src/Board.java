/**
 * @author          : Giri Liyangi
 * @name            : Board
 * @createDate      : 07 Nov 2023
 * @description     : Represents the game board for the Battleship game, managing the placement of battleships and game state.
 * @version         : 1.0
 * @lastModifiedBy  :
 * @lastModifiedDate:
 */

import java.util.Random;

public class Board {
	
	// Two-dimensional array representing the game board.
	private Square[][] gameBoard;
	
	// The number of rows on the game board.
	private int rows;
	
	// The number of columns on the game board.
	private int columns;
	
	// The number of remaining ships on the game board.
	private int remainingShips;
	
	/**
    * Constructs a Board object with the specified number of rows and columns.
    *
    * @param rows    The number of rows on the game board.
    * @param columns The number of columns on the game board.
    */
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		gameBoard = new Square[rows][columns];
		this.remainingShips = 0;
		
		// Populate the game board with Square objects.
		populateBoard();
		
	}
	
	/**
	* Retrieves the number of remaining ships on the game board.
	*
	* @return The number of remaining ships.
	*/
	public int getRemainingShips() {
		return remainingShips;
	}

	/**
	* Sets the number of remaining ships on the game board.
	*
	* @param remainingShips The new value for the number of remaining ships.
	*/
	public void setRemainingShips(int remainingShips) {
		this.remainingShips = remainingShips;
	}
	
	/**
	* Retrieves the Square object located at the specified row and column on the game board.
	*
	* @param row The row index of the desired Square.
	* @param col The column index of the desired Square.
	* @return The Square object at the specified position on the game board.
	*/
	public Square getSquare(int row, int col) {
		return gameBoard[row][col];
	}
	
	/**
	* Checks if the game is over by verifying if there are no remaining ships.
	*
	* @return True if the game is over, false otherwise.
	*/
	public boolean isGameOver() {
		
		// The game is over when there are no remaining ships.
        return remainingShips == 0; 
    }
	
	
	/**
    * Populates the game board with Square objects.
    */
	private void populateBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
            	gameBoard[i][j] = new Square(i, j);
            }
        }
    }
	
	/**
	* Randomly places battleships of different types on the game board.
	* Calls the helper method to randomly place Small, Medium, and Large battleships with their respective maximum counts.
	*/
	public void randomlyPlaceBattleshipsOfType() {
		randomlyPlaceBattleships(SmallBattleship.MAX_COUNT);
		randomlyPlaceBattleships(MediumBattleship.MAX_COUNT);
		randomlyPlaceBattleships(LargeBattleship.MAX_COUNT);
	}
	
	/**
	* Randomly places battleships of a specific type on the game board based on the provided battleship type and maximum count.
	*
	* @param battleshipType The class representing the type of battleship to be placed.
	* @param maxCount       The maximum count of battleships of the specified type to be placed on the board.
	*/
	private void randomlyPlaceBattleships(int maxCount) {
		
		// Variable to store the size of the battleship.
		int shipSize = 0;
		
	    // Variable to store the number of remaining battleships of the specified type.
		this.remainingShips = 0;
		
	    // Determine the battleship size and remaining ships based on the maximum count.
		switch(maxCount) {
		
			case 1:
				shipSize = 3;
				this.remainingShips = 1;
				break;
			case 2:
				shipSize = 2;
				this.remainingShips = 2;
				break;
			case 3:
				shipSize = 1;
				this.remainingShips = 3;
				break;
			default:
				System.out.println("No ships to place");
		
		}
		
		Random r = new Random();
		
		// Continue placing ships on the board until the desired number of ships of a particular type is reached.
		while(this.remainingShips > 0) {
	        boolean isHorizontal = r.nextBoolean();
	        int row, col;
	        boolean isValid = false;
	        boolean isInsideBound = false;
	        
	        	// Keep generating random positions until a valid placement is found.
	            do {
	            	// Generate random row and column positions.
	                row = r.nextInt(rows);
	                col = r.nextInt(columns);
	                
	                // Check if the generated position is inside the bounds of the board.
	                isInsideBound = isInsideBounds(row, col, shipSize, isHorizontal);
	                
	                // If inside bounds, check if the placement is valid.
	                if(isInsideBound) {
	                	isValid = isValidPlacement(row, col, shipSize, isHorizontal);
	                }
	                
	                // If both inside bounds and valid, place the ship on the board.
	                if(isValid) {
	                	placeShipOnBoard(row, col, shipSize, isHorizontal);
	                }
	            } while (!isInsideBound && !isValid); 
	           
	            // Decrease the number of remaining ships after placing one on the board.
	            this.remainingShips--;
	     }
		
	}
	
	/**
	* Checks if placing a battleship of the specified size in a given orientation at the provided position
	* is within the bounds of the game board.
	*
	* @param row          The starting row position for the battleship.
	* @param col          The starting column position for the battleship.
	* @param shipSize     The size of the battleship to be placed.
	* @param isHorizontal A boolean indicating whether the battleship is to be placed horizontally.
	* @return True if the placement is within bounds, false otherwise.
	*/
	private boolean isInsideBounds(int row, int col, int shipSize, boolean isHorizontal) {
		
		boolean isBound;
		
	    // Check if placing the battleship horizontally exceeds the column bounds.
		if(isHorizontal) {
			
			if(col + shipSize - 1 >= this.columns  ) {
				isBound = false;
			}else {
				isBound = true;
			}
		}else { // Check if placing the battleship vertically exceeds the row bounds.
			if(row + shipSize - 1 >= this.rows) {
				isBound = false;
			}else {
				isBound = true;
			}
		}
		
		return isBound;
	}
	
	/**
	* Checks if placing a battleship of the specified size in a given orientation at the provided position
	* is a valid placement on the game board, ensuring that it does not overlap with existing ships.
	*
	* @param row          The starting row position for the battleship.
	* @param col          The starting column position for the battleship.
	* @param shipSize     The size of the battleship to be placed.
	* @param isHorizontal A boolean indicating whether the battleship is to be placed horizontally.
	* @return True if the placement is valid, false otherwise.
	*/
	private boolean isValidPlacement(int row, int col, int shipSize, boolean isHorizontal){
		
		boolean isValid = false;
		
	    // Check if placing the battleship horizontally overlaps with existing ships.
		if(isHorizontal) {
			
			for(int i = 0; i < shipSize; i++) {
				if(gameBoard[row][col+i].hasShip()) {
					isValid = false;
				}else {
					isValid = true;
				}
			}
		} else { // Check if placing the battleship vertically overlaps with existing ships.
			
			for(int i = 0; i < shipSize; i++) {
				if(gameBoard[row+i][col].hasShip()) {
					isValid = false;
				}else {
					isValid = true;
				}
			}
		}
		
		return isValid;
	}
	
	/**
	* Places a battleship on the game board based on the specified position, size, and orientation.
	*
	* @param row          The starting row position for the battleship.
	* @param col          The starting column position for the battleship.
	* @param shipSize     The size of the battleship to be placed.
	* @param isHorizontal A boolean indicating whether the battleship is to be placed horizontally.
	*/
	private void placeShipOnBoard(int row, int col, int shipSize, boolean isHorizontal) {
		
	    // Create a new battleship instance with the specified size.
		Battleship battleship = new Battleship(shipSize);
		
	    // Loop through each square to place the battleship based on orientation.
		for(int i = 0; i < shipSize; i++) {
			
			// Place the battleship horizontally
			if(isHorizontal) {
				gameBoard[row][col+i].placeShip(battleship);
			}else { // Place the battleship vertically
				gameBoard[row+i][col].placeShip(battleship);
			}
		}
	}
	
	/**
	* Generates a string representation of the game board, including the state of each square.
	*
	* @return The string representation of the game board.
	*/
	public String toString() {
        String boardString = "";

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                boardString += gameBoard[i][j].toString();
            }
            // Move to the next row.
            boardString += "\n"; 
        }

        return boardString;
    }

}
