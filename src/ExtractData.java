import java.util.ArrayList;
import java.util.Arrays;

public class ExtractData {
    private ArrayList<Integer> buildingHeight;
    private ArrayList<Boolean> exitPortal;
    private ArrayList<Boolean> fuelCell;
    private ArrayList<Boolean> web;
    private ArrayList<Boolean> freeze;

    public ExtractData(){
        this.buildingHeight = new ArrayList<>();
        this.exitPortal = new ArrayList<>();
        this.fuelCell = new ArrayList<>();
        this.web = new ArrayList<>();
        this.freeze = new ArrayList<>();
    }

    public void defineProperties(ArrayList<String[]> data){
        for (String[] datum : data) {
            this.buildingHeight.add(Integer.parseInt(datum[0]));
            this.exitPortal.add(Boolean.parseBoolean(datum[1]));
            this.fuelCell.add(Boolean.parseBoolean(datum[2]));
            this.web.add(Boolean.parseBoolean(datum[3]));
            this.freeze.add(Boolean.parseBoolean(datum[4]));
        }
    }

    public void random() {
        String[][] str = new String[15][5];
        for (int i = 0; i < 15; i++){
            for (int j = 0; j < 5; j++){
                str[i][j] = "X";
            }
        }
        System.out.println(Arrays.deepToString(str));
    }
}

