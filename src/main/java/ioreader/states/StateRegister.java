package ioreader.states;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class StateRegister {

    List<State> states = new ArrayList<>();


    private State createState(String stateName, String capital) {

        return new State(stateName,capital);

    }

    private FileReader createFileReader(String stringFileName) {
        try {
            File file = new File("src/main/resources/"+ stringFileName);
            FileReader fr = new FileReader(file, StandardCharsets.UTF_8);
            return fr;
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file!", e);
        }
    }

    private void processLine(String line) {
        String[] stateData = line.split("-");
        states.add(createState(stateData[0],stateData[1]));
    }

    public State findStateByCapitalName(String capital) {
        for (State state : states) {
            if (state.getStateName().equals(capital)) {
                return state;
            }
        }
        throw new IllegalArgumentException("No state with this name!");
    }

    public String findCapitalByStateName(String stateName) {
        for (State state : states) {
            if (state.getStateName().equals(stateName)) {
                return state.getCapital();
            }
        }
        throw new IllegalArgumentException("No state with this name!");
    }

    public void readStatesFromFile(String stringFileName) {
        FileReader fileReader = createFileReader(stringFileName);
        try (BufferedReader br = new BufferedReader(fileReader) ) {
            String line;
            while ((line = br.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file, " +stringFileName,e);
        }
    }

    public List<State> getStates() {
        return new ArrayList<>(states);
    }


}
