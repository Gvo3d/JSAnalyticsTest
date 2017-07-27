package application.support;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.Priority;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Log4j
@Component
public class HttpSender {
    private static final String SPLUNK_NAME = "Splunk ";
    private static final String AUTHORIZATION = "Authorization";
    private final RestTemplate restTemplate = new RestTemplate();
    private HttpHeaders headers;

    @Value("${qrok.medical.statistics.splunkServerUrl}")
    private String url;
    @Value("${qrok.medical.statistics.token}")
    private String token;

    @PostConstruct
    private void init() {
        this.token = SPLUNK_NAME + token;
        changeAuthHeaders();
    }

    private void changeAuthHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(AUTHORIZATION, token);
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        this.headers = headers;
    }

    public synchronized void changeToken(String newToken) {
        this.token = SPLUNK_NAME + token;
        changeAuthHeaders();
    }

    void sendInterceptorData(StatisticDataHolder statisticsData) {
        HttpEntity<StatisticDataHolder> entity = new HttpEntity<StatisticDataHolder>(statisticsData, headers);
        try {
            System.out.println("SENDING IN HS: "+restTemplate.exchange(url, HttpMethod.POST, entity, StatisticDataHolder.class));
        } catch (RestClientException e) {
            System.out.println(e);
        }
    }
}