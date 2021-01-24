package constructoroverloading;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {

    private List<SimpleTime> timeTable = new ArrayList<>();

    public BusTimeTable(List<SimpleTime> timeTable) {
        this.timeTable=timeTable;
    }

    private void CheckParam(int firstHour, int lastHour, int everyMinutes) {
        if(firstHour <0 || firstHour >23) {
            throw new IllegalArgumentException("firstHour (" + firstHour + ") must be between 0 and 23");
        }
        if(lastHour <0 || lastHour >23) {
            throw new IllegalArgumentException("firstHour (" + lastHour + ") must be between 0 and 23");
        }
        if (firstHour <lastHour) {
            throw new IllegalArgumentException("Start our has to be smaller than last hour");
        }
    }


    public BusTimeTable(int firstHour, int lastHour, int everyMinute){
        SimpleTime nextTime = new SimpleTime(firstHour,everyMinute);
        do {
            timeTable.add(nextTime);
            nextTime = new SimpleTime(nextTime.getHours()+1,everyMinute);
        } while (nextTime.getHours() <= lastHour);

    }

    public SimpleTime nextBus(SimpleTime time) {
        for (SimpleTime simpleTime : timeTable) {
            if (simpleTime.difference(time) >0) {
                return simpleTime;
            }
        }
        throw new IllegalStateException("No more buses today!");
    }

    public List<SimpleTime> getTimeTable() {
        return new ArrayList<>(timeTable);
    }
}
