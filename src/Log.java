/**
 * Class which holds fields for logging player's
 * turn count, fuel count, web count & freeze count
 * @author Christian Morabito
 * @version ver1.0.0
 */
public class Log
{
    private int turnCount;
    private int fuelCount;
    private int webCount;
    private int freezeCount;

    /**
     * Default constructor for Log class
     */
    public Log()
    {
        turnCount = 0;
        fuelCount = 0;
        webCount = 0;
        freezeCount = 0;
    }

    /**
     * Non-default constructor for Log class
     * @param turnCount accepts int for turnCount
     * @param fuelCount accepts int for fuelCount
     * @param webCount accepts int for webCount
     * @param freezeCount accepts int for freezeCount
     */
    public Log(int turnCount, int fuelCount, int webCount, int freezeCount)
    {
        this.turnCount = turnCount;
        this.fuelCount = fuelCount;
        this.webCount = webCount;
        this.freezeCount = freezeCount;
    }

    /**
     * method which returns string of field states
     * @return returns string of field states
     */
    public String display()
    {
        return "Turn count: " + turnCount + "\n" +
                "Fuel collect count: " + fuelCount + "\n" +
                "Web count: " + webCount + "\n" +
                "Freeze count: " + freezeCount;
    }

    /**
     * Accessor method to get freeze count
     * @return returns int freeze count
     */
    public int getFreezeCount()
    {
        return freezeCount;
    }

    /**
     * Accessor method to get fuel count
     * @return returns int fuel count
     */
    public int getFuelCount()
    {
        return fuelCount;
    }

    /**
     * Accessor method to get turn count
     * @return returns int turn count
     */
    public int getTurnCount()
    {
        return turnCount;
    }

    /**
     * Accessor method to get web count
     * @return returns int web count
     */
    public int getWebCount()
    {
        return webCount;
    }

    /**
     * Mutator method to set freeze count
     * @param freezeCount accepts freeze count int
     */
    public void setFreezeCount(int freezeCount)
    {
        this.freezeCount = freezeCount;
    }

    /**
     * Mutator method to set fuel count
     * @param fuelCount accepts fuel count int
     */
    public void setFuelCount(int fuelCount)
    {
        this.fuelCount = fuelCount;
    }

    /**
     * Mutator method to set turn count
     * @param turnCount accepts turn count int
     */
    public void setTurnCount(int turnCount)
    {
        this.turnCount = turnCount;
    }

    /**
     * Mutator method to set web count
     * @param webCount accepts web count int
     */
    public void setWebCount(int webCount)
    {
        this.webCount = webCount;
    }
}
