package ru.kpfu.itis.demo.websocket.dto;

import lombok.Data;

@Data
public class VoiceMessage {

    private String text;
    private String voice;
    private VoiceConfig voiceConfig;

    @Data
    public static class VoiceConfig {

        private Double pitch;
        private Double volume;
        private Double rate;
    }
}
