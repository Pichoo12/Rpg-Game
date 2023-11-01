import javax.swing.ImageIcon;

public class Giant extends Enemy{

	public Giant() {
		super();
		

	}
	//int xV, int yV, int width, int height, Abilities a, 
	public Giant (int health, Ranged a, int x, int y) {
		super(x,y,300,300,a, new ImageIcon("src\\Pics\\giant.png"),health,600,"");
	}
	public String toString () {
		return "Giant";
	
	}
}