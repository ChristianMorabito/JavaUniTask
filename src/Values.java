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
    public static final int MIN_ROW_LENGTH = 6;
    public static final int STARTING_CHARGE = 10;
    public static final int MAX_CHARGE = 20;
    public static final int MIN_CHARGE = 1;
    private static int maxHeight = -1;
    private static int rowLength = -1;
    private static int endIndex = -1;

    final public static int BUILDING_WIDTH = 8; // should not be less than 7
    final public static String PORTAL =    "@";
    final public static String JUMPER =    "█";
    final public static String FUEL_CELL = "$";
    final public static String WEB =       "#";
    final public static String FREEZE =    "^";

    private Values()
    {
        // no need to instantiate
    }

    /**
     * Accessor method to get endIndex
     * @return endIndex: int
     */
    public static int getEndIndex()
    {
        return rowLength - 1;
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
    public static int getRowLength()
    {
        return rowLength;
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
    public static void setRowLength(int rowLength)
    {
        Values.rowLength = Values.rowLength == -1 ? rowLength : Values.rowLength;
    }
}
