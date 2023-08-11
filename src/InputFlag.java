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
     * Default constructor for class inputFlag
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
     * Non-default constructor for inputFlag
     * @param frozenExit accepts boolean
     * @param numbers accepts boolean for numbers
     * @param numbersLoop accepts boolean for numbersLoop
     * @param exitFrozeLoop accepts boolean for exitFrozeLoop
     * @param outOfRange accepts boolean for outOfRange
     * @param invalidInput accepts boolean for invalidInput
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
     * display method to print the state
     * of the class fields
     */
    public void display()
    {
        System.out.println("FrozenExit: " + frozenExit + "\n" +
                           "Numbers " + numbers + "\n" +
                           "NumbersLoop " + numbersLoop + "\n" +
                           "ExitFrozeLoop " + exitFrozeLoop + "\n" +
                           "OutOfRange " + outOfRange + "\n" +
                           "InvalidInput " + invalidInput);
    }

    /**
     * Method which updates boolean field 'frozenExit'
     * @param freeze accepts boolean arraylist
     */
    public void freezeOnExitCheck(ArrayList<Boolean> freeze)
    {
        frozenExit = freeze.get(Values.getEndIndex());
    }

    /**
     * Accessor method to get exitFrozeLoop boolean
     * @return returns exitFrozeLoop boolean
     */
    public boolean isExitFrozeLoop()
    {
        return exitFrozeLoop;
    }

    /**
     * Accessor method to get frozenExit boolean
     * @return returns frozenExit boolean
     */
    public boolean isFrozenExit()
    {
        return frozenExit;
    }

    /**
     * Accessor method to get invalidInput boolean
     * @return returns invalidInput boolean
     */
    public boolean isInvalidInput()
    {
        return invalidInput;
    }

    /**
     * Accessor method to get numbers boolean
     * @return returns numbers boolean
     */
    public boolean isNumbers()
    {
        return numbers;
    }

    /**
     * Accessor method to get numbersLoop boolean
     * @return returns numbersLoop boolean
     */
    public boolean isNumbersLoop()
    {
        return numbersLoop;
    }

    /**
     * Accessor method to get outOfRange loop
     * @return returns outOfRange loop
     */
    public boolean isOutOfRange()
    {
        return outOfRange;
    }

    /**
     * Mutator method to set exitFrozeLoop
     * @param exitFrozeLoop accepts boolean for exitFrozeLoop
     */
    public void setExitFrozeLoop(boolean exitFrozeLoop)
    {
        this.exitFrozeLoop = exitFrozeLoop;
    }

    /**
     * Mutator method to set frozenExit boolean
     * @param frozenExit accepts frozenExit boolean
     */
    public void setFrozenExit(boolean frozenExit)
    {
        this.frozenExit = frozenExit;
    }

    /**
     * Mutator method to set invalidInput boolean
     * @param invalidInput accepts invalidInput boolean
     */
    public void setInvalidInput(boolean invalidInput)
    {
        this.invalidInput = invalidInput;
    }

    /**
     * Mutator method to set numbers boolean
     * @param numbers accepts numbers boolean
     */
    public void setNumbers(boolean numbers)
    {
        this.numbers = numbers;
    }

    /**
     * Mutator method to set numbersLoop boolean
     * @param numbersLoop accepts numbersLoops boolean
     */
    public void setNumbersLoop(boolean numbersLoop)
    {
        this.numbersLoop = numbersLoop;
    }

    /**
     * Mutator method to set outOfRange boolean
     * @param outOfRange accepts outOfRange boolean
     */
    public void setOutOfRange(boolean outOfRange)
    {
        this.outOfRange = outOfRange;
    }
}
