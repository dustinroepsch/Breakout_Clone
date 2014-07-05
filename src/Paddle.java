import java.awt.*;
import java.awt.geom.*;
public class Paddle{
    private Location loc;
    private Location midPoint;
    private Rectangle rectangle;
    public final static int LENGTH = 100;
    public final static int HEIGHT = 10;
    public Paddle(){
       
        loc = new Location(200 ,550);
        midPoint = new Location(loc.getX() + (loc.getX()/2), loc.getY());
         rectangle = new Rectangle(loc.getX(), loc.getY(), LENGTH, HEIGHT);
    }
    public void draw(Graphics2D g2){
        g2.setColor(Color.BLUE);
        g2.fill(rectangle);
        g2.setColor(Color.BLACK);
        g2.draw(rectangle);
    }
    public void setX(int x){
        loc.setX(x);
        rectangle.setLocation(loc.getX(), loc.getY());
        midPoint = new Location(loc.getX() + (loc.getX()/2), loc.getY());
    }
    public void checkBounce(Ball b){
        if (b.getCircle().intersects(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight())){
            b.setDY(Math.abs(b.getDY()) * -1);
            
            b.setDX((int)((b.getCircle().getX()+ 10) - (rectangle.getX()+(50)))/10);
            //System.out.println((int)((b.getCircle().getX()+ 10) - (rectangle.getX()+(50)))/10);
            
        }
    }
}