public class Colisions {
    int x;
    int y;
    boolean r,l,u,d;

   public boolean colison(int x, int y){

       // sprawdzanie kwadratkow
        for(int i=35; i<550;){
            for(int j=35;j<550;){
                if(((x==i+20 ||x==i+50) && (y>=j+20 && y<=j+50)) || ((x>=i+20 && x<=i+50) && (y==j+20 || y==j+50)) ) {
                    System.out.println("tam jest zakaz "+j);
                    return false;
                }
                j+=40;
            }
            i+=40;
        }
        return true;
    }
}
