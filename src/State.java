import javax.swing.plaf.PanelUI;

public class State
{

    private boolean frozen;
    private boolean webbed;
    private boolean outOfRange;
    private boolean skipTurn;
    private boolean gameRunning;
    private boolean exit;

    public State()
    {

        outOfRange = false;
        gameRunning = true;
        skipTurn = false;
        frozen = false;
        webbed = false;
        exit = false;
    }
    public State(boolean outOfRange, boolean gameRunning, boolean skipTurn, boolean exit)
    {

        this.outOfRange = outOfRange;
        this.gameRunning = gameRunning;
        this.skipTurn = skipTurn;
        this.exit = exit;
    }



    public void exitCheck(int currentPosition)
    {
        if (currentPosition == Data.END_INDEX && !frozen)
        {
            gameRunning = false;
        }
    }



    public boolean isFrozen()
    {
        return frozen;
    }

    public boolean isGameRunning()
    {
        return gameRunning;
    }

    public boolean isOutOfRange()
    {
        return outOfRange;
    }

    public boolean isSkipTurn()
    {
        return skipTurn;
    }
    public boolean isExit()
    {
        return exit;
    }
    public boolean isWebbed()
    {
        return webbed;
    }
    public void setGameRunning(boolean gameRunning)
    {
        this.gameRunning = gameRunning;
    }

    public void setOutOfRange(boolean outOfRange)
    {
        this.outOfRange = outOfRange;
    }

    public void setSkipTurn(boolean skipTurn)
    {
        this.skipTurn = skipTurn;
    }

    public void setFrozen(boolean frozen)
    {
        this.frozen = frozen;
    }

    public void setWebbed(boolean webbed)
    {
        this.webbed = webbed;
    }

    public void setExit(boolean exit)
    {
        this.exit = exit;
    }
}
