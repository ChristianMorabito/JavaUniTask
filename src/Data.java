import java.util.ArrayList;
import java.util.Collections;

public class Data
{
    private ArrayList<Integer> buildingHeights;
    private ArrayList<Boolean> exitPortal;
    private ArrayList<Boolean> originalFuel;
    private ArrayList<Boolean> fuel;
    private int fuelMove;
    private ArrayList<Boolean> web;
    private ArrayList<Boolean> freeze;

    public Data()
    {
        buildingHeights = new ArrayList<>();
        exitPortal = new ArrayList<>();
        originalFuel = new ArrayList<>();
        fuel = new ArrayList<>();
        web = new ArrayList<>();
        freeze = new ArrayList<>();
        fuelMove = 0;

    }

    public Data(ArrayList<Boolean> fuel, int fuelMove)
    {
        this.buildingHeights = new ArrayList<>();
        this.exitPortal = new ArrayList<>();
        this.originalFuel = new ArrayList<>();
        this.fuel = fuel;
        this.fuelMove = fuelMove;
        this.web = new ArrayList<>();
        this.freeze = new ArrayList<>();
    }

    public void define(ArrayList<String[]> data)
    {
        for (String[] datum : data) {
            Validation.columnLengthCheck(datum.length);
            this.buildingHeights.add(Integer.parseInt(datum[0]));
            this.exitPortal.add(Validation.stringToBoolean(datum[1]));
            this.originalFuel.add(Validation.stringToBoolean(datum[2]));
            this.web.add(Validation.stringToBoolean(datum[3]));
            this.freeze.add(Validation.stringToBoolean(datum[4]));
        }
        Validation.exitCheck(this.exitPortal);
    }

    public void fuelCollect(int currentPosition)
    {
        if (fuel.get(currentPosition))
        {
            fuel.set(currentPosition, false);
        }
    }
    
    /**
     * Checks if fuelShuffleCount is modulo 3 or not.
     * @return  Returns a boolean that determines if the fuel array should be shuffled
     * or not.
     */
    public boolean fuelShuffleCheck()
    {
        return fuelMove >= 0 &&
                Validation.fuelShuffleModulo(fuelMove) == 0;
    }
    
    public ArrayList<Integer> getBuildings()
    {
        return buildingHeights;
    }

    public ArrayList<Boolean> getExitPortal()
    {
        return exitPortal;
    }

    public ArrayList<Boolean> getFuel()
    {
        return fuel;
    }

    /**
     * Accessor method for fuelShuffleCount
     * @return returns fuelShuffleCount: int
     */
    public int getFuelMove()
    {
        return fuelMove;
    }

    public ArrayList<Boolean> getFreeze()
    {
        return freeze;
    }

    public ArrayList<Boolean> getOriginalFuel()
    {
        return originalFuel;
    }

    public ArrayList<Boolean> getWeb()
    {
        return web;
    }

    public void setBuildingHeights(ArrayList<Integer> buildingHeights)
    {
        this.buildingHeights = buildingHeights;
    }

    public void setExitPortal(ArrayList<Boolean> exitPortal)
    {
        this.exitPortal = exitPortal;
    }

    public void setFreeze(ArrayList<Boolean> freeze)
    {
        this.freeze = freeze;
    }

    public void setFuel(ArrayList<Boolean> fuel)
    {
        this.fuel = fuel;
    }

    /**
     * Mutator method for fuelShuffleCount
     * @param fuelMove used to update the fuelShuffleCount: int, through incrementation.
     */
    public void setFuelMove(int fuelMove)
    {
        this.fuelMove = fuelMove;
    }

    public void setOriginalFuel(ArrayList<Boolean> originalFuel)
    {
        this.originalFuel = originalFuel;
    }

    public void setWeb(ArrayList<Boolean> web)
    {
        this.web = web;
    }

    private void shift(int sharedIndex)
    {
        if (sharedIndex > Values.START_INDEX)
        {
            web.set(web.indexOf(true), false);
            web.set(sharedIndex - 1, true);
        }
        else
        {
            web.set(web.indexOf(true), false);
            web.set(sharedIndex + 1, true);
        }

    }

    public void shuffle()
    {
        int safeStartIndex = fuelMove > 0 ? 0 : 1;
        Collections.shuffle(buildingHeights);
        Collections.shuffle(web.subList(safeStartIndex, Values.getRowLength() - 1)); // web cannot land on exit
        Collections.shuffle(freeze.subList(safeStartIndex, Values.getRowLength()));
        if (web.indexOf(true) == freeze.indexOf(true) && web.contains(true))
        {
            shift(web.indexOf(true));
        }

        if (fuelShuffleCheck())
        {
            fuel = new ArrayList<>(originalFuel);
            Collections.shuffle(fuel.subList(safeStartIndex, Values.getEndIndex()));
        }
        fuelMove++;
    }
}
