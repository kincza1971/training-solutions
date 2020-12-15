package ioreader.states;

public class State {
    private final String stateName;
    private final String capital;

    public String getStateName() {
        return stateName;
    }

    public String getCapital() {
        return capital;
    }

    private void checkParams(String stateName, String capital) {
        if (stateName == null || stateName.isBlank()) {
            throw new IllegalArgumentException("State name cannot be null or blank, " + stateName);
        }
        if (stateName == null || stateName.isBlank()) {
            throw new IllegalArgumentException("Capital name cannot be null or blank, " + capital);
        }
    }



    public State(String stateName, String capital) {
        this.stateName = stateName;
        this.capital = capital;
    }
}
