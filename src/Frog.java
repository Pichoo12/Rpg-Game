import javax.swing.ImageIcon;

public class Frog extends Enemy{

	public Frog() {
		super();
		

	}
	//int xV, int yV, int width, int height, Abilities a, 
	public Frog(int health, Ranged a, int x, int y) {
		super(x,y+50,300,300,a, new ImageIcon("src\\Pics\\giant.png"),health,600,"");
	}
	public String toString () {
		return "Frog";
	
	}
}