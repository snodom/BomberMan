import java.util.LinkedList;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.*;

public class Bomb extends JPanel  {
    private int time = 2700;
    private int power = 3;

    private Co_Ordinates pozycja;
    private Timer timer; 
    private Timer timer2;
    private LinkedList<Bomb> b;
    private LinkedList<Explosion> ekspl;
    Explosion wyb;
     
    public Bomb(Co_Ordinates pos, int sil, LinkedList<Bomb> bombs, LinkedList<Explosion> explosions){
        pozycja = new Co_Ordinates(pos);
        power = sil;
        b = bombs;
        ekspl = explosions;
        b.add(this);
        
        
        timer = new Timer();
        timer.schedule(new TimerBomby(this), time);
        
    }

    class TimerBomby extends TimerTask {
        private Bomb bomba;
 
        public TimerBomby(Bomb bomb){
            bomba= bomb;
            
        }
        public void run() {
            timer.cancel(); //Terminate the timer thread
            b.removeFirst();

            wyb = new Explosion(bomba.getPos().getX(), bomba.getPos().getY(), power);

            timer2 = new Timer();
            timer2.schedule(new BombExplosion(bomba), 500);
        }
        
    }
       
    class BombExplosion extends TimerTask {
        public BombExplosion(Bomb bomb){
            ekspl.add(wyb);
        }
            
        public void run() {
            timer2.cancel(); //Terminate the timer thread
            ekspl.removeFirst();
        }

    }
     public Co_Ordinates getPos() {
        return pozycja;
    }

    
}
