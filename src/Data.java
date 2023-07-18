import java.util.ArrayList;
import java.util.Collections;

public class Data
{

    private int fuelShuffleCount;
    private ArrayList<Integer> buildingHeights;
    private ArrayList<Boolean> exitPortals;
    private ArrayList<Boolean> fuelCells;
    private ArrayList<Boolean> web;
    private ArrayList<Boolean> freeze;
    private Fuel fuel;

    public Data()
    {
        this.fuelShuffleCount = 0;
        this.buildingHeights = new ArrayList<>();
        this.exitPortals = new ArrayList<>();
        this.fuelCells = new ArrayList<>();
        this.web = new ArrayList<>();
        this.freeze = new ArrayList<>();
        this.fuel = new Fuel();
    }

    public Data(Fuel fuel)
    {
        this.fuelShuffleCount = 0;
        this.buildingHeights = new ArrayList<>();
        this.exitPortals = new ArrayList<>();
        this.fuelCells = new ArrayList<>();
        this.web = new ArrayList<>();
        this.freeze = new ArrayList<>();
        this.fuel = fuel;
    }

    public void shuffleData()
    {

        Collections.shuffle(this.buildingHeights);
        Collections.shuffle(this.web.subList(1, 15));
        Collections.shuffle(this.freeze.subList(1, 15));
        if (this.fuelShuffleCount >= 0 && this.fuelShuffleCount % 3 == 0){
            fuel.setCurrentFuel(this.fuelCells);
            Collections.shuffle(this.fuel.getCurrentFuel().subList(0, 14));
        }
        this.fuelShuffleCount++;

    }

    public void define(ArrayList<String[]> data)
    {

        for (String[] datum : data)
        {
            this.buildingHeights.add(Integer.parseInt(datum[0]));
            this.exitPortals.add(Boolean.parseBoolean(datum[1]));
            this.fuelCells.add(Boolean.parseBoolean(datum[2]));
            this.web.add(Boolean.parseBoolean(datum[3]));
            this.freeze.add(Boolean.parseBoolean(datum[4]));
        }
    }

    public ArrayList<Integer> heights()
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
    public ArrayList<Boolean> getExitPortals()
    {
        return exitPortals;
    }
    public Fuel getFuel()
    {
        return fuel;
    }
    public int getFuelShuffleCount()
    {
        return fuelShuffleCount;
    }

    public void setBuildingHeights(ArrayList<Integer> buildingHeights)
    {
        this.buildingHeights = buildingHeights;
    }

    public void setExitPortals(ArrayList<Boolean> exitPortals)
    {
        this.exitPortals = exitPortals;
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

    public void setFuelShuffleCount(int fuelShuffleCount)
    {
        this.fuelShuffleCount = fuelShuffleCount;
    }
    public void setWeb(ArrayList<Boolean> web)
    {
        this.web = web;
    }
}


