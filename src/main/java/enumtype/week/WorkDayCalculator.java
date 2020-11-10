package enumtype.week;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

public class WorkDayCalculator {

    private Day nextDay(Day day) {
        Day result;
        if (day.ordinal()==6) {
            result= Day.HÉTFŐ;
        } else {
            result =  Day.values()[day.ordinal()+1];
        }
        return result;
    }

    public List<DayType> dayTypes(Day firstDay, int numberOfDays) {
        List<DayType> result = new ArrayList<>();
        Day aDay = firstDay;
        int index =firstDay.ordinal();
        for (int i=0;i<numberOfDays;i++) {
            aDay = nextDay(aDay);
        }
        result.add(aDay.getDayType());
        return result;
    }

    public static void main(String[] args) {
        WorkDayCalculator wdc = new WorkDayCalculator();
        Day aDay = Day.KEDD;
        System.out.println(wdc.dayTypes(aDay,18).get(0).name());
    }
}
