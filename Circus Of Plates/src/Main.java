import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Main extends Applet  implements Runnable{
	
	int x = 0;
	int y = 0;
	double dx = 10;
	double dy = 0;
	int radius = 20;
//	private Image i;
//	private Graphics doubleG;
	double gravity = 15;
	double energyloss = .80;
	double dt = .2;
	
	
	
	@Override
	public void init() {
		setSize(800,600);

	}
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		Thread thread = new Thread(this);
		thread.start();
		
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			
			if(x+dx > this.getWidth() - radius-1){
				x = this.getWidth() - radius-1;
				dx *= -1;
			}else if(x+dx < 0 + radius){
				x = 0 + radius;
				dx *= -1;
			}else{
				x+=dx;
			}
			
			if(y > this.getHeight() - radius-1){
				y = this.getHeight() - radius-1;
				dy *= -energyloss;
			}else{
				//velocity formula
				dy += gravity * dt;
				//posistion formula
				y += dy*dt + .5*gravity*dt*dt;
			}

			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(x-radius,y-radius,radius*2,radius*2);
	}
}