
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class Game extends JPanel implements Runnable, KeyListener, MouseListener,MouseMotionListener{
	private static final ArrayList<Ranged> rangedList = null;
	private BufferedImage back;
	private int key, x, y,w,h;
	private Character Archerqueen;
	private Character Icewizard;
	private Character Archer;
	private Character Wizard;
	//private String screens;
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
	private File file;

	private Queue <Enemy> enemies;
	private int enemyFireInterval = 100; // Adjust this value as needed
	private int enemyFireTimer = 0;
	private boolean up,down,left,right,move,invis;


	ArrayList<Abilities>ranged = new ArrayList<Abilities>();
	ArrayList<Abilities> projectiles = new ArrayList<Abilities>();
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

		screen = Screen.START;
		key =-1;
		x=0;
		y=0;
		w=0;
		h=0;
		bx = 0;
		by = 0;
		up = false;
		left = false;
		right=false;
		down = false;
		move=false;

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
		file = new File("backup.txt");

		enemies=setES();
		setStartChars();
	}
	private Queue<Enemy> setES() {
		Queue <Enemy> temp = new LinkedList <> ();
		temp.add(new Giant (200, new Energy(440,350, 5, 0), 1200,240));
		temp.add(new Sparky (500, new Energy(440,350, 5, 0), 1200,240));
		temp.add(new Valk (500, new Rock (440,350, 5, 0), 1200,200));
		temp.add(new Frog (400, new Rock(400,300,5,0),1200,200));
		return temp;
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

		public void createFile() {
	try {
		if (file.createNewFile()) {
			System.out.println("File created" +file.getName());
		}
		else {
			System.out.println("File already exists");
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	//scanner
	public void writeToFile() {
		try {
			FileWriter myWriter = new FileWriter(file);
			myWriter.write("You have" + enemies.size()+ "enemies left");
			myWriter.close();
			System.out.println("Successfullly wrote to file");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void readFile() {
		try {
			Scanner sc= new Scanner(file);
			while(sc.hasNext()) {
				System.out.println(sc.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}





	public void paint(Graphics g){
		Graphics2D twoDgraph = (Graphics2D) g;
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight())));
		Graphics g2d = back.createGraphics();
		g2d.clearRect(0,0,getSize().width, getSize().height);
			
		if(enemies.isEmpty()){
					screen = screen.WINSCREEN;
				}
		
		g2d.setFont( new Font("Broadway", Font.BOLD, 50));
		switch (screen) {
		case START:
			drawStartScreen(g2d);
			break;
		case WIZARD:
			player = startList.get(0);
			player.drawChar(g2d);	
			player.getAb().reset(time);
			break;
		case ARCHER:
			player = startList.get(1);	
			player.drawChar(g2d);	
			player.getAb().reset(time);
			break;
		case DRAG:
			//wizard
			player = startList.get(2);
			if (!containsSword()) {
				ranged.add(new Sword (player.getAb().getX(), player.getAb().getY()));
			}
			player.setAb((Ranged) ranged.get(ranged.size() -1));
			player.drawChar(g2d);
			player.getAb().reset(time);
			break;
		case BABYDRAG:
			player = startList.get(3);	
			player.drawChar(g2d);	
			player.getAb().reset(time);
			break;
			case WINSCREEN:
		 g2d.drawString("Win", 500, 500);
			break;
			case LOSESCREEN:
		 g2d.drawString("Lose", 500, 500);
			break;
		case GAMESCREEN:
player.getAb().setY(player.getY());
			g2d.drawImage(img.getImage(), bx, by, getSize().width + 3000, getSize().height + 3000, null);
		//	System.out.println(enemies.element());
          Enemy enemy = enemies.element();
			if (player.getAb().getReady()) {
				enemies.element().drawChar(g2d);
				g2d.drawRect(player.getX(),player.getY(),player.getX()+player.getW(),player.getY()+player.getH());
				g2d.drawRect(enemy.getX(),enemy.getY(),enemy.getX()+enemy.getW(),enemy.getY()+enemy.getH());
				player.drawChar(g2d);
				
			}

			
//LOSESCREEN
			System.out.println(player.getHp());
				if(player.getHp()<=0){
					screen = screen.LOSESCREEN;
				}
//WINSCREEN
	
			



			
			if (time%100==0) {
				enemy.updatePosition();

				if (enemies.element() instanceof Sparky) 
				projectiles.add(new Abilities(50, 100, 0, enemies.element().getX(), enemies.element().getY(), 100, 100, new ImageIcon("src/Pics/energy (2).gif")));
				//enemies.element();
				if  (enemies.element() instanceof Valk) 
				projectiles.add(new Abilities(50, 10, 0, enemies.element().getX(), enemies.element().getY(), 100, 100, new ImageIcon("src\\ax.png")));
	
				if (enemies.element() instanceof Giant) 
				projectiles.add(new Abilities(50, 10, 0, enemies.element().getX(), enemies.element().getY(), 200, 200, new ImageIcon("src\\rock.png")));
				if (enemies.element() instanceof Sparky) 
				projectiles.add(new Abilities(50, 10, 0, enemies.element().getX(), enemies.element().getY(), 100, 100, new ImageIcon("src/Pics/energy (2).gif")));
				if  (enemies.element() instanceof Frog)
               projectiles.add(new Abilities(50, 10, 0, enemies.element().getX(), enemies.element().getY(), 100, 100, new ImageIcon("src\\ax.png")));
				
			//	System.out.println("works");
			}

			//System.out.println(ranged.size());
			ArrayList<Abilities> toBeRemoved = new ArrayList<Abilities>();
			for (Abilities wep : projectiles) {
				wep.drawWeapon(g2d);
				wep.move2();

				if (wep.isColliding(player)) {
					player.setHp(player.getHp()-20);
				    
					toBeRemoved.add(wep);
					
				}

			}
			projectiles.removeAll(toBeRemoved);
			
			if (enemies.element().getHp() <= 0) {
				enemies.poll();
			}

			//collision

			//player.getAb().isColliding(enemies.peek());
			//for(int i=0; i<ranged.size();i++) {
			//	if(ranged.get(i).isColliding(enemies.element()));{
			//		enemies.element().setHp(enemies.element().getHp();
			//	}

			//if (enemies.element().getHp()<=0){
			//	enemies.poll();
			//}
			
			ArrayList<Abilities> toBeRemoved2 = new ArrayList<Abilities>();
			
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
				if (wep.isColliding(enemies.element())) {
					enemies.element().setHp(enemies.element().getHp() - 100);
					toBeRemoved2.add(wep);
				}
				if (wep.isColliding(player)) {
					enemies.element().setHp(player.getHp() - 10);
				    
					toBeRemoved.add(wep);
					
				}
				
				
				System.out.println((wep.isColliding(player)));
				//System.out.println (wep.isColliding(enemies.element())) ;
			//	System.out.println(wep.getX());			
			}
			
			ranged.removeAll(toBeRemoved2);
			
			
				
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
		//System.out.println(typeIndex + " " + selectString.length());



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
		if (e.getKeyCode() == KeyEvent.VK_L) {
			if (this.screen.equals(screen.GAMESCREEN)){
				//System.out.println(enemies.peek());
				enemies.poll();
			}


		}		

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			bx -= 5;
			
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			bx += 5;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			by -= 5;
			
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			by += 5;
			
		} else if (e.getKeyCode() == KeyEvent.VK_W) {
			player.setY(player.getY()-20);
		}
		else if (e.getKeyCode() == KeyEvent.VK_A) {
			player.setX(player.getX()-20);
		}
		else if (e.getKeyCode() == KeyEvent.VK_S) {
			player.setY(player.getY()+20);
		}
		else if (e.getKeyCode() == KeyEvent.VK_D) {
				player.setX(player.getX()+20);
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