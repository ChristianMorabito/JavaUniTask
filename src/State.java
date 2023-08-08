import java.util.ArrayList;

public class State
{

    private boolean exit;
    private boolean frozenExit;
    private boolean gameRunning;
    private boolean numbers;
    private boolean numbersLoop;
    private boolean exitFrozeLoop;
    private boolean outOfRange;
    private boolean skipTurn;
    private boolean invalidIntInput;

    public State()
    {
        exit = false;
        gameRunning = true;
        numbers = false;
        numbersLoop = false;
        outOfRange = false;
        skipTurn = false;
        frozenExit = false;
        exitFrozeLoop = false;
        invalidIntInput = false;
    }

    public State(boolean outOfRange, boolean gameRunning, boolean skipTurn,
                 boolean exit, boolean numbers, boolean numbersLoop, boolean frozenExit,
                 boolean exitFrozeLoop, boolean invalidIntInput)
    {
        this.outOfRange = outOfRange;
        this.gameRunning = gameRunning;
        this.skipTurn = skipTurn;
        this.exit = exit;
        this.numbers = numbers;
        this.numbersLoop = numbersLoop;
        this.frozenExit = frozenExit;
        this.exitFrozeLoop = exitFrozeLoop;
        this.invalidIntInput = invalidIntInput;
    }

    public void exitCheck(int currentPosition, boolean isFrozen)
    {
        if (currentPosition == Values.getEndIndex() && !isFrozen)
        {
            gameRunning = false;
        }
    }

    public void freezeOnExitCheck(ArrayList<Boolean> freeze)
    {
        frozenExit = freeze.get(Values.getEndIndex());

    }

    public boolean isExit()
    {
        return exit;
    }

    public boolean isExitFrozeLoop()
    {
        return exitFrozeLoop;
    }

    public boolean isFrozenExit()
    {
        return frozenExit;
    }

    public boolean isGameRunning()
    {
        return gameRunning;
    }

    public boolean isInvalidIntInput()
    {
        return invalidIntInput;
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

    public void setExit(boolean exit)
    {
        this.exit = exit;
    }

    public void setExitFrozeLoop(boolean exitFrozeLoop)
    {
        this.exitFrozeLoop = exitFrozeLoop;
    }

    public void setFrozenExit(boolean frozenExit)
    {
        this.frozenExit = frozenExit;
    }

    public void setGameRunning(boolean gameRunning)
    {
        this.gameRunning = gameRunning;
    }

    public void setInvalidIntInput(boolean invalidIntInput)
    {
        this.invalidIntInput = invalidIntInput;
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

}
