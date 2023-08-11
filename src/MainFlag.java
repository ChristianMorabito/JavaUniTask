/**
 * Class which holds flags for the main game loop
 * @author Christian Morabito
 * @version ver1.0.0
 */
public class MainFlag
{
    private boolean exit;
    private boolean wonGame;
    private boolean gameRunning;
    private boolean firstTurn;

    /**
     *
     */
    public MainFlag()
    {
        exit = false;
        wonGame = false;
        gameRunning = true;
        firstTurn = true;
    }

    /**
     * @param exit
     * @param wonGame
     * @param gameRunning
     */
    public MainFlag(boolean exit, boolean wonGame, boolean gameRunning, boolean firstTurn)
    {
        this.exit = exit;
        this.wonGame = wonGame;
        this.gameRunning = gameRunning;
        this.firstTurn = firstTurn;
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
     * @return
     */
    public boolean isExit()
    {
        return exit;
    }

    /**
     * @return
     */
    public boolean isFirstTurn()
    {
        return firstTurn;
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
     *
     * @param firstTurn
     */
    public void setFirstTurn(boolean firstTurn)
    {
        this.firstTurn = firstTurn;
    }

    /**
     * @param wonGame
     */
    public void setWonGame(boolean wonGame)
    {
        this.wonGame = wonGame;
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

}
