import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    private ArrayList<String[]> data = new ArrayList<>();

    ReadFile(){

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
        return data;

    }

}
