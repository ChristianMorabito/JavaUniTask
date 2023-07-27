public class State
{

    private boolean frozen;
    private boolean webbed;
    private boolean outOfRange;
    private boolean skipTurn;
    private boolean gameRunning;
    private boolean exit;
    private boolean numbers;
    private boolean numbersLoop;

    public State()
    {
        outOfRange = false;
        gameRunning = true;
        skipTurn = false;
        frozen = false;
        webbed = false;
        exit = false;
        numbers = false;
        numbersLoop = false;

    }
    public State(boolean outOfRange, boolean gameRunning, boolean skipTurn, boolean exit, boolean numbers, boolean numbersLoop)
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

    public boolean isNumbers()
    {
        return numbers;
    }

    public boolean isNumbersLoop()
    {
        return numbersLoop;
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

    public void setNumbers(boolean numbers)
    {
        this.numbers = numbers;
    }
    public void setNumbersLoop(boolean numbersLoop)
    {
        this.numbersLoop = numbersLoop;
    }
}
