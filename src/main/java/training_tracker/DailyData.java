
package training_tracker;

import java.util.Objects;

public class DailyData {
    private final String packageName;
    private boolean exist;

    public DailyData(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageName() {
        return packageName;
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
        DailyData dailyData = (DailyData) o;
        return Objects.equals(packageName, dailyData.packageName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packageName);
    }
}