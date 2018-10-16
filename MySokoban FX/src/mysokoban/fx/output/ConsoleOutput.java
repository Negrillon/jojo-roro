package mysokoban.fx.output;

import mysokoban.fx.core.Coord_x_y;
import mysokoban.fx.core.Level;

import java.lang.reflect.AnnotatedArrayType;

public class ConsoleOutput {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void ConsoleMapDispay(Level level){

        int[][] cachemap = level.getMapLevel();

        for (int i = 0; i < level.goalCoord.size(); i++) {
            if(cachemap[level.goalCoord.get(i).getX()][level.goalCoord.get(i).getY()] == 0)
            cachemap[level.goalCoord.get(i).getX()][level.goalCoord.get(i).getY()] = 4;
        }
        for(int i = 0; i< 11;i++){
            for (int j = 0; j < 19; j++) {
                //System.out.print(level.getMapLevel()[i][j] + " ");
                if(cachemap[i][j] == 1)
                    System.out.print(ANSI_RED + "1 "+ ANSI_RESET);
                else if(cachemap[i][j] == 2)
                    System.out.print(ANSI_BLUE + "2 "+ ANSI_RESET);
                else if(cachemap[i][j] == 5)
                    System.out.print(ANSI_PURPLE + "5 "+ ANSI_RESET);
                else if(cachemap[i][j] == 4)
                    System.out.print(ANSI_GREEN + "4 "+ ANSI_RESET);
                else System.out.print(cachemap[i][j] + " ");
            }
            System.out.println();

        }



    }

    public static void ConsoleGoalCoordDisplay(Level lvl){
        System.out.println("Voila les coord des cases goals");
        for (int i = 0; i < lvl.goalCoord.size(); i++) {
            System.out.println(lvl.goalCoord.get(i));
        }
        System.out.println(lvl.goalCoord.size());
    }
}
