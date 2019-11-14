import java.awt.*;

public class Map_walls {

    int map[][];
    int i, j;

    private void setMap(int col, int row) {
        map[col][row] = 0;
    }

    void draw(Graphics2D g) {
        // rozmiar 20x20
        /// na x ma malowac co 2
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    g.setColor(Color.gray);
                    g.fillOval(i * 20 + 90, j * 20 + 90, 20, 20);
                }
            }
        }
    }

    Map_walls(int rows, int cols) {
        map = new int[rows][cols];
        System.out.println("wielkosc" + map.length);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = 1;
            }
        }
    }

    private boolean check_cols_rows_40(int x) {
        for (int i = 0; i < 11; i++) {
            if (x == (i * 40 + 90)) return true;
        }
        return false;

    }

    private boolean check_cols_rows_20(int x) {
        for (int i = 0; i < 22; i++) {
            if (x == (i * 20 + 90)) return true;
        }
        return false;

    }

    boolean check_cols(int x) {
        for (int i = 0; i < 22; i++) {
            if (x == (i * 40 + 90)) return true;
        }
        return false;

    }

    int return_col_rows(int x, int y) {
        for (int i = 0; i < 23; i++) {
            for (int j = 0; j < 23; j++) {
                if ((x == (i * 20 + 90)) && y == (j * 40 + 90)) {
                    return i;
                }
                if ((x == (2 * i * 20 + 90)) && y == (j * 20 + 90)) {
                    return 2 * i;
                }
            }
        }
        return 0;
    }

    int return_col(int x) {
        for (int i = 0; i < 23; i++) {
            for (int j = 0; j < 23; j++) {
                if (x == (i * 20 + 90) ) {
                    return i;
                }
                if ((x < (i * 20 + 90)) && (x < (i * 40 + 90))) {
                    return i+1;
                }
            }
        }
        return 0;
    }

    boolean check_position(int x, int y) {

        return check_cols_rows_40(x) && check_cols_rows_20(y) || (check_cols_rows_20(x) && check_cols_rows_40(y));
    }

    void setBombColsRows(int i, int j) {
        setBombCol(i,j,2);
        setBombRow(i,j,2);
    }
    void setBombCol(int i, int j,int check_set_bomb) {             // i sie nie zmienia
        if (j >= 0) {
            if ((j - 4 >= 0) && check_set_bomb==1) setMap(i, j - 4);
            if (j - 3 >= 0) setMap(i, j - 3);
            if (j - 2 >= 0) setMap(i, j - 2);
            if (j - 1 >= 0) setMap(i, j - 1);
            if (j <= 20) {
                setMap(i, j);
                if ((j + 3 <=20) && check_set_bomb==2) setMap(i, j +3);
                if ((j + 2 <= 20) && check_set_bomb==2) setMap(i, j + 2);
                if (j + 1 <= 20) setMap(i, j + 1);
            }
        }
    }
    void setBombRow(int i, int j,int check_set_bomb) {
        if (i >= 0) {
            if ((i - 4 >= 0) && check_set_bomb==1) setMap(i-4, j);
            if (i - 3 >= 0) setMap(i-3, j);
            if (i - 2 >= 0) setMap(i-2, j);
            if (i - 1 >= 0) setMap(i-1, j);
            if (i <= 20) {
                setMap(i, j);
                if ((i + 3 <=20) && check_set_bomb==2) setMap(i+3, j);
                if ((i + 2 <= 20)&& check_set_bomb==2) setMap(i+2, j);
                if (i + 1 <= 20) setMap(i+1, j);
            }
        }
    }
}

