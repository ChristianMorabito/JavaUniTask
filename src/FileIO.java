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
     * @param data Accepts array list (String) to store the 'data' field
     */
    public FileIO(ArrayList<String[]> data)
    {
        this.data = data;
    }

    /**
     * Accessor method for mutator
     * @return
     */
    public ArrayList<String[]> getData()
    {
        return data;
    }


    public void read() throws FileNotFoundException
    {
        FileReader reader = new FileReader(Data.READ_FILE_NAME);
        Scanner fileInput = new Scanner(reader);
        int maxHeight = 0;
        int i = 0;
        try
        {
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
            catch (Exception FileNotFoundException)
            {
                System.out.println("Reading file error!! Exiting...");
                System.exit(-1);
            }
        }

        Data.setMaxHeight(maxHeight);
        Data.setRowLength(data.size());
        Validation.rowLengthCheck();
    }

    public void setData(ArrayList<String[]> data)
    {
        this.data = data;
    }

    public void write(String writeData, String username) throws IOException
    {
        FileWriter fileWriter = new FileWriter(Data.WRITE_FILE_NAME);
        try
        {
            fileWriter.write("___" + username + "'s Gameplay Statistics___\n");
            fileWriter.write(writeData);
        }
        finally
        {
            try
            {
                fileWriter.close();
            }
            catch (Exception e)
            {
                System.out.println("Error in closing file! Exiting...");
            }
        }
    }
}
