
public class Co_Ordinates {
    private int x;
    private int y;
    
    public Co_Ordinates(int a, int b){
        x = a;
        y = b;
    }
    
    public Co_Ordinates(Co_Ordinates drugi){
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
