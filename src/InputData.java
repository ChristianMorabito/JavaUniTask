import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class InputData {
    private ArrayList<String[]> data = new ArrayList<>();

    InputData(){

        try {
            File textFile = new File("buildings.txt");
            Scanner scanner = new Scanner(textFile);
            while (scanner.hasNextLine()){
                data.add(scanner.next().split(","));
            }
            scanner.close();
        }
        catch (FileNotFoundException exception) {
            System.out.println("Reading file error!! Exiting...");
            System.exit(-1);
        }
    }
    public ArrayList<String[]> getData(){
        int subListLength = data.size()-1;
        Collections.shuffle(data.subList(0, subListLength));
        return data;

    }

}
