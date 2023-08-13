/**
 * Class that stores both: 'static constants' &
 * 'static variables' (that can only be mutated/set once).
 * @author Christian Morabito
 * @version ver1.0.0
 */

public final class Values
{
    public static final String WRITE_FILE = "outcome.txt";
    public static final String READ_FILE = "buildings.txt";
    public static final int CHARGE_INCREMENT = 5;
    public static final int FUEL_UPDATE_COUNT = 3;
    public static final int COLUMN_LENGTH = 5;
    public static final int START_INDEX = 0;
    public static final int MIN_ROW_LENGTH = 3;
    public static final int STARTING_CHARGE = 5;
    public static final int MAX_CHARGE = 20;
    public static final int MIN_CHARGE = 1;
    public static final int MIN_HEIGHT = 1;
    private static int maxHeight = -1;
    private static int rowsAmount = -1;
    private static int endIndex = -1;

    public static final int BUILDING_WIDTH = 8; // should not be less than 7
    public static final String PORTAL =    "@";
    public static final String JUMPER =    "█";
    public static final String FUEL_CELL = "$";
    public static final String WEB =       "#";
    public static final String FREEZE =    "^";

    /**
     * Private constructor. Cannot instantiate
     */
    private Values()
    {
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
     * Accessor method to get endIndex
     * @return endIndex: int
     */
    public static int getEndIndex()
    {
        return rowsAmount - 1;
    }

    /**
     * Accessor method to get maxheight
     * @return maxHeight: int
     */
    public static int getMaxHeight()
    {
        return maxHeight;
    }

    /**
     * Accessor method to get rowLength
     * @return rowLength: int
     */
    public static int getRowsAmount()
    {
        return rowsAmount;
    }

    /**
     * Mutator method to set endIndex: int.
     * After the endIndex has been set once, it cannot be overridden.
     */
    public static void setEndIndex(int endIndex)
    {
        Values.endIndex = Values.endIndex == -1 ? endIndex : Values.endIndex;
    }

    /**
     * Mutator method to set maxHeight: int.
     * After the maxHeight has been set once, it cannot be overridden.
     */
    public static void setMaxHeight(int maxHeight)
    {
        Values.maxHeight = Values.maxHeight == -1 ? maxHeight : Values.maxHeight;
    }

    /**
     * Mutator method to set rowLength: int.
     * After the rowLength has been set once, it cannot be overridden.
     */
    public static void setRowsAmount(int rowsAmount)
    {
        Values.rowsAmount = Values.rowsAmount == -1 ? rowsAmount : Values.rowsAmount;
    }
}
