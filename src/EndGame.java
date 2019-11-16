public class EndGame {


    static boolean verticalExplosion(int playerPosX,int playerPosY, int bombPosX,int bombPosY,Colisions colision){
        if(((playerPosX>bombPosX-19) && (playerPosX<bombPosX+19)) && ((playerPosY>bombPosY-59) && (playerPosY<bombPosY+59))&& colision.colizje(bombPosX,bombPosY)!=2200) return true;
        return false;
    }
    static boolean horizontalExplosion(int playerPosX,int playerPosY, int bombPosX,int bombPosY,Colisions colision){
        if(((playerPosY>bombPosY-19) && (playerPosY<bombPosY+19)) && ((playerPosX>bombPosX-59) && (playerPosX<bombPosX+59)) && colision.colizje(bombPosX,bombPosY)!=22) return true;
        return false;
    }

    static boolean crossExplosion(int playerPosX,int playerPosY, int bombPosX,int bombPosY,Colisions colision){
        if(verticalExplosion(playerPosX,playerPosY,bombPosX,bombPosY,colision)) return true;
        if(horizontalExplosion(playerPosX,playerPosY,bombPosX,bombPosY,colision)) return true;
        return false;
    }
}
