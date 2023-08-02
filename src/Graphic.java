import java.util.ArrayList;

/**
 * Graphic class for creating 2d array (string-builder) which
 * represents the buildings graphic
 * @author Christian Morabito
 * @version ver1.0.0
 **/

public class Graphic
{
    final private int SIDES_AND_GAP = 3; // 3 = 2 building sides + 1 gap (between buildings)
    final private int INNER_BUILDING_SPACE = Data.BUILDING_WIDTH - SIDES_AND_GAP;
    final private char SINGLE_SPACE = ' ';
    final private String JUMPER_WINDOW = "‡".repeat(INNER_BUILDING_SPACE);
    final private String DARK_WINDOW =  "∎".repeat(INNER_BUILDING_SPACE);
    final private String CLEAR_WINDOW = "◫".repeat(INNER_BUILDING_SPACE);
    final private String FULL_WINDOW =  "◩".repeat(INNER_BUILDING_SPACE);
    final private String BUILDING_SIDE = "┃";

    private StringBuilder[][] buildingString;

    /**
     * Default constructor for Graphic class
     **/
    public Graphic()
    {
        this.buildingString = new StringBuilder[Data.getMaxHeight() + 1][Data.getRowLength()];
    }

    /**
     * Non-default constructor for Graphic class
     * @param buildingString 2d stringbuilder array
     **/
    Graphic(StringBuilder[][] buildingString)
    {
        this.buildingString = buildingString;
    }

    /**
     * Method to iterate over 2d string-builder array to parse graphic string
     * @param parse Accepts Parse object
     * @param currentPosition Accepts int which represents current position player is on
     * @param leftPosition Accepts int which represents position if player potentially jumps left
     * @param rightPosition Accepts int which represents position if player potentially jumps right
     * @param numbers Accepts int which represents if numbers bool is true (from State class)
     **/
    public StringBuilder[][] create(Parse parse, int currentPosition, int leftPosition,
                                    int rightPosition, boolean numbers)
    {

        ArrayList<Integer> heights = parse.buildings();

        for (int i = 0; i < Data.getRowLength(); i++)
        {
            int currentHeight = heights.get(i);
            createRoof(parse, i, currentHeight, currentPosition);
            createBase(i, currentPosition, leftPosition, rightPosition, numbers, heights);

            for (int j = 0; j < Data.getMaxHeight() - 1; j++)
            {
                createUnderAndAbove(currentPosition, currentHeight, i, j, leftPosition, rightPosition);
            }
        }
        return buildingString;
    }

    /**
     * Method to create base graphic (bottom of building)
     * @param i Accepts int iterator from 1st for-loop
     * @param currentPosition Accepts int which represents current position player is on
     * @param leftPosition Accepts int which represents position if player potentially jumps left
     * @param rightPosition Accepts int which represents position if player potentially jumps right
     * @param numbers Accepts int which represents if numbers bool is true (from State class)
     * @param heights Accepts int array-list containing building heights from Parse class
     **/
    private void createBase(int i, int currentPosition, int leftPosition, int rightPosition,
                            boolean numbers, ArrayList<Integer> heights)
    {
        String baseText;
        int beginIndex = heights.get(i).toString().length();


        if (i == Data.getPortalIndex())
        {
            baseText = numbers ? SINGLE_SPACE + FULL_WINDOW.substring(beginIndex) : FULL_WINDOW;
        }
        else if (i == currentPosition)
        {
            baseText = numbers ? SINGLE_SPACE + JUMPER_WINDOW.substring(beginIndex) : JUMPER_WINDOW;
        }
        else if (i == leftPosition || i == rightPosition)
        {
            baseText = numbers ? SINGLE_SPACE + DARK_WINDOW.substring(beginIndex) : DARK_WINDOW;
        }
        else
        {
            baseText = numbers ? SINGLE_SPACE + CLEAR_WINDOW.substring(beginIndex) : CLEAR_WINDOW;
        }

        String numbersSide = numbers ? String.valueOf(heights.get(i)) : BUILDING_SIDE;
        buildingString[Data.getMaxHeight()][i] = new StringBuilder(numbersSide + baseText + BUILDING_SIDE);
    }

    /**
     * Method to create roof graphic. It deals with symbols on the roof, such as
     * portal, jumper, fuel cell, web & freeze.
     * @param parse Accepts Parse object
     * @param i Accepts int iterator from 1st for loop
     * @param currentHeight Accepts int which represents the building height the player currently is on
     * @param currentPosition Accepts int which represents current position player is on
     **/
    private void createRoof(Parse parse, int i, int currentHeight, int currentPosition)
    {
        String TOP_LEFT_ROOF = "┎";
        String TOP_RIGHT_ROOF = "┒";
        String ROOF = "─";
        final String WHOLE_ROOF = TOP_LEFT_ROOF + ROOF.repeat(INNER_BUILDING_SPACE) + TOP_RIGHT_ROOF;
        final boolean[] CONDITIONS = {i == currentPosition, parse.getFuel().getArray().get(i),
                parse.getFreeze().get(i), parse.getWeb().get(i), parse.getExitPortal().get(i)};
        final int HEIGHT_FORMULA = Data.getMaxHeight() - currentHeight;
        final String[] SYMBOLS_ARRAY = new String[] {Data.JUMPER, Data.FUEL_CELL, Data.FREEZE, Data.WEB, Data.PORTAL};
        buildingString[Data.getMaxHeight() - currentHeight][i] = new StringBuilder(WHOLE_ROOF);

        int nextPosition = 1; // 1 = 1-th index on top of building (so symbol doesn't begin on edge of building).
        for (int x = 0; x < CONDITIONS.length; x++)
        {
            int startPosition = nextPosition;
            nextPosition += SYMBOLS_ARRAY[x].length();
            if (CONDITIONS[x])
            {
                buildingString[HEIGHT_FORMULA][i] =
                buildingString[HEIGHT_FORMULA][i].replace(startPosition, nextPosition, SYMBOLS_ARRAY[x]);
            }
        }
    }

    /**
     * Method to graphically fill above & between (building roof & base) in the 2d stringbuilder array
     * @param currentPosition Accepts int which represents current position player is on.
     * @param currentHeight Accepts int which represents the building height the player currently is on
     * @param i Accepts int iterator from 1st for-loop
     * @param j Accepts int iterator from nested for-loop
     * @param leftPosition Accepts int which represents position if player potentially jumps left
     * @param rightPosition Accepts int which represents position if player potentially jumps right
     **/
    private void createUnderAndAbove(int currentPosition, int currentHeight, int i, int j, int leftPosition, int rightPosition)
    {
        final String DEFAULT_SIDES = BUILDING_SIDE + CLEAR_WINDOW + BUILDING_SIDE;
        final String CURRENT_SIDES = BUILDING_SIDE + JUMPER_WINDOW + BUILDING_SIDE;
        final String JUMP_TO_SIDES = BUILDING_SIDE + DARK_WINDOW + BUILDING_SIDE;
        final String PORTAL_SIDES = BUILDING_SIDE + FULL_WINDOW + BUILDING_SIDE;
        final String EMPTY_SPACE =   Character.toString(SINGLE_SPACE).repeat(Data.BUILDING_WIDTH - 1);
        int underBuilding = Data.getMaxHeight() + j + 1;

        if (underBuilding - currentHeight < Data.getMaxHeight())
        {
            if (i == Data.getPortalIndex())
            {
                buildingString[underBuilding - currentHeight][i] = new StringBuilder(PORTAL_SIDES);
            }
            else if (i == currentPosition)
            {
                buildingString[underBuilding - currentHeight][i] = new StringBuilder(CURRENT_SIDES);
            }
            else if (i == leftPosition || i == rightPosition)
            {
                buildingString[underBuilding - currentHeight][i] = new StringBuilder(JUMP_TO_SIDES);
            }
            else
            {
                buildingString[underBuilding - currentHeight][i] = new StringBuilder(DEFAULT_SIDES);
            }
        }
        else
        {
            buildingString[(underBuilding - currentHeight) - Data.getMaxHeight()][i] = new StringBuilder(EMPTY_SPACE);
        }
    }

    /**
     * Accessor method to get buildingString field
     **/
    public StringBuilder[][] getBuildingString()
    {
        return buildingString;
    }

    /**
     * Mutator method to set buildingString field
     * @param buildingString 2d stringbuilder array
     **/
    public void setBuildingString(StringBuilder[][] buildingString)
    {
        this.buildingString = buildingString;
    }
}