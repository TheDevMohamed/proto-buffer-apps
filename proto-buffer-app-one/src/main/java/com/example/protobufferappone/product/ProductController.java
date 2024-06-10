package com.example.protobufferappone.product;


import com.example.protobuf.MessageProto;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/send")
public class ProductController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JsonFormat.Printer jsonPrinter;

    @Autowired
    private JsonFormat.Parser jsonParser;

    @GetMapping
    public String sendMessage() throws InvalidProtocolBufferException {
        MessageProto.Request request = MessageProto.Request.newBuilder()
                .setMessage("Hello from Sender!")
                .build();

        String jsonRequest = jsonPrinter.print(request);

        String jsonResponse = restTemplate.postForObject("http://localhost:8081/receive", jsonRequest, String.class);

        MessageProto.Response.Builder responseBuilder = MessageProto.Response.newBuilder();
        jsonParser.merge(jsonResponse, responseBuilder);
        MessageProto.Response response = responseBuilder.build();

        return response.getMessage();
    }
}