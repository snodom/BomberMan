
public class Explosion {
    int posX;
    int posY;
    int power = 3; //Maksymalna siła uderzenia

    
    public Explosion(int x, int y, int s){
        posX = x;
        posY = y;
        power = s;
    }

    public int getPosX() {
        return posX;
    }


    public int getPosY() {
        return posY;
    }

}
