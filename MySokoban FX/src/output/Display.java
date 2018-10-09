package output;

import java.lang.reflect.Array;

public class Display {

    public void Console(int[][] mapLevel) {
        int[][] mapLevel;
        mapLevel = Level.mapLevel;

        for (int i = 0; i < 12 ; i++) {
            for (int j = 0; j < 20 ; j++) {
                switch (mapLevel){
                    case 1 :
                        break;
                    case 2 :
                        break;
                    case 3 :
                        break;
                    case 4 :
                        break;
                    case 5 :
                        break;
                }
            }
        }

    }

    public void Graphics(int[] mapLevel) {
        mapLevel = Level.mapLevel;
    }
}
