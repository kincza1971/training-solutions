package lambdaoptional;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class SocialNetwork {
    private List<Member> members;

    public Optional<Member> findFirst(Predicate<Member> condition) {
        Optional<Member> result;
        result = members.stream().filter(condition::test).findFirst();
        return result;
    }

    public Optional<Double> averageNumberOfSkills() {
        int counter = members.size();

        if (counter == 0) {
            return Optional.empty();
        }

        Optional<Double> result;
        int sum =members.stream().map(member -> member.getSkills().size()).reduce(0,(a,b) -> a+=b,(a,b) ->a+b);
        result = Optional.of((double) sum/counter);
    return result;
    }

    public SocialNetwork(List<Member> members) {
        this.members = members;
    }
}
