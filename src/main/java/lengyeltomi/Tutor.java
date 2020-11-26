package lengyeltomi;

import java.util.ArrayList;
import java.util.List;

public class Tutor
{
    private String name;
    private List<Subject> taughtSubjects = new ArrayList<>();

    public Tutor(String name, List<Subject> taughtSubjects)
    {
        this.name = name;
        this.taughtSubjects = taughtSubjects;
    }

    public String getName()
    {
        return name;
    }

    public List<Subject> getTaughtSubjects()
    {
        return taughtSubjects;
    }

    public boolean tutorTeachingSubject(Subject subject)
    {
        for (Subject sub : taughtSubjects)
        {
            if (sub.equals(subject))
            {
                return true;
            }
        }
        return false;
    }
}