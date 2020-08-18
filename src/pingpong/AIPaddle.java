package pingpong;
import java.util.*;
import java.awt.Color;
import java.awt.Graphics;

public class AIPaddle implements paddle {
double y, yVel;
//int rand = (int)(Math.random() * 100) + -40; 
Ball b1;
boolean upAccel, downAccel;
int player,x;
double GRAVITY = 0.83;
public AIPaddle(int player,Ball b) {
	y=210;
	yVel = 0;
	b1=b;
	upAccel = false;
	downAccel = false;
	if(player==1) {
		x=20;
	}
	else {
		x=660;
	}
}
public void draw(Graphics g) {
	g.setColor(Color.white);
	g.fillRect(x,(int)y, 20, 80);
}

public void move() {

y = b1.getY()-40;
//	if(upAccel)
//		yVel-=0.9;
//	
//	else if(downAccel)
//		yVel+=0.9;
//	
//	else if(!upAccel && !downAccel) {
//		yVel*=GRAVITY;
//	}
//	y+=yVel;
	if(y<0) {
		y=0;
	}
	else if(y>420) {
		y=420;
	}
}
public int getY() {
	return (int)y;
}


public void setupAccel(boolean input) {
	upAccel = input;
}
public void setdownAccel(boolean input) {
	downAccel = input;
}


}
