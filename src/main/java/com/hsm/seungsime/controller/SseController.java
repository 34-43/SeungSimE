package com.hsm.seungsime.controller;

import com.hsm.seungsime.dto.ReqDto;
import com.hsm.seungsime.dto.ResDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/api/chat")
public class SseController {

    @GetMapping
    public ResponseEntity<ResDto> sendChat(@RequestParam String q) {
        return sendChat(new ReqDto(q));
    }

    @PostMapping
    public ResponseEntity<ResDto> sendChat(@RequestBody ReqDto req) {

        String q = req.getQuestion();
        String a = convertChat(q);

        return ResponseEntity.ok(new ResDto(a));
    }

    private final Map<String,String> qPatternMap = Map.ofEntries(
            Map.entry("레야크","..."),
            Map.entry("승민아","게이"),
            Map.entry("딕ㄱ?","ㄱㄱ"),
            Map.entry("딕ㄱ","게이"),
            Map.entry("엄","준"),
            Map.entry("준","식"),
            Map.entry("식","ㅊㅊ")
    );

    private String convertChat(String input) {
        Random rand = new Random();
        String postfix;
        String line = "";
        String output = "";

        if (qPatternMap.containsKey(input)) {
            return qPatternMap.get(input);
        }

        if (rand.nextBoolean()) {
            postfix = "이지랄";
        } else {
            postfix = "이러고 있네";
        }

        line = switch (rand.nextInt(10)) {
            case 0 -> "난리났네";
            case 1 -> "조현병이야?";
            case 2 -> "진정해";
            case 3 -> "게이";
            case 4 -> "게이야";
            case 5 -> "그게 무슨 소리야";
            case 6 -> "미쳤네";
            case 7 -> "동윤집고?";
            case 8 -> "영롱하네요";
            default -> line;
        };


        output = switch (rand.nextInt(10)) {
            case 0, 1, 2, 3, 4, 5 -> input + " " + postfix;
            case 6, 7, 8, 9 -> line;
            default -> output;
        };

        return output;
    }
}
