import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        InputData inputData = new InputData();
        ArrayList<String[]> data = inputData.getData();
        ExtractData ed = new ExtractData();
        ed.defineProperties(data);
        new Graphic().buildingPrint(ed);

    }
}