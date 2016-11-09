package x3.benjamin.study.async.component;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import x3.benjamin.study.async.WebServerApplication;

/**
 * Created by benjamin on 2016. 11. 9..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebServerApplication.class)
@Log4j
public class HealthCheckComponentTest {

    @Autowired
    private HealthCheckComponent healthCheckComponent;

    @Test
    public void test(){
        healthCheckComponent.healthCheck("http://www.naver.com/");
        try {
            Thread.sleep(10000);
        } catch (Exception e){

        }
    }
}
