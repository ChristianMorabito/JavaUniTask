import java.util.ArrayList;

public class Graphic
{
    private StringBuilder[][] buildingString;

    public Graphic()
    {
        this.buildingString = new StringBuilder[Data.getMaxHeight() + 1][Data.getRowLength()];
    }

    Graphic(StringBuilder[][] buildingString)
    {
        this.buildingString = buildingString;
    }

    private void createRoof(Parse parse, int i, int currHeight, int jumperIndex)
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

        buildingString[Data.getMaxHeight() - currHeight][i] = new StringBuilder(ROOF);
        if (i == jumperIndex)
        {
            buildingString[Data.getMaxHeight() - currHeight][i] = buildingString[Data.getMaxHeight() - currHeight][i].replace(2, 3, JUMPER);
        }
        if (fuelCell.get(i))
        {
            buildingString[Data.getMaxHeight() - currHeight][i] = buildingString[Data.getMaxHeight() - currHeight][i].replace(3, 4, FUEL_CELL);
        }
        if (freeze.get(i))
        {
            buildingString[Data.getMaxHeight() - currHeight][i] = buildingString[Data.getMaxHeight() - currHeight][i].replace(4, 6, FREEZE);
        }
        if (web.get(i))
        {
            buildingString[Data.getMaxHeight() - currHeight][i] = buildingString[Data.getMaxHeight() - currHeight][i].replace(6, 7, WEB);
        }
        if (exitPortal.get(i))
        {
            buildingString[Data.getMaxHeight() - currHeight][i] = buildingString[Data.getMaxHeight() - currHeight][i].replace(7, 8, PORTAL);
        }

    }

    public StringBuilder[][] create(Parse parse, int[] positions, boolean numbers)
    {
        int currentPosition = positions[0];
        int leftPosition = positions[1];
        int rightPosition = positions[2];
        ArrayList<Integer> buildingHeights = parse.buildings();

        for (int i = 0; i < Data.getRowLength(); i++)
        {
            int currHeight = buildingHeights.get(i);

            createRoof(parse, i, currHeight, currentPosition);
            createBase(i, currentPosition, leftPosition, rightPosition, numbers, buildingHeights);

            for (int j = 0; j < Data.getMaxHeight() - 1; j++)
            {

                createUnderAndAbove(currHeight, i, j, leftPosition, rightPosition);
            }
        }
        return buildingString;
    }

    private void createUnderAndAbove(int currHeight, int i, int j, int leftPosition, int rightPosition)
    {
        final String DEFAULT_SIDES = " ┃◫◫◫◫◫◫┃";
        final String JUMP_SIDES =    " ┃∎∎∎∎∎∎┃";
        final String EMPTY_SPACE =   "         ";
        int underBuilding = Data.getMaxHeight() + j + 1;

        if (underBuilding - currHeight < Data.getMaxHeight())
        {
            if (i == leftPosition || i == rightPosition)
            {
                buildingString[underBuilding - currHeight][i] = new StringBuilder(JUMP_SIDES);
            }
            else
            {
                buildingString[underBuilding - currHeight][i] = new StringBuilder(DEFAULT_SIDES);
            }
        }
        else
        {
            buildingString[(underBuilding - currHeight) - Data.getMaxHeight()][i] = new StringBuilder(EMPTY_SPACE);
        }
    }
    private void createBase(int i, int currPosition, int leftPosition, int rightPosition, boolean numbers, ArrayList<Integer> heights)
    {
        final String betweenGap = " ";
        String firstGap = " ";
        String buildingSide = "┃";
        String baseText;

        if (i == currPosition)
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
    public StringBuilder[][] getBuildingString()
    {
        return buildingString;
    }
    public void setBuildingString(StringBuilder[][] buildingString)
    {
        this.buildingString = buildingString;
    }
}


