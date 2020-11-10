package emuntype.week;

public enum Day {
    HÉTFŐ(DayType.WORKDAY), KEDD(DayType.WORKDAY), SZERDA(DayType.WORKDAY), CSÜTÖRTÖK(DayType.WORKDAY),
    PÉNTEK(DayType.WORKDAY),SZOMBAT(DayType.WEEKEND), VASÁRNAP(DayType.WEEKEND);

    private DayType dayType;

    Day(DayType dayType) {
        this.dayType = dayType;
    }

    public DayType getDayType() {
        return dayType;
    }
}
