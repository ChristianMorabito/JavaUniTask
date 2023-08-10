/**
 * Class which
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
     *
     */
    public Log()
    {
        turnCount = 0;
        fuelCount = 0;
        webCount = 0;
        freezeCount = 0;
    }

    /**
     * @param turnCount
     * @param fuelCount
     * @param webCount
     * @param freezeCount
     */
    public Log(int turnCount, int fuelCount, int webCount, int freezeCount)
    {
        this.turnCount = turnCount;
        this.fuelCount = fuelCount;
        this.webCount = webCount;
        this.freezeCount = freezeCount;
    }

    /**
     * @return
     */
    public String display()
    {
        return "Turn count: " + turnCount + "\n" +
                "Fuel collect count: " + fuelCount + "\n" +
                "Web count: " + webCount + "\n" +
                "Freeze count: " + freezeCount;
    }

    /**
     * @return
     */
    public int getFreezeCount()
    {
        return freezeCount;
    }

    /**
     * @return
     */
    public int getFuelCount()
    {
        return fuelCount;
    }

    /**
     * @return
     */
    public int getTurnCount()
    {
        return turnCount;
    }

    /**
     * @return
     */
    public int getWebCount()
    {
        return webCount;
    }

    /**
     * @param freezeCount
     */
    public void setFreezeCount(int freezeCount)
    {
        this.freezeCount = freezeCount;
    }

    /**
     * @param fuelCount
     */
    public void setFuelCount(int fuelCount)
    {
        this.fuelCount = fuelCount;
    }

    /**
     * @param turnCount
     */
    public void setTurnCount(int turnCount)
    {
        this.turnCount = turnCount;
    }

    /**
     * @param webCount
     */
    public void setWebCount(int webCount)
    {
        this.webCount = webCount;
    }
}
