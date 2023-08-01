import java.util.ArrayList;

/**
 * Graphic class for creating 2d array (string-builder) which
 * represents the buildings graphic
 * @author Christian Morabito
 * @version ver1.0.0
 **/

public class Graphic
{
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
     * @param positions Accepts int array containing current position, & L/R jump positions
     **/
    public StringBuilder[][] create(Parse parse, int[] positions, boolean numbers)
    {
        int currentPosition = positions[0];
        int leftPosition = positions[1];
        int rightPosition = positions[2];
        ArrayList<Integer> heights = parse.buildings();

        for (int i = 0; i < Data.getRowLength(); i++)
        {
            int currentHeight = heights.get(i);
            createRoof(parse, i, currentHeight, currentPosition);
            createBase(i, currentPosition, leftPosition, rightPosition, numbers, heights);

            for (int j = 0; j < Data.getMaxHeight() - 1; j++)
            {
                createUnderAndAbove(currentHeight, i, j, leftPosition, rightPosition);
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
        final String betweenGap = " ";
        String firstGap = " ";
        String buildingSide = "┃";
        String baseText;

        if (i == currentPosition)
        {
            baseText = numbers ? " HERE." : ".HERE.";
        }
        else if (i == leftPosition || i == rightPosition)
        {
            baseText = numbers ? " ∎∎∎∎∎" : "∎∎∎∎∎∎";
        }
        else
        {
            baseText = numbers ? " ◫◫◫◫◫" : "◫◫◫◫◫◫";
        }

        firstGap = i > 0 ? firstGap.trim() : firstGap;
        String numbersSide = numbers ? String.valueOf(heights.get(i)) : buildingSide;
        buildingString[Data.getMaxHeight()][i] = new StringBuilder(firstGap +
                numbersSide +
                baseText +
                buildingSide +
                betweenGap);
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
        final String PORTAL = "@";
        final String JUMPER =    "█";
        final String FUEL_CELL = "$";
        final String WEB = "#";
        final String FREEZE = "^^";
        final String ROOF = " ┎──────┒";
        ArrayList<Boolean> exitPortal = parse.getExitPortal();
        ArrayList<Boolean> fuelCell = parse.getFuel().getArray();
        ArrayList<Boolean> web = parse.getWeb();
        ArrayList<Boolean> freeze = parse.getFreeze();

        buildingString[Data.getMaxHeight() - currentHeight][i] = new StringBuilder(ROOF);
        if (i == currentPosition)
        {
            buildingString[Data.getMaxHeight() - currentHeight][i] = buildingString[Data.getMaxHeight() - currentHeight][i].replace(2, 3, JUMPER);
        }
        if (fuelCell.get(i))
        {
            buildingString[Data.getMaxHeight() - currentHeight][i] = buildingString[Data.getMaxHeight() - currentHeight][i].replace(3, 4, FUEL_CELL);
        }
        if (freeze.get(i))
        {
            buildingString[Data.getMaxHeight() - currentHeight][i] = buildingString[Data.getMaxHeight() - currentHeight][i].replace(4, 6, FREEZE);
        }
        if (web.get(i))
        {
            buildingString[Data.getMaxHeight() - currentHeight][i] = buildingString[Data.getMaxHeight() - currentHeight][i].replace(6, 7, WEB);
        }
        if (exitPortal.get(i))
        {
            buildingString[Data.getMaxHeight() - currentHeight][i] = buildingString[Data.getMaxHeight() - currentHeight][i].replace(7, 8, PORTAL);
        }
    }

    /**
     * Method to graphically fill above & between (building roof & base) in the 2d stringbuilder array
     * @param currentHeight Accepts int which represents the building height the player currently is on
     * @param i Accepts int iterator from 1st for-loop
     * @param j Accepts int iterator from nested for-loop
     * @param leftPosition Accepts int which represents position if player potentially jumps left
     * @param rightPosition Accepts int which represents position if player potentially jumps right
     **/
    private void createUnderAndAbove(int currentHeight, int i, int j, int leftPosition, int rightPosition)
    {
        final String DEFAULT_SIDES = " ┃◫◫◫◫◫◫┃";
        final String JUMP_SIDES =    " ┃∎∎∎∎∎∎┃";
        final String EMPTY_SPACE =   "         ";
        int underBuilding = Data.getMaxHeight() + j + 1;

        if (underBuilding - currentHeight < Data.getMaxHeight())
        {
            if (i == leftPosition || i == rightPosition)
            {
                buildingString[underBuilding - currentHeight][i] = new StringBuilder(JUMP_SIDES);
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