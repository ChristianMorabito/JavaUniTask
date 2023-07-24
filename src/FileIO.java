import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO
{
    private ArrayList<String[]> data;
    private File textFile;
    private String fileName;

    public FileIO(Data data)
    {
        this.data = new ArrayList<>();
        this.fileName = "Empty file name";
        this.textFile = new File(fileName);
    }

    public FileIO(String fileName)
    {
        this.data = new ArrayList<>();
        this.fileName = fileName;
        this.textFile = new File(fileName);
    }

    public ArrayList<String[]> getData()
    {
        return data;
    }

    public File getTextFile()
    {
        return textFile;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void readFile()
    {
        try
        {
            Scanner scanner = new Scanner(textFile);
            while (scanner.hasNextLine())
            {
                data.add(scanner.next().split(","));
            }
            scanner.close();
        }
        catch (FileNotFoundException exception)
        {
            System.out.println("Reading file error!! Exiting...");
            System.exit(-1);
        }
    }

    public void setData(ArrayList<String[]> data)
    {
        this.data = data;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public void setTextFile(File textFile)
    {
        this.textFile = textFile;
    }
}
