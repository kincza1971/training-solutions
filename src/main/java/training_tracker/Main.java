
package training_tracker;

import java.nio.file.Path;

public class Main {
    static final String DAILYEXTRICEFILENAME = "src/main/java/training_tracker/daily.txt";
    static final String LESSONEXTRICEFILENAME = "src/main/java/training_tracker/lesson.txt";

    public static void main(String[] args) {
        LessonGenerator lessonGenerator = new LessonGenerator();
        lessonGenerator.loadData(Path.of(LESSONEXTRICEFILENAME));
        lessonGenerator.checkExtrices();
        lessonGenerator.generateHTML();

        DailyGenerator dailyGenerator = new DailyGenerator();
        dailyGenerator.loadData(Path.of(DAILYEXTRICEFILENAME));
        dailyGenerator.checkExtrices();
        dailyGenerator.generateHTML();

        DetailGenerator detailGenerator = new DetailGenerator();
        detailGenerator.generateHTML(dailyGenerator.calculatePassed(), dailyGenerator.countAllPackage(), lessonGenerator.calculatePassed(), lessonGenerator.countAllPackage());
    }
}