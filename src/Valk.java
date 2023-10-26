import javax.swing.ImageIcon;

public class Valk extends Character{

	public Valk() {
		super();
		

	}
	//int xV, int yV, int width, int height, Abilities a, 
	public Valk (int health, Ranged a, int x, int y) {
		super(x,y,300,300,a, new ImageIcon("C:\\Users\\S1802049\\git\\repository\\Rpg Game (2)\\Rpg Game\\src\\Pics\\archer.png"),health,600,"");
	}
	public String toString () {
		return "Aq";
	
	}
}