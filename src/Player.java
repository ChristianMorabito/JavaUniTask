import java.util.ArrayList;

/**
 * Class which
 * @author Christian Morabito
 * @version ver1.0.0
 */
public class Player
{

    private int currentPos;
    private int leftPos;
    private int rightPos;
    private int prevPosition;

    /**
     *
     */
    public Player()
    {
        currentPos = 0;
        leftPos = 0;
        rightPos = 0;
        prevPosition = 0;
    }

    /**
     * @param currentPos
     * @param leftPos
     * @param rightPos
     * @param prevPosition
     */
    public Player(int currentPos, int leftPos, int rightPos, int prevPosition)
    {
        this.currentPos = currentPos;
        this.leftPos = leftPos;
        this.rightPos = rightPos;
        this.prevPosition = prevPosition;
    }

    /**
     * @return
     */
    public int getCurrentPos()
    {
        return currentPos;
    }

    /**
     * @return
     */
    public int getLeftPos()
    {

        return leftPos;
    }

    /**
     * @return
     */
    public int getRightPos()
    {
        return rightPos;
    }

    /**
     * Accessor method for previousPosition
     * @return returns previousPosition: int
     */
    public int getPreviousPos()
    {
        return prevPosition;
    }

    /**
     * @param inputFlag
     * @param freeze
     * @param buildingHeights
     * @param input
     */
    public void move(InputFlag inputFlag, ArrayList<Boolean> freeze, ArrayList<Integer> buildingHeights, int input)
    {
        int temp = currentPos;
        switch (input)
        {
            case 1 ->
            {
                temp += buildingHeights.get(currentPos);
                if (temp <= Values.getEndIndex())
                {
                    if (temp == Values.getEndIndex() && freeze.get(Values.getEndIndex()))
                    {
                        inputFlag.setExitFrozeLoop(true);
                        return;
                    }
                    prevPosition = currentPos;
                }
                else
                {
                    inputFlag.setOutOfRange(true);
                    return;
                }
            }
            case 2 ->
            {
                temp -= buildingHeights.get(currentPos);
                if (temp >= Values.START_INDEX)
                {
                    prevPosition = currentPos;
                }
                else
                {
                    inputFlag.setOutOfRange(true);
                    return;
                }
            }
            case 3 ->
            {
                prevPosition = currentPos;
            }
            default ->
            {
                Print.invalidInput(inputFlag);
                System.exit(-1);
            }
        }
        currentPos = temp;
        inputFlag.setOutOfRange(false);
        inputFlag.setExitFrozeLoop(false);
    }


    /**
     * @param buildingHeights
     */
    public void setPotentialPositions(ArrayList<Integer> buildingHeights)
    {
        int temp = currentPos;
        temp -= buildingHeights.get(currentPos);
        temp = temp >= Values.START_INDEX ? temp : -1;
        this.leftPos = temp;

        temp = currentPos;
        temp += buildingHeights.get(currentPos);
        temp = temp <= Values.getEndIndex() ? temp : -1;
        this.rightPos = temp;
    }

    /**
     * @param currentPos
     */
    public void setCurrentPos(int currentPos)
    {
        this.currentPos = currentPos;
    }

    /**
     * @param leftHeight
     */
    public void setLeftPos(ArrayList<Integer> leftHeight)
    {
        int temp = currentPos;
        temp -= leftHeight.get(currentPos);
        temp = temp >= Values.START_INDEX ? temp : -1;
        this.leftPos = temp;
    }

    /**
     * Mutator method for previousPosition
     * @param prevPosition used to update the previousPosition: int
     */
    public void setPrevPosition(int prevPosition)
    {
        this.prevPosition = prevPosition;
    }

    /**
     * @param buildingHeights
     */
    public void setRightPos(ArrayList<Integer> buildingHeights)
    {
        int temp = currentPos;
        temp += buildingHeights.get(currentPos);
        temp = temp <= Values.getEndIndex() ? temp : -1;
        this.rightPos = temp;
    }
}

