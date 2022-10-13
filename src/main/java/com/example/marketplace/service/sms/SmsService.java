package com.example.marketplace.service.sms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class SmsService {
    @Value("${SMS_ACCOUNT_ID}")
    private String SID_LIVE;
    @Value("${SMS_ACCOUNT_PASS}")
    private String PASS_LIVE;
    @Value("${SMS_TEST_ID}")
    private String SID_TEST;
    @Value("${SMS_TEST_PASS}")
    private String PASS_TEST;
    @Value("${SENDING_NUMBER}")
    private String fromNumber;
    @Value("${URL_PATH}")
    private String URL_PATH;

//    public void sendSms() {
//        Twilio.init(SID_LIVE, PASS_LIVE);
//        Message message = Message.creator(
//                        new PhoneNumber("+77779066364"),
//                        new PhoneNumber("+12136452868"),
//                        "Your order has been accepted by shop")
//                .create();
//    }

    public String sendSms(String toNumber) {

        MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();

        bodyValues.add("Body", "Your order is accepted, please pick it up at the store");
        bodyValues.add("To", toNumber);
        bodyValues.add("From", fromNumber);

        WebClient client = WebClient.builder()
                .baseUrl(URL_PATH)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .defaultHeaders(headers -> headers.setBasicAuth(SID_LIVE,PASS_LIVE))
                .build();


        return client.post().uri(SID_LIVE+"/Messages.json")
                .body(BodyInserters.fromFormData(bodyValues))
                .retrieve()
                .bodyToFlux(String.class)
                .blockLast();


    }


}
