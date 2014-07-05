import java.awt.*;
import java.awt.geom.*;
public class Block{
    private Location loc;
    private Color color;
    private Rectangle rectangle;
    private Rectangle rectangleTop;
    private Rectangle rectangleDown;
    private Rectangle rectangleLeft;
    private Rectangle rectangleRight;
    public Block(Location l){
        loc = l;
        color = new Color((int) Math.random() * 256 ,(int) Math.random() * 256, (int) Math.random() * 256);
        rectangle = new Rectangle(loc.getX(),loc.getY(), 60, 30);
        rectangleTop = new Rectangle(loc.getX(),loc.getY(), 60, 10);
        rectangleDown = new Rectangle(loc.getX(), loc.getY() + 20 ,60,10);
        rectangleLeft = new Rectangle(loc.getX(), loc.getY(), 10, 30);
        rectangleRight = new Rectangle(loc.getX() + 50, loc.getY(), 10, 30);
    }
    public Block(int x, int y){
        Location loc = new Location(x, y);
        color = new Color((int) (Math.random() * 256) ,(int) (Math.random() * 256), (int) (Math.random() * 256));
        rectangle = new Rectangle(loc.getX(),loc.getY(), 60, 30);
        rectangleTop = new Rectangle(loc.getX(),loc.getY(), 60, 10);
        rectangleDown = new Rectangle(loc.getX(), loc.getY() + 20 ,60,10);
        rectangleLeft = new Rectangle(loc.getX(), loc.getY(), 10, 30);
        rectangleRight = new Rectangle(loc.getX() + 50, loc.getY(), 10, 30);
    }
    public Block(int x, int y, Color c){
        Location loc = new Location(x, y);
        color = c;
        rectangle = new Rectangle(loc.getX(),loc.getY(), 60, 30);
        rectangleTop = new Rectangle(loc.getX(),loc.getY(), 60, 10);
        rectangleDown = new Rectangle(loc.getX(), loc.getY() + 20 ,60,10);
        rectangleLeft = new Rectangle(loc.getX(), loc.getY(), 10, 30);
        rectangleRight = new Rectangle(loc.getX() + 50, loc.getY(), 10, 30);
    }
    public void draw(Graphics2D g2){
        g2.setColor(color);
        g2.fill(rectangle);
        g2.setColor(Color.BLACK);
        g2.draw(rectangle);
    }
    public boolean checkBounce(Ball b){
        boolean blah = false;
        if (b.getCircle().intersects(rectangleLeft.getX(), rectangleLeft.getY(), rectangleLeft.getWidth(), rectangleLeft.getHeight())){
            blah = true;
            b.setDX(Math.abs(b.getDX()) * -1);
            
        }
        if (b.getCircle().intersects(rectangleRight.getX(), rectangleRight.getY(), rectangleRight.getWidth(), rectangleRight.getHeight())){
            blah = true;
            b.setDX(Math.abs(b.getDX()));
            
        }
        if (b.getCircle().intersects(rectangleTop.getX(), rectangleTop.getY(), rectangleTop.getWidth(), rectangleTop.getHeight())){
            blah = true;
            b.setDY(Math.abs(b.getDY()) * -1);
            
        }
        if (b.getCircle().intersects(rectangleDown.getX(), rectangleDown.getY(), rectangleDown.getWidth(), rectangleDown.getHeight())){
            blah = true;
            b.setDY(Math.abs(b.getDY()));
            
        }
        return blah;
    }
}