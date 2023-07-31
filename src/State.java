public class State
{

    private boolean exit;
    private boolean frozen;
    private boolean gameRunning;
    private boolean numbers;
    private boolean numbersLoop;
    private boolean outOfRange;
    private boolean skipTurn;
    private boolean webbed;

    public State()
    {
        exit = false;
        frozen = false;
        gameRunning = true;
        numbers = false;
        numbersLoop = false;
        outOfRange = false;
        skipTurn = false;
        webbed = false;
    }

    public State(boolean outOfRange, boolean gameRunning, boolean skipTurn,
                 boolean exit, boolean numbers, boolean numbersLoop)
    {
        this.outOfRange = outOfRange;
        this.gameRunning = gameRunning;
        this.skipTurn = skipTurn;
        this.exit = exit;
        this.numbers = numbers;
        this.numbersLoop = numbersLoop;
    }

    public void exitCheck(int currentPosition)
    {
        if (currentPosition == Data.getPortalIndex() && !frozen)
        {
            gameRunning = false;
        }
    }

    public boolean isExit()
    {
        return exit;
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

    public boolean isNumbersLoop()
    {
        return numbersLoop;
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

    public void setNumbersLoop(boolean numbersLoop)
    {
        this.numbersLoop = numbersLoop;
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
