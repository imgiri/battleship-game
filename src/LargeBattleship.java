/**
 * @author           : Giri Liyangi
 * @name             : LargeBattleship
 * @createDate       : 09 Nov 2023
 * @description      : Represents a large battleship type in the Battleship game.<br>
 *                     Extends the Battleship class with a specific size and maximum count.<br>
 * @version          : 1.0
 * @lastModifiedBy   :
 * @lastModifiedDate :
 */

public class LargeBattleship extends Battleship {
	
    // Static attribute specifying the maximum count of large battleships on the board
	public static int MAX_COUNT = 1;
	
    // Constructor for LargeBattleship, calling the constructor of the superclass (Battleship) with size 3
	public LargeBattleship() {
		super(3);
	}

}
