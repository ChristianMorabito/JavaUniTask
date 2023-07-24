import java.util.ArrayList;

public class ChargeCount
{
    private int amount;
    private final int STARTING_CHARGE = 10;
    private final int MAX_CHARGE = 20;
    private State state;

    public ChargeCount(int startingCharge)
    {
        amount = startingCharge;
        state = new State();
    }

    public ChargeCount(State state)
    {
        this.amount = STARTING_CHARGE;
        this.state = state;
    }

    private void jumpDeplete(int building1, int building2)
    {
        amount -= (Math.abs(building1 - building2)) + 1;
        chargeCheck();
    }

    private void fuelCharge(Log log)
    {
        amount = Math.min(amount + 5, MAX_CHARGE);
        log.setFuelCount(log.getFuelCount() + 1);

    }


    public void passiveCheck(int currPosition, ArrayList<Boolean> dataFuelCells, Log log)
    {
        if (state.getPreviousPosition() == currPosition && dataFuelCells.get(currPosition))
        {
            fuelCharge(log);
        }

        if (state.isWebbed())
        {
            amount -= 5;
            chargeCheck();

        }
    }

    public void activeCheck(int currPosition, ArrayList<Boolean> dataFuelCells, Log log)
    {
        if (chargeCheck()) // if jumper fuel goes to < 1, the game exits before potential refuel
        {
            return;
        }
        if (dataFuelCells.get(currPosition))
        {
            fuelCharge(log);
        }

        if (state.getPreviousPosition() == currPosition)
        {
            amount -= 1;
            chargeCheck();
        }
        else
        {
            jumpDeplete(state.getBuilding2Height(), state.getBuilding1Height());
        }

    }

    public boolean chargeCheck()
    {
        if (amount < 1)
        {
            state.setGameRunning(false);
            return true;
        }
        return false;

    }
    public void print()
    {
        if (amount > 0)
        {
            String chargeBlock = "█ ".repeat(amount);
            System.out.print(chargeBlock);
        }
        System.out.println(amount + "\n");
    }

    public int getAmount()
    {
        return amount;
    }
}
