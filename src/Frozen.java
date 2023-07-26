import java.util.ArrayList;

public class Frozen
{

    public Frozen()
    {
    }

    public void check(State state, ArrayList<Boolean> freeze, int currentPosition, Log log)
    {
        if (freeze.get(currentPosition)) {
            log.setFreezeCount(log.getFreezeCount() + 1);
            state.setFrozen(true);
        }
    }

    public void turningOff(State state, int currPosition)
    {
        state.setFrozen(false);
    }


}
