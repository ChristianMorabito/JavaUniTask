import java.util.ArrayList;
import java.util.Collections;

/**
 * Class which parses & stores the input txt-file data into arrays,
 * as well as shuffles the array contents
 * @author Christian Morabito
 * @version ver1.0.0
 */

public class Array
{
    private final ArrayList<Integer> buildingHeights;
    private final ArrayList<Boolean> exitPortal;
    private final ArrayList<Boolean> originalFuel;
    private ArrayList<Boolean> tempFuel; // this array gets recreated after every fuel shuffle
    private int fuelMove; // counter which increments & determines when tempFuel array needs to be updated
    private final ArrayList<Boolean> web;
    private final ArrayList<Boolean> freeze;


    /**
     * Default constructor which creates the object of the class Array.
     */
    public Array()
    {
        buildingHeights = new ArrayList<>();
        exitPortal = new ArrayList<>();
        originalFuel = new ArrayList<>();
        tempFuel = new ArrayList<>();
        web = new ArrayList<>();
        freeze = new ArrayList<>();
        fuelMove = 0;

    }

    /**
     * Non-default constructor which creates the object of the class Array.
     * @param fuelMove accepts int to set value
     */
    public Array(int fuelMove)
    {
        this.buildingHeights = new ArrayList<>();
        this.exitPortal = new ArrayList<>();
        this.originalFuel = new ArrayList<>();
        this.tempFuel = new ArrayList<>();;
        this.fuelMove = fuelMove;
        this.web = new ArrayList<>();
        this.freeze = new ArrayList<>();
    }

    /**
     * display method to print the state
     * of the class fields
     */
    public void display()
    {
        System.out.println();
    }

    /**
     * checks if tempFuel index is true. If so, then
     * 'true' is updated to 'false' as a 'fuel collect'
     * @param currentPosition accepts int which represents index of player
     */
    public void fuelCollect(int currentPosition)
    {
        if (tempFuel.get(currentPosition))
        {
            tempFuel.set(currentPosition, false);
        }
    }
    
    /**
     * Checks if fuelCount % n == 0.
     * @return  Returns a boolean that determines if the fuel array should be shuffled
     * or not.
     */
    public boolean fuelShuffleCheck()
    {
        return Validation.fuelShuffleModulo(fuelMove) == 0;
    }

    /**
     * accessor method for 'buildings' arraylist (boolean)
     * @return returns 'buildings' arraylist (boolean)
     */
    public ArrayList<Integer> getBuildings()
    {
        return buildingHeights;
    }

    /**
     * accessor method for exitPortal arraylist (boolean)
     * @return returns 'exitPortal' arraylist (boolean)
     */
    public ArrayList<Boolean> getExitPortal()
    {
        return exitPortal;
    }

    /**
     * accessor method for fuelMove (int)
     * @return returns int fuelMove
     */
    public ArrayList<Boolean> getFreeze()
    {
        return freeze;
    }

    /**
     * Accessor method for fuelMove
     * @return returns fuelMove: int
     */
    public int getFuelMove()
    {
        return fuelMove;
    }

    /**
     * accessor method for 'freeze' arraylist (boolean)
     * @return returns 'freeze' arraylist (boolean)
     */
    public ArrayList<Boolean> getOriginalFuel()
    {
        return originalFuel;
    }

    /**
     * accessor method for tempFuel arraylist (boolean)
     * @return returns 'tempFuel' arraylist (boolean)
     */
    public ArrayList<Boolean> getTempFuel()
    {
        return tempFuel;
    }

    /**
     * Accessor method for 'web' arraylist (boolean)
     * @return returns 'web' arraylist (boolean)
     */
    public ArrayList<Boolean> getWeb()
    {
        return web;
    }

    /**
     * method to parse & validate data to ensure it's acceptable
     * for Jumper game
     * @param data accepts arraylist (string[]) to parse contents
     *             into individual arrays
     */
    public void parse(ArrayList<String[]> data)
    {
        int maxHeight = Values.MIN_HEIGHT;

        Values.setRowsAmount(data.size());
        Validation.rowLengthCheck();

        for (String[] datum : data)
        {
            Validation.columnLengthCheck(datum.length);
            this.buildingHeights.add(Validation.stringToInteger(datum[0]));
            maxHeight = Math.max(buildingHeights.get(buildingHeights.size()-1), maxHeight);
            Validation.minHeightCheck(buildingHeights.get(buildingHeights.size()-1));
            this.exitPortal.add(Validation.stringToBoolean(datum[1]));
            this.originalFuel.add(Validation.stringToBoolean(datum[2]));
            this.web.add(Validation.stringToBoolean(datum[3]));
            this.freeze.add(Validation.stringToBoolean(datum[4]));
        }
        Values.setMaxHeight(maxHeight);
        Validation.exitCheck(this.exitPortal);
    }

    /**
     * Mutator method for fuelShuffleCount
     * @param fuelMove accepts fuelShuffleCount: int.
     */
    public void setFuelMove(int fuelMove)
    {
        this.fuelMove = fuelMove;
    }

    /**
     * Mutator method for 'fuel' arraylist (boolean)
     * @param tempFuel accepts 'fuel' arraylist (boolean)
     */
    public void setTempFuel(ArrayList<Boolean> tempFuel)
    {
        this.tempFuel = tempFuel;
    }

    /**
     * Method to shift the 'true' boolean in the web array to left or right
     * @param sharedIndex accepts int which is the shared index between
     *                    web & freeze arrays.
     */
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

    /**
     * Method to (1) shuffle arrays, (2) update & shuffle fuel array
     * (3) check if a web/freeze element is not on the same index
     * (4) increment fuelMove (fuel shuffle counter)
     */
    public void shuffle()
    {
        int safeStartIndex = fuelMove > 0 ? 0 : 1;
//        Collections.shuffle(buildingHeights);
//        Collections.shuffle(web.subList(safeStartIndex, Values.getRowsAmount() - 1)); // web cannot land on exit
//        Collections.shuffle(freeze.subList(safeStartIndex, Values.getRowsAmount()));
        if (web.indexOf(true) == freeze.indexOf(true) && web.contains(true))
        {
            shift(web.indexOf(true));
        }

        if (fuelShuffleCheck())
        {
            tempFuel = new ArrayList<>(originalFuel);
            Collections.shuffle(tempFuel.subList(safeStartIndex, Values.getRowsAmount()));
        }
        fuelMove++;
    }
}
