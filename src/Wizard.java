import javax.swing.ImageIcon;

public class Wizard extends Character{

	public Wizard() {
		super();
		

	}
	//int xV, int yV, int width, int height, Abilities a, 
	public Wizard (int health, Ranged a, int x, int y) {
		super(x,y,300,300,a, new ImageIcon("C:\\Users\\S1802049\\git\\repository\\Rpg Game (2)\\Rpg Game\\src\\Pics\\wiz.gif"),health,600,"");
	}
	public String toString () {
		return "Aq";
	
	}
}