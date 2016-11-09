package x3.benjamin.study.async;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import x3.benjamin.study.async.data.entity.User;
import x3.benjamin.study.async.repository.UserRepository;

import java.util.List;

/**
 * Created by benjamin on 2016. 11. 5..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebServerApplication.class)
public class ForEachTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testIterableForEach() {
        List<User> userList = userRepository.findAll();
        userList.forEach(user -> System.out.println(user));
    }

    @Test
    public void testStreamForEach() {
        List<User> userList = userRepository.findAll();
        userList.stream()
                .forEach(user -> System.out.println(user));
    }

    @Test
    public void testParallelStreamForEach() {
        List<User> userList = userRepository.findAll();
        userList.parallelStream()
                .forEach(user -> System.out.println(user));
    }

}
