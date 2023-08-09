public class MainFlag
{
    private boolean exit;
    private boolean wonGame;
    private boolean gameRunning;

    public MainFlag()
    {
        exit = false;
        wonGame = false;
        gameRunning = true;
    }

    public MainFlag(boolean exit, boolean wonGame, boolean gameRunning)
    {
        this.exit = exit;
        this.wonGame = wonGame;
        this.gameRunning = gameRunning;
    }

    public void wonGameCheck(int currentPos, int charge)
    {
        if (Validation.onExit(currentPos) && charge >= Values.MIN_CHARGE - 1)
        {
            gameRunning = false;
            wonGame = true;
        }
    }

    public boolean isExit()
    {
        return exit;
    }

    public boolean isGameRunning()
    {
        return gameRunning;
    }

    public boolean isWonGame()
    {
        return wonGame;
    }

    public void setExit(boolean exit)
    {
        this.exit = exit;
    }

    public void setGameRunning(boolean gameRunning)
    {
        this.gameRunning = gameRunning;
    }

    public void setWonGame(boolean wonGame)
    {
        this.wonGame = wonGame;
    }

}
