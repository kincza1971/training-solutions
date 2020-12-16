package ioprintwriter.salary;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SalaryWriter {

    public static final int GENERAL_SALARY = 200000;
    public static final int DR_SALARY = 500000;
    private List<String> names;

    private void printToFile(PrintWriter pw, String name, int salary) {
        pw.print(name);
        pw.print(": ");
        pw.println(salary);
    }

    private void writeToFile(PrintWriter pw, String name) {
        if (name.startsWith("Mr") || name.startsWith("Mrs")) {
            printToFile(pw, name, GENERAL_SALARY);
        } else if (name.startsWith("Dr")) {
            printToFile(pw, name, DR_SALARY);
        }
    }


    public void writeNamesAndSalaries(Path file){
        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(file))) {
            for (String name : names) {
                writeToFile(pw, name);
            }
        } catch (IOException e) {
            throw new IllegalStateException("I/O hiba", e);
        }
    }

    public SalaryWriter(List<String> names) {
        this.names = names;
    }
}
