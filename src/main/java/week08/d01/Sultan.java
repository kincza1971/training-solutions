package week08.d01;

import java.util.Arrays;

public class Sultan {
    private OpenClose[] doors;
    private final int NUMBER_OF_DAYS;
    private final int NUMBER_OF_DOORS;


    private String getResult() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i< NUMBER_OF_DOORS; i++) {
            if(doors[i].equals(OpenClose.OPEN)){
                result.append(Integer.toString(i+1)+ ", ");
            }
        }
        return  result.substring(0, result.length()-2);
    }

    private void changeDoors(int i) {
        for (int j = i-1; j<NUMBER_OF_DOORS; j+=i) {
            doors[j] = OpenClose.change(doors[j]);
        }
    }

    public String  openDoors() {
        for (int i = 1; i <= NUMBER_OF_DAYS; i++) {
            changeDoors(i);
        }
        return getResult();
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i= 0; i<NUMBER_OF_DOORS;i++) {
            result.append(Integer.toString(i) + ". door: " +doors[i].name()+"\n");
        }
        return result.toString();
    }


    private void init() {
        doors = new OpenClose[NUMBER_OF_DOORS];
        for (int i = 0; i < NUMBER_OF_DOORS; i++) {
            doors[i] = OpenClose.CLOSE;
        }
    }

    public OpenClose[] getDoors() {
        return doors.clone();
    }

    public Sultan() {
        NUMBER_OF_DAYS = 100;
        NUMBER_OF_DOORS = 100;
        init();
    }

    private void checkParams(int numberOfDays, int numberOfDoors) {
        if (numberOfDays<1 || numberOfDoors <1) {
            throw new IllegalArgumentException(
                    "A napok és az ajtók száma csak 0-nál nagyobb lehet (" + numberOfDays + ", " + numberOfDoors+ ")"
            );
        }
    }

    public Sultan(int numberOfDays, int numberOfDoors) {
        checkParams(numberOfDays,numberOfDoors);
        NUMBER_OF_DOORS = numberOfDoors;
        NUMBER_OF_DAYS = numberOfDays;
        init();
    }

}
