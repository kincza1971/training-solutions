package filescanner.bucketlist;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class BucketList {
    public static void main(String[] args) {
        try (Scanner scnr = new Scanner(Path.of("bucketlist.txt"))) {
            while (scnr.hasNext()){
                System.out.println(scnr.nextLine());
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
