import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class Game extends JPanel implements Runnable, KeyListener, MouseListener,MouseMotionListener{
	private BufferedImage back;
	private int key, x, y,w,h;
	private Character Archerqueen;
	private Character Icewizard;
	private Character Archer;
	private Character Wizard;
	//private String screen,
	private String selectString;
	private Screen screen;
	private int text;
	private int bx,by;
	private int time;
	private Character player;
	private String characterbackground;
	private String background;
	private String selectcharacterbackground;
	private ImageIcon img , img1, img2;
	ArrayList<Abilities>ranged = new ArrayList<Abilities>();
	ArrayList<Character> startList = new ArrayList<Character>();
	private ArrayList<Character> setStartChars() {
		startList.add(new Archerqueen(200, new bfire(400,280, 5, 0), 130,320));
		startList.add(new Icewizard(200, new Boom(380,350, 5, 0), 510,270));
		startList.add(new Wizard(200,new Sword(4000,500), 830,260));
		startList.add(new Archer(200, new Bow(440,350, 5, 0), 1200,240));
		return startList;
	}
	//private ArrayList <Character>startList;
	public Game() {
		new Thread(this).start();
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		setStartChars();
		screen = Screen.START;
		key =-1;
		x=0;
		y=0;
		w=0;
		h=0;
		bx = 0;
		by = 0;
		//	screen="start";
		selectString = "Select Your Character";
		text = 1;
		time = 0;
		background = "src\\characterback.gif";
		selectcharacterbackground = "src\\Pics\\selectcharback.jpg";
		characterbackground = "src\\Pics\\background.jpg";
		img = new ImageIcon(characterbackground);
		img1 = new ImageIcon (background);
		img2 = new ImageIcon (selectcharacterbackground);
	}
	public void run()
	{
		try
		{
			while(true)
			{
				Thread.currentThread().sleep(5);
				repaint();
			}
		}
		catch(Exception e)
		{
		}
	}
	public boolean containsSword() {
		for (Abilities r : ranged) {
			if (r instanceof Ranged) {
				if (r instanceof Sword) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void paint(Graphics g){
		Graphics2D twoDgraph = (Graphics2D) g;
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight())));
		Graphics g2d = back.createGraphics();
		g2d.clearRect(0,0,getSize().width, getSize().height);
		g2d.setFont( new Font("Broadway", Font.BOLD, 50));
		switch (screen) {
			case START:
			drawStartScreen(g2d);
			break;
		case WIZARD:
			player = startList.get(0);
			player.drawChar(g2d);	
			break;
		case ARCHER:
			player = startList.get(1);	
			player.drawChar(g2d);	
			break;
		case DRAG:
			//wizard
			player = startList.get(2);
			if (!containsSword()) {
				ranged.add(new Sword (player.getAb().getX(), player.getAb().getY()));
			}
			
			player.setAb((Ranged) ranged.get(ranged.size() -1));

			player.drawChar(g2d);
			break;
		case BABYDRAG:
			player = startList.get(3);	
			player.drawChar(g2d);	
			break;
		case GAMESCREEN:
		g2d.drawImage(img.getImage(), bx, by, getSize().width + 3000, getSize().height + 3000, null);

			player.drawChar(g2d);
			//System.out.println(ranged.size());

			for (Abilities wep : ranged) {
				if (wep instanceof Sword) {
					wep.setX(player.getX());
					wep.setY(player.getY());
					wep.drawWeapon(g2d);
					//System.out.println(wep);
					//click player.getWep().switchsword();
				} else {
					wep.drawWeapon(g2d);
					wep.move();

				}
				System.out.println(wep.getX());			
			}
			break;
		}
		drawScreen(g2d);
		//if(player!=null)
			//System.out.println(player.getAb());
			time++;
		twoDgraph.drawImage (back, null, 0, 0);
	}
	private void drawScreen(Graphics g2d) {
	}
	private void drawStartScreen(Graphics g2d) {
		int text =1;
		int typeTime = 100;
		int typeSpeed = 3;
		typeTime = typeTime / typeSpeed;
		int typeIndex = time/typeTime - ((time%typeTime)/typeTime);
		g2d.setColor(Color.black);
		System.out.println(typeIndex + " " + selectString.length());



		if (typeIndex<= selectString.length() && typeIndex !=0) {
		g2d.setColor(Color.white);
		 g2d.drawImage(img1.getImage(), 0,0,getSize().width, getSize().height, null);
			g2d.drawString(selectString.substring(0,typeIndex),500,200);
			System.out.println(selectString.substring(0,typeIndex));
		}
		else {
			text++;
			g2d.drawImage(img.getImage(), 0,0,getSize().width, getSize().height, null);
			//selectString="";
			for(Character sL : startList) {
				sL.drawChar(g2d);
			}	
			//g2d.drawString(selectString,500,200);
			g2d.drawString("drag",550,600);
			g2d.drawString("bdrag",170,600);
			g2d.drawString("wizard",850,600);
			g2d.drawString("archer",1270,600);
		}
	}
	//DO NOT DELETE
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}
	//DO NOT DELETE
	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			bx -= 5;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			bx += 5;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			by -= 5;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			by += 5;
		}

		switch (e.getKeyCode()){
		case 49:
			//1
			if (screen.getIndex() == 0) {
				screen = screen.WIZARD;	
			}
			break;
		case 50:
			if (screen.getIndex() == 0) {
				screen = screen.ARCHER;
			}
			break;
		case 51:
			if (screen.getIndex() == 0) {
				screen = screen.DRAG;	
			}
			break;
		case 52:
			if (screen.getIndex() == 0) {
				screen = screen.BABYDRAG;
			}	
		case 32:
			if (player != null) {
				screen = screen.GAMESCREEN;	
				player.setX(200);
				player.setY(200);
				
	
			}	

			//player.getWeapon(g2d).drawWeapon();
		}	
	}	
	// TODO Auto-generated method stu
	//DO NOT DELETE
	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		x=arg0.getX();
		y=arg0.getY();
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("entered");
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("exited");
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("you clicked at"+ arg0.getY());
		x=arg0.getX();
		y=arg0.getY();
		//ranged.add(new Bow(100, player.getY(), 1, 1));
		//System.out.println()
		if (player instanceof Archerqueen) {
			ranged.add(new bfire(player.getAb().getX(), player.getAb().getY(),player.getAb().getDx(),player.getAb().getDy()));
			System.out.println(ranged.get(ranged.size()-1).getX());
		}
		else if (player instanceof Icewizard) {
			ranged.add(new Boom(player.getAb().getX(), player.getAb().getY(),player.getAb().getDx(),player.getAb().getDy()));
			ranged.add(new Boom(player.getAb().getX(), player.getAb().getY()+20,player.getAb().getDx(),player.getAb().getDy()));
			System.out.println(ranged.get(ranged.size()-1).getX());
		}

		else if (player instanceof Archer) {
			ranged.add(new Bow(player.getAb().getX(), player.getAb().getY(),player.getAb().getDx(),player.getAb().getDy()));
			System.out.println(ranged.get(ranged.size()-1).getX());
		}
		else if (player instanceof Wizard) {
			if (player != null) {
				if (player.getAb() instanceof Sword){
					((Sword) player.getAb()).switchSword();
					
				}
			}
		}
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
}



