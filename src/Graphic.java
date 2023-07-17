import java.util.ArrayList;
import java.util.Arrays;

public class Graphic
{

    private StringBuilder[][] buildingString = new StringBuilder[6][15];

    private void print(StringBuilder[][] buildingString)
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
        final String JUMPER = "X";
        final String FUEL_CELL = "$";
        final String WEB = "###";
        final String FREEZE = "^^^";
        final String ROOF = "   ┎────────┒   ";
        ArrayList<Boolean> exitPortal = data.getExitPortals();
        ArrayList<Boolean> fuelCell = data.getFuelCells();
        ArrayList<Boolean> web = data.getWeb();
        ArrayList<Boolean> freeze = data.getFreeze();

        buildingString[5 - currHeight][i] = new StringBuilder(ROOF);
        if (i == jumperIndex)
        {
            buildingString[5 - currHeight][i] = buildingString[5 - currHeight][i].replace(4, 5, JUMPER);
        }
        if (exitPortal.get(i))
        {
            buildingString[5 - currHeight][i] = buildingString[5 - currHeight][i].replace(11, 12, PORTAL);
        }
        if (fuelCell.get(i))
        {
            buildingString[5 - currHeight][i] = buildingString[5 - currHeight][i].replace(11, 12, FUEL_CELL);
        }
        if (web.get(i))
        {
            buildingString[5 - currHeight][i] = buildingString[5 - currHeight][i].replace(8, 11, WEB);
        }
        if (freeze.get(i))
        {
            buildingString[5 - currHeight][i] = buildingString[5 - currHeight][i].replace(5, 8, FREEZE);
        }

    }

    private void createBase(ArrayList<Integer> buildingHeights, int i)
    {
        String gap = "   ";
        if (i > 0)
        {
            gap = gap.trim();
        }
        buildingString[5][i] = new StringBuilder(gap + buildingHeights.get(i) + "        │" + "      ");
    }

    private void createUnderAndAbove(int maxHeight, int currHeight, int i, int j)
    {
        final String BUILDING_SIDES = "   │        │   ";
        final String EMPTY_SPACE = "                ";
        int underBuilding = maxHeight + j + 1;

        if (underBuilding - currHeight < maxHeight)
        {
            buildingString[underBuilding - currHeight][i] = new StringBuilder(BUILDING_SIDES);
        }
        else
        {
            buildingString[(underBuilding - currHeight) - maxHeight][i] = new StringBuilder(EMPTY_SPACE);
        }
    }

    public void createGraphic(Data data, int jumperIndex)
    {
        ArrayList<Integer> buildingHeights = data.getBuildingHeights();

        for (int i = 0; i < buildingString[0].length; i++)
        {

            int maxHeight = buildingString.length-1;
            int currHeight = buildingHeights.get(i);

            createRoof(data, i, currHeight, jumperIndex);
            createBase(buildingHeights, i);

            for (int j = 0; j < maxHeight-1; j++)
            { // 1 ... 4, 5

                createUnderAndAbove(maxHeight, currHeight, i, j);
            }
        }
        print(buildingString);
    }
}


