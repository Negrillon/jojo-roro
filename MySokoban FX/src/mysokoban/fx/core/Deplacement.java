package mysokoban.fx.core;

import com.sun.java.accessibility.util.TopLevelWindowMulticaster;
import javafx.scene.input.KeyCode;
import mysokoban.fx.MySokobanFX;
import mysokoban.fx.output.Frame;

//Class qui gere le deplacement
public class Deplacement {

    private Level lvl;

    public Deplacement(Level lvl){
        this.lvl = lvl;
    }

    int directionX;
    int directionY;

    public Level keypressed( KeyCode keyCode) {
        //pseudo case of en fctn de ka touche pressé
        if (keyCode == KeyCode.Z || keyCode == KeyCode.Q || keyCode == KeyCode.S || keyCode == KeyCode.D) {
            if (keyCode == KeyCode.Z) {
                directionX = -1;
                directionY = 0;
                move();
            }
            if (keyCode == KeyCode.Q) {
                directionX = 0;
                directionY = -1;
                move();
            }
            if (keyCode == KeyCode.S) {
                directionX = 1;
                directionY = 0;
                move();
            }
            if (keyCode == KeyCode.D) {
                directionX = 0;
                directionY = 1;
                move();
            }


        }
        return lvl;
    }

    //Procedure qui gerent le deplacement cas par cas --> amelioration possible en refactor avec un objet direction

    public void move(){

        if((lvl.getMapLevel()[lvl.playerCoord.getX()+directionX][lvl.playerCoord.getY()+directionY] != 1) && (lvl.getMapLevel()[lvl.playerCoord.getX()+directionX][lvl.playerCoord.getY()+directionY] != 2)){

            lvl.mapLevel[lvl.playerCoord.getX()+directionX][lvl.playerCoord.getY()+directionY] = 5;
            lvl.mapLevel[lvl.playerCoord.getX()][lvl.playerCoord.getY()] = 0;

            if(directionX == 0){
                lvl.playerCoord.setY(lvl.playerCoord.getY()+directionY);
            }else {lvl.playerCoord.setX(lvl.playerCoord.getX()+directionX);}

        }else if ((lvl.getMapLevel()[lvl.playerCoord.getX()+directionX][lvl.playerCoord.getY()+directionY] == 2) && ( (lvl.getMapLevel()[lvl.playerCoord.getX()+directionX+directionX][lvl.playerCoord.getY()+directionY+directionY] == 0) || (lvl.getMapLevel()[lvl.playerCoord.getX()+directionX+directionX][lvl.playerCoord.getY()+directionY+directionY] == 4))){
            moveBlock();
            if(directionX == 0){
                lvl.playerCoord.setY(lvl.playerCoord.getY()+directionY);
            }else {lvl.playerCoord.setX(lvl.playerCoord.getX()+directionX);}
        }
    }

    private void moveBlock(){

        lvl.mapLevel[lvl.playerCoord.getX()+directionX+directionX][lvl.playerCoord.getY()+directionY+directionY] = 2;
        lvl.mapLevel[lvl.playerCoord.getX()+directionX][lvl.playerCoord.getY()+directionY] = 5;
        lvl.mapLevel[lvl.playerCoord.getX()][lvl.playerCoord.getY()] = 0;
    }
}
