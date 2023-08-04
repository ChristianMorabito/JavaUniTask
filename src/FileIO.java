import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for reading the game txt file & writing the output txt file.
 * @author Christian Morabito
 * @version ver1.0.0
 */

public class FileIO
{

    /**
     * Reads file, parses data to 2d arraylist (string)
     * & sets Data fields: maxHeight & rowLength
     * @return returns the data arraylist (2d String)
     */
    public static ArrayList<String[]> read(String fileName)
    {
        ArrayList<String[]> data = new ArrayList<>();
        int maxHeight = 0;
        int i = 0;
        try
        {
            FileReader reader = new FileReader(fileName);
            try
            {
                Scanner fileInput = new Scanner(reader);
                while (fileInput.hasNextLine())
                {
                    data.add(fileInput.next().split(","));
                    maxHeight = Math.max(Validation.stringToInteger(data.get(i)[0]), maxHeight);
                    i++;
                }
            }
            finally
            {
                try
                {
                    reader.close();
                }
                catch (Exception exception)
                {
                    System.out.println("Error in closing file!! Exiting...");
                    System.exit(-1);
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Error in Reading file!! Exiting...");
            System.exit(-1);
        }

        Values.setMaxHeight(maxHeight);
        Values.setRowLength(data.size());
        Validation.rowLengthCheck();
        return data;
    }

    public static void write(String writeData, String username)
    {
        try
        {
            FileWriter fileWriter = new FileWriter(Values.WRITE_FILE);
            fileWriter.write("___" + username + "'s Gameplay Statistics___\n");
            fileWriter.write(writeData);
            try
            {
                fileWriter.close();
            }
            catch (Exception exception)
            {
                System.out.println("Error in closing file!! Exiting...");
                System.exit(-1);
            }
        }
        catch (IOException ioException)
        {
            System.out.println("Error writing file!!");
            System.exit(-1);
        }
    }
}

