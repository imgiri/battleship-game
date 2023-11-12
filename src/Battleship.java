/**
* @author 		   : Giri Liyangi
* @name 		   : Battleship
* @createDate 	   : 05 Nov 2023
* @description 	   : Represents a battleship with attributes for whether it is sunk,<br>
				     the remaining health of the battleship,<br>
 				     and the size of the battleship.
* @version 		   : 1.0
* @lastModifiedBy  :
* @lastModifiedDate:
*/

public class Battleship {
	
	// Indicates whether the battleship is sunk.
	private boolean isSunk;
	
	// The remaining health of the battleship(how many more hits it can take before sinking).
	private int remainingHealth;
	
	// The size of the battleship.
	private int size;
	
	/**
	* Constructs a Battleship object with the specified size. The battleship is initially not sunk, 
	* and its remaining health is set to the given size.
	*
	* @param size: the size of the battleship.
	*/
	public Battleship(int size) {
		this.isSunk = false;
		this.remainingHealth = size;
		this.size = size;
	}
	
	/**
	* Checks if the battleship is sunk. 
    * 
    * @return true if the battleship is sunk, false otherwise.
    */
	public boolean isSunk() {
		return isSunk;
	}
	
	/**
    * Gets the remaining health of the battleship.
    * 
    * @return the remaining health of the battleship.
    */
	public int getRemainingHealth() {
		return remainingHealth;
	}
	
	/**
    * Gets the size of the battleship.
    * 
    * @return the size of the battleship.
    */
	public int getSize() {
		return size;
	}
	
	/**
    * Simulates the battleship taking a hit, reducing its remaining health by 1, 
    * and marking it as sunk if its health reaches zero.
    *
    */
    public void takeHit() {
        remainingHealth--;
        if (remainingHealth <= 0) {
            isSunk = true;
        }
    }

}