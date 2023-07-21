public class Jumper
{
    public static void main(String[] args)
    {
        Input input = new Input();
        State state = new State();
        Position position = new Position(state);
        Fuel fuel = new Fuel(state);
        Data data = new Data(fuel, state);
        ChargeCount chargeCount = new ChargeCount(state);
        FileIO fileIO = new FileIO("buildings.txt");

        fileIO.readFile();
        data.define(fileIO.getData());
//        input.usernameInput();

        while (state.isGameRunning())
        {
            state.setBuilding1Height(data.getBuildingHeights().get(position.getCurrPosition()));
            data.shuffleData();
            position.setPositions(data.getBuildingHeights());
            chargeCount.update(position.getCurrPosition(), fuel.getCurrentFuel());
            state.setBuilding2Height(data.getBuildingHeights().get(position.getCurrPosition()));
            do
            {
                chargeCount.print();
                fuel.print(position.getCurrPosition());
                new Graphic().create(data, position.getPositions());
                fuel.collectFuel(position.getCurrPosition());
                input.actionInput();
                position.move(data.getBuildingHeights(), input.getAction());
            }
            while (state.isOutOfRange());
            //TODO: figure out elegant exit solution that doesn't mess with score
        }



        //TODO: ORGANISE WRITE RESULTS
        //TODO: CREATE FREEZE CLASS & WEB CLASS ACCOUNT FOR TEXT, i.e. just like when "Fuel Collected"

    }
}