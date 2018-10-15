package mysokoban.fx.output;

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

    public void ConsoleMapDispay(Level level){
        for(int i = 0; i< 11;i++){
            for (int j = 0; j < 19; j++) {
                //System.out.print(level.getMapLevel()[i][j] + " ");
                if(level.getMapLevel()[i][j] == 1)
                    System.out.print(ANSI_RED + "1 "+ ANSI_RESET);
                else if(level.getMapLevel()[i][j] == 2)
                    System.out.print(ANSI_BLUE + "2 "+ ANSI_RESET);
                else if(level.getMapLevel()[i][j] == 5)
                    System.out.print(ANSI_PURPLE + "5 "+ ANSI_RESET);
                else System.out.print(level.getMapLevel()[i][j] + " ");
            }
            System.out.println();
// ajout de black list et distance
        }

        System.out.println("Voila les coord des cases goals");
        for (int i = 0; i < level.goalCoord.size(); i++) {
            System.out.println(level.goalCoord.get(i));
        }
        System.out.println(level.goalCoord.size());

    }
}
