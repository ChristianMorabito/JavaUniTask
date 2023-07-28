import java.util.ArrayList;
import java.util.Collections;

public class Parse
{

    private ArrayList<Integer> buildingHeights;
    private ArrayList<Boolean> exitPortal;
    private ArrayList<Boolean> fuelCells;
    private ArrayList<Boolean> web;
    private ArrayList<Boolean> freeze;
    private Fuel fuel;
    private Count count;

    public Parse()
    {
        this.buildingHeights = new ArrayList<>();
        this.exitPortal = new ArrayList<>();
        this.fuelCells = new ArrayList<>();
        this.web = new ArrayList<>();
        this.freeze = new ArrayList<>();
        this.fuel = new Fuel();
        this.count = new Count();
    }

    public Parse(Fuel fuel, Count count)
    {
        this.buildingHeights = new ArrayList<>();
        this.exitPortal = new ArrayList<>();
        this.fuelCells = new ArrayList<>();
        this.web = new ArrayList<>();
        this.freeze = new ArrayList<>();
        this.fuel = fuel;
        this.count = count;
    }

    public void shuffleOnlyPortal()
    {
        int twoThirdsMark = (Data.getRowLength() - (Data.getRowLength() / 3) - 1);
        Collections.shuffle(this.exitPortal.subList(twoThirdsMark, Data.getRowLength()));
        Data.setPortalIndex(exitPortal.indexOf(true));
    }

    public void shuffle()
    {

        Collections.shuffle(this.buildingHeights);
        Collections.shuffle(this.web.subList(Data.START_INDEX + 1, Data.getRowLength()));
        Collections.shuffle(this.freeze.subList(Data.START_INDEX + 1, Data.getRowLength()));
        if (count.fuelShuffleCheck()){
            fuel.setArray(new ArrayList<>(fuelCells));
            Collections.shuffle(fuel.getArray().subList(1,2));
        }
        count.setFuelShuffleCount(count.getFuelShuffleCount() + 1);

    }

    public void define(ArrayList<String[]> data)
    {
        for (String[] datum : data)
        {
            this.buildingHeights.add(Integer.parseInt(datum[0]));
            this.exitPortal.add(Boolean.parseBoolean(datum[1]));
            this.fuelCells.add(Boolean.parseBoolean(datum[2]));
            this.web.add(Boolean.parseBoolean(datum[3]));
            this.freeze.add(Boolean.parseBoolean(datum[4]));
        }
    }

    public ArrayList<Integer> buildings()
    {
        return buildingHeights;
    }
    public ArrayList<Boolean> getFuelCells()
    {
        return fuelCells;
    }
    public ArrayList<Boolean> getFreeze()
    {
        return freeze;
    }
    public ArrayList<Boolean> getWeb()
    {
        return web;
    }
    public ArrayList<Boolean> getExitPortal()
    {
        return exitPortal;
    }
    public Fuel getFuel()
    {
        return fuel;
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

    public void setFuel(Fuel fuel)
    {
        this.fuel = fuel;
    }

    public void setFuelCells(ArrayList<Boolean> fuelCells)
    {
        this.fuelCells = fuelCells;
    }

    public void setWeb(ArrayList<Boolean> web)
    {
        this.web = web;
    }
}


