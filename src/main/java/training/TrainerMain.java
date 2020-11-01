package training;

public class TrainerMain {
    public static void main(String[] args) {
        Trainer trainer = new Trainer("Kovács Gejza",1978);
        System.out.println(trainer.getNameAndAge(2020));
        Trainer trainer2 = new Trainer("Kovács István",1922);
        System.out.println(trainer2.getNameAndAge(2020));
    }
}
