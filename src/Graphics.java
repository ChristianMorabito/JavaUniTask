import java.util.ArrayList;
import java.util.Arrays;

public class Graphics {

    private String roofPortal = "@";

    private String jumper = "║";

    private String roofFuelCell = "$";
    private String roofWeb = "###";
    private String roofFreeze = "^^^";
    private String roofClear = "   ┎────────┒   ";
    private String midBuilding = "   │        │   ";
    private String fullSpace = "                ";

    private StringBuilder[][] buildingString = new StringBuilder[6][15];

    private void printFormat(StringBuilder[][] buildingString){
        for (int i = 0; i < 6; i++){
            String formattedString = Arrays.toString(buildingString[i])
                .replace(",", "")
                .replace("[", "")
                .replace("]", "");
            System.out.println(formattedString);
        }
    }

    public void buildingPrint(Organise data, int jumperIndex) {
        ArrayList<Integer> buildingHeights = data.getBuildingHeights();
        ArrayList<Boolean> exitPortal = data.getExitPortals();
        ArrayList<Boolean> fuelCell = data.getFuelCells();
        ArrayList<Boolean> web = data.getWeb();
        ArrayList<Boolean> freeze = data.getFreeze();

        for (int i = 0; i < buildingString[0].length; i++){ // 0 ... 14, 15

            int maxHeight = buildingString.length-1;
            int currHeight = buildingHeights.get(i);

            buildingString[5 - currHeight][i] = new StringBuilder(roofClear);

            if (i == jumperIndex){
                buildingString[5 - currHeight][i] = buildingString[5 - currHeight][i].replace(4, 5, jumper);
            }
            if (exitPortal.get(i)) {
                buildingString[5 - currHeight][i] = buildingString[5 - currHeight][i].replace(11, 12, roofPortal);
            }
            if (fuelCell.get(i)) {
                buildingString[5 - currHeight][i] = buildingString[5 - currHeight][i].replace(11, 12, roofFuelCell);
            }
            if (web.get(i)) {
                buildingString[5 - currHeight][i] = buildingString[5 - currHeight][i].replace(8, 11, roofWeb);
            }
            if (freeze.get(i)) {
                buildingString[5 - currHeight][i] = buildingString[5 - currHeight][i].replace(5, 8, roofFreeze);
            }

            String gap = "   ";
            if (i > 0) {
                gap = gap.trim();
            }
            buildingString[5][i] = new StringBuilder(gap + buildingHeights.get(i) + "        │" + "      ");

            for (int j = 0; j < maxHeight-1; j++){ // 1 ... 4, 5
                int underBuilding = maxHeight + j + 1;

                if (underBuilding - currHeight < maxHeight) {
                    buildingString[underBuilding - currHeight][i] = new StringBuilder(midBuilding);
                }
                else {
                    buildingString[(underBuilding - currHeight) - maxHeight][i] = new StringBuilder(fullSpace);
                }
            }
        }
        printFormat(buildingString);
    }
}


