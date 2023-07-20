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
    }

    private void fuelCharge()
    {
        if (this.chargeAmount + 5 > MAX_CHARGE)
        {
            this.chargeAmount = MAX_CHARGE;
        }
        else
        {
            chargeAmount += 5;
        }
    }
    public void update(int currPosition)
    {
        if (state.isFirstMove())
        {
            state.setFirstMove(false);
            return;
        }

        if (state.getPreviousPosition() == currPosition)
        {
            this.chargeAmount -= 1;
        }
        else
        {
            jumpDeplete(state.getBuilding2Height(), state.getBuilding1Height());
        }


//        ArrayList<Integer> buildingHeights = data.heights();
//
//        ArrayList<Boolean> fuelCell = data.getFuelCells();
//        if (fuelCell.get(currIndex))
//        {
//            fuelCharge();
//        }


//        ArrayList<Boolean> web = data.getWeb();
//        ArrayList<Boolean> freeze = data.getFreeze();

    }
    public void print()
    {
        System.out.println("Current charge = " + this.chargeAmount);
    }

}
