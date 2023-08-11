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
     * Default constructor for FileIO class
     */
    public FileIO()
    {
    }

    /**
     * Static method that reads file, parses data to 2d arraylist (string).
     * & sets Values fields: maxHeight & rowLength. Also, validates row lengths.
     * @return returns the data arraylist (2d String)
     */
    public static ArrayList<String[]> read(String fileName)
    {
        ArrayList<String[]> data = new ArrayList<>();
        try
        {
            FileReader reader = new FileReader(fileName);
            try
            {
                Scanner fileInput = new Scanner(reader);
                while (fileInput.hasNextLine())
                {
                    data.add(fileInput.next().split(","));
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

        return data;
    }

    /**
     * Static method that writes text file.
     * @param fileName accepts string representing the file's name
     * @param writeData accepts string data that is to be written to file
     * @param username accepts string data, username, which is also be to written in file.
     */
    public static void write(String fileName, String writeData, String username)
    {
        try
        {
            FileWriter fileWriter = new FileWriter(fileName);
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

