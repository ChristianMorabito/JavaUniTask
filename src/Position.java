import java.util.ArrayList;

public class Position
{

    private Integer currentPosition;
    private State state;

    private final int END_INDEX = 14;
    private final int START_INDEX = 0;

    private int leftPosition;

    private int rightPosition;

    Position()
    {
        this.currentPosition = 0;
        this.leftPosition = 0;
        this.rightPosition = 0;
        this.state = new State();
    }

    Position(State state)
    {
        this.currentPosition = 0;
        this.leftPosition = 0;
        this.rightPosition = 0;
        this.state = state;
    }
    public void move(ArrayList<Integer> buildingHeights, int input)
    {
        int temp = currentPosition;

        if (input == 1)
        {
            temp += buildingHeights.get(currentPosition);
            if (temp < END_INDEX)
            {
                state.setPreviousPosition(currentPosition);
            }
            else if (temp == END_INDEX)
            {
                System.out.println("On last index!!"); // TODO: consider if character lands on FROZEN exit portal
            }
            else
            {
                outOfRange();
                return;
            }
        }
        else if (input == 2)
        {
            temp -= buildingHeights.get(currentPosition);
            if (temp >= START_INDEX)
            {
                state.setPreviousPosition(currentPosition);
            }
            else
            {
                outOfRange();
                return;
            }
        }
        else if (input == 3)
        {
            state.setSkipTurn(true);
        }
        else
        {
            System.out.println("Exiting...");
            state.setGameRunning(false);
        }

        currentPosition = temp;
        state.setOutOfRange(false);
    }

    private void outOfRange()
    {
        for (int i = 0; i < currentPosition; i++)
        {
            System.out.print("                 ");
        }
        System.out.println("Out of range!!");
        state.setOutOfRange(true);

    }

    public int getCurrPosition()
    {
        return currentPosition;
    }

    public int[] getPositions()
    {
        return new int[]{currentPosition, leftPosition, rightPosition};
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

    public void setCurrentPosition(int currentPosition)
    {
        this.currentPosition = currentPosition;
    }

    public void setLeftPosition(ArrayList<Integer> leftHeight)
    {
        int temp = currentPosition;
        temp -= leftHeight.get(currentPosition);
        temp = temp >= START_INDEX ? temp : -1;
        this.leftPosition = temp;
    }

    public void setRightPosition(ArrayList<Integer> buildingHeights)
    {
        int temp = currentPosition;
        temp += buildingHeights.get(currentPosition);
        temp = temp < END_INDEX ? temp : -1;
        this.rightPosition = temp;
    }

    public void setPositions(ArrayList<Integer> buildingHeights)
    {
        int temp = currentPosition;
        temp -= buildingHeights.get(currentPosition);
        temp = temp >= START_INDEX ? temp : -1;
        this.leftPosition = temp;

        temp = currentPosition;
        temp += buildingHeights.get(currentPosition);
        temp = temp < END_INDEX ? temp : -1;
        this.rightPosition = temp;
    }

    public void setState(State state)
    {
        this.state = state;
    }
}
