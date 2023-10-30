import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main extends JFrame{
	private static final int WIDTH =1600;
	private static final int HEIGHT=900;
	public Main () {
		super("KeyListener Demo");
		setSize(WIDTH, HEIGHT);
		Game play = new Game();
		((Component) play).setFocusable(true);
		Color Red= new Color(250,0,0);
		setBackground(Red);
		getContentPane().add(play);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		Main run = new Main();
	}
}
