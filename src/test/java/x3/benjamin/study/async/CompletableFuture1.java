package x3.benjamin.study.async;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

/**
 * Created by benjamin on 2016. 11. 10..
 */
public class CompletableFuture1 {


    // 비동기처리 Return 값을 다음 처리의 Parameter 로 사용할때 사용한다
    @Test
    public void thenComposeTest() throws Exception {
        Price price = new Price();
        price.getPriceAsync(1)
                .thenComposeAsync(price::getPriceAsync)
                .thenComposeAsync(price::getPriceAsync)
                .thenComposeAsync(r -> price.getPriceAsync(r));

        System.out.println("Non Blocking!!");

        Thread.sleep(5000l);

    }

    static class Price {

        public double getPrice(double oldprice) throws Exception {
            return calculatePrice(oldprice);
        }

        public double calculatePrice(double oldprice) throws Exception {

            System.out.println("Input :" + oldprice);
            Thread.sleep(1000l);
            System.out.println("Output :" + (oldprice + 1l));

            return oldprice + 1l;
        }

        public CompletableFuture<Double> getPriceAsync(double oldPrice) {
            CompletableFuture<Double> completableFuture = new CompletableFuture<>();
            new Thread(() -> {
                try {
                    double price = calculatePrice(oldPrice);
                    completableFuture.complete(price);
                } catch (Exception ex) {
                    completableFuture.completeExceptionally(ex);
                }
            }).start();

            return completableFuture;
        }
    }

}
