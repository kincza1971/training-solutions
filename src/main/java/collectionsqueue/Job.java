package collectionsqueue;

public class Job implements Comparable<Job> {

    private final int priority; // 1..10
    private final String jobDescription;
    private boolean urgent;

    public Job(int priority, String jobDescription) {
        if (priority < 1 || priority > 10) {
            throw new IllegalArgumentException("Priority has to be between 1 and 10");
        }
        this.priority = priority;
        this.jobDescription = jobDescription;
        if (priority < 5) {
            urgent = true;
        }
    }

    public int getPriority() {
        return priority;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    @Override
    public int compareTo(Job o) {
        return getPriority() - o.getPriority(); //lower number = higher priority
    }


}
