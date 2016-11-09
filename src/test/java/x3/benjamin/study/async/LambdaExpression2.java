package x3.benjamin.study.async;

import org.junit.Test;

import java.util.Date;

/**
 * Created by benjamin on 2016. 11. 7..
 */
public class LambdaExpression2 {

    @Test
    public void test() {
        // 100ms 뒤 현재 시간을 출력하는 Runnable 을 Method Reference 를 사용한 람다식으로 변경할것.
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable Time :" + new Date());
            }
        };

        Runnable r2 = System.out::println;
        Thread t = new Thread(r);
        t.start();
        System.out.println("Main Thread Time :" + new Date());
    }
}
