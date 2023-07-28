import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO
{
    private ArrayList<String[]> data;

    public FileIO()
    {
        data = new ArrayList<String[]>();
    }

    public FileIO(ArrayList<String[]> data)
    {
        this.data = data;
    }

    public ArrayList<String[]> getData()
    {
        return data;
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

    public void read() throws FileNotFoundException {
        FileReader reader = new FileReader(Data.READ_FILE_NAME);
        Scanner fileInput = new Scanner(reader);
        int maxHeight = 0;
        int i = 0;
        try
        {
            while (fileInput.hasNextLine())
            {
                data.add(fileInput.next().split(","));
                maxHeight = Math.max(Integer.parseInt(data.get(i)[0]), maxHeight);
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


    }


}
