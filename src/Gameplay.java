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
    private Co_Ordinates playerPos = new Co_Ordinates(20,20);
    private JFrame frame;
    private LinkedList<Bomb> bombs = new LinkedList<Bomb>();
    private LinkedList<Explosion> wybuchy = new LinkedList<Explosion>();
    private Colisions colision = new Colisions();
    private Map_walls map;


    private void mov_x_l(){
        if(colision.colison(playerPos.getX()-5,playerPos.getY()))
            if(!colision.wall_colision(map,playerPos.getX()-20,playerPos.getY())){
                playerPos.setX(playerPos.getX()-5);
            }
    }
    private void mov_x_r(){
        if(colision.colison(playerPos.getX()+5,playerPos.getY())){
            if(!colision.wall_colision(map,playerPos.getX()+20,playerPos.getY())) {
                playerPos.setX(playerPos.getX()+5);
            }
        }

    }
    private void mov_y_u(){
        if(colision.colison(playerPos.getX(),playerPos.getY()-5)){
            if(!colision.wall_colision(map,playerPos.getX(),playerPos.getY()-20)){
                playerPos.setY(playerPos.getY()-5);
            }
        }
    }
    private void mov_y_d(){
        if(colision.colison(playerPos.getX(),playerPos.getY()+5))
            if(!colision.wall_colision(map,playerPos.getX(),playerPos.getY()+20)){
                playerPos.setY(playerPos.getY()+5);
            }
    }

    public Gameplay(JFrame f){
        map= new Map_walls(21,21);
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
        map.draw((Graphics2D)g);

        //borders
        g.setColor(Color.darkGray);
        g.fillRect(0,0,20,590);
        g.fillRect(0,0,600,20);
        g.fillRect(575,0,20,600);
        g.fillRect(0,575,600,20);

  // cubes
        for(int i=30; i<500;){
            i+=40;
            for(int j=30;j<500;){
                j+=40;
                g.fillRect(i,j,20,20);
            }
        }

        //player

        g.setColor(Color.CYAN);
        g.fillOval(playerPos.getX(),playerPos.getY(),20,20);

        
        //Bomb
        g.setColor(Color.YELLOW);
        for(int i=0; i<bombs.size();++i){

            g.fillRect(bombs.get(i).getPos().getX(),bombs.get(i).getPos().getY(),20,20);
        }
        
        //Wybuch
        g.setColor(Color.RED);
        for(int i=0; i<wybuchy.size();++i){

            // rysuj w prawo g.fillRect(wybuchy.get(i).getPosX(),wybuchy.get(i).getPosY(),80, 20);
            // rysuj w lewo //  g.fillRect(wybuchy.get(i).getPosX()-60,wybuchy.get(i).getPosY(), 80, 20);
            // rysuj w dol g.fillRect(wybuchy.get(i).getPosX(),wybuchy.get(i).getPosY(), 20, 80);
            // rysuj w gore g.fillRect(wybuchy.get(i).getPosX(),wybuchy.get(i).getPosY()-60, 20, 80);

            if(colision.colizje(wybuchy.get(i).getPosX(),wybuchy.get(i).getPosY())==0){
                g.fillRect(wybuchy.get(i).getPosX(),wybuchy.get(i).getPosY()-60, 20, 80);
                g.fillRect(wybuchy.get(i).getPosX(),wybuchy.get(i).getPosY(), 20, 80);
                g.fillRect(wybuchy.get(i).getPosX()-60,wybuchy.get(i).getPosY(), 80, 20);
                g.fillRect(wybuchy.get(i).getPosX(),wybuchy.get(i).getPosY(),80, 20);

                if(map.check_position(wybuchy.get(i).getPosX(),wybuchy.get(i).getPosY())){

                    map.i=map.return_col_rows(wybuchy.get(i).getPosX(),wybuchy.get(i).getPosY());
                    map.j=map.return_col_rows(wybuchy.get(i).getPosY(),wybuchy.get(i).getPosX());

                    map.setBombColsRows(map.i,map.j);
                }

                System.out.println("wybuch x"+wybuchy.get(i).getPosX());
                System.out.println("wybuch y"+wybuchy.get(i).getPosY());
            }
            else if(colision.colizje(wybuchy.get(i).getPosX(),wybuchy.get(i).getPosY())==22){
                g.fillRect(wybuchy.get(i).getPosX(),wybuchy.get(i).getPosY()-60, 20, 80);
                g.fillRect(wybuchy.get(i).getPosX(),wybuchy.get(i).getPosY(), 20, 80);


               if(map.check_cols(wybuchy.get(i).getPosX())){
                   map.i=map.return_col(wybuchy.get(i).getPosX());
                   map.j=map.return_col(wybuchy.get(i).getPosY());

                   map.setBombCol(map.i,map.j,1);
                   System.out.println("wybuch x"+map.i);
                   System.out.println("wybuch y"+map.j);
               }

            }
            else if(colision.colizje(wybuchy.get(i).getPosX(),wybuchy.get(i).getPosY())==2200){
                g.fillRect(wybuchy.get(i).getPosX()-60,wybuchy.get(i).getPosY(), 80, 20);
                g.fillRect(wybuchy.get(i).getPosX(),wybuchy.get(i).getPosY(),80, 20);

                if(map.check_cols(wybuchy.get(i).getPosY())){

                    map.j=map.return_col(wybuchy.get(i).getPosY());
                    map.i=map.return_col(wybuchy.get(i).getPosX());
                    map.setBombRow(map.i,map.j,1);
                }
            }
            else{
                g.setColor(Color.red);
                g.fillRect(wybuchy.get(i).getPosX(),wybuchy.get(i).getPosY(),20,20);
            }
        }
        g.dispose();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        for(int i=0; i<wybuchy.size();++i){
            repaint();
        if(EndGame.crossExplosion(playerPos.getX(),playerPos.getY(),wybuchy.get(i).getPosX(),wybuchy.get(i).getPosY(),colision)){
                JOptionPane.showMessageDialog(null,"Koniec gry - przegrales :)");
        }
        }
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
            if((przyScianie(playerPos, 2)>0)){
                playerPos.setY(20);
            }
            else mov_y_u();
        }
        if(e.getKeyCode()== KeyEvent.VK_DOWN){
            if(przyScianie(playerPos, 4)>0){
                playerPos.setY(555);
            }
            else mov_y_d();
        }
        if(e.getKeyCode()== KeyEvent.VK_SPACE){
           if(playerPos.getX()>=70 && playerPos.getY()>=70) {
               Bomb bomb = new Bomb(playerPos, 3, bombs, wybuchy);
               frame.add(bomb);
           }
        }       
        System.out.println("pozycja "+"x:"+playerPos.getX()+"y: "+playerPos.getY());
        System.out.println("lukasz 30 ");
    }
    
    private int przyScianie(Co_Ordinates pos, int kierunek){
            if(kierunek == 1 && pos.getX() -5 < 20){
                
                System.out.println("Sciana "+kierunek);
                return kierunek;
            } else if(kierunek == 3 && pos.getX() +5 >555){
                
                System.out.println("Sciana "+kierunek);
                return kierunek;
            } else if(kierunek == 2 && pos.getY() -5 <20){
                
                System.out.println("Sciana "+kierunek);
                return kierunek;
            } else if(kierunek ==4 && pos.getY() +5 > 555){
                
                System.out.println("Sciana "+kierunek);
                return kierunek;
            }else
                return 0;
        }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
   
}
