package x3.benjamin.study.async.component;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import x3.benjamin.study.async.exception.ComponentException;
import x3.benjamin.study.async.exception.NetworkException;

/**
 * Created by benjamin on 2016. 11. 5..
 */
@Log4j
@Component
public class PushComponent {

    public boolean pushMessage(String message, String phoneNumber) throws NetworkException {
        try {
            log.info("message : " + message + ", phoneNumber : " + phoneNumber);
            Thread.sleep(1000);

        } catch (InterruptedException ignore) {
        }

        throw new NetworkException("fail to connect server");
    }

    public boolean sendMessage(String message, String phoneNumber) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignore) {
        }

        throw new ComponentException("send message error");
    }
}
