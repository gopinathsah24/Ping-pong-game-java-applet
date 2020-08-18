package pingpong;

import java.util.*;
import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AudioClip;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.net.URL;


public class Tennis extends Applet implements Runnable, KeyListener,ActionListener {
	Thread thread;
	int score=0;int score1=0;
	HumanPaddle2 p2;
	HumanPaddle p1;
	Graphics gfx;
	Image img;
	int level=1;
	int levelcheck;
	AIPaddle p3;
	Ball b1;
	AudioClip ballhit;
	
	boolean gamestarted;
	
	final int WIDTH = 700; int HEIGHT = 500;
	public void init() {
		score = 0;
		levelcheck=0;
		score1=0;
		this.resize(WIDTH,HEIGHT);
		gamestarted = false;
		this.addKeyListener(this);
		ballhit = getAudioClip(getDocumentBase(),"BALL.au");
		b1 = new Ball();
		p1 = new HumanPaddle(1,b1);
		//p2 = new HumanPaddle2(2);
	
		p3 = new AIPaddle(2,b1);
		Button play = new Button(" Play in Loop "); 
	      play.addActionListener(this);
	
		
		img = createImage(WIDTH,HEIGHT);
		gfx = img.getGraphics();
		thread = new Thread(this);
	
		thread.start();
	}
	public void paint(Graphics g) {
		gfx.setColor(Color.black);
		gfx.fillRect(0, 0, WIDTH, HEIGHT);
		
		String s = Integer.toString(score);
		Font font  = new Font("Arial", Font.BOLD,18);
		gfx.setFont(font);
		gfx.setColor(Color.WHITE);
		gfx.drawString("P2 score :" + s, WIDTH-150, 50);
		
		
		String s1 = Integer.toString(score1);
		Font font1  = new Font("Arial", Font.BOLD,18);
		gfx.setFont(font1);
		gfx.setColor(Color.WHITE);
		gfx.drawString("P1 score : "+s1, 40, 50);
//		
//		String l = Integer.toString(level);
//		Font font2  = new Font("Arial", Font.BOLD,18);
//		gfx.setFont(font2);
//		gfx.setColor(Color.red);
//		gfx.drawString(l, 350, 50);
		
		
		if(b1.getX()<0||b1.getX()>700) {
		
			b1.x=-70990;
			b1.y=25000;
			p1.y=250;
			p1.yVel=0;
			gfx.setColor(Color.red);
			Font font4  = new Font("Arial", Font.BOLD,32);
			gfx.setFont(font4);
			gfx.drawString("Game Over", 260,180);
			
		
			
		}
		p1.draw(gfx);
		p3.draw(gfx);
		b1.draw(gfx);
	if(!gamestarted) {
		gfx.setColor(Color.WHITE);
		gfx.drawString("PingPong",290,100);
		gfx.drawString("Press Enter to Begin....",200,130);
	}
	g.drawImage(img, 0, 0,this);
	}

	public void update(Graphics g) {
		paint(g);
	}
	public void run() {
		// TODO Auto-generated method stub
		for(;;) {
//			if(levelcheck>100000) {
//				level++;
//				levelcheck=0;
//			}
//			levelcheck++;
			if(gamestarted) {
			p1.move();
			p3.move();
			b1.move();
			b1.checkPaddleCollision(p1, p3);
			if(b1.checkcollision1()) {
				score1+=10;
				
			}else if(b1.checkcollision2()){
				score+=10;
//				if(score1>30||score>30) {
//					b1.xVel-=0.4;
//					b1.yVel+=0.4;
//				}
			}
		
			
			repaint();
		
		try {
			Thread.sleep(10);
			
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		}
	}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_W) {
			p1.setupAccel(true);
		}else if(e.getKeyCode()==KeyEvent.VK_S) {
			p1.setdownAccel(true);
		}
		else if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			gamestarted = true;
		}else if(e.getKeyCode()==KeyEvent.VK_UP) {
			p3.setupAccel(true);
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			p3.setdownAccel(true);
		}
		// TODO Auto-generated method stub
		
	}
	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	if(e.getKeyCode()==KeyEvent.VK_W) {
			p1.setupAccel(false);
		}else if(e.getKeyCode()==KeyEvent.VK_S) {
			p1.setdownAccel(false);
		}else if(e.getKeyCode()==KeyEvent.VK_UP) {
			p3.setupAccel(false);
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			p3.setdownAccel(false);
		}
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==(Object)b1.checkcollision1()) {
			ballhit.play();
		}

	}





	
}
