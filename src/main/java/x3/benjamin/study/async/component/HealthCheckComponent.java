package x3.benjamin.study.async.component;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.client.AsyncRestTemplate;

/**
 * Created by benjamin on 2016. 11. 5..
 */
@Component
@Log4j
public class HealthCheckComponent {

    @Autowired
    private AsyncRestTemplate asyncRestTemplate;

    public boolean healthCheck(String url) {

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);

        ListenableFuture<ResponseEntity<String>> future = asyncRestTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        future.addCallback((responseEntity -> {
            log.info("bodySize : " + responseEntity.getBody().length());
            ListenableFuture<ResponseEntity<String>> future1 = asyncRestTemplate.exchange("http://google.com", HttpMethod.GET, requestEntity, String.class);
            future1.addCallback((googleResponseEntity -> {
                log.info("bodySize : " + googleResponseEntity.getBody().length());
            }), (throwable -> {
                log.warn("Error from Gogole", throwable);
            }));
        }), throwable -> {
            log.warn("Error", throwable);
        });
        return false;
    }
}
