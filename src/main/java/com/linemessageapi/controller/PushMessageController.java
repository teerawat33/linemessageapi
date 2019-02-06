package com.linemessageapi.controller;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.message.ImageMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.concurrent.ExecutionException;

@RestController
@LineMessageHandler
@RequestMapping("/send")
public class PushMessageController {

    @Autowired
    private LineMessagingClient lineMessagingClient;

    @RequestMapping("/text")
    public void sendText(
            @RequestParam("userId") String userId,
            @RequestParam("message") String message
    ) throws ExecutionException, InterruptedException {

        PushMessage pushMessage = new PushMessage(userId, Collections.singletonList(new TextMessage(message)));
        lineMessagingClient.pushMessage(pushMessage).get();
    }

    @RequestMapping("/image")
    public void sendImage(
            @RequestParam("userId") String userId,
            @RequestParam("originalContentUrl") String originalContentUrl,
            @RequestParam("previewImageUrl") String previewImageUrl
    ) throws ExecutionException, InterruptedException {

        ImageMessage imageMessage = new ImageMessage(originalContentUrl, previewImageUrl);
        PushMessage pushMessage = new PushMessage(userId, imageMessage);
        lineMessagingClient.pushMessage(pushMessage).get();
    }
}
