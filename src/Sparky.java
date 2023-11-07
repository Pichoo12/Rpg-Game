import javax.swing.ImageIcon;

public class Sparky extends Enemy{

	public Sparky() {
		super();
		

	}
	//int xV, int yV, int width, int height, Abilities a, 
	public Sparky (int health, Ranged a, int x, int y) {
		super(x,y-200,300,300,a, new ImageIcon("src\\Pics\\sparky.png"),health,600,"");
	}
	public String toString () {
		return "sparky";
	
	}
}