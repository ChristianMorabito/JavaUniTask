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
    private ArrayList<String[]> data;

    /**
     * Default constructor which creates the FiloIO object.
     */

    public FileIO()
    {
        data = new ArrayList<String[]>();
    }

    /**
     * Non-default constructor which creates the FiloIO object.
     * @param data Accepts 2d arraylist (String) to store the 'data' field
     */
    public FileIO(ArrayList<String[]> data)
    {
        this.data = data;
    }

    /**
     * Accessor method for mutator
     * @return Returns 2d arraylist (string)
     */
    public ArrayList<String[]> getData()
    {
        return data;
    }

    /**
     * Reads file, parses data to 2d arraylist (string)
     * & sets Data fields: maxHeight & rowLength
     */
    public void read()
    {
        int maxHeight = 0;
        int i = 0;
        FileReader reader;
        try
        {
            reader = new FileReader(Data.READ_FILE_NAME);
            Scanner fileInput = new Scanner(reader);

            while (fileInput.hasNextLine())
            {
                data.add(fileInput.next().split(","));
                maxHeight = Math.max(Validation.stringToInteger(data.get(i)[0]), maxHeight);
                i++;
            }
            reader.close();
        }
        catch (RuntimeException | IOException e)
        {
            System.out.println("File error!! Exiting...");
            System.exit(-1);
            throw new RuntimeException(e);
        }

        Data.setMaxHeight(maxHeight);
        Data.setRowLength(data.size());
        Validation.rowLengthCheck();
    }

    /**
     * Mutator method to set data field (2d arraylist (string))
     *
     */
    public void setData(ArrayList<String[]> data)
    {
        this.data = data;
    }

    /**
     * Writes text file
     * @param writeData Accepts string data to be written
     * @param username Accepts string username to be written
     */
    public void write(String writeData, String username)
    {
        FileWriter fileWriter;
        try
        {
            fileWriter = new FileWriter(Data.WRITE_FILE_NAME);
            fileWriter.write("___" + username + "'s Gameplay Statistics___\n");
            fileWriter.write(writeData);
            fileWriter.close();
        }
        catch (IOException e)
        {
            System.out.println("Error writing file!!");
            throw new RuntimeException(e);
        }
    }
}
