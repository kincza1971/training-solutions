package controlselection.week;

public class DayOfWeeks {

    public String dayOlWeek(String day) {
        switch(day.toUpperCase()){
            case "HÉTFŐ":
                return "Hét eleje";
            case "KEDD":
            case "SZERDA":
            case "CSÜTÖRTÖK":
                return "Hét közepe";
            case "PÉNTEK":
                return "Majdnem hétvége";
            case "SZOMBAT":
            case "VASÁRNAP":
                return "Hétvége";
            default:
                throw new IllegalArgumentException("Invalid day " + day);
        }

    }

}

