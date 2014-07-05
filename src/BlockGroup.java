import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
public class BlockGroup{
    private Block[][] blocks;
    public BlockGroup(){
        blocks = new Block[4][7];
        for (int i = 0; i < blocks.length; i++){
            for (int j = 0; j <blocks[i].length; j++){
                blocks[i][j] = new Block((j *70) + 50 , (i * 40) + 50);
            }
        }
    }
    
    public void setLevel(int m){
        if (m == 1){
            blocks = new Block[4][7];
            for (int i = 0; i < blocks.length; i++){
                for (int j = 0; j <blocks[i].length; j++){
                    if (i%2 == 0 && j%2 ==0){
                        blocks[i][j] = new Block((j *70) + 50 , (i * 40) + 50);
                    }
                    if (i%2 == 1 && j%2 ==1){
                        blocks[i][j] = new Block((j *70) + 50 , (i * 40) + 50);
                    }
                }
            }
        }
        if (m == 2){
            Color c = new Color(0,0,0);
            for (int i = 0; i < blocks.length; i++){
                for (int j = 0; j <blocks[i].length; j++){
                    if (i%2 == 1){
                        c = new Color(0,0,0);
                        
                    }
                    else{
                        c = new Color(255,255,255);
                    }
                    blocks[i][j] = new Block((j *70) + 50 , (i * 40) + 50, c);
                }
            }
        }
        if (m == 3){
            for (int i = 0; i < blocks.length; i++){
                for (int j = 0; j <blocks[i].length; j++){
                    blocks[i][j] = null;
                }
            }
            for (int i = 0; i < blocks.length; i++){
                blocks[i][0] = new Block(50 , (i * 40) + 50, Color.RED);
            }
            blocks[1][1] = new Block((1 *70) + 50 , (1 * 40) + 50, Color.RED);
            blocks[2][1] = new Block((1 *70) + 50 , (2 * 40) + 50, Color.RED);
            for (int i = 0; i < blocks.length; i++){
                blocks[i][2] = new Block(190 , (i * 40) +50, Color.RED);
            }
            for (int i = 0; i < blocks.length; i++){
                blocks[i][5] = new Block((5*70) + 50 , (i * 40) +50, Color.RED);
            }
            blocks[0][4] = new Block((4 *70) + 50 , (0 * 40) + 50, Color.RED);
            blocks[0][6] = new Block((6 *70) + 50 , (0 * 40) + 50, Color.RED);
            blocks[3][4] = new Block((4 *70) + 50 , (3 * 40) + 50, Color.RED);
            blocks[3][6] = new Block((6 *70) + 50 , (3 * 40) + 50, Color.RED);
        }
    }
    public void draw(Graphics2D g2){
        for (int i = 0; i < blocks.length; i++){
            for (int j = 0; j <blocks[i].length; j++){
                if (blocks[i][j] != null){
                    blocks[i][j].draw(g2);
                }
            }
        }
    }
    public void checkAll(Ball b){
        for (int i = 0; i < blocks.length; i++){
            for (int j = 0; j <blocks[i].length; j++){
                if (blocks[i][j] != null && blocks[i][j].checkBounce(b)){
                    blocks[i][j] = null;
                }
            }
        }
    }
    public boolean checkWin(){
        boolean win = true;
        for (int i = 0; i < blocks.length; i++){
            for (int j = 0; j <blocks[i].length; j++){
                if (blocks[i][j] != null){
                    win = false;
                }
            }
        }
        return win;
    }
}