import java.io.IOException;

public class Jumper
{
    public static void main(String[] args) throws IOException {
        Log log = new Log();
        Count count = new Count();
        State state = new State();
        Input input = new Input(state);
        Position position = new Position(count, state);
        Fuel fuel = new Fuel(count);
        Parse parse = new Parse(fuel, count);
        Frozen frozen = new Frozen();
        Web web = new Web();
        Charge charge = new Charge(count, state);
        FileIO fileIO = new FileIO();
        fileIO.read();
        parse.define(fileIO.getData());
        parse.shuffleOnlyPortal();
        input.usernameInput();

        while (state.isGameRunning())
        {
            web.turnOff(state);
            parse.shuffle();
            web.check(state, parse.getWeb(), position.getCurrentSpot(), log);
            position.set(parse.buildings());
            charge.passiveCheck(position.getCurrentSpot(), fuel.getArray(), log);
            count.setHeight_1(parse.buildings().get(position.getCurrentSpot()));
            frozen.check(state, parse.getFreeze(), position.getCurrentSpot(), log);
            state.exitCheck(position.getCurrentSpot());

            do
            {
                if (state.isGameRunning())
                {
                    Print.clearScreen();
                    Print.chargeAmount(charge.getAmount(), state.isNumbers());
                    Print.frozen(state);
                    Print.web(state);
                    Print.outOfRange(state);
                    Print.fuelRespawning(count.fuelShuffleCheck());
                    Print.fuelCollected(fuel.getArray(), position.getCurrentSpot(), charge.getAmount());
                    Print.graphic(parse, position.getPositions(), state.isNumbers());
                    Print.action(state.isFrozen());

                    fuel.collect(position.getCurrentSpot());
                    input.inputAction();
                    input.action(log, parse.buildings(), position);
                }
            }
            while (state.isOutOfRange() || state.isNumbersLoop());

            frozen.turningOff(state, position.getCurrentSpot());
            count.setHeight_2(parse.buildings().get(position.getCurrentSpot()));
            charge.activeCheck(position.getCurrentSpot(), fuel.getArray(), log);
        }

        Print.exit(charge.getAmount(), input.getName(), state.isExit(), state.isWebbed());
        fileIO.write(log.display(), input.getName());
    }
}