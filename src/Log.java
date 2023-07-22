/*
The game should write the number of turns played,
the number of fuel cells found,
and the win status of the game.
 */


public class Log {
    private int turnCount;
    private int fuelCount;

    Log()
    {
        turnCount = 0;
        fuelCount = 0;
    }

    public int getFuelCount() {
        return fuelCount;
    }

    public String display()
    {
        return "Turn count: " + turnCount + "\nFuel count: " + fuelCount;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public void setFuelCount(int fuelCount) {
        this.fuelCount = fuelCount;
    }

    public void setTurnCount(int turnCount) {
        this.turnCount = turnCount;
    }
}
