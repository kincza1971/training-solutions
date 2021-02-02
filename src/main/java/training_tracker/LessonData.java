package training_tracker;

import java.util.Objects;

public class LessonData {
    private final String packageName;
    private final String description;
    private boolean exist;

    public LessonData(String packageName, String description) {
        this.packageName = packageName;
        this.description = description;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getDescription() {
        return description;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LessonData that = (LessonData) o;
        return Objects.equals(packageName, that.packageName) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packageName, description);
    }
}