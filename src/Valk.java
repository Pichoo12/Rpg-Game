import javax.swing.ImageIcon;

public class Valk extends Enemy{

	public Valk() {
		super();
		

	}
	//int xV, int yV, int width, int height, Abilities a, 
	public Valk (int health, Ranged a, int x, int y) {
		super(x,y,300,300,a, new ImageIcon("src\\Pics\\valk.png"),health,600,"");
	}
	public String toString () {
		return "Sparky";
	
	}
}