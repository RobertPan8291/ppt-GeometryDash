package geometrydash;

import java.util.*;

public class GeometryDash {
    /**
     * Returns whether the given level can be completed using the given play.
     * @param level is not null and not empty
     * @param play is not null and not empty
     * @return true if the play completes the level and false otherwise
     */
    public static boolean isSuccessfulPlay(String level, String play) {
        int playerIndex = 0;
        boolean state = true;

        char[] arrlevel = level.toCharArray();
        char[] charplay = play.toCharArray();
        int[] arrplay = new int[play.length()];
        List<Integer> dangerList = new ArrayList<>();

        for(int i = 0; i< play.length(); i++){
            arrplay[i] = Integer.parseInt(String.valueOf(charplay[i]));
        }

        for(int i = 0; i<arrlevel.length; i++){
            if(arrlevel[i] == '^'){
                dangerList.add(i);
            }
        }

        for(int i = 0; i < arrplay.length; i++){
            playerIndex += arrplay[i];

            if(dangerList.contains(playerIndex)){
                state = false;
            }
        }

        return state;
    }

    /**
     * Returns the subset of plays which can complete the given level ending
     * with the target resting energy
     * @param level is not null and not empty
     * @param possiblePlays is not null
     * @param startingEnergy the energy at the start of the level
     * @param targetRestingEnergy the minimum energy to end the level at
     * @return a subset of {@code possiblePlays} which complete the level with
     * {@code targetRestingEnergy} units of energy remaining
     */
    public static Set<String> successfulPlays(String level, Set<String> possiblePlays,
                                              int startingEnergy, int targetRestingEnergy) {
        Set<String> success = new HashSet<>();


        char[] arrlevel = level.toCharArray();
        List<Integer> dangerList = new ArrayList<>();
        List<Integer> specialList = new ArrayList<>();

        for(int i = 0; i<arrlevel.length; i++){
            if(arrlevel[i] == '^'){
                dangerList.add(i);
            }

            if(arrlevel[i] == '*'){
                specialList.add(i);
            }
        }

        for(String play: possiblePlays){
            int playerIndex = 0;
            boolean state = true;
            int playerenergy = startingEnergy;
            int[] arrplay = new int[play.length()];

            char[] charplay = play.toCharArray();

            for(int i = 0; i< play.length(); i++){
                arrplay[i] = Integer.parseInt(String.valueOf(charplay[i]));
            }

            for(int i = 0; i < arrplay.length; i++){
                playerIndex += arrplay[i];

                if(arrplay[i] != 0){
                    playerenergy -= arrplay[i];
                }
                else if(arrplay[i] == 0 && playerenergy < 3){
                    playerenergy++;
                }

                if(specialList.contains(playerIndex)){
                    playerIndex += 4;
                }


                if(dangerList.contains(playerIndex)){
                    state = false;
                }
            }

            if(playerenergy < targetRestingEnergy){
                state = false;
            }

            if(playerIndex + 1 > arrlevel.length){
                state = false;
            }

            if(state == true){
                success.add(play);
            }

        }
        return success;
    }

    /**
     * Returns the shortest play that completes the given level
     * @param level is not null and not empty
     * @param startingEnergy the energy at the start of the level
     * @param targetRestingEnergy the minimum energy to end the level at
     * @return the shortest play that allows a player to complete the given level
     * @throws UnplayableLevelException if no play can complete the level
     */
    public static String shortestPlay(String level, int startingEnergy, int targetRestingEnergy)
            throws UnplayableLevelException {
        // TODO: Implement this method
        return null;
    }

    /**
     * Returns the total number of plays which allow a player to complete the given level
     * @param level is not null and not empty
     * @param startingEnergy the energy at the start of the level
     * @param targetRestingEnergy the minimum energy to end the level at
     * @return the total number of plays which allow a player to complete the given level
     * with target resting energy {@code targetRestingEnergy}
     */
    public static int numberOfPlays(String level, int startingEnergy, int targetRestingEnergy) {
        return -1;
    }

    public static int recursivenum(int remain, int[]possibleplay,List curr, int start, List list){
        if(remain == 0){

        }

        if(remain < 0){

        }

        for(int i = start; i < possibleplay.length; i++){
            curr.add(possibleplay[i]);
            recursivenum(remain - possibleplay[i],possibleplay,curr,start,list);
            curr.remove(curr.size() - 1);
        }
    }
}
