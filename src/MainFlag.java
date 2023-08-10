/**
 * Class which
 * @author Christian Morabito
 * @version ver1.0.0
 */
public class MainFlag
{
    private boolean exit;
    private boolean wonGame;
    private boolean gameRunning;

    /**
     *
     */
    public MainFlag()
    {
        exit = false;
        wonGame = false;
        gameRunning = true;
    }

    /**
     * @param exit
     * @param wonGame
     * @param gameRunning
     */
    public MainFlag(boolean exit, boolean wonGame, boolean gameRunning)
    {
        this.exit = exit;
        this.wonGame = wonGame;
        this.gameRunning = gameRunning;
    }

    /**
     * display method to print the state
     * of the class fields
     */
    public void display()
    {
        System.out.println();
    }

    /**
     * @param currentPos
     * @param charge
     */
    public void wonGameCheck(int currentPos, int charge)
    {
        if (Validation.onExit(currentPos) && charge >= Values.MIN_CHARGE - 1)
        {
            gameRunning = false;
            wonGame = true;
        }
    }

    /**
     * @return
     */
    public boolean isExit()
    {
        return exit;
    }

    /**
     * @return
     */
    public boolean isGameRunning()
    {
        return gameRunning;
    }

    /**
     * @return
     */
    public boolean isWonGame()
    {
        return wonGame;
    }

    /**
     * @param exit
     */
    public void setExit(boolean exit)
    {
        this.exit = exit;
    }

    /**
     * @param gameRunning
     */
    public void setGameRunning(boolean gameRunning)
    {
        this.gameRunning = gameRunning;
    }

    /**
     * @param wonGame
     */
    public void setWonGame(boolean wonGame)
    {
        this.wonGame = wonGame;
    }

}
