package mysokoban.fx.output;

import mysokoban.fx.core.Coord_x_y;
import mysokoban.fx.core.Level;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    int adjustWidth, adjustHeight;
    Level lvl;

    public Panel(int width, int height, Level lvl){
        this.adjustWidth = width;
        this.adjustHeight = height;
        this.lvl=lvl;
    }

    public void paintComponent(Graphics graphics) {
        graphics.setColor(new Color(255, 255, 255, 80));


        //int width = this.getWidth();
        //int height = this.getHeight();

        //graphics.fillRect(0, 0, width, height);

        //Remplacer par un switch
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 19; j++) {
                switch (lvl.mapLevel[i][j]){
                    case 0:  graphics.drawImage(new ImageIcon("/Users/joris/Document/Projet ING3/jojo-roro/MySokoban FX/src/ressource/Image/0.png").getImage(), j*20, i*20,  null);
                        break;
                    case 1:  graphics.drawImage(new ImageIcon("/Users/joris/Document/Projet ING3/jojo-roro/MySokoban FX/src/ressource/Image/1.png").getImage(), j*20, i*20, null);
                        break;
                    case 2:  graphics.drawImage(new ImageIcon("/Users/joris/Document/Projet ING3/jojo-roro/MySokoban FX/src/ressource/Image/2.png").getImage(), j*20, i*20, null);
                        break;
                    case 3:  graphics.drawImage(new ImageIcon("/Users/joris/Document/Projet ING3/jojo-roro/MySokoban FX/src/ressource/Image/3.png").getImage(), j*20, i*20, null);
                        break;
                    case 4:  graphics.drawImage(new ImageIcon("/Users/joris/Document/Projet ING3/jojo-roro/MySokoban FX/src/ressource/Image/4.png").getImage(), j*20, i*20,  null);
                        break;
                    case 5:  graphics.drawImage(new ImageIcon("/Users/joris/Document/Projet ING3/jojo-roro/MySokoban FX/src/ressource/Image/5haut.png").getImage(),j*20, i*20,  null);
                        break;
                }
            }
        }
    }
}


