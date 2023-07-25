import java.util.ArrayList;

public class Position
{

    private Integer currentPosition;
    private State state;

    private int leftPosition;

    private int rightPosition;

    public Position()
    {
        this.currentPosition = 0;
        this.leftPosition = 0;
        this.rightPosition = 0;
        this.state = new State();
    }

    public Position(State state)
    {
        this.currentPosition = 0;
        this.leftPosition = 0;
        this.rightPosition = 0;
        this.state = state;
    }
    public void move(ArrayList<Integer> buildingHeights, int input, Log log, ArrayList<Boolean> freezeCheck, Frozen frozen)
    {
        if (state.isFrozen())
        {
            return;
        }
        int temp = currentPosition;

        switch (input)
        {
            case 1 ->
            {
                temp += buildingHeights.get(currentPosition);
                if (temp <= Data.END_INDEX)
                {
                    state.setPreviousPosition(currentPosition);
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
                if (temp >= Data.START_INDEX)
                {
                    state.setPreviousPosition(currentPosition);
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
                state.setPreviousPosition(currentPosition);
            }
            case 4 ->
            {
                System.out.println("Exiting...");
                state.setGameRunning(false);
            }
            default ->
            {
                System.out.println("Input error! Exiting...");
                System.exit(-1);
            }
        }

        currentPosition = temp;
        state.setOutOfRange(false);
        if (!state.isFrozen()) // if frozen, turn number is not incremented
        {
            log.setTurnCount(log.getTurnCount() + 1);
        }
    }

    public void printIfOutOfRange()
    {
        if (state.isOutOfRange())
        {
            System.out.println("\uD83D\uDEA8 BEYOND RANGE: Retry \uD83D\uDEA8");
        }

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
        temp = temp >= Data.START_INDEX ? temp : -1;
        this.leftPosition = temp;
    }

    public void setRightPosition(ArrayList<Integer> buildingHeights)
    {
        int temp = currentPosition;
        temp += buildingHeights.get(currentPosition);
        temp = temp <= Data.END_INDEX ? temp : -1;
        this.rightPosition = temp;
    }

    public void setPositions(ArrayList<Integer> buildingHeights)
    {
        int temp = currentPosition;
        temp -= buildingHeights.get(currentPosition);
        temp = temp >= Data.START_INDEX ? temp : -1;
        this.leftPosition = temp;

        temp = currentPosition;
        temp += buildingHeights.get(currentPosition);
        temp = temp <= Data.END_INDEX ? temp : -1;
        this.rightPosition = temp;
    }

    public void setState(State state)
    {
        this.state = state;
    }
}
