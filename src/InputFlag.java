import java.util.ArrayList;

/**
 * Class which
 * @author Christian Morabito
 * @version ver1.0.0
 */
public class InputFlag
{
    private boolean frozenExit;
    private boolean numbers;
    private boolean numbersLoop;
    private boolean exitFrozeLoop;
    private boolean outOfRange;
    private boolean invalidInput;

    /**
     *
     */
    public InputFlag()
    {
        frozenExit = false;
        numbers = false;
        numbersLoop = false;
        exitFrozeLoop = false;
        outOfRange = false;
        invalidInput = false;
    }

    /**
     * @param frozenExit
     * @param numbers
     * @param numbersLoop
     * @param exitFrozeLoop
     * @param outOfRange
     * @param invalidInput
     */
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

    /**
     * @param freeze
     */
    public void freezeOnExitCheck(ArrayList<Boolean> freeze)
    {
        frozenExit = freeze.get(Values.getEndIndex());
    }

    /**
     * @return
     */
    public boolean isExitFrozeLoop()
    {
        return exitFrozeLoop;
    }

    /**
     * @return
     */
    public boolean isFrozenExit()
    {
        return frozenExit;
    }

    /**
     * @return
     */
    public boolean isInvalidInput()
    {
        return invalidInput;
    }

    /**
     * @return
     */
    public boolean isNumbers()
    {
        return numbers;
    }

    /**
     * @return
     */
    public boolean isNumbersLoop()
    {
        return numbersLoop;
    }

    /**
     * @return
     */
    public boolean isOutOfRange()
    {
        return outOfRange;
    }

    /**
     * @param exitFrozeLoop
     */
    public void setExitFrozeLoop(boolean exitFrozeLoop)
    {
        this.exitFrozeLoop = exitFrozeLoop;
    }

    /**
     * @param frozenExit
     */
    public void setFrozenExit(boolean frozenExit)
    {
        this.frozenExit = frozenExit;
    }

    /**
     * @param invalidInput
     */
    public void setInvalidInput(boolean invalidInput)
    {
        this.invalidInput = invalidInput;
    }

    /**
     * @param numbers
     */
    public void setNumbers(boolean numbers)
    {
        this.numbers = numbers;
    }

    /**
     * @param numbersLoop
     */
    public void setNumbersLoop(boolean numbersLoop)
    {
        this.numbersLoop = numbersLoop;
    }

    /**
     * @param outOfRange
     */
    public void setOutOfRange(boolean outOfRange)
    {
        this.outOfRange = outOfRange;
    }
}
