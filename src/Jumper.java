public class Jumper
{
    public static void main(String[] args)
    {
        Log log = new Log();
        State state = new State();
        Input input = new Input(state);
        Position position = new Position(state);
        Fuel fuel = new Fuel(state);
        Parse parse = new Parse(fuel, state);
        Frozen frozen = new Frozen();
        Web web = new Web();
        ChargeCount chargeCount = new ChargeCount(state);
        FileIO fileIO = new FileIO("buildings.txt");
        fileIO.readFile();
        parse.define(fileIO.getData());
//        input.usernameInput();

        while (state.isGameRunning())
        {
            web.turningOff(state);
            parse.shuffleData();
            web.checking(state, parse.getWeb(), position.getCurrPosition(), log);
            position.setPositions(parse.getBuildingHeights());
            chargeCount.passiveCheck(position.getCurrPosition(), fuel.getCurrentFuel(), log);
            state.setBuilding1Height(parse.getBuildingHeights().get(position.getCurrPosition()));
            frozen.checking(state, parse.getFreeze(), position.getCurrPosition(), log);
            do
            {
                if (state.isGameRunning())
                {
                    System.out.println(log.display());
                    chargeCount.print();
                    frozen.print(state);
                    web.print(state);
                    position.printIfOutOfRange();
                    fuel.print(position.getCurrPosition(), chargeCount.getAmount());
                    new Graphic().create(parse, position.getPositions());
                    fuel.collectFuel(position.getCurrPosition());
                    input.actionInput();
                    position.move(parse.getBuildingHeights(), input.getAction(), log, parse.getFreeze(), frozen);
                }
            }
            while (state.isOutOfRange());
            frozen.turningOff(state, position.getCurrPosition());
            state.setBuilding2Height(parse.getBuildingHeights().get(position.getCurrPosition()));
            chargeCount.activeCheck(position.getCurrPosition(), fuel.getCurrentFuel(), log);
        }
        System.out.println(log.display());
        state.exitPrint(chargeCount.getAmount(), input.getUserName());




        // PRINT WIN/LOSS STATE. IF LOSS, WERE YOU WEBBED?



        //TODO: ORGANISE WRITE RESULTS
        //TODO: CREATE FREEZE CLASS & WEB CLASS ACCOUNT FOR TEXT, i.e. just like when "Fuel Collected"

    }
}