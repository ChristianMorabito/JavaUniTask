import java.util.ArrayList;

public class Charge
{

    private int chargeAmount = 10;
    private final int MAX_CHARGE = 20;
    private void jumpDeplete(int building1, int building2)
    {
        this.chargeAmount -= Math.abs((building1 - building2)) + 1;
    }

    private int currIndex = 0;
    private int prevIndex = 0;

    private boolean firstMove = false;

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
    public void update(Data data)
    {

        if (!firstMove)
        {
            firstMove = true;
            return;
        }

        if (currIndex == prevIndex)
        {
            this.chargeAmount -= 1;
        }

        ArrayList<Integer> buildingHeights = data.getBuildingHeights();
        jumpDeplete(buildingHeights.get(currIndex), buildingHeights.get(prevIndex));

        ArrayList<Boolean> fuelCell = data.getFuelCells();
        if (fuelCell.get(currIndex))
        {
            fuelCharge();
        }


//        ArrayList<Boolean> web = data.getWeb();
//        ArrayList<Boolean> freeze = data.getFreeze();

    }
    public void print()
    {
        System.out.println("Current charge = " + this.chargeAmount);
    }
    public int getCurrIndex()
    {
        return currIndex;
    }
    public int getPrevIndex()
    {
        return prevIndex;
    }

    public void setCurrIndex(int currIndex)
    {
        this.currIndex = currIndex;
    }

    public void setPrevIndex(int prevIndex)
    {
        this.prevIndex = prevIndex;
    }
}
