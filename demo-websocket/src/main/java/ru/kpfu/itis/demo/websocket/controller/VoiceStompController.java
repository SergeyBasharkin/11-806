package ru.kpfu.itis.demo.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Controller;
import ru.kpfu.itis.demo.websocket.dto.VoiceMessage;

@Controller
public class VoiceStompController {

    @MessageMapping("/speech")
    @SendTo("/topic/speech")
    public VoiceMessage handleSpeech(@Payload VoiceMessage voiceMessage){
        return voiceMessage;
    }
}
