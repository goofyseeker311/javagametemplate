package game.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class GameTemplate extends JFrame implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener, ComponentListener, Runnable {
	int screenwidth = 1920, screenheight = 1080;
	BufferedImage doublebuffer = null; //new BufferedImage(screenwidth, screenheight, BufferedImage.TYPE_INT_ARGB);
	
	public GameTemplate() {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice(); this.screenwidth = gd.getDisplayMode().getWidth(); this.screenheight = gd.getDisplayMode().getHeight();
		doublebuffer = new BufferedImage(screenwidth, screenheight, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = doublebuffer.createGraphics(); g2.setColor(Color.GREEN); g2.fillRect(0, 0, screenwidth, screenheight); g2.setColor(Color.YELLOW);
		g2.drawLine(0, screenheight-1, screenwidth-1, screenheight-1); g2.drawLine(0, screenheight-3, screenwidth-1, screenheight-3); g2.drawLine(0, screenheight-5, screenwidth-1, screenheight-5);
		g2.drawLine(0, 0, screenwidth-1, 0); g2.drawLine(0, 2, screenwidth-1, 2); g2.drawLine(0, 4, screenwidth-1, 4);
		g2.setColor(Color.MAGENTA); g2.drawLine(0, 0, 0, screenheight-1); g2.drawLine(2, 0, 2, screenheight-1); g2.drawLine(4, 0, 4, screenheight-1);
		g2.drawLine(screenwidth-1, 0, screenwidth-1, screenheight-1); g2.drawLine(screenwidth-3, 0, screenwidth-3, screenheight-1); g2.drawLine(screenwidth-5, 0, screenwidth-5, screenheight-1);
		
		this.addKeyListener(this); this.addMouseListener(this); this.addMouseMotionListener(this); this.addMouseWheelListener(this); this.addComponentListener(this);
		this.setUndecorated(true); this.setExtendedState(JFrame.MAXIMIZED_BOTH); this.setSize(screenwidth, screenheight); this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); this.setVisible(true);
	}

	public static void main(String[] args) { GameTemplate app = new GameTemplate(); app.render(); } //app.run();
	@Override public void paint(Graphics g) { super.paint(g); Graphics2D g2 = (Graphics2D)g.create(); g2.drawImage(doublebuffer, 0, 0, null); }
	@Override public void keyPressed(KeyEvent e) { if (e.getKeyCode() == KeyEvent.VK_ESCAPE) { System.exit(0); } }
	
	@Override public void keyTyped(KeyEvent e) {}
	@Override public void keyReleased(KeyEvent e) {}
	@Override public void mouseWheelMoved(MouseWheelEvent e) {}
	@Override public void mouseDragged(MouseEvent e) {}
	@Override public void mouseMoved(MouseEvent e) {}
	@Override public void mouseClicked(MouseEvent e) {}
	@Override public void mousePressed(MouseEvent e) {}
	@Override public void mouseReleased(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
	@Override public void componentResized(ComponentEvent e) {}
	@Override public void componentMoved(ComponentEvent e) {}
	@Override public void componentShown(ComponentEvent e) {}
	@Override public void componentHidden(ComponentEvent e) {}
	@Override public void run() {}
	
	public void render() {
		RenderEngine render = new RenderEngine();
	}
	
	private class RenderEngine {
		public RenderEngine() {
		}
		class Sphere { public Sphere(double xd,double yd,double zd,double rd){this.x=xd;this.y=yd;this.z=zd;this.r=rd;} public double x,y,z,r; }
		class Plane { public Plane(double ad,double bd,double cd,double dd){this.a=ad;this.b=bd;this.c=cd;this.d=dd;} public double a,b,c,d; }
	}

}
