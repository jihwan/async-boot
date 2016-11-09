package x3.benjamin.study.async.repository;

import org.springframework.stereotype.Repository;
import x3.benjamin.study.async.data.Sex;
import x3.benjamin.study.async.data.entity.User;

import java.util.Arrays;
import java.util.List;

/**
 * Created by benjamin on 2016. 11. 5..
 */
@Repository
public class UserRepository {

    private static List<User> dummyUserList = Arrays.asList(
            new User(30, "benjamin", "010-1111-2222", Sex.MALE),
            new User(41, "fubu", "010-1234-2222", Sex.MALE),
            new User(20, "Jane", "010-4321-2222", Sex.FEMALE),
            new User(19, "Lane", "010-1234-9999", Sex.FEMALE)
    );

    public List<User> findAll() {
        return dummyUserList;
    }
}
