package GUI;

import java.awt.Color;
import java.awt.Graphics;

import Model.Coord;
import Model.Figure;
import Model.OnOff;

public class FigureGUI extends Figure{

	private Color color;
	
	public FigureGUI(Figure figure, Color color){
		super(figure.getSize(), figure.getDirection(), 
			  figure.getSpeed(), figure, figure.getState());
		this.setArea(figure.getArea());
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void init() {
		this.setMoving(true);
		new Thread(this).start(); 
	}

	public void draw(Graphics g) {
		Coord center = new Coord(this.getX()-this.getSize()/2,
				                           this.getY()-this.getSize()/2);
		g.setColor(this.color);
		g.fillRect((int)center.getX(), (int)center.getY(), 
				(int)this.getSize(), 
				(int)this.getSize());
		g.fillRect((int) (center.getX() + this.getSize()*4/10), 
				(int)(center.getY()+ this.getSize()), 
				(int)this.getSize()*2/10, 
				(int)this.getSize()/7);
		if (this.getState() == OnOff.ON) {
			g.setColor(Color.LIGHT_GRAY);
		}else{
			g.setColor(Color.BLACK);
		}
		g.fillRect((int) (center.getX() + this.getSize()/10), 
				(int)(center.getY()+ this.getSize()/10), 
				(int)this.getSize()*8/10, 
				(int)this.getSize()*8/10);
		if (this.getState() == OnOff.ON) {
			g.setColor(Color.YELLOW);
			g.fillOval((int) (center.getX()+ this.getSize()/2-this.getSize()/5), 
					(int)(center.getY()- this.getSize()*3/5), 
					(int)this.getSize()*2/5, 
					(int)this.getSize()*2/5);
		}else{
			g.drawOval((int) (center.getX() + this.getSize()/2-this.getSize()/5), 
					(int)(center.getY()- this.getSize()*3/5), 
					(int)this.getSize()*2/5, 
					(int)this.getSize()*2/5);
		}
	}
}
