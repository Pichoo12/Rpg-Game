import javax.swing.ImageIcon;

public class Archer extends Character{

	public Archer() {
		super();
		

	}
	//int xV, int yV, int width, int height, Abilities a, 
	public Archer (int health, Ranged a, int x, int y) {
		super(x,y,300,300,a, new ImageIcon("src/archer.png"),health,600,"");
	}
	//public String toString () {
		//return "Aq";
	
	//}
}
