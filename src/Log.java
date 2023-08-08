public class Log
{
    private int turnCount;
    private int fuelCount;
    private int webCount;
    private int freezeCount;

    public Log()
    {
        turnCount = 0;
        fuelCount = 0;
        webCount = 0;
        freezeCount = 0;
    }

    public Log(int turnCount, int fuelCount, int webCount, int freezeCount)
    {
        this.turnCount = turnCount;
        this.fuelCount = fuelCount;
        this.webCount = webCount;
        this.freezeCount = freezeCount;
    }

    public String display()
    {
        return "Turn count: " + turnCount + "\n" +
                "Fuel collect count: " + fuelCount + "\n" +
                "Web count: " + webCount + "\n" +
                "Freeze count: " + freezeCount;
    }

    public int getFreezeCount()
    {
        return freezeCount;
    }

    public int getFuelCount()
    {
        return fuelCount;
    }

    public int getTurnCount()
    {
        return turnCount;
    }

    public int getWebCount()
    {
        return webCount;
    }

    public void setFreezeCount(int freezeCount)
    {
        this.freezeCount = freezeCount;
    }

    public void setFuelCount(int fuelCount)
    {
        this.fuelCount = fuelCount;
    }

    public void setTurnCount(int turnCount)
    {
        this.turnCount = turnCount;
    }

    public void setWebCount(int webCount)
    {
        this.webCount = webCount;
    }
}
