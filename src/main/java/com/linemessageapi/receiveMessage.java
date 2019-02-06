package com.linemessageapi;

import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

@LineMessageHandler
public class receiveMessage {

    @EventMapping
    public void handleTextMessage(MessageEvent<TextMessageContent> event) {

        //TODO ส่งไปไหน
        TextMessageContent message = event.getMessage();
        String userId = event.getSource().getUserId();
        String setMessage = message.getText();
    }
}
