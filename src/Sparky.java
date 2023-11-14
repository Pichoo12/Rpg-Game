import javax.swing.ImageIcon;

public class Sparky extends Enemy{

	public Sparky() {
		super();
		

	}
	//int xV, int yV, int width, int height, Abilities a, 
	public Sparky (int health, Ranged a, int x, int y) {
<<<<<<< HEAD
		super(x,y+50,300,300,a, new ImageIcon("src\\Pics\\sparky.png"),health,600,"");
=======
		super(x,y,300,300,a, new ImageIcon("src/Pics/sparky.png"),health,600,"");
>>>>>>> 73495bcafc82cadb2030f1db7f7cd1a49ad5a4ff
	}
	public String toString () {
		return "sparky";
	
	}
}
