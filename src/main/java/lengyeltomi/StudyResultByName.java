package lengyeltomi;


public class StudyResultByName
{
    String studentName;
    double studyAverage;

    public StudyResultByName(String studentName, double studyAverage)
    {
        this.studentName = studentName;
        this.studyAverage = studyAverage;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public double getStudyAverage()
    {
        return studyAverage;
    }
}