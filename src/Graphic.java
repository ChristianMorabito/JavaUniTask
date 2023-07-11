import java.util.ArrayList;
import java.util.Arrays;

public class Graphic{

    private String roofPortal = "   ┎─────@┒   ";

    private String roofFuelCell = "   ┎─────$┒   ";
    private String roofWeb = "   ┎######┒   ";
    private String roofFreeze = "   ┎^^^^^^┒   ";
    private String roofClear = "   ┎──────┒   ";
    private String midBuilding = "   │      │   ";
    private String fullSpace = "              ";



    private final String[][] buildingString = new String[6][15];

    private void printFormat(String[][] buildingString){
        for (int i = 0; i < 6; i++){
            String formattedString = Arrays.toString(buildingString[i])
                .replace(",", "")
                .replace("[", "")
                .replace("]", "");
            System.out.println(formattedString);
        }
    }

    public void buildingPrint(ExtractData data) {
        ArrayList<Integer> buildingHeights = data.getBuildingHeight();
        ArrayList<Boolean> exitPortal = data.getExitPortal();
        ArrayList<Boolean> fuelCell = data.getFuelCell();
        ArrayList<Boolean> web = data.getWeb();
        ArrayList<Boolean> freeze = data.getFreeze();

        for (int i = 0; i < buildingString[0].length; i++){ // 0 ... 14, 15

            int maxHeight = buildingString.length-1;
            int currHeight = buildingHeights.get(i);

            String gap = "   ";
            if (i > 0) {
                gap = gap.trim();
            }

            if (exitPortal.get(i)) {
                buildingString[5 - currHeight][i] = roofPortal;
            } else if (fuelCell.get(i)) {
                buildingString[5 - currHeight][i] = roofFuelCell;
            } else if (web.get(i)) {
                buildingString[5 - currHeight][i] = roofWeb;
            } else if (freeze.get(i)) {
                buildingString[5 - currHeight][i] = roofFreeze;
            } else {
                buildingString[5 - currHeight][i] = roofClear;
            }






            buildingString[5][i] = gap + buildingHeights.get(i) + "      │" + "      ";

            for (int j = 0; j < maxHeight-1; j++){ // 1 ... 4, 5
                int underBuilding = maxHeight + j + 1;

                if (underBuilding - currHeight < maxHeight) {
                    buildingString[underBuilding - currHeight][i] = midBuilding;
                }
                else {
                    buildingString[(underBuilding - currHeight) - maxHeight][i] = fullSpace;

                }

            }
        }
        printFormat(buildingString);
    }
}


