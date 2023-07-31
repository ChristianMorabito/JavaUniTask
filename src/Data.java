/**
 * Class that stores both: 'static constants' &
 * 'static non-constants' (that can only be mutated/set once).
 * @author Christian Morabito
 * @version ver1.0.0
 */

public class Data
{
    public static final String WRITE_FILE_NAME = "outcome.txt";
    public static final String READ_FILE_NAME = "buildings.txt";
    public static final int COLUMN_LENGTH = 5;
    public static final int START_INDEX = 0;
    public static final int MIN_ROW_LENGTH = 6;
    public static final int STARTING_CHARGE = 10;
    public static final int MAX_CHARGE = 20;

    private static int maxHeight = -1;
    private static int rowLength = -1;
    private static int endIndex = -1;
    private static int portalIndex = -1;

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
     * Accessor method to get portalIndex
     * @return portalIndex: int
     */
    public static int getPortalIndex()
    {
        return portalIndex;
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
        Data.endIndex = Data.endIndex == -1 ? endIndex : Data.endIndex;
    }

    /**
     * Mutator method to set maxHeight: int.
     * After the maxHeight has been set once, it cannot be overridden.
     */
    public static void setMaxHeight(int maxHeight)
    {
        Data.maxHeight = Data.maxHeight == -1 ? maxHeight : Data.maxHeight;
    }

    /**
     * Mutator method to set portalIndex: int.
     * After the portalIndex has been set once, it cannot be overridden.
     */
    public static void setPortalIndex(int portalIndex)
    {
        Data.portalIndex = Data.portalIndex == -1 ? portalIndex : Data.portalIndex;
    }

    /**
     * Mutator method to set rowLength: int.
     * After the rowLength has been set once, it cannot be overridden.
     */
    public static void setRowLength(int rowLength)
    {
        Data.rowLength = Data.rowLength == -1 ? rowLength : Data.rowLength;
    }
}
