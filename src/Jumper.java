public class Jumper
{
    public static void main(String[] args)
    {
        Log log = new Log();
        State state = new State();
        Input input = new Input(state);
        Position position = new Position(state);
        Fuel fuel = new Fuel(state);
        Data data = new Data(fuel, state);
        Frozen frozen = new Frozen();
        Web web = new Web();
        ChargeCount chargeCount = new ChargeCount(state);
        FileIO fileIO = new FileIO("buildings.txt");

        fileIO.readFile();
        data.define(fileIO.getData());
        input.usernameInput();

        while (state.isGameRunning())
        {
            web.turningOff(state);
            data.shuffleData();
            web.checking(state, data.getWeb(), position.getCurrPosition());
            position.setPositions(data.getBuildingHeights());
            chargeCount.passiveCheck(position.getCurrPosition(), fuel.getCurrentFuel(), log);
            state.setBuilding1Height(data.getBuildingHeights().get(position.getCurrPosition()));
            frozen.checking(state, data.getFreeze(), position.getCurrPosition());
            do
            {
                if (state.isGameRunning())
                {
                    chargeCount.print();
                    frozen.print(state);
                    web.print(state);
                    position.printIfOutOfRange();
                    fuel.print(position.getCurrPosition());
                    new Graphic().create(data, position.getPositions());
                    fuel.collectFuel(position.getCurrPosition());
                    input.actionInput();
                    position.move(data.getBuildingHeights(), input.getAction(), log);
                }
            }
            while (state.isOutOfRange());
            frozen.turningOff(state);
            state.setBuilding2Height(data.getBuildingHeights().get(position.getCurrPosition()));
            chargeCount.activeCheck(position.getCurrPosition(), fuel.getCurrentFuel(), log);
        }
        state.exitPrint(chargeCount.getAmount(), input.getUserName());
        System.out.println(log.display());




        // PRINT WIN/LOSS STATE. IF LOSS, WERE YOU WEBBED?



        //TODO: ORGANISE WRITE RESULTS
        //TODO: CREATE FREEZE CLASS & WEB CLASS ACCOUNT FOR TEXT, i.e. just like when "Fuel Collected"

    }
}