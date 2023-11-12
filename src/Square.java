/**
* @author 		   : Giri Liyangi
* @name 		   : Square
* @createDate 	   : 04 Nov 2023
* @description 	   : Represents a square on the game board with attributes for its position (row and column position),<br> 
				   	 whether it contains a ship, and whether it has been shot at. 
* @version 		   : 1.0
* @lastModifiedBy  :
* @lastModifiedDate:
*/

public class Square {
	
	// The row position of the square.
	private int row_position;
	
	// The column position of the square.
	private int column_position;	
	
	// Indicates whether the square contains a ship.
	private boolean hasShip;
	
	// A reference to the battleship if one is currently on the square.
	private Battleship battleship;
	
	// Indicates whether the player has fired a shot at the square.
	private boolean hasShot;
	
	/**
    * Constructs a Square object with the specified row and column position. 
    * Initially, it does not contain a ship and has not been shot at.
    *
    * @param row_position the row position of the square.
    * @param column_position: the column position of the square.
    */
	public Square(int row_position, int column_position) {
		this.row_position = row_position;
		this.column_position = column_position;
		this.hasShip = false;
		this.hasShot = false;
	}
	
	/**
    * Gets the row position of the square.
    *
    * @return the row position.
    */
	public int getRow() {
		return row_position;
	}
	
	/**
	* Gets the column position of the square.
	*
	* @return the column position.
	*/
	public int getColumn() {
		return column_position;
	}
	
	/**
    * Checks if the square contains a ship.
    *
    * @return true if the square contains a ship, false otherwise.
    */
	public boolean hasShip() {
		return hasShip;
	}
	
	/**
    * Checks if the square has been shot at.
    *
    * @return true if the square has been shot at, false otherwise.
    */
	public boolean hasShot() {
		return hasShot;
	}
	
	/**
    * Gets the battleship that occupies the square if there is one.
    *
    * @return the battleship on the square or null if there is no battleship.
    */
	public Battleship getBattleship() {
		return this.battleship;
	}
	
	/**
    * Marks the square as shot, indicating that it has been fired upon.
    * 
    */
    public void markAsShot() {
        this.hasShot = true;
    }
	
	/**
    * Places a battleship on the square.
    *
    * @param battleship: the battleship to place on the square.
    */
    public void placeShip(Battleship battleship) {
        this.hasShip = true;
        this.battleship = battleship;
    }
    
    /**
    * Returns a string representation of the current state of the Square.
    * If the square has not been shot at, it is represented as "-".
    * If the square has been shot at and contains a ship, it is represented as "x".
    * If the square has been shot at and does not contain a ship, it is represented as "o".
    *
    * @return The string representation of the Square's state.
    */
    public String toString() {
    	if(!hasShot()) {
    		return String.format("%3s", "-");
    	}else if(hasShot() && hasShip()) {
    		return String.format("%3s", "x");
    	}else {
    		return String.format("%3s", "o");
    	}
    }
	
}
