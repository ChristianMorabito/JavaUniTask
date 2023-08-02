import java.util.ArrayList;

public class Web
{
    public static void check(State state, ArrayList<Boolean> web, int currentPosition, Log log)
    {
        if (web.get(currentPosition))
        {
            state.setWebbed(true);
            log.setWebCount(log.getWebCount() + 1);
        }
    }
    public static void turnOff(State state)
    {
        state.setWebbed(false);
    }

}
