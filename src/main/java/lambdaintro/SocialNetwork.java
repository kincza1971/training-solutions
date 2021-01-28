package lambdaintro;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SocialNetwork {

    private List<Member> members;

    public List<Member> findMembersBy(Predicate<Member> condition) {
        List<Member> foundMembers = new ArrayList<>();
        for (Member member : members) {
            if (condition.test(member)) {
                foundMembers.add(member);
            }
        }
        return foundMembers;
    }
    public void applyToSelectedMembers(Predicate<Member> condition, Consumer<Member> consumer) {
        for (Member member : members) {
            if (condition.test(member)) {
                consumer.accept(member);
            }
        }
    }

    public List<String> transformMembers(Function<Member,String> function) {
        List<String> resultList = new ArrayList<>();
        for (Member member : members) {
            resultList.add(function.apply(member));
        }
        return resultList;
    }

    public SocialNetwork(List<Member> members) {
        this.members = members;
    }
}

//SocialNetwork osztályt, mely Member objektumokat képes tárolni.
// A findMembersBy() metódusa a paraméterként átadott feltétel alapján kigyűjti a tagokat.
// A applyToSelectedMembers() a paraméterként átadott feltételnek megfelelő tagokon végez valamilyen műveletet (2. paraméterként átadva).
// A transformMembers() metódus minden tagon valamilyen transzformációt végez.
