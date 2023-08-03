import java.util.ArrayList;

/**
 * Utility class for switching on/off 'frozen' boolean
 * (State class), & to increment 'freezeCount' (Log class)  
 * @author Christian Morabito
 * @version ver1.0.0
 */

public class Frozen
{
    /**
     * Utility method to set field 'frozen' (from State class) to true,
     * If set to true, then freezeCount (from Log class) is incremented.
     * @param state              State class object
     * @param freeze             arraylist (boolean) object
     * @param currentPosition    current position of jumper integer
     * @param log                Log class object
     **/
    public static void check(State state, ArrayList<Boolean> freeze, int currentPosition, Log log)
    {
        if (freeze.get(currentPosition)) {
            log.setFreezeCount(log.getFreezeCount() + 1);
            state.setFrozen(true);
        }
    }

    /**
     * Utility method to set field 'frozen' (from State class) to false,
     * @param state              State class object
     **/
    public static void turningOff(State state)
    {
        state.setFrozen(false);
    }

}