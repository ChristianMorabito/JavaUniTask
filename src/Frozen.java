import java.util.ArrayList;

public class Frozen {

    Frozen() {
    }

    public void checking(State state, ArrayList<Boolean> freeze, int currentPosition) {
        if (freeze.get(currentPosition)) {
            state.setFrozen(true);
        }
    }

    public void turningOff(State state) {
        state.setFrozen(false);
    }

    public void print(State state) {

        if (state.isFrozen()) {
            System.out.println("\uD83D\uDEA8 YOU ARE FROZEN \uD83D\uDEA8");
        }
    }

}
