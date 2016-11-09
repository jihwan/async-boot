package x3.benjamin.study.async;

import org.junit.Test;

import java.util.Date;

/**
 * Created by benjamin on 2016. 11. 7..
 */
public class LambdaExpression1 {

    @Test
    public void test() {
        // 100ms 뒤 현재 시간을 출력하는 Runnable 을 Lambda 식으로 변경할것.
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignore) {
                }
                System.out.println("Runnable Time :" + new Date());
            }
        };

        Thread t = new Thread(r);
        t.start();
        System.out.println("Main Thread Time :" + new Date());
    }
}
