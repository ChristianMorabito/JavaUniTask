import java.util.ArrayList;

public class ChargeCount
{
    private int chargeAmount;
    private final int STARTING_CHARGE = 10;
    private final int MAX_CHARGE = 20;
    private State state;

    ChargeCount(int startingCharge)
    {
        chargeAmount = startingCharge;
        state = new State();
    }

    ChargeCount(State state)
    {
        this.chargeAmount = STARTING_CHARGE;
        this.state = state;
    }

    private void jumpDeplete(int building1, int building2)
    {
        this.chargeAmount -= (Math.abs(building1 - building2)) + 1;
        chargeCheck();
    }

    private void fuelCharge()
    {
        chargeAmount = Math.min(chargeAmount + 5, MAX_CHARGE);
    }
    public void update(int currPosition, ArrayList<Boolean> dataFuelCells)
    {
        if (dataFuelCells.get(currPosition))
        {
            fuelCharge();
        }
        if (state.isFirstMove())
        {
            state.setFirstMove(false);
            return;
        }

        if (state.getPreviousPosition() == currPosition)
        {
            this.chargeAmount -= 1;
            chargeCheck();
        }
        else
        {
            jumpDeplete(state.getBuilding2Height(), state.getBuilding1Height());
        }


//        ArrayList<Integer> buildingHeights = data.heights();
//
//        ArrayList<Boolean> fuelCell = data.getFuelCells();


//        ArrayList<Boolean> web = data.getWeb();
//        ArrayList<Boolean> freeze = data.getFreeze();

    }

    public void chargeCheck()
    {
        if (chargeAmount < 1)
        {
            state.setGameRunning(false);
        }

    }
    public void print()
    {
        if (chargeAmount > 0)
        {
            String chargeBlock = "█ ".repeat(chargeAmount);
            System.out.print(chargeBlock);
        }
        System.out.println(chargeAmount);
    }

    public int getChargeAmount()
    {
        return chargeAmount;
    }
}
