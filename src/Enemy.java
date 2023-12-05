

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


public class Enemy extends Character {
private int x,w,y,h;
private int dx,dy;
private Ranged ab;
private ImageIcon img;
private int hp,dmg;
private String buffs;

public Enemy () {
	x=0;
	y=0;
	w=0;
	h=0;
	dx=0;
	dy=0;
	ab = new Ranged();
	img= new ImageIcon("");
	hp = 100;
	dmg = 0;
	buffs = "none";
}	
public Enemy (int xV, int yV, int width, int height, Ranged a, ImageIcon i, int health, int damage, String b)
{
x=xV;
y=yV;
w=width;
h=height;
ab=a;
dy=0;
img= i;
hp = health;
dmg = damage;
buffs = b;
}

public void drawChar(Graphics g2d) {
	g2d.drawImage(img.getImage(),x,y,w,h, null);}


	public void updatePosition() {
        // Add logic to move the enemy up and down randomly
        int direction = (int) (Math.random() * 2); // 0 or 1
        int speed = 50; // Adjust the speed as needed

        if (direction == 0) {
            // Move up
            setY(getY() - speed);
        } else {
            // Move down
            setY(getY() + speed);
        }
    }


public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public int getW() {
	return w;
}
public void setW(int w) {
	this.w = w;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}
public int getH() {
	return h;
}
public void setH(int h) {
	this.h = h;
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
public Ranged getAb() {
	return ab;
}
public void setAb(Ranged ab) {
	this.ab = ab;
}
public ImageIcon getImg() {
	return img;
}
public void setImg(ImageIcon img) {
	this.img = img;
}
public int getHp() {
	return hp;
}
public void setHp(int hp) {
	this.hp = hp;
}
public int getDmg() {
	return dmg;
}
public void setDmg(int dmg) {
	this.dmg = dmg;
}
public String getBuffs() {
	return buffs;
}
public void setBuffs(String buffs) {
	this.buffs = buffs;
}

}