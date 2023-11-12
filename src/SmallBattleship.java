/**
 * @author           : Giri Liyangi
 * @name             : SmallBattleship
 * @createDate       : 09 Nov 2023
 * @description      : Represents a small battleship type in the Battleship game.<br>
 *                     Extends the Battleship class with a specific size and maximum count.<br>
 * @version          : 1.0
 * @lastModifiedBy   :
 * @lastModifiedDate :
 */

public class SmallBattleship extends Battleship {
	
    // Static attribute specifying the maximum count of small battleships on the board
	public static int MAX_COUNT = 3;
	
    // Constructor for SmallBattleship, calling the constructor of the superclass (Battleship) with size 1
	public SmallBattleship() {
		super(1);
	}

}
