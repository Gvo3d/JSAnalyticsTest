package test;

import application.support.StatisticDataHolder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

public class Test {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://192.168.1.137:8088/services/collector/event";
        String token = "Splunk 97F766E2-AC06-44A8-8263-93E31E17B71F";
        HttpHeaders headers = new HttpHeaders();
        headers.add(AUTHORIZATION, token);
        headers.setContentType(MediaType.APPLICATION_JSON);
//
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        String normalView = "{\"host\": \"test-dev\"\n" +
//                "\"source\": \"ourSite\"\n" +
//                "\"sourcetype\": \"access_combined\"\n" +
//                "\"clientip\": \"127.0.0.1\"\n" +
//                "\"eventtype\": \"web-traffic\"\n" +
//                "\"tag\": \"web\"\n" +
//                "\"uri\": \"/test_uri\"\n" +
//                "\"user\": \"testuser\"\n" +
//                "\"action\": \"unknown\"\n" +
//                "\"dest\": \"unknown\"\n" +
//                "\"http_content_type\": \"unknown\"\n" +
//                "\"http_method\": \"GET\"\n" +
//                "\"http_referer\": \"http://previousReferer/\"\n" +
//                "\"http_user_agent\": \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/600.2.5 (KHTML, like Gecko) Version/8.0.2 Safari/600.2.5\"\n" +
//                "\"src\": \"unknown\"\n" +
//                "\"status\": \"200\"\n" +
//                "\"url\": \"/tralala\"\n" +
//                "\"url_length\": \"7\"\n" +
//                "\"vendor_product\": \"access_combined\"\n" +
//                "\"http_channel\": \"Referal\"\n" +
//                "}";
//
//            System.out.println("Normal View");
//        try {
//            normalView = mapper.writer().writeValueAsString(holder);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        System.out.println("NORMAL="+normalView);
//
//        String result = "127.0.0.1 - - [01/Apr/2016:23:58:58 +0100] \"GET /2015/1/3/egen-programmering/ HTTP/1.1\" 200 17496 \"-\" \"Mozilla/5.0 (iPhone; CPU iPhone OS 7_1_2 like Mac OS X) AppleWebKit/537.51.2 (KHTML, like Gecko) Version/7.0 Mobile/11D257 Safari/9537.53\"";
//
//        StringBuilder resultBuilder = new StringBuilder(result);
//        resultBuilder.append(normalView);

//            String jsonInString = "{\"name\":\"mkyong\",\"age\":33,\"position\":\"Developer\",\"salary\":7500,\"skills\":[\"java\",\"python\"]}";
//            Staff normalStaff = mapper.readerWithView(Views.Normal.class).forType(Staff.class).readValue(jsonInString);
//            System.out.println(normalStaff);
//
        StatisticDataHolder holder = new StatisticDataHolder("83.248.128.170 - - [01/Apr/2016:07:28:41 +0100] \"GET /images/bg5.jpg HTTP/1.1\" 304 174 \"http://www.sampleapachesite.com/\" \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36\"");

        HttpEntity<StatisticDataHolder> entity = new HttpEntity<StatisticDataHolder>(holder, headers);
        restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
//        restTemplate.postForEntity(url, entity, String.class);
    }
}
