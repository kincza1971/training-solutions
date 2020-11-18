package schoolrecords;

public class Mark {
    private MarkType markType;
    private Subject subject;
    private Tutor tutor;

    @Override
    public String toString() {
        return markType.getDescription()+"(" + markType.getValue() + ")" ;
    }

    public MarkType getMarkType() {
        return markType;
    }

    public Subject getSubject() {
        return subject;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public Mark(MarkType markType, Subject subject, Tutor tutor) {
        if (markType == null) {
            throw new NullPointerException("Both subject and tutor must be provided!");
        }
        this.markType = markType;
        if (subject == null) {
            throw new NullPointerException("Both subject and tutor must be provided!");
        }
        this.subject = subject;
        if (tutor == null) {
            throw new NullPointerException("Both subject and tutor must be provided!");
        }
        this.tutor = tutor;
    }

    public Mark(String markType, Subject subject, Tutor tutor) {
        MarkType mt = MarkType.A;
        mt = mt.getMarkTypeByName(markType);
        this.markType = mt;
        this.subject = subject;
        this.tutor = tutor;
    }
}
