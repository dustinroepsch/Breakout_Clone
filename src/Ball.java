import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;
public class Ball{
    private Location loc;
    private Location originalLoc;
    private Color color;
    private Ellipse2D.Double circle;
    private int dx;
    private int dy;
    
    public Ball(Location l){
        
        loc = l;
        originalLoc = l;
        dx = 5;
        dy = 5;
        circle = new Ellipse2D.Double(loc.getX(),loc.getY(), 20, 20);
        color = Color.RED;
    }
    public Ball(int x, int y){
        
        dx = 5;
        dy = 5;
        loc = new Location(x, y);
        originalLoc = new Location(x,y);
        circle = new Ellipse2D.Double(loc.getX(),loc.getY(), 20, 20);
        color = Color.RED;
    }
    public void draw(Graphics2D g2){
        g2.setColor(color);
        g2.fill(circle);
        g2.setColor(Color.BLACK);
        g2.draw(circle);
    }
    public void move(){
        loc.set((int) circle.getX() + dx, (int) circle.getY() + dy);
        circle.setFrame(circle.getX() + dx, circle.getY() + dy, 20,20);
        
    }
    public void checkWalls(Lives lives, Start start){
        if (loc.getX() < 0 ){
            dx = Math.abs(dx);
        }
        if (loc.getX() > 580 ){
            dx =Math.abs(dx) *-1;
        }
        if (loc.getY() < 0){
            dy = Math.abs(dy);
        }
        
        if (loc.getY() > 580){
            this.reset();
            
            lives.loseLife();
            
            start.set(false);
            
            
        }
    }
    public Ellipse2D.Double getCircle(){
        return circle;
    }
    public void setDX(int d){
        dx = d;
    }
    public void setDY(int d){
        dy = d;
    }
    public int getDX(){
        return dx;
    }
    public int getDY(){
        return dy;
    }
    public Location getLocation(){
        return loc;
    }
    
    public void reset(){
        
        loc = new Location(originalLoc.getX(), originalLoc.getY());
        dx = 5;
        dy = 5;
        circle = new Ellipse2D.Double(loc.getX(),loc.getY(), 20, 20);
        color = Color.RED;
    }
    
}