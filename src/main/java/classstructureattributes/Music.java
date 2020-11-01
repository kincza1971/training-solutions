package classstructureattributes;

import java.util.Scanner;

public class Music {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Légysi add meg a kedvenc zeneszámod adatait!");
        System.out.println("Előadó neve:");
        Song song = new Song();
        song.band = scanner.nextLine();
        System.out.println("Zeneszám címe?");
        song.title = scanner.nextLine();
        System.out.println("Szerzemény hossza percben?");
        song.length = scanner.nextInt();
        System.out.println(song.band + " - " + song.title + " (" + song.length + " perc)");
    }
}
