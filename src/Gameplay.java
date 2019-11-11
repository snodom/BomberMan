import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

    private Timer timer;
    private int delay=15;
    private Wspolrzedne playerPos = new Wspolrzedne(20,20);
    private JFrame frame;
    private LinkedList<Bomb> bombs = new LinkedList<Bomb>();
    private LinkedList<Wybuch> wybuchy = new LinkedList<Wybuch>();

    private void mov_x_l(){
        playerPos.setX(playerPos.getX()-5);
    }
    private void mov_x_r(){
        playerPos.setX(playerPos.getX()+5);
    }
    private void mov_y_u(){
        playerPos.setY(playerPos.getY()-5);
    }
    private void mov_y_d(){
        playerPos.setY(playerPos.getY()+5);
    }

    public Gameplay(JFrame f){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer= new Timer(delay,this);
        timer.start();
        
        frame = f;
    }
    @Override
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
        g.fillRect(playerPos.getX(),playerPos.getY(),20,20);

        
        //Bomb
        g.setColor(Color.YELLOW);
        for(int i=0; i<bombs.size();++i){
                                System.out.println("czeka");
            g.fillRect(bombs.get(i).getPos().getX(),bombs.get(i).getPos().getY(),20,20);
        }
        
        //Wybuch
        g.setColor(Color.RED);
        for(int i=0; i<wybuchy.size();++i){
                g.fillRect(wybuchy.get(i).getPosX()-20*wybuchy.get(i).getSila(),wybuchy.get(i).getPosY(),(20*wybuchy.get(i).getSila())*2+20, 20);
                g.fillRect(wybuchy.get(i).getPosX(),wybuchy.get(i).getPosY()-20*wybuchy.get(i).getSila(), 20,(20*wybuchy.get(i).getSila())*2+20);

        }
        
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

        
        
        if(e.getKeyCode()== KeyEvent.VK_RIGHT){
            if(przyScianie(playerPos, 3)>0){
                playerPos.setX(555);
            }
            else mov_x_r();
        }
        if(e.getKeyCode()== KeyEvent.VK_LEFT){
            if(przyScianie(playerPos, 1)>0){
                playerPos.setX(20);
            }
            else mov_x_l();
        }
        if(e.getKeyCode()== KeyEvent.VK_UP){
            if(przyScianie(playerPos, 2)>0){
                playerPos.setY(20);
            }
            else mov_y_u();
        }
        if(e.getKeyCode()== KeyEvent.VK_DOWN){
            if(przyScianie(playerPos, 4)>0){
                playerPos.setY(535);
            }
            else mov_y_d();
        }
        if(e.getKeyCode()== KeyEvent.VK_SPACE){
            Bomb bomb = new Bomb(playerPos, 3, bombs, wybuchy);
            frame.add(bomb);
               
        }       
        System.out.println("pozycja "+"x:"+playerPos.getX()+"y: "+playerPos.getY());
    }
    
    private int przyScianie(Wspolrzedne pos, int kierunek){
            if(kierunek == 1 && pos.getX() -5 < 20){
                
                System.out.println("Sciana "+kierunek);
                return kierunek;
            } else if(kierunek == 3 && pos.getX() +5 >555){
                
                System.out.println("Sciana "+kierunek);
                return kierunek;
            } else if(kierunek == 2 && pos.getY() -5 <20){
                
                System.out.println("Sciana "+kierunek);
                return kierunek;
            } else if(kierunek ==4 && pos.getY() +5 > 535){
                
                System.out.println("Sciana "+kierunek);
                return kierunek;
            }else
                return 0;
        }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
   
}
