import java.util.ArrayList;

/**
 * Class which stores, increments & decrements the jumper's fuel charge.
 * @author Christian Morabito
 * @version ver1.0.0
 */
public class Charge
{

    private int amount;
    private Count count;
    private State state;

    /**
     * Default constructor which creates the object of the class Charge.
     */
    public Charge()
    {
        amount = 0;
        count = new Count();
        state = new State();
    }

    /**
     * Non-Default constructor which creates the object of the class Charge.
     *
     * @param count    Accepts a Count object.
     * @param state    Accepts a State object.
     */

    public Charge(Count count, State state)
    {
        this.amount = Data.STARTING_CHARGE;
        this.count = count;
        this.state = state;
    }

    /**
     * Depletes fuel if user jumped/skipped turn, or increases fuel if user's move landed them on fuel.
     *
     * @param currentPosition    Accepts the user's current position as an int
     * @param fuelCells          Accepts the fuel cell array as an arraylist (Boolean)
     * @param log                Accepts the Log object
     */

    public void activeCheck(int currentPosition, ArrayList<Boolean> fuelCells, Log log)
    {
        if (!state.isGameRunning())
        {
            return;
        }
        if (count.getPreviousPosition() == currentPosition)
        {
            amount -= 1;
        }
        else
        {
            jumpDeplete(count.getHeight_2(), count.getHeight_1());
        }
        if (amount >= 0 && fuelCells.get(currentPosition))
        {
            fuelCharge(log);
        }
        chargeCheck();
    }

    /**
     * Checks if charge is above 1. If charge is not above 1, then 'gameRunning' (in State class)
     * is set to false.
     */
    private void chargeCheck()
    {
        if (amount < 1)
        {
            state.setGameRunning(false);
        }
    }

    /**
     * Accessor method to get amount descriptor
     * @return amount as int
     */
    public int getAmount()
    {
        return amount;
    }

    /**
     * Increases charge, ensuring that refueling doesn't go above MAX_CHARGE.
     *
     * @param log                Accepts the Log object
     */
    private void fuelCharge(Log log)
    {
        amount = Math.min(amount + 5, Data.MAX_CHARGE);
        log.setFuelCount(log.getFuelCount() + 1);
    }

    /**
     * Depletes fuel if webbed, or increases fuel if fuel respawns onto jumper.
     *
     * @param currentPosition    Accepts the user's current position as an int
     * @param fuelCells          Accepts the fuel cell array as an arraylist (Boolean)
     * @param log                Accepts the Log object
     */
    public void passiveCheck(int currentPosition, ArrayList<Boolean> fuelCells, Log log)
    {
        if (count.getPreviousPosition() == currentPosition && fuelCells.get(currentPosition))
        {
            fuelCharge(log);
        }

        if (state.isWebbed())
        {
            amount -= 5;
            chargeCheck();
        }
    }

    /**
     * jump depletion formula when user jumps from building1 to building2.
     *
     * @param building1    Accepts building1 height as int
     * @param building2    Accepts building2 height as int
     */
    private void jumpDeplete(int building1, int building2)
    {
        amount -= (Math.abs(building1 - building2)) + 1;
    }
}