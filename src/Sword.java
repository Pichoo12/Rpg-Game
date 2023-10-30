import javax.swing.ImageIcon;

public class Sword extends Ranged{

	private boolean switched;

	public Sword(int x, int y) {
		super (6000, x,y,0,0,200,200,new ImageIcon("C:\\Users\\S1802049\\git\\repository\\Rpg Game (2)\\Rpg Game\\src\\Pics\\sworddown (1).gif"));
		switched = false;
	}

	//public String toString() {
	//	return "bow!";

	//}



	public void switchSword() {
		if (switched) {
			super.setImg(new ImageIcon("C:\\Users\\S1802049\\git\\repository\\Rpg Game (2)\\Rpg Game\\src\\Pics\\sworddown (2).gif"));
		} else {
			super.setImg(new ImageIcon("C:\\Users\\S1802049\\git\\repository\\Rpg Game (2)\\Rpg Game\\src\\Pics\\sworddown (1).gif"));
		}
		switched = !switched;
	}
}
