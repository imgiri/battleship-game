/**
 * @author           : Giri Liyangi
 * @name             : MediumBattleship
 * @createDate       : 09 Nov 2023
 * @description      : Represents a medium battleship type in the Battleship game.<br>
 *                     Extends the Battleship class with a specific size and maximum count.<br>
 * @version          : 1.0
 * @lastModifiedBy   :
 * @lastModifiedDate :
 */

public class MediumBattleship extends Battleship {
	
    // Static attribute specifying the maximum count of medium battleships on the board
	public static int MAX_COUNT = 2;
	
    // Constructor for MediumBattleship, calling the constructor of the superclass (Battleship) with size 2
	public MediumBattleship() {
		super(2);
	}
}
