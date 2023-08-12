package kim.zhyun.studyredis.controller;

import kim.zhyun.studyredis.service.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class RedisController {

    private final RedisService service;

    @GetMapping("/")
    public String main(){
        String result = service.process("1::여기는 어디인가::가나다라마바사아자차카타파하기니디리미비시이지치키티피히그느드르므브스으즈츠크트프흐구누두루무부수우주추구쿠푸🐢게네데레메베세에제체케테페헤😑abcdefghijklmnopqrstuvwxyz::서울시 몽롱구 졸리거동 참호");
        log.info("🥃🐢 process result :: {}", result);
        return "하이";
    }

    @GetMapping("/hash")
    public String hash(){
        service.hashData("test");
        return "hash test";
    }

    @GetMapping("/pipe")
    public String pipeline(){
        service.pipeline("test");
        return "pipeline test";
    }

    @GetMapping("/set")
    public String set(){
        service.set();
        return "set test";
    }

    @GetMapping("/geo")
    public String geo(){
        service.geospecial();
        return "geospecial test";
    }
}
