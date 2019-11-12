class Colisions {

   boolean colison(int x, int y){

       // sprawdzanie kwadratkow

        for(int i=35; i<510;){
            for(int j=35;j<510;){          //((lewa , prawa)                  // (gora, dol)
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
int colizje(int bomb_posX, int bomb_posY){
     int x=0;
    if(bom_col_r(bomb_posX, bomb_posY)) x=x+2;
    if(bom_col_l(bomb_posX, bomb_posY)) x=x+20;
    if(bom_col_d(bomb_posX, bomb_posY)) x=x+200;
    if(bom_col_u(bomb_posX, bomb_posY)) x=x+2000;

    return x;
}
    boolean bom_col_r(int bomb_posX, int bomb_posY){ // z prawej  x +5

        for(int i=35; i<510;){
            for(int j=35;j<510;){          //((lewa , prawa)                  // (gora, dol)
                if(((bomb_posX==i+15) && (bomb_posY>=j+20 && bomb_posY<=j+50))) {
                    System.out.println("tam jest zakaz "+j);
                    return true;
                }
                j+=40;
            }
            i+=40;
        }
        return false;
    }
    boolean bom_col_l(int bomb_posX, int bomb_posY){            // z lewej x-5

        for(int i=35; i<510;){
            for(int j=35;j<510;){
                if(((bomb_posX==i+55) && (bomb_posY>=j+20 && bomb_posY<=j+50))) {
                    System.out.println("tam jest zakaz "+j);
                    return true;
                }
                j+=40;
            }
            i+=40;
        }
        return false;
    }
    boolean bom_col_d(int bomb_posX, int bomb_posY){            // od dolu  Y +5

        for(int i=35; i<510;){
            for(int j=35;j<510;){
                if(((bomb_posY==i+55) && (bomb_posX>=j+20 && bomb_posX<=j+50))) {
                    return true;
                }
                j+=40;
            }
            i+=40;
        }
        return false;
    }
    boolean bom_col_u(int bomb_posX, int bomb_posY){            // od dolu  Y -5

        for(int i=35; i<510;){
            for(int j=35;j<510;){
                if(((bomb_posY==i+15) && (bomb_posX>=j+20 && bomb_posX<=j+50))) {
                    return true;
                }
                j+=40;
            }
            i+=40;
        }
        return false;
    }
}
