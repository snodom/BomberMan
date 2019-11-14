import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.*;

public class Bomb extends JPanel  {
    private int czas = 2500;
    private int sila = 3; //Maksymalna siła uderzenia

    private Wspolrzedne pozycja;
    private Timer timer; 
    private Timer timer2;
    private LinkedList<Bomb> b;
    private LinkedList<Wybuch> w;
    Wybuch wyb;
     
    public Bomb(Wspolrzedne pos, int sil, LinkedList<Bomb> bombs, LinkedList<Wybuch> wybuchy){
        pozycja = new Wspolrzedne(pos);
        sila = sil;
        b = bombs;
        w = wybuchy;
        b.add(this);
        System.out.println("Bomba rzucona w       x: "+pozycja.getX()+"y: "+pozycja.getY());
        
        
        timer = new Timer();
        timer.schedule(new TimerBomby(this), czas);
        
    }

    class TimerBomby extends TimerTask {
        private Bomb bomba;
 
        public TimerBomby(Bomb bomb){
            bomba= bomb;
            
        }
        public void run() {
            System.out.println("Bomba wybucha!");
            timer.cancel(); //Terminate the timer thread
            b.removeFirst();

            wyb = new Wybuch (bomba.getPos().getX(), bomba.getPos().getY(), sila);

            timer2 = new Timer();
            timer2.schedule(new WybuchanieBomby(bomba), 500);
        }
        
    }
       
    class WybuchanieBomby extends TimerTask {
        public WybuchanieBomby(Bomb bomb){
            w.add(wyb);
        }
            
        public void run() {
            timer2.cancel(); //Terminate the timer thread
            w.removeFirst();
        }

    }
     public Wspolrzedne getPos() {
        return pozycja;
    }

    
}
