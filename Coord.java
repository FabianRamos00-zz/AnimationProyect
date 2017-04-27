package Model;
public class Coord {
   protected double x;
   protected double y;

    public Coord(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void move(double direction, double step){
       this.x = this.x + step * Math.cos(direction);
       this.y = this.y + step * Math.sin(direction);
    } 
      
    public boolean isInArea(Area area){
       return this.x>=area.x && this.x <= area.x+area.getWidth() &&
              this.y>=area.y && this.y <= area.y+area.getHeight(); 
    }

	public void run() {
		// TODO Auto-generated method stub
		
	}
   
   
}
