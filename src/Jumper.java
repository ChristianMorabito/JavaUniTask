public class Jumper
{
    public static void main(String[] args)
    {
        Data data = new Data();
        Input input = new Input();
        Position position = new Position();
        FileIO fileIO = new FileIO("buildings.txt");
        fileIO.readFile();
        data.define(fileIO.getData());
        boolean gameLoop = true;
        int exit = 100; // TODO: Make magic numbers in a shared class
        while (gameLoop)
        {
            data.shuffleData();
            int result = -1;
            while (result < 0)
            {

                input.optionInput();
                result = position.move(data, input.getAction());
                new Graphic().createGraphic(data, result);
            }
            if (result == exit)
            {
                gameLoop = false;
            }
        }
        System.out.println("Exiting...");
        //TODO: ORGANISE WRITE RESULTS

    }
}