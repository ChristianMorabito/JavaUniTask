import java.util.ArrayList;

public class Player
{

    private int currentPos;
    private int leftPos;
    private int rightPos;

    public Player()
    {
        currentPos = 0;
        leftPos = 0;
        rightPos = 0;
    }

    public Player(int currentPos, int leftPos, int rightPos)
    {
        this.currentPos = currentPos;
        this.leftPos = leftPos;
        this.rightPos = rightPos;
    }
    public int getCurrentPos()
    {
        return currentPos;
    }

    public int getLeftPos()
    {

        return leftPos;
    }

    public int getRightPos()
    {
        return rightPos;
    }

    public void move(State state, Count count, ArrayList<Boolean> freeze, ArrayList<Integer> buildingHeights, int input)
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
                        state.setExitFrozeLoop(true);
                        return;
                    }
                    count.setPrevPosition(currentPos);
                }
                else
                {
                    state.setOutOfRange(true);
                    return;
                }
            }
            case 2 ->
            {
                temp -= buildingHeights.get(currentPos);
                if (temp >= Values.START_INDEX)
                {
                    count.setPrevPosition(currentPos);
                }
                else
                {
                    state.setOutOfRange(true);
                    return;
                }
            }
            case 3 ->
            {
                state.setSkipTurn(true);
                count.setPrevPosition(currentPos);
            }
            default ->
            {
                Print.invalidInput();
                System.exit(-1);
            }
        }
        currentPos = temp;
        state.setOutOfRange(false);
        state.setExitFrozeLoop(false);
    }



    public void set(ArrayList<Integer> buildingHeights)
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

    public void setCurrentPos(int currentPos)
    {
        this.currentPos = currentPos;
    }

    public void setLeftPos(ArrayList<Integer> leftHeight)
    {
        int temp = currentPos;
        temp -= leftHeight.get(currentPos);
        temp = temp >= Values.START_INDEX ? temp : -1;
        this.leftPos = temp;
    }

    public void setRightPos(ArrayList<Integer> buildingHeights)
    {
        int temp = currentPos;
        temp += buildingHeights.get(currentPos);
        temp = temp <= Values.getEndIndex() ? temp : -1;
        this.rightPos = temp;
    }
}

