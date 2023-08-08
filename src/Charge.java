import java.util.ArrayList;

/**
 * Class which stores, increments & decrements the jumper's fuel charge.
 * @author Christian Morabito
 * @version ver1.0.0
 */
public class Charge
{

    private int amount;
    private int height1;
    private int height2;

    /**
     * Default constructor which creates the object of the class Charge.
     */
    public Charge()
    {
        amount = Values.STARTING_CHARGE;
        height2 = 0;
        height1 = 0;
    }

    /**
     * Non-Default constructor which creates the object of the class Charge.
     * @param amount                Accepts an int for beginning charge amount.
     * @param height1              Accepts an int for first building height
     * @param height2              Accepts an int for previous building height
     */

    public Charge(int amount, int height1, int height2)
    {
        this.amount = amount;
        this.height1 = height1;
        this.height2 = height2;
    }

    /**
     * Depletes fuel if user jumped/skipped turn, or increases fuel if user's move landed them on fuel.
     *
     * @param currentPos    Accepts the user's current position as an int
     * @param fuelCells          Accepts the fuel cell array as an arraylist (Boolean)
     * @param log                Accepts the Log object
     */

    public void activeCheck(Player player, Data data, State state, int currentPos, ArrayList<Boolean> fuelCells, Log log)
    {
        if (!state.isGameRunning())
        {
            return;
        }
        if (player.getPreviousPos() == currentPos)
        {
            amount -= 1;
        }
        else
        {
            jumpDeplete(height2, height1);
        }
        if (amount >= 0 && !data.fuelShuffleCheck() && fuelCells.get(currentPos))
        {
            fuelCharge(log);
        }
        chargeCheck(state);
    }

    /**
     * Checks if charge is above 1. If charge is not above 1, then 'gameRunning' (in State class)
     * is set to false.
     */
    private void chargeCheck(State state)
    {
        if (amount < Values.MIN_CHARGE)
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
     * Accessor method for height_1
     * @return returns height_1: int
     */
    public int getHeight1()
    {
        return height1;
    }

    /**
     * Accessor method for height_2
     * @return returns height_2: int
     */
    public int getHeight2()
    {
        return height2;
    }

    /**
     * Increases charge, ensuring that refueling doesn't go above MAX_CHARGE.
     *
     * @param log                Accepts the Log object
     */
    private void fuelCharge(Log log)
    {
        amount = Math.min(amount + 5, Values.MAX_CHARGE);
        log.setFuelCount(log.getFuelCount() + 1);
    }

    public void passiveCheck(Data data, boolean isWebbed, State state, int currentPos, Log log)
    {
        if (Validation.fuelShuffleModulo(data.getFuelMove()) == 1 && data.getFuel().get(currentPos))
        {
            fuelCharge(log);
        }

        if (isWebbed)
        {
            amount -= 5;
            chargeCheck(state);
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

    /**
     * Mutator method for height_1
     * @param height1 used to update height_1: int
     */
    public void setHeight1(int height1)
    {
        this.height1 = height1;
    }

    /**
     * Mutator method for height_2
     * @param height2 used to update height_2: int
     */
    public void setHeight2(int height2)
    {
        this.height2 = height2;
    }
}
