package interfaces.simplethread;

import com.sun.source.tree.DoWhileLoopTree;
import typeconversion.whichtype.WhichType;

import java.util.List;

public class SimpleThread implements Runnable{

    List<String> tasks;

    private boolean nextStep() {
        if (tasks.size() >0) {
//            System.out.println(tasks.get(tasks.size()-1));
            tasks.remove(tasks.size() - 1);
            return tasks.size()>0;
        }
        return false;
    }

    @Override
    public void run() {
        boolean notEmpty = false;
        do {
            notEmpty = nextStep();
        } while (notEmpty);
    }

    public List<String> getTasks() {
        return tasks;
    }

    public SimpleThread(List<String> tasks) {
        this.tasks = tasks;
    }
}
