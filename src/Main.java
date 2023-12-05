import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main extends JFrame{
	private static final int WIDTH =1600;
	private static final int HEIGHT=900;
	public Main () {
		super("Clash Royale");
		setSize(WIDTH, HEIGHT);
		Game play = new Game();
		((Component) play).setFocusable(true);
		Color Yellow = new Color(250,0,0);
		setBackground(Yellow);
		getContentPane().add(play);
		setVisible(true);
		addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				play.createFile();
				play.readFile();
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				play.writeToFile();
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		Main run = new Main();
	}
}
