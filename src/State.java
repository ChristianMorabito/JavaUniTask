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
    private boolean invalidInput;
    private boolean wonGame;

    public State()
    {
        exit = false;
        gameRunning = true;
        numbers = false;
        numbersLoop = false;
        outOfRange = false;
        frozenExit = false;
        exitFrozeLoop = false;
        invalidInput = false;
        wonGame = false;
    }

    public State(boolean outOfRange, boolean gameRunning, boolean exit, boolean numbers,
                 boolean numbersLoop, boolean frozenExit,
                 boolean exitFrozeLoop, boolean invalidInput, boolean wonGame)
    {
        this.outOfRange = outOfRange;
        this.gameRunning = gameRunning;
        this.exit = exit;
        this.numbers = numbers;
        this.numbersLoop = numbersLoop;
        this.frozenExit = frozenExit;
        this.exitFrozeLoop = exitFrozeLoop;
        this.invalidInput = invalidInput;
        this.wonGame = wonGame;
    }

    public void wonGameCheck(int currentPos, int charge)
    {
        if (Validation.onExit(currentPos) && charge >= Values.MIN_CHARGE - 1)
        {
            gameRunning = false;
            wonGame = true;
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

    public boolean isInvalidInput()
    {
        return invalidInput;
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

    public boolean isWonGame()
    {
        return wonGame;
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

    public void setInvalidInput(boolean invalidInput)
    {
        this.invalidInput = invalidInput;
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

    public void setWonGame(boolean wonGame)
    {
        this.wonGame = wonGame;
    }
}
