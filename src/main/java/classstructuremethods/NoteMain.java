package classstructuremethods;

public class NoteMain {
    public static void main(String[] args) {
        Note note = new Note();
        note.setName("Mézga Géza");
        note.setTopic("KeenCarp");
        note.setText("A Keen Carp 50-50 nutty bojliját kiváló eredményekkel használták őszi lehűlő vizeken");

        System.out.println(note.getNoteText());
    }
}
