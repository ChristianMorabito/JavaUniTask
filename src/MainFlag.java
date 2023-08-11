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
     * default constructor for MainFlag class
     */
    public MainFlag()
    {
        exit = false;
        wonGame = false;
        gameRunning = true;
        firstTurn = true;
    }

    /**
     * Non-default constructor for MainFlag class
     * @param exit accepts boolean for exit
     * @param wonGame accepts boolean for wonGame
     * @param gameRunning accepts boolean for gameRunning
     * @param firstTurn accepts boolean for firstTurn
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
        System.out.println("Exit: " + exit + "\n" +
                           "WonGame " + wonGame + "\n" +
                           "GameRunning " + gameRunning + "\n" +
                           "FirstTurn " + firstTurn);
    }

    /**
     * Accessor method which returns true/false
     * dependent if player has opted to exit game, lost
     * the game or won the game
     * @return returns boolean exit
     */
    public boolean isExit()
    {
        return exit;
    }

    /**
     * Accessor method which returns
     * true/false dependent if it's players first turn or not.
     * @return returns boolean
     */
    public boolean isFirstTurn()
    {
        return firstTurn;
    }

    /**
     * Accessor method which returns
     * true/false dependent if game is running
     * @return returns boolean
     */
    public boolean isGameRunning()
    {
        return gameRunning;
    }

    /**
     * Accessor method which returns
     * true/false dependent on whether player won game or not
     * @return returns boolean
     */
    public boolean isWonGame()
    {
        return wonGame;
    }

    /**
     * Mutator method that sets boolean
     * which determines if player exited game or not
     * @param exit accepts exit boolean
     */
    public void setExit(boolean exit)
    {
        this.exit = exit;
    }

    /**
     * Mutator method that sets boolean
     * which determines if it's player's first turn or not
     * @param firstTurn accepts firstTurn boolean
     */
    public void setFirstTurn(boolean firstTurn)
    {
        this.firstTurn = firstTurn;
    }

    /**
     * Mutator method that sets boolean
     * which determines if game is running or not
     * @param gameRunning accepts gameRunning boolean
     */
    public void setGameRunning(boolean gameRunning)
    {
        this.gameRunning = gameRunning;
    }

    /**
     * Mutator method that sets boolean which
     * determines if player won the game or not
     * @param wonGame accepts wonGame boolean
     */
    public void setWonGame(boolean wonGame)
    {
        this.wonGame = wonGame;
    }

    /**
     * method that updates boolean fields 'gameRunning' & 'wonGame' as true
     * if player has reached exit portal on charge >= 0
     * @param currentPos accepts int for player's current position
     * @param charge accepts int for current charge amount
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
