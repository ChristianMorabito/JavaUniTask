import java.util.ArrayList;
import java.util.Arrays;

public class Graphic
{
    private StringBuilder[][] buildingString;

    public Graphic()
    {
        this.buildingString = new StringBuilder[Data.MAX_HEIGHT + 1][Data.ROW_LENGTH];
    }

    Graphic(StringBuilder[][] buildingString)
    {
        this.buildingString = buildingString;
    }

    private void print()
    {
        System.out.println();
        for (int i = 0; i < Data.MAX_HEIGHT + 1; i++)
        {
            String formattedString = Arrays.toString(buildingString[i])
                .replace(",", "")
                .replace("[", "")
                .replace("]", "");
            System.out.println(formattedString);
        }
    }

    private void createRoof(Parse parse, int i, int currHeight, int jumperIndex)
    {
        final String PORTAL = "@";
        final String JUMPER =    "█";
        final String FUEL_CELL = "$";
        final String WEB = "##";
        final String FREEZE = "^^^";
        final String ROOF = " ┎────────┒ ";
        ArrayList<Boolean> exitPortal = parse.getExitPortals();
        ArrayList<Boolean> fuelCell = parse.getFuel().getCurrentFuel();
        ArrayList<Boolean> web = parse.getWeb();
        ArrayList<Boolean> freeze = parse.getFreeze();

        buildingString[Data.MAX_HEIGHT - currHeight][i] = new StringBuilder(ROOF);
        if (i == jumperIndex)
        {
            buildingString[Data.MAX_HEIGHT - currHeight][i] = buildingString[Data.MAX_HEIGHT - currHeight][i].replace(2, 3, JUMPER);
        }
        if (fuelCell.get(i))
        {
            buildingString[Data.MAX_HEIGHT - currHeight][i] = buildingString[Data.MAX_HEIGHT - currHeight][i].replace(3, 4, FUEL_CELL);
        }
        if (freeze.get(i))
        {
            buildingString[Data.MAX_HEIGHT - currHeight][i] = buildingString[Data.MAX_HEIGHT - currHeight][i].replace(4, 7, FREEZE);
        }
        if (web.get(i))
        {
            buildingString[Data.MAX_HEIGHT - currHeight][i] = buildingString[Data.MAX_HEIGHT - currHeight][i].replace(7, 9, WEB);
        }
        if (exitPortal.get(i))
        {
            buildingString[Data.MAX_HEIGHT - currHeight][i] = buildingString[Data.MAX_HEIGHT - currHeight][i].replace(9, 10, PORTAL);
        }

    }

    private void createBase(ArrayList<Integer> buildingHeights, int i, int currPosition, int leftPosition, int rightPosition)
    {
        final String here =  "..HERE..";
        final String jumpTo = "  ↑↑↑↑  ";
        final String betweenGap = "  ";
        String buildingWidth = "        ";
        String firstGap = " ";
        String buildingSide = "│";
        String baseText;

        if (i == currPosition)
        {
            baseText = here;
        }

        else if (i == leftPosition || i == rightPosition)
        {
            baseText = jumpTo;
            buildingSide = "╹";
        }

        else
        {
            baseText = "";
        }

        buildingWidth = i == currPosition || i == leftPosition || i == rightPosition ? "" : buildingWidth;
        firstGap = i > 0 ? firstGap.trim() : firstGap;
        buildingString[Data.MAX_HEIGHT][i] = new StringBuilder(firstGap +
                                                               buildingHeights.get(i) +
                                                               baseText +
                                                               buildingWidth +
                                                               buildingSide +
                                                               betweenGap);
    }

    private void createUnderAndAbove(int currHeight, int i, int j, int leftPosition, int rightPosition)
    {
        final String DEFAULT_SIDES = " │◫◫◫◫◫◫◫◫│ ";
        final String JUMP_SIDES =    " ╹∎∎∎∎∎∎∎∎╹ ";
        final String EMPTY_SPACE =   "            ";
        int underBuilding = Data.MAX_HEIGHT + j + 1;

        if (underBuilding - currHeight < Data.MAX_HEIGHT)
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
            buildingString[(underBuilding - currHeight) - Data.MAX_HEIGHT][i] = new StringBuilder(EMPTY_SPACE);
        }
    }

    public void create(Parse parse, int[] positions)
    {
        int currentPosition = positions[0];
        int leftPosition = positions[1];
        int rightPosition = positions[2];
        ArrayList<Integer> buildingHeights = parse.getBuildingHeights();

        for (int i = 0; i < Data.ROW_LENGTH; i++)
        {

            int currHeight = buildingHeights.get(i);

            createRoof(parse, i, currHeight, currentPosition);
            createBase(buildingHeights, i, currentPosition, leftPosition, rightPosition);

            for (int j = 0; j < Data.MAX_HEIGHT - 1; j++)
            {

                createUnderAndAbove(currHeight, i, j, leftPosition, rightPosition);
            }
        }
        print();
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


