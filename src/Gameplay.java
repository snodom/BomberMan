import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

    private Timer timer;
    private int delay=15;
    private int playerposX=20;
    private int playerposY=20;

    private void mov_x_l(){
        playerposX=playerposX-5;
    }
    private void mov_x_r(){
        playerposX+=5;
    }
    private void mov_y_u(){
        playerposY-=5;
    }
    private void mov_y_d(){
        playerposY+=5;
    }

    public Gameplay(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer= new Timer(delay,this);
        timer.start();
    }
    public void paint(Graphics g){
        //background
        g.setColor(Color.black);
        g.fillRect(0,0,600,600);

        //borders
        g.setColor(Color.darkGray);
        g.fillRect(0,0,20,590);
        g.fillRect(0,0,600,20);
        g.fillRect(575,0,20,600);
        g.fillRect(0,555,600,20);

        //player

        g.setColor(Color.CYAN);
        g.fillRect(playerposX,playerposY,20,20);
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        repaint();
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        ///////////// player movement ///////////

        int i=0;

        if(e.getKeyCode()== KeyEvent.VK_RIGHT){
            if(playerposX>=555){
                playerposX= 555;
                i++;
                System.out.println("pozycja "+"x:"+playerposX+"y: "+playerposY+i);
            }
            else mov_x_r();
        }
        if(e.getKeyCode()== KeyEvent.VK_LEFT){
            System.out.println("lewo");
            if(playerposX<=20){
                playerposX= 20;
                System.out.println("pozycja "+"x:"+playerposX+"y: "+playerposY);
            }
            else mov_x_l();
        }
        if(e.getKeyCode()== KeyEvent.VK_UP){
            System.out.println("lewo");
            System.out.println("pozycja "+"x:"+playerposX+"y: "+playerposY);
            if(playerposY<=20){
                playerposY= 20;
            }
            else mov_y_u();
        }
        if(e.getKeyCode()== KeyEvent.VK_DOWN){
            if(playerposY>=535){
                playerposY= 535;
                System.out.println("pozycja "+"x:"+playerposX+"y: "+playerposY);
            }
            else mov_y_d();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
