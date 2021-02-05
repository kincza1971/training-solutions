package week14.d03;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserFilters {
    public UserFilter createFilter(List<Predicate<User>> predicates) {
        if (predicates.size()==0) {
            throw new IllegalArgumentException("Not condition in the list");
        }
//        Predicate result = predicates.get(0);
//        for (int i =1; i< predicates.size();i++) {
//            result = result.and(predicates.get(i));
//        }
//
//        result = predicates.stream().reduce(a ->true,Predicate::and);

//        Predicate finalResult = result;
        return new UserFilter() {
            @Override
            public List<User> filter(List<User> users) {
                return users.stream().filter(predicates.stream().reduce(a ->true,Predicate::and)::test).collect(Collectors.toList());
            }
        };
    }



}