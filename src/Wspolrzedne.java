
public class Wspolrzedne {
    private int x;
    private int y;
    
    public Wspolrzedne(int a, int b){
        x = a;
        y = b;
    }
    
    public Wspolrzedne(Wspolrzedne drugi){
        x = drugi.getX();
        y = drugi.getY();
    }
    
    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
