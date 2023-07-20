public class State
{
    private int previousPosition;

    private int building1Height;
    private int building2Height;
    private int fuelShuffleCount;
    private boolean outOfRange;
    private boolean skipTurn;
    private boolean gameRunning;
    private boolean firstMove;

    State()
    {
        building2Height = 0;
        building1Height = 0;
        previousPosition = 0;
        fuelShuffleCount = 0;
        outOfRange = false;
        gameRunning = true;
        skipTurn = false;
        firstMove = true;
    }
    State(int building1Height, int previousPosition, int building2Height, int fuelShuffleCount, boolean outOfRange, boolean gameRunning, boolean skipTurn, boolean firstMove)
    {
        this.building1Height = building1Height;
        this.previousPosition = previousPosition;
        this.building2Height = building2Height;
        this.fuelShuffleCount = fuelShuffleCount;
        this.outOfRange = outOfRange;
        this.gameRunning = gameRunning;
        this.skipTurn = skipTurn;
        this.firstMove = firstMove;
    }

    public boolean fuelShuffleCheck()
    {
        return fuelShuffleCount >= 0 && fuelShuffleCount % 3 == 0;
    }

    public int getFuelShuffleCount()
    {
        return fuelShuffleCount;
    }

    public int getPreviousPosition()
    {
        return previousPosition;
    }

    public int getBuilding1Height()
    {
        return building1Height;
    }

    public int getBuilding2Height()
    {
        return building2Height;
    }

    public boolean isGameRunning()
    {
        return gameRunning;
    }

    public boolean isOutOfRange()
    {
        return outOfRange;
    }

    public boolean isSkipTurn()
    {
        return skipTurn;
    }

    public boolean isFirstMove()
    {
        return firstMove;
    }
    public void setGameRunning(boolean gameRunning)
    {
        this.gameRunning = gameRunning;
    }

    public void setOutOfRange(boolean outOfRange)
    {
        this.outOfRange = outOfRange;
    }

    public void setSkipTurn(boolean skipTurn)
    {
        this.skipTurn = skipTurn;
    }
    public void setFirstMove(boolean firstMove)
    {
        this.firstMove = firstMove;
    }

    public void setFuelShuffleCount(int fuelShuffleCount)
    {
        this.fuelShuffleCount = fuelShuffleCount;
    }

    public void setPreviousPosition(int previousPosition)
    {
        this.previousPosition = previousPosition;
    }
    public void setBuilding2Height(int building2Height)
    {
        this.building2Height = building2Height;
    }
    public void setBuilding1Height(int building1Height)
    {
        this.building1Height = building1Height;
    }
}
