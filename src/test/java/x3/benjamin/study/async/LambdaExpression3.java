package x3.benjamin.study.async;

import java.util.Date;

/**
 * Created by benjamin on 2016. 11. 7..
 */
public class LambdaExpression3 {
    public static void main(String... args) {
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println(new Date());
            }
        };

        runnable.run();
    }
}
