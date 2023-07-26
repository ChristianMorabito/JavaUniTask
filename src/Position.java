import java.util.ArrayList;

public class Position
{

    private Integer currentSpot;
    private Count count;

    private State state;

    private int leftPosition;

    private int rightPosition;

    public Position()
    {
        this.currentSpot = 0;
        this.leftPosition = 0;
        this.rightPosition = 0;
        this.count = new Count();
        this.state = new State();
    }

    public Position(Count count, State state)
    {
        this.currentSpot = 0;
        this.leftPosition = 0;
        this.rightPosition = 0;
        this.count = count;
        this.state = state;
    }
    public void move(ArrayList<Integer> buildingHeights, int input, Log log, ArrayList<Boolean> freezeCheck, Frozen frozen)
    {
        if (state.isFrozen())
        {
            return;
        }
        int temp = currentSpot;

        switch (input)
        {
            case 1 ->
            {
                temp += buildingHeights.get(currentSpot);
                if (temp <= Data.END_INDEX)
                {
                    count.setPreviousPosition(currentSpot);
                }

                else
                {
                    state.setOutOfRange(true);
                    return;
                }
            }
            case 2 ->
            {
                temp -= buildingHeights.get(currentSpot);
                if (temp >= Data.START_INDEX)
                {
                    count.setPreviousPosition(currentSpot);
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
                count.setPreviousPosition(currentSpot);
            }
            case 4 ->
            {
                System.out.println("Exiting...");
                state.setGameRunning(false);
                state.setExit(true);
            }
            default ->
            {
                System.out.println("Input error! Exiting...");
                System.exit(-1);
            }
        }

        currentSpot = temp;
        state.setOutOfRange(false);
        if (!state.isFrozen()) // if frozen, turn number is not incremented
        {
            log.setTurnCount(log.getTurnCount() + 1);
        }
    }

    public int getCurrentSpot()
    {
        return currentSpot;
    }

    public int[] getPositions()
    {
        return new int[]{currentSpot, leftPosition, rightPosition};
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

    public void setCurrentSpot(int currentSpot)
    {
        this.currentSpot = currentSpot;
    }

    public void setLeftPosition(ArrayList<Integer> leftHeight)
    {
        int temp = currentSpot;
        temp -= leftHeight.get(currentSpot);
        temp = temp >= Data.START_INDEX ? temp : -1;
        this.leftPosition = temp;
    }

    public void setRightPosition(ArrayList<Integer> buildingHeights)
    {
        int temp = currentSpot;
        temp += buildingHeights.get(currentSpot);
        temp = temp <= Data.END_INDEX ? temp : -1;
        this.rightPosition = temp;
    }

    public void set(ArrayList<Integer> buildingHeights)
    {
        int temp = currentSpot;
        temp -= buildingHeights.get(currentSpot);
        temp = temp >= Data.START_INDEX ? temp : -1;
        this.leftPosition = temp;

        temp = currentSpot;
        temp += buildingHeights.get(currentSpot);
        temp = temp <= Data.END_INDEX ? temp : -1;
        this.rightPosition = temp;
    }

    public void setState(State state)
    {
        this.state = state;
    }
}
