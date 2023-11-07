import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
public class Abilities {

	private int dmg, dx, dy, x,y,w,h;
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
   }


   public boolean isColliding(Enemy enemy) {
	if (enemy.getX() >= this.getX() && enemy.getX() <= (this.getX() + (this.getW()/2))) {
		if (enemy.getY() >= this.getY() && enemy.getY() <= (this.getY() + (this.getH()/2))) {https://codeshare.io/register?saveCodeshare=dwmQ4D
			return true;
		}
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


public void setDmg(int dmg) {
	this.dmg = dmg;
}


public int getDmg () {
	return dmg;
}


}