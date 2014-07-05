import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
public class Lives{
    int numLives;
    public Lives(){
        numLives = 3;
    }
    public void loseLife(){
        numLives--;
    }
    public boolean checkLose(){
        return (numLives <= 0);
    }
    public void draw(Graphics2D g2){
        Font f = new Font("Blah", Font.BOLD, 70);
        g2.setFont(f);
        g2.setColor(Color.BLUE);
        g2.drawString(Integer.toString(numLives),5,50);
    }
}