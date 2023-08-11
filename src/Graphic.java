import java.util.ArrayList;

/**
 * Graphic class for creating 2d array (string-builder) which
 * represents the buildings graphic
 * @author Christian Morabito
 * @version ver1.0.0
 **/

public class Graphic
{
    final private int SIDES_AND_GAP = 3; // 3 = x2 building sides + x1 gap (between buildings)
    final private int INNER_BUILDING_SPACE = Values.BUILDING_WIDTH - SIDES_AND_GAP;
    final private char SINGLE_SPACE = ' ';
    final private String JUMPER_WINDOW = "‡".repeat(INNER_BUILDING_SPACE);
    final private String DARK_WINDOW =  "∎".repeat(INNER_BUILDING_SPACE);
    final private String CLEAR_WINDOW = "◫".repeat(INNER_BUILDING_SPACE);
    final private String FULL_WINDOW =  "□".repeat(INNER_BUILDING_SPACE);
    final private String BUILDING_SIDE = "┃";

    private StringBuilder[][] buildingString;

    /**
     * Default constructor for Graphic class
     **/
    public Graphic()
    {
        this.buildingString = new StringBuilder[Values.getMaxHeight() + 1][Values.getRowsAmount()];
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
     * @param array Accepts Parse object
     * @param currentPos Accepts int which represents current position player is on
     * @param leftPos Accepts int which represents position if player potentially jumps left
     * @param rightPos Accepts int which represents position if player potentially jumps right
     * @param numbers Accepts int which represents if numbers bool is true (from State class)
     **/
    public StringBuilder[][] create(Array array, int currentPos, int leftPos,
                                    int rightPos, boolean numbers)
    {

        ArrayList<Integer> heights = array.getBuildings();

        for (int i = 0; i < Values.getRowsAmount(); i++)
        {
            int currentHeight = heights.get(i);
            createRoof(array, i, currentHeight, currentPos);
            createBase(i, currentPos, leftPos, rightPos, numbers, heights);

            for (int j = 0; j < Values.getMaxHeight() - 1; j++)
            {
                createUnderAndAbove(currentPos, currentHeight, i, j, leftPos, rightPos);
            }
        }
        return buildingString;
    }

    /**
     * Method to create base graphic (bottom of building)
     * @param i Accepts int iterator from 1st for-loop
     * @param currentPos Accepts int which represents current position player is on
     * @param leftPos Accepts int which represents position if player potentially jumps left
     * @param rightPos Accepts int which represents position if player potentially jumps right
     * @param numbers Accepts int which represents if numbers bool is true (from State class)
     * @param heights Accepts int array-list containing building heights from Parse class
     **/
    private void createBase(int i, int currentPos, int leftPos, int rightPos,
                            boolean numbers, ArrayList<Integer> heights)
    {
        String baseText;
        int beginIndex = heights.get(i).toString().length();


        if (i == currentPos)
        {
            baseText = numbers ? SINGLE_SPACE + JUMPER_WINDOW.substring(beginIndex) : JUMPER_WINDOW;
        }
        else if (i == leftPos || i == rightPos)
        {
            baseText = numbers ? SINGLE_SPACE + DARK_WINDOW.substring(beginIndex) : DARK_WINDOW;
        }
        else if (i == Values.getEndIndex())
        {
            baseText = numbers ? SINGLE_SPACE + FULL_WINDOW.substring(beginIndex) : FULL_WINDOW;
        }
        else
        {
            baseText = numbers ? SINGLE_SPACE + CLEAR_WINDOW.substring(beginIndex) : CLEAR_WINDOW;
        }

        String numbersSide = numbers ? String.valueOf(heights.get(i)) : BUILDING_SIDE;
        buildingString[Values.getMaxHeight()][i] = new StringBuilder(numbersSide + baseText + BUILDING_SIDE);
    }

    /**
     * Method to graphically fill above & between (building roof & base) in the 2d stringbuilder array
     * @param currentPos Accepts int which represents current position player is on.
     * @param currentHeight Accepts int which represents the building height the player currently is on
     * @param i Accepts int iterator from 1st for-loop
     * @param j Accepts int iterator from nested for-loop
     * @param leftPos Accepts int which represents position if player potentially jumps left
     * @param rightPos Accepts int which represents position if player potentially jumps right
     **/
    private void createUnderAndAbove(int currentPos, int currentHeight, int i, int j, int leftPos, int rightPos)
    {
        final String DEFAULT_SIDES = BUILDING_SIDE + CLEAR_WINDOW + BUILDING_SIDE;
        final String CURRENT_SIDES = BUILDING_SIDE + JUMPER_WINDOW + BUILDING_SIDE;
        final String JUMP_TO_SIDES = BUILDING_SIDE + DARK_WINDOW + BUILDING_SIDE;
        final String PORTAL_SIDES = BUILDING_SIDE + FULL_WINDOW + BUILDING_SIDE;
        final String EMPTY_SPACE =   Character.toString(SINGLE_SPACE).repeat(Values.BUILDING_WIDTH - 1);
        int underBuilding = Values.getMaxHeight() + j + 1;

        if (underBuilding - currentHeight < Values.getMaxHeight())
        {
            if (i == currentPos)
            {
                buildingString[underBuilding - currentHeight][i] = new StringBuilder(CURRENT_SIDES);
            }
            else if (i == leftPos || i == rightPos)
            {
                buildingString[underBuilding - currentHeight][i] = new StringBuilder(JUMP_TO_SIDES);
            }
            else if (i == Values.getEndIndex())
            {
                buildingString[underBuilding - currentHeight][i] = new StringBuilder(PORTAL_SIDES);
            }
            else
            {
                buildingString[underBuilding - currentHeight][i] = new StringBuilder(DEFAULT_SIDES);
            }
        }
        else
        {
            buildingString[(underBuilding - currentHeight) - Values.getMaxHeight()][i] = new StringBuilder(EMPTY_SPACE);
        }
    }

    /**
     * Method to create roof graphic. It deals with symbols on the roof, such as
     * portal, jumper, fuel cell, web & freeze.
     * @param array Accepts array object
     * @param i Accepts int iterator from 1st for loop
     * @param currentHeight Accepts int which represents the building height the player currently is on
     * @param currentPos Accepts int which represents current position player is on
     **/
    private void createRoof(Array array, int i, int currentHeight, int currentPos)
    {
        String TOP_LEFT_ROOF = "┎";
        String TOP_RIGHT_ROOF = "┒";
        String ROOF = "─";
        final String WHOLE_ROOF = TOP_LEFT_ROOF + ROOF.repeat(INNER_BUILDING_SPACE) + TOP_RIGHT_ROOF;
        final boolean[] CONDITIONS = {i == currentPos, array.getTempFuel().get(i),
                array.getFreeze().get(i), array.getWeb().get(i), array.getExitPortal().get(i)};
        final int HEIGHT_FORMULA = Values.getMaxHeight() - currentHeight;
        final String[] SYMBOLS_ARRAY = new String[] {Values.JUMPER, Values.FUEL_CELL, Values.FREEZE, Values.WEB, Values.PORTAL};
        buildingString[Values.getMaxHeight() - currentHeight][i] = new StringBuilder(WHOLE_ROOF);

        int nextPosition = 1;
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
     * display method to print the state
     * of the class fields
     */
    public void display()
    {
        System.out.println();
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
