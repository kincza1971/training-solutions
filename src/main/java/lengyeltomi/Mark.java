package lengyeltomi;

public class Mark
{
    MarkType markType;
    Subject  subject;
    Tutor    tutor;

    public Mark(MarkType markType, Subject subject, Tutor tutor)
    {
        if (subject == null || tutor == null)
        {
            throw new NullPointerException("Both subject and tutor must be provided!");
        }
        this.markType = markType;
        this.subject  = subject;
        this.tutor    = tutor;
    }

    public MarkType getMarkType()
    {
        return markType;
    }

    public Subject getSubject()
    {
        return subject;
    }

    public Tutor getTutor()
    {
        return tutor;
    }

    public String toString()
    {
        return markType.getDescription() + "(" + markType.getValues() + ")";
    }
}