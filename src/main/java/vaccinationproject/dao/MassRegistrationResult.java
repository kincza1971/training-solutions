package vaccinationproject.dao;

import java.util.List;

public class MassRegistrationResult {
    private final long lineCounter;
    private final long insertedLineCounter;
    private final int errorCounter;
    private final List<String> wrongLines;

    public MassRegistrationResult(long lineCounter, List<String> wrongLines) {
        this.lineCounter = lineCounter - 1;
        if (wrongLines.size() > 0) {
            this.errorCounter = wrongLines.size() - 1;
        } else {
            this.errorCounter = 0;
        }
        this.insertedLineCounter = lineCounter - wrongLines.size();
        this.wrongLines = wrongLines;
    }

    public long getLineCounter() {
        return lineCounter;
    }

    public long getInsertedLineCounter() {
        return insertedLineCounter;
    }

    public int getErrorCounter() {
        return errorCounter;
    }

    public List<String> getWrongLines() {
        return wrongLines;
    }
}
