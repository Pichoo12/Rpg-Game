import javax.swing.ImageIcon;

public class Archerqueen extends Character{

	public Archerqueen() {
		super();
		
	}
	//int xV, int yV, int width, int height, Abilities a, 
	public Archerqueen (int health, Ranged a, int x, int y) {
		super(x,y,250,250,a, new ImageIcon("C:\\Users\\S1802049\\git\\repository\\Rpg Game (2)\\Rpg Game\\src\\Pics\\babyd.png"),health,600,"");
	}
	public String toString () {
		return super.getAb().toString() ;
	
	}
}