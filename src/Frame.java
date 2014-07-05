import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Frame{
    public static void main(String[] args){
        final JFrame frame = new JFrame();
        final BlockGroup test = new BlockGroup();
        final Paddle paddle = new Paddle();
        final Ball ball = new Ball(280,350);
        final Lives lives = new Lives();
        final Start start = new Start();
        class FrameComponent extends JComponent{
            public void paintComponent(Graphics g){
                Graphics2D g2 = (Graphics2D) g;
                lives.draw(g2);
                test.draw(g2);
                paddle.draw(g2);
                ball.draw(g2);

                if (start.get()){
                    ball.move();
                }
                ball.checkWalls(lives, start);
                test.checkAll(ball);
                paddle.checkBounce(ball);
                //if (ball.checkDead()){
                //    ball.reset();
                //}

            }
        }
        final FrameComponent co = new FrameComponent();

        class ReDraw implements ActionListener{
            private int level = 0;
            public void actionPerformed(ActionEvent e){
                boolean checked = false;

                if (test.checkWin() && !checked){

                    checked = true;
                    if (level == 3){
                        JOptionPane.showMessageDialog(frame,"You won the game!");
                        System.exit(0);
                    }
                    JOptionPane.showMessageDialog(frame,"You win!");
                    level++;
                    ball.reset();
                    test.setLevel(level);

                    start.set(false);
                }
                if (lives.checkLose() && !checked){
                    JOptionPane.showMessageDialog(frame,"You Lose!");
                    checked = true;
                    System.exit(0);
                }

                frame.repaint();
            }

            public void setLevel(int n){
                level = n;   
            }

            public int getLevel(){
                return level;
            }
        }
        class Mouse implements MouseMotionListener{
            public void mouseDragged(MouseEvent e){
                //if (start.get()){
                paddle.setX(e.getX() - Paddle.LENGTH/2);
                //}
            }

            public void mouseMoved(MouseEvent e){
                //if (start.get()){
                paddle.setX(e.getX() - Paddle.LENGTH/2);
                //}
            }
        }
        class MouseClick implements MouseListener{
            public void mouseClicked(MouseEvent e){
                start.set(true);   
            }

            public void mouseEntered(MouseEvent e){

            }

            public void mouseExited(MouseEvent e){
                //start.set(false);
            }

            public void mousePressed(MouseEvent e){

            }

            public void mouseReleased(MouseEvent e){

            }
        }
        final ReDraw m = new ReDraw();
        class KeyStuff implements KeyListener{
            private boolean cheats = false;;
            public void keyPressed(KeyEvent e){

                if (cheats){
                    ball.reset();
                    //System.out.println(e.getKeyText(e.getKeyCode()));

                    test.setLevel(Integer.parseInt(e.getKeyText(e.getKeyCode())));

                }
                if (Integer.parseInt(e.getKeyText(e.getKeyCode())) == 6){
                    cheats = true;
                }

            }

            public void keyReleased(KeyEvent e){

            }

            public void keyTyped(KeyEvent e){

            }
        }
        frame.addKeyListener(new KeyStuff());
        MouseClick mc = new MouseClick();
        Mouse ml = new Mouse();
        frame.addMouseMotionListener(ml);
        frame.addMouseListener(mc);

        Timer t = new Timer(15,m);
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(co);
        frame.setVisible(true);
        frame.setResizable(false);
        t.start();
    }
}