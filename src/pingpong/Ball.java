package pingpong;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

public class Ball implements ActionListener{
 double xVel, yVel, x;
 double y;AudioClip ballhit;
 boolean flag,flag1;
 public Ball() {
	 x=350;
	 y=250;
	 xVel =getRandomSpeed()*getRandomDirection();
	// ballhit = getAudioClip(getDocumentBase(),"BALL.au");
	 yVel = getRandomSpeed()*getRandomDirection();
	 
 }
 public double getRandomSpeed() {
	 return (Math.random()*3+2);
 }
 public int getRandomDirection() {
	 int rand = (int)(Math.random()*2);
	 if(rand==1) {
		 return 1;
		 
	 }
	 else {
		 return -1;
	 }
 }
 public void draw(Graphics g) {
	 g.setColor(Color.GREEN);
	 g.fillOval((int)x-10, (int)y-10, 20, 20);
 }
 public void move() {
	 x+=xVel;
	 y+=yVel;
	 if(y<10) {
		 yVel = -yVel;
	 }
	 if(y>490) {
		 yVel = -yVel;
	 }
 }
 public void checkPaddleCollision(paddle p1 , paddle p2) {
	  flag=false;
	  flag1=false;
	 if(x<=50) {
		 if(y>=p1.getY()&&y<=p1.getY()+80) {
			xVel = -xVel; 
			flag=true;
			
		 }
	 }
	 else if(x>=650) {
		 if(y>=p2.getY()&&y<=p2.getY()+80) {
				xVel = -xVel;
				flag1=true;
			 }
	 
	 }
 }
 public boolean checkcollision1() {

	 return flag;
 }
 public boolean checkcollision2() {
	 return flag1;
 }
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(flag) {
			ballhit.play();
		}

	}
 public int getX() {
	 return (int)x;
 }
 public int getY() {
	 return (int)y;
 }

}