import java.util.ArrayList;
import java.util.Collections;

public class Data
{
    private ArrayList<Integer> buildingHeights;
    private ArrayList<Boolean> exitPortal;
    private ArrayList<Boolean> originalFuel;
    private ArrayList<Boolean> fuel;
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

    }

    public Data(ArrayList<Boolean> fuel)
    {
        this.buildingHeights = new ArrayList<>();
        this.exitPortal = new ArrayList<>();
        this.originalFuel = new ArrayList<>();
        this.fuel = fuel;
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

    public ArrayList<Boolean> getExitPortal()
    {
        return exitPortal;
    }

    public ArrayList<Integer> getBuildings()
    {
        return buildingHeights;
    }

    public ArrayList<Boolean> getFuel()
    {
        return fuel;
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

    public void setOriginalFuel(ArrayList<Boolean> originalFuel)
    {
        this.originalFuel = originalFuel;
    }

    public void setWeb(ArrayList<Boolean> web)
    {
        this.web = web;
    }

    private void shiftWebOrFreeze(int sharedIndex)
    {
        if (sharedIndex > Values.START_INDEX && sharedIndex <= Values.getEndIndex())
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

    public void shuffle(Count count)
    {
        int safeStartIndex = count.getFuelMove() > 0 ? 0 : 1;
        Collections.shuffle(buildingHeights);
        Collections.shuffle(web.subList(safeStartIndex, Values.getRowLength()));
        Collections.shuffle(freeze.subList(safeStartIndex, Values.getRowLength()));
        if (web.indexOf(true) == freeze.indexOf(true))
        {
            shiftWebOrFreeze(web.indexOf(true));
        }

        if (count.fuelShuffleCheck())
        {
            fuel = new ArrayList<>(originalFuel);
            Collections.shuffle(fuel.subList(safeStartIndex, Values.getEndIndex()));
        }
        count.setFuelMove(count.getFuelMove() + 1);
    }
}
