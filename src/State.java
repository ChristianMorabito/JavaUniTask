import java.util.ArrayList;

public class State
{

    private boolean exit;
    private boolean frozeExit;
    private boolean frozen;
    private boolean gameRunning;
    private boolean numbers;
    private boolean numLoop;
    private boolean exitFrozeLoop;
    private boolean outOfRange;
    private boolean skipTurn;
    private boolean webbed;

    public State()
    {
        exit = false;
        frozen = false;
        gameRunning = true;
        numbers = false;
        numLoop = false;
        outOfRange = false;
        skipTurn = false;
        webbed = false;
        frozeExit = false;
        exitFrozeLoop = false;
    }

    public State(boolean outOfRange, boolean gameRunning, boolean skipTurn,
                 boolean exit, boolean numbers, boolean numLoop, boolean frozeExit, boolean exitFrozeLoop)
    {
        this.outOfRange = outOfRange;
        this.gameRunning = gameRunning;
        this.skipTurn = skipTurn;
        this.exit = exit;
        this.numbers = numbers;
        this.numLoop = numLoop;
        this.frozeExit = frozeExit;
        this.exitFrozeLoop = exitFrozeLoop;
    }

    public void exitCheck(int currentPosition)
    {
        if (currentPosition == Values.getEndIndex() && !frozen)
        {
            gameRunning = false;
        }
    }

    public void freezeOnExitCheck(ArrayList<Boolean> freeze)
    {
        frozeExit = freeze.get(Values.getEndIndex());

    }

    public boolean isExit()
    {
        return exit;
    }

    public boolean isExitFrozeLoop()
    {
        return exitFrozeLoop;
    }

    public boolean isFrozeExit()
    {
        return frozeExit;
    }

    public boolean isFrozen()
    {
        return frozen;
    }

    public boolean isGameRunning()
    {
        return gameRunning;
    }

    public boolean isNumbers()
    {
        return numbers;
    }

    public boolean isNumLoop()
    {
        return numLoop;
    }

    public boolean isOutOfRange()
    {
        return outOfRange;
    }

    public boolean isSkipTurn()
    {
        return skipTurn;
    }

    public boolean isWebbed()
    {
        return webbed;
    }

    public void setExit(boolean exit)
    {
        this.exit = exit;
    }

    public void setExitFrozeLoop(boolean exitFrozeLoop)
    {
        this.exitFrozeLoop = exitFrozeLoop;
    }

    public void setFrozeExit(boolean frozeExit)
    {
        this.frozeExit = frozeExit;
    }

    public void setFrozen(boolean frozen)
    {
        this.frozen = frozen;
    }

    public void setGameRunning(boolean gameRunning)
    {
        this.gameRunning = gameRunning;
    }

    public void setNumbers(boolean numbers)
    {
        this.numbers = numbers;
    }

    public void setNumLoop(boolean numLoop)
    {
        this.numLoop = numLoop;
    }

    public void setOutOfRange(boolean outOfRange)
    {
        this.outOfRange = outOfRange;
    }

    public void setSkipTurn(boolean skipTurn)
    {
        this.skipTurn = skipTurn;
    }

    public void setWebbed(boolean webbed)
    {
        this.webbed = webbed;
    }

}
