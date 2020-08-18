package pingpong;
import java.util.*;
import java.awt.Color;
import java.awt.Graphics;

public class HumanPaddle implements paddle {
double y, yVel;
Ball b1;
boolean upAccel, downAccel;
int player,x;
double GRAVITY = 0.83;
public HumanPaddle(int player,Ball b) {
	y=210;
	b1=b;
	yVel = 0;
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
	if(upAccel)
		yVel-=0.9;
	
	else if(downAccel)
		yVel+=0.9;
	
	else if(!upAccel && !downAccel) {
		yVel*=GRAVITY;
	}
	y+=yVel;
	//y=b1.getY()-40;
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
