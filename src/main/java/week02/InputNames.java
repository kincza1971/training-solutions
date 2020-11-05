package week02;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.Scanner;

public class InputNames {
    public static void main(String[] args) {
        String[] nevek = new String[5];
        Scanner scnr = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {

            System.out.println("Kérem a()z " + (i+1) + ". nevet");
            nevek[i] = scnr.nextLine();

        }

        for (int i = 0; i < 5; i++) {

            System.out.println( (i+1) + " " +"nevek[i]);
        }
    }
}
