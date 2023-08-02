import java.util.ArrayList;

public class Position
{

    private int currentPosition;
    private Count count;
    private State state;
    private int leftPosition;
    private int rightPosition;

    public Position()
    {
        currentPosition = 0;
        leftPosition = 0;
        rightPosition = 0;
        count = new Count();
        state = new State();
    }

    public Position(Count count, State state)
    {
        this.currentPosition = 0;
        this.leftPosition = 0;
        this.rightPosition = 0;
        this.count = count;
        this.state = state;
    }
    public int getCurrentPosition()
    {
        return currentPosition;
    }

    public int getLeftPosition()
    {

        return leftPosition;
    }

    public int getRightPosition()
    {
        return rightPosition;
    }

    public State getState()
    {
        return state;
    }

    public void move(ArrayList<Integer> buildingHeights, int input)
    {
        int temp = currentPosition;
        switch (input)
        {
            case 1 ->
            {
                temp += buildingHeights.get(currentPosition);
                if (temp <= Data.getEndIndex()) {
                    count.setPreviousPosition(currentPosition);
                }
                else
                {
                    state.setOutOfRange(true);
                    return;
                }
            }
            case 2 ->
            {
                temp -= buildingHeights.get(currentPosition);
                if (temp >= Data.START_INDEX) {
                    count.setPreviousPosition(currentPosition);
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
                count.setPreviousPosition(currentPosition);
            }
            default ->
            {
                Print.invalidInput();
                System.exit(-1);
            }
        }
        currentPosition = temp;
        state.setOutOfRange(false);
    }



    public void set(ArrayList<Integer> buildingHeights)
    {
        int temp = currentPosition;
        temp -= buildingHeights.get(currentPosition);
        temp = temp >= Data.START_INDEX ? temp : -1;
        this.leftPosition = temp;

        temp = currentPosition;
        temp += buildingHeights.get(currentPosition);
        temp = temp <= Data.getEndIndex() ? temp : -1;
        this.rightPosition = temp;
    }

    public void setCurrentPosition(int currentPosition)
    {
        this.currentPosition = currentPosition;
    }

    public void setLeftPosition(ArrayList<Integer> leftHeight)
    {
        int temp = currentPosition;
        temp -= leftHeight.get(currentPosition);
        temp = temp >= Data.START_INDEX ? temp : -1;
        this.leftPosition = temp;
    }

    public void setRightPosition(ArrayList<Integer> buildingHeights)
    {
        int temp = currentPosition;
        temp += buildingHeights.get(currentPosition);
        temp = temp <= Data.getEndIndex() ? temp : -1;
        this.rightPosition = temp;
    }

    public void setState(State state)
    {
        this.state = state;
    }
}
