import java.util.ArrayList;
import java.util.Arrays;

public class Graphic
{
    private StringBuilder[][] buildingString;

    Graphic()
    {
        this.buildingString = new StringBuilder[6][15];
    }

    Graphic(StringBuilder[][] buildingString)
    {
        this.buildingString = buildingString;
    }

    private void print()
    {
        for (int i = 0; i < 6; i++)
        {
            String formattedString = Arrays.toString(buildingString[i])
                .replace(",", "")
                .replace("[", "")
                .replace("]", "");
            System.out.println(formattedString);
        }
    }

    private void createRoof(Data data, int i, int currHeight, int jumperIndex)
    {
        final String PORTAL = "@";
        final String JUMPER =    "█";
        final String FUEL_CELL = "$";
        final String WEB = "##";
        final String FREEZE = "^^^";
        final String ROOF = " ┎────────┒ ";
        ArrayList<Boolean> exitPortal = data.getExitPortals();
        ArrayList<Boolean> fuelCell = data.getFuel().getCurrentFuel();
        ArrayList<Boolean> web = data.getWeb();
        ArrayList<Boolean> freeze = data.getFreeze();

        buildingString[5 - currHeight][i] = new StringBuilder(ROOF);
        if (i == jumperIndex)
        {
            buildingString[5 - currHeight][i] = buildingString[5 - currHeight][i].replace(2, 3, JUMPER);
        }
        if (fuelCell.get(i))
        {
            buildingString[5 - currHeight][i] = buildingString[5 - currHeight][i].replace(3, 4, FUEL_CELL);
        }
        if (freeze.get(i))
        {
            buildingString[5 - currHeight][i] = buildingString[5 - currHeight][i].replace(4, 7, FREEZE);
        }
        if (web.get(i))
        {
            buildingString[5 - currHeight][i] = buildingString[5 - currHeight][i].replace(7, 9, WEB);
        }
        if (exitPortal.get(i))
        {
            buildingString[5 - currHeight][i] = buildingString[5 - currHeight][i].replace(9, 10, PORTAL);
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
        buildingString[5][i] = new StringBuilder(firstGap + buildingHeights.get(i) + baseText + buildingWidth + buildingSide + betweenGap);
    }

    private void createUnderAndAbove(int maxHeight, int currHeight, int i, int j, int leftPosition, int rightPosition)
    {
        final String DEFAULT_SIDES = " │◫◫◫◫◫◫◫◫│ ";
        final String JUMP_SIDES =    " ╹∎∎∎∎∎∎∎∎╹ ";
        final String EMPTY_SPACE =   "            ";
        int underBuilding = maxHeight + j + 1;

        if (underBuilding - currHeight < maxHeight)
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
            buildingString[(underBuilding - currHeight) - maxHeight][i] = new StringBuilder(EMPTY_SPACE);
        }
    }

    public void create(Data data, int[] positions)
    {
        int currentPosition = positions[0];
        int leftPosition = positions[1];
        int rightPosition = positions[2];
        ArrayList<Integer> buildingHeights = data.getBuildingHeights();

        for (int i = 0; i < buildingString[0].length; i++)
        {

            int maxHeight = buildingString.length-1;
            int currHeight = buildingHeights.get(i);

            createRoof(data, i, currHeight, currentPosition);
            createBase(buildingHeights, i, currentPosition, leftPosition, rightPosition);

            for (int j = 0; j < maxHeight-1; j++)
            {

                createUnderAndAbove(maxHeight, currHeight, i, j, leftPosition, rightPosition);
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


