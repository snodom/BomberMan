import java.awt.*;

public class Map_walls {

    int map[][];

    public void setMap(int col, int row, int value){
        map[col][row]=value;
    }

    public boolean getMap(int i, int j) {
        if(map[i][j]==0) return true;
        return false;
    }

    public void draw(Graphics2D g){
        // rozmiar 20x20
        /// na x ma malowac co 2
        for(int i=0;i<map.length;i++){
            for( int j=0;j<map[0].length;j++){
                if (map[i][j] > 0) {
                    g.setColor(Color.gray);
                    g.fillRect(i*20+90,j*20+90,20,20);
                }
            }
        }
    }

    public  Map_walls(int rows, int cols){
        map=new int[rows][cols];
        System.out.println("wielkosc" +map.length);
        for(int i=0;i<map.length;i++){
            for( int j=0;j<map[0].length;j++){
                map[i][j]=1;
            }
        }
    }

    public boolean check_cols_rows_40(int x){
        for(int i=0;i<11;i++) {
            if (x == (i * 40 + 90)) return true;
        }
        return false;

    }

    public boolean check_cols_rows_20(int x){
        for(int i=0;i<22;i++) {
            if (x == (i * 20 + 90)) return true;
        }
        return false;

    }

    public int return_col_rows(int x, int y){
        for(int i=0;i<23;i++) {
            for (int j = 0; j < 23; j++) {
                if((x == (i * 20 + 90)) && y==(j*40+90)) {
                    return i;
                }
                if((x == (2*i * 20 + 90)) && y==(j*20+90)){
                    return 2*i;
                }
            }
        }
        return 0;
    }
}

