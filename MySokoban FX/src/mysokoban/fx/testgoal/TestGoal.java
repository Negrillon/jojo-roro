package mysokoban.fx.testgoal;

import mysokoban.fx.core.Level;

//
//Cette fonction static permet de verifier si les case goal sont toutes complété
//
public class TestGoal {

    public static boolean test(Level level){
        int nbgoalvide = level.goalCoord.size();

        for (int i = 0; i < level.goalCoord.size() ; i++) {
            if(level.mapLevel[level.goalCoord.get(i).getX()][level.goalCoord.get(i).getY()] == 2){
                    nbgoalvide --;
                }
        }
        if (nbgoalvide == 0){
            //Toutes cases goal sont remplit
            return  true;
        }
        //Les cases ne sont pas toutes remplit
        return false;
    }


}

