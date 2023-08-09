import java.util.ArrayList;

public class InputFlag
{
    private boolean frozenExit;
    private boolean numbers;
    private boolean numbersLoop;
    private boolean exitFrozeLoop;
    private boolean outOfRange;
    private boolean invalidInput;

    public InputFlag()
    {
        frozenExit = false;
        numbers = false;
        numbersLoop = false;
        exitFrozeLoop = false;
        outOfRange = false;
        invalidInput = false;
    }

    public InputFlag(boolean frozenExit, boolean numbers, boolean numbersLoop,
                     boolean exitFrozeLoop, boolean outOfRange, boolean invalidInput)
    {
        this.frozenExit = frozenExit;
        this.numbers = numbers;
        this.numbersLoop = numbersLoop;
        this.exitFrozeLoop = exitFrozeLoop;
        this.outOfRange = outOfRange;
        this.invalidInput = invalidInput;
    }

    public void freezeOnExitCheck(ArrayList<Boolean> freeze)
    {
        frozenExit = freeze.get(Values.getEndIndex());
    }

    public boolean isExitFrozeLoop()
    {
        return exitFrozeLoop;
    }

    public boolean isFrozenExit()
    {
        return frozenExit;
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
    public void setExitFrozeLoop(boolean exitFrozeLoop)
    {
        this.exitFrozeLoop = exitFrozeLoop;
    }

    public void setFrozenExit(boolean frozenExit)
    {
        this.frozenExit = frozenExit;
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
}
