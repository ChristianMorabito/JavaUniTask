public class CharacterPosition {

    private Integer currentPosition = 0;

    public int move(ParsedData data, int input){
        int endIndex = data.getBuildingHeights().size() - 1;
        int startIndex = 0;
        int temp = currentPosition;

        if (input == 1){
            temp += data.getBuildingHeights().get(currentPosition);
            if (temp < endIndex){
                currentPosition = temp;
            }
            else if (temp == endIndex){
                System.out.println("On last index!!"); // TODO: consider if character lands on FROZEN exit portal
            }
            else{
                System.out.println("Out of range!!");
                return -1;
            }
        }

        else if (input == 2){
            temp -= data.getBuildingHeights().get(currentPosition);
            if (temp >= startIndex){
                currentPosition = temp;
            }
            else{
                System.out.println("Out of range!!");
                return -1;
            }
        }

        else if (input == 4){
            return 100;
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
