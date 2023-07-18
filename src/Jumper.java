public class Jumper
{
    public static void main(String[] args)
    {
        Input input = new Input();
        State state = new State();
        Position position = new Position(state);
        Fuel fuel = new Fuel();
        Data data = new Data(fuel);
        FileIO fileIO = new FileIO("buildings.txt");

        fileIO.readFile();
        data.define(fileIO.getData());
        input.usernameInput();

        while (state.isGameRunning())
        {
            data.shuffleData();
            do
            {
                position.setLeftPosition(data.heights());
                position.setRightPosition(data.heights());
                fuel.print(position.getCurrPosition());
                new Graphic().create(data, position.getCurrPosition(), position.getLeftPosition(), position.getRightPosition());
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