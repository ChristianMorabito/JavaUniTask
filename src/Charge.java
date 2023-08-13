import java.util.ArrayList;

/**
 * Class which stores, increments & decrements the jumper's fuel charge,
 * as well as holds the x2 building height values to calculate jump cost
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
     * @param amount               Accepts an int for beginning charge amount.
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
     * Method for directly after player input, which:
     * (1) always depletes charge (based on either jump or skip-turn) & increases charge
     * (if player jumped onto an already present fuel cell).
     * (2) checks has depleted to below 1, which prompts exit game, & (3) logs if fuel is collected
     * @param player accepts Player object to get player current & prev positions (to determine if player
     *               jumped or skipped turn)
     * @param array accepts Array object for tempFuel array & fuelShuffleCount.
     * @param mainFlag accepts MainFlag object to potentially flag game exit.
     * @param currentPos accepts int which represents current index player is on
     * @param log accepts Log object to potentially log fuel collection
     */
    public void afterChargeCheck(Player player, Array array, MainFlag mainFlag, int currentPos, Log log)
    {
        ArrayList<Boolean> fuelCells = array.getTempFuel();

        if (!mainFlag.isGameRunning()) return;

        if (player.getPreviousPos() == currentPos)
        {
            amount--;
        }
        else
        {
            jumpDeplete(height2, height1);
        }
        if (afterCharge(mainFlag)) return;

        if (!array.fuelShuffleCheck() && fuelCells.get(currentPos))
        {
            fuelCharge();
            log.setFuelCount(log.getFuelCount() + 1);
        }
        beforeTurnCheck(mainFlag);
    }


    /**
     * checks if charge is below < 0; if so, then mainFlag boolean is set to false,
     * ending main game loop
     * @param mainFlag accepts mainFlag object
     */
    private boolean afterCharge(MainFlag mainFlag)
    {
        if (amount < Values.MIN_CHARGE - 1)
        {
            mainFlag.setGameRunning(false);
            return true;
        }
        return false;
    }

    /**
     * checks if charge is below < 1; if so, then mainFlag boolean is set to false,
     * ending main game loop
     * @param mainFlag accepts mainFlag object
     */
    private void beforeTurnCheck(MainFlag mainFlag)
    {
        if (amount < Values.MIN_CHARGE) mainFlag.setGameRunning(false);

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
     * Accessor method to get 'amount' int.
     * @return returns 'amount' int
     */
    public int getAmount()
    {
        return amount;
    }


    /**
     * Accessor method to get int 'height1'
     * @return returns int 'height1'
     */
    public int getHeight1()
    {
        return height1;
    }


    /**
     * Accessor method to get int 'height2'
     * @return returns int 'height2'
     */
    public int getHeight2()
    {
        return height2;
    }

    /**
     * method to increment charge & ensure that the charge does not go above max amount.
     */
    private void fuelCharge()
    {
        amount = Math.min(amount + Values.CHARGE_INCREMENT, Values.MAX_CHARGE);
    }

    /**
     * Method for directly after arrays are shuffled, but before player turn, which:
     * (1) increments player charge if player coincidentally is standing on new spawned fuel.
     * (2a) decrements charge if player coincidentally is standing on a web that shuffled into player position.
     * (2b) checks if charge is < 1, to flag potential game exit.
     * @param array accepts Array object
     * @param isWebbed accepts boolean which determines if player is standing on a web or not.
     * @param mainFlag accepts Mainflag object to potentially flag game exit.
     * @param currentPos accepts int which represents player's current position
     * @param log accepts log object for logging if player collected fuel
     */
    public void beforeTurnCheck(Array array, boolean isWebbed, MainFlag mainFlag, int currentPos, Log log)
    {
        if (Validation.fuelShuffleModulo(array.getFuelMove()) == 1 && array.getTempFuel().get(currentPos))
        {
            fuelCharge();
            log.setFuelCount(log.getFuelCount() + 1);
        }

        if (isWebbed)
        {
            amount -= 5;
            beforeTurnCheck(mainFlag);
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
