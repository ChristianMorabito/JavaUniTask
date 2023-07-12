public class Conditions {

    private int currentPosition = 0;
    private int fuelAmount;


    public int move(Organise data, int input){

        if (input == 1){
            currentPosition += data.getBuildingHeights().get(currentPosition);
        }
        return getCurrentPosition();

    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
