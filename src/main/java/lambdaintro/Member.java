package lambdaintro;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private final String name;
    private final List<String> skills;
    private final Sex sex;
    private List<String> messages = new ArrayList<>();

    public void sendMessage(String message) {
        messages.add(message);
    }

    public Member(String name, List<String> skills, Sex sex) {
        this.name = name;
        this.sex = sex;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return skills;
    }

    public Sex getGender() {
        return sex;
    }

    public List<String> getMessages() {
        return messages;
    }
}

//Member osztályt, name, skills (mely egy List<String>), gender és messages (List<String>) attribútumokkal.
// Hozz létre benne egy sendMessage(String) metódust, mely a paraméterként kapott üzenetet beteszi a messages listába.
