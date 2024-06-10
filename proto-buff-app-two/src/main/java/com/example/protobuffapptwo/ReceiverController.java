package com.example.protobuffapptwo;

import com.example.protobuf.MessageProto;
import com.google.protobuf.InvalidProtocolBufferException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.protobuf.util.JsonFormat;

@RestController
public class ReceiverController {
    @Autowired
    private JsonFormat.Parser jsonParser;

    @Autowired
    private JsonFormat.Printer jsonPrinter;

    @PostMapping("/receive")
    public String receiveMessage(@RequestBody String jsonRequest) throws InvalidProtocolBufferException {
        MessageProto.Request.Builder requestBuilder = MessageProto.Request.newBuilder();
        jsonParser.merge(jsonRequest, requestBuilder);
        MessageProto.Request request = requestBuilder.build();

        // Handle the request and create a response
        MessageProto.Response response = MessageProto.Response.newBuilder()
                .setMessage("Hello from Receiver! Received: " + request.getMessage())
                .build();

        return jsonPrinter.print(response);
    }
}