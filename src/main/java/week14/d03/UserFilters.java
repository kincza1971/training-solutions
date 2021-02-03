package week14.d03;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserFilters {
    public UserFilter createFilter(List<Predicate<User>> predicates) {
        Predicate result = predicates.get(0);
        for (Predicate condition : predicates) {
            result = result.and(condition);

        }
        Predicate finalResult = result;
        return new UserFilter() {
            @Override
            public List<User> filter(List<User> users) {
                return users.stream().filter(finalResult::test).collect(Collectors.toList());
            }
        };
    }



}