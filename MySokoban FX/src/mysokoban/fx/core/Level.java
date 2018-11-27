package mysokoban.fx.core;

import javax.swing.text.html.parser.Parser;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;

//
//La class Level contient la majorité des element du jeu : la map sous forme de tableau d'entier, les coordonnées des cases goal
//
public class Level {
    //Map
    public int[][] mapLevel;

    //Coordonné du player ( id 5 sur la map )
    public Coord_x_y playerCoord;


    //list des Coord Goal
    public List<Coord_x_y> goalCoord = new ArrayList<Coord_x_y>();





    public void loadLevel(String lvl_id){
        mapLevel = new int[11][19];
        //lecture d'un fichier
        File file = new File(lvl_id);

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("erreur file reader");
            e.printStackTrace();
        }

        String  st = "";

        try{



            for(int i=0;i<11;i++){

                    for (int j = 0; j < 19; j++) {

                        if ((st = br.readLine()) != null) {
                            mapLevel[i][j] = parseInt(st);
                        }
                    }

            }



            getGoalInitmap();

        }catch(Exception e){
            System.out.println("erreur readLine");
            System.out.println(e);
        }
        //getGoalInitmap();
    }


    public int[][] getMapLevel() {
        return mapLevel;
    }

    //Recuperer les cases goal au chargement de la map
    private void getGoalInitmap(){
        int k=0;
        for(int i = 0 ; i < 11; i++){
            for (int j = 0; j < 19; j++) {
                if(mapLevel[i][j] == 4){
                    goalCoord.add(k,new Coord_x_y(i,j));
                    k++;
                    //mapLevel[i][j] = 0;
                }
                if(mapLevel[i][j] == 5){
                    playerCoord = new Coord_x_y(i,j);
                }
            }
        }

    }




}


