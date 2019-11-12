public class Colisions {
    int x;
    int y;
    boolean r,l,u,d;

   public void colison(int x, int y){

       // sprawdzanie kwadratkow
        for(int i=35; i<500;){
            for(int j=35;j<500;){
                if(((x==i+20 ||x==i+50) && (y>=j+20 && y<=j+50)) || ((x>=i+20 && x<=i+50) && (y==j+20 || y==j+50)) ) System.out.println("tam jest zakaz "+j);
                j+=40;
            }
            i+=40;
        }
    }
}
