package x3.benjamin.study.async;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import x3.benjamin.study.async.component.PushComponent;
import x3.benjamin.study.async.repository.UserRepository;
import x3.benjamin.study.function.ThrowableConsumer;

/**
 * Created by benjamin on 2016. 11. 5..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebServerApplication.class)
@Log4j
public class ExceptionTest2 {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PushComponent pushComponent;

    @Test
    public void testCheckedException() throws Exception {

        String messsage = "SPAM MESSAGE";
        final ThrowableConsumer<String> consumer = phoneNumber -> {
            pushComponent.pushMessage(messsage, phoneNumber);
        };

        // change pushComponent.pushMessage() method to pushComponent.sendMessage() method.
        String message = "Spam Message";

        userRepository.findAll().stream()
                .map(user -> user.getPhoneNumber())
                .filter(phoneNumber -> phoneNumber != null)
                .peek(phoneNumber -> log.debug(phoneNumber))
                .forEach(consumer);
    }
}
