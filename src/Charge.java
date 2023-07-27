import java.util.ArrayList;

public class Charge
{
    private int amount;

    private Count count;
    private State state;

    public Charge(int startingCharge)
    {
        amount = startingCharge;
        count = new Count();
        state = new State();
    }

    public Charge(Count count, State state)
    {
        this.amount = Data.STARTING_CHARGE;
        this.count = count;
        this.state = state;
    }

    private void jumpDeplete(int building1, int building2)
    {
        amount -= (Math.abs(building1 - building2)) + 1;
    }

    private void fuelCharge(Log log)
    {
        amount = Math.min(amount + 5, Data.MAX_CHARGE);
        log.setFuelCount(log.getFuelCount() + 1);

    }


    public void passiveCheck(int currPosition, ArrayList<Boolean> dataFuelCells, Log log)
    {
        if (count.getPreviousPosition() == currPosition && dataFuelCells.get(currPosition))
        {
            fuelCharge(log);
        }

        if (state.isWebbed())
        {
            amount -= 5;
            chargeCheck();

        }
    }

    public void activeCheck(int currPosition, ArrayList<Boolean> fuelCells, Log log)
    {
        if (!state.isGameRunning())
        {
            return;
        }
        if (count.getPreviousPosition() == currPosition)
        {
            amount -= 1;
        }
        else
        {
           jumpDeplete(count.getHeight_2(), count.getHeight_1());
        }
        if (amount >= 0 && fuelCells.get(currPosition))
        {
            fuelCharge(log);
        }
        chargeCheck();
    }

    private void chargeCheck()
    {
        if (amount < 1)
        {
            state.setGameRunning(false);
        }

    }


    public int getAmount()
    {
        return amount;
    }
}
