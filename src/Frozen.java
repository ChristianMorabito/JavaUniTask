import java.util.ArrayList;

public class Frozen
{
    public static void check(State state, ArrayList<Boolean> freeze, int currentPosition, Log log)
    {
        if (freeze.get(currentPosition)) {
            log.setFreezeCount(log.getFreezeCount() + 1);
            state.setFrozen(true);
        }
    }

    public static void turningOff(State state)
    {
        state.setFrozen(false);
    }

}
