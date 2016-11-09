package x3.benjamin.study.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.AsyncClientHttpRequestFactory;
import org.springframework.http.client.Netty4ClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.AsyncRestTemplate;

/**
 * Created by benjamin on 2016. 11. 5..
 */
@Configuration
public class RestClientConfig {

    @Bean
    public AsyncRestTemplate asyncRestTemplate() {
        AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate(asyncClientHttpRequestFactory());
        asyncRestTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter());
        asyncRestTemplate.getMessageConverters().add(stringHttpMessageConverter());
        return asyncRestTemplate;
    }

    @Bean
    public AsyncClientHttpRequestFactory asyncClientHttpRequestFactory() {
        Netty4ClientHttpRequestFactory netty4ClientHttpRequestFactory = new Netty4ClientHttpRequestFactory();
        netty4ClientHttpRequestFactory.setReadTimeout(5000);
        netty4ClientHttpRequestFactory.setMaxResponseSize(10 * 1024 * 1024);

        return netty4ClientHttpRequestFactory;
    }

    @Bean
    public HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        return converter;
    }

    @Bean
    public HttpMessageConverter stringHttpMessageConverter() {
        return new StringHttpMessageConverter();
    }

}
