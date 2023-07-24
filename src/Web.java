import java.util.ArrayList;

public class Web
{

    public Web()
    {

    }

    public void checking(State state, ArrayList<Boolean> web, int currentPosition, Log log)
    {
        if (web.get(currentPosition))
        {
            state.setWebbed(true);
            log.setWebCount(log.getWebCount() + 1);
        }
    }

    public void print(State state) {

        if (state.isWebbed()) {
            System.out.println("\uD83D\uDEA8 YOU ARE WEBBED!! \uD83D\uDEA8");
        }
    }

    public void turningOff(State state) {
        state.setWebbed(false);
    }

}
