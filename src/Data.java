public class Data
{
    public static final String WRITE_FILE_NAME = "outcome.txt";
    public static final String READ_FILE_NAME = "buildings.txt";
    private static int maxHeight;
    private static int rowLength;
    public static final int START_INDEX = 0;
    private static int endIndex;
    private static int portalIndex;
    public static final int STARTING_CHARGE = 10;
    public static final int MAX_CHARGE = 20;

    public Data()
    {
    }

    public static void setMaxHeight(int maxHeight)
    {
        Data.maxHeight = maxHeight;
    }

    public static void setEndIndex(int endIndex)
    {
        Data.endIndex = endIndex;
    }

    public static void setPortalIndex(int portalIndex)
    {
        Data.portalIndex = portalIndex;
    }

    public static void setRowLength(int rowLength)
    {
        Data.rowLength = rowLength;
    }

    public static int getMaxHeight()
    {
        return maxHeight;
    }

    public static int getRowLength()
    {
        return rowLength;
    }

    public static int getEnd_index()
    {
        return rowLength - 1;
    }

    public static int getEndIndex()
    {
        return endIndex;
    }

    public static int getPortalIndex()
    {
        return portalIndex;
    }
}
