public class Jumper
{
    public static void main(String[] args)
    {
        Input input = new Input();
        State state = new State();
        Position position = new Position(state);
        Fuel fuel = new Fuel(state);
        Data data = new Data(fuel, state);
        FileIO fileIO = new FileIO("buildings.txt");

        fileIO.readFile();
        data.define(fileIO.getData());
        input.usernameInput();

        while (state.isGameRunning())
        {
            data.shuffleData();
            position.setPositions(data.heights());
            do
            {
                fuel.print(position.getCurrPosition());
                new Graphic().create(data, position.getPositions());
                fuel.collectFuel(position.getCurrPosition());
                input.actionInput();
                position.move(data.heights(), input.getAction());
            }
            while (state.isOutOfRange());
        }



        //TODO: ORGANISE WRITE RESULTS
        //TODO: CREATE FREEZE CLASS & WEB CLASS ACCOUNT FOR TEXT, i.e. just like when "Fuel Collected"

    }
}