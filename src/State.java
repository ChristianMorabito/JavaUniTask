public class State
{
    private int previousPosition;
    private boolean outOfRange;
    private boolean skipTurn;
    private boolean gameRunning;

    private boolean firstMove;

    State()
    {
        previousPosition = 0;
        outOfRange = false;
        gameRunning = true;
        skipTurn = false;
        firstMove = true;
    }
    State(int previousPosition, boolean outOfRange, boolean gameRunning, boolean skipTurn, boolean firstMove)
    {
        this.previousPosition = previousPosition;
        this.outOfRange = outOfRange;
        this.gameRunning = gameRunning;
        this.skipTurn = skipTurn;
        this.firstMove = firstMove;
    }
    public int getPreviousPosition()
    {
        return previousPosition;
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

    public void setPreviousPosition(int previousPosition)
    {
        this.previousPosition = previousPosition;
    }

    public void setSkipTurn(boolean skipTurn)
    {
        this.skipTurn = skipTurn;
    }
    public void setFirstMove(boolean firstMove)
    {
        this.firstMove = firstMove;
    }
}
