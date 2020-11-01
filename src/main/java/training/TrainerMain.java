package training;

public class TrainerMain {
    public static void main(String[] args) {
        Trainer trainer = new Trainer();
        trainer.setName("Kovács Gejza");
        trainer.setYearOfBirth(1978);
        System.out.println(trainer.getNameAndAge(2020));
        Trainer trainer2 = new Trainer();
        trainer2.setName("Kovács István");
        trainer2.setYearOfBirth(1922);
        System.out.println(trainer2.getNameAndAge(2020));
    }
}
