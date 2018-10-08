package mysokoban.fx.core;

import javax.swing.text.html.parser.Parser;
import java.io.*;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;


public class Level {

    public int[][] mapLevel;




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
                for(int j=0;j<19;j++){
                    if ((st = br.readLine()) != null) {
                        mapLevel[i][j] = parseInt(st);
                    }
                }
            }

        }catch(Exception e){
            System.out.println("erreur readLine");
            System.out.println(e);
        }

    }


    public int[][] getMapLevel() {
        return mapLevel;
    }




}
