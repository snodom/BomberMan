
public class Wybuch {
    int posX;
    int posY;
    int sila = 3; //Maksymalna siła uderzenia

    
    public Wybuch(int x, int y, int s){
        posX = x;
        posY = y;
        sila = s;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }


    public int getSila() {
        return sila;
    }

    public void setSila(int sila) {
        this.sila = sila;
    }
    
    
}
