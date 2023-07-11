import java.util.ArrayList;
import java.util.Arrays;

public class Graphic{

    private String topBuilding = "   ┎──────┒   ";
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
        String gap = "   ";
        for (int i = 0; i < buildingString[0].length; i++){ // 0 ... 14, 15

            int maxHeight = buildingString.length-1;
            int currHeight = buildingHeights.get(i);
            if (i > 0) {
                gap = gap.trim();
            }

            buildingString[5 - currHeight][i] = topBuilding; // fill top of building
            buildingString[5][i] = gap + buildingHeights.get(i) + "      │" + "      ";

            for (int j = 0; j < maxHeight-1; j++){ // 1 ... 4, 5
                int underBuilding = maxHeight + j + 1;

                if (underBuilding - currHeight < maxHeight) {
                    buildingString[underBuilding - currHeight][i] = midBuilding;
                }
                if (underBuilding - currHeight >= maxHeight){
                    buildingString[(underBuilding - currHeight) - maxHeight][i] = fullSpace;

                }

            }
        }
        printFormat(buildingString);
    }
}


