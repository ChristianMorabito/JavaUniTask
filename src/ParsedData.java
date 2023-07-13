import java.util.ArrayList;
import java.util.Collections;

public class ParsedData {

    private int fuelShuffleCount = 0;
    private ArrayList<Integer> buildingHeights;
    private ArrayList<Boolean> exitPortals;
    private ArrayList<Boolean> fuelCells;
    private ArrayList<Boolean> web;
    private ArrayList<Boolean> freeze;

    public ParsedData(){
        this.buildingHeights = new ArrayList<>();
        this.exitPortals = new ArrayList<>();
        this.fuelCells = new ArrayList<>();
        this.web = new ArrayList<>();
        this.freeze = new ArrayList<>();
    }

    public void shuffleData(){
        Collections.shuffle(this.buildingHeights);
        Collections.shuffle(this.web.subList(1, 15));
        Collections.shuffle(this.freeze.subList(1, 15));
        if (this.fuelShuffleCount > 0 && this.fuelShuffleCount % 3 == 0){
            Collections.shuffle(this.fuelCells.subList(0, 14));
        }
        this.fuelShuffleCount++;

    }

    public void define(){
        ReadFile readFile = new ReadFile();

        for (String[] datum : readFile.getData()) {
            this.buildingHeights.add(Integer.parseInt(datum[0]));
            this.exitPortals.add(Boolean.parseBoolean(datum[1]));
            this.fuelCells.add(Boolean.parseBoolean(datum[2]));
            this.web.add(Boolean.parseBoolean(datum[3]));
            this.freeze.add(Boolean.parseBoolean(datum[4]));
        }
    }

    public ArrayList<Integer> getBuildingHeights() {
        return buildingHeights;
    }
    public ArrayList<Boolean> getFuelCells() {
        return fuelCells;
    }
    public ArrayList<Boolean> getFreeze() {
        return freeze;
    }
    public ArrayList<Boolean> getWeb() {
        return web;
    }
    public ArrayList<Boolean> getExitPortals() {
        return exitPortals;
    }
}


