package com.example.knap_aop_v2.loghandle;

import com.example.knap_aop_v2.model.KnapLoggingMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Log4j2
public class KnapMessageController {

    @GetMapping("/log")
    public String logSuccess() {
        KnapLoggingMessage message = KnapLoggingMessage.builder()
                .messageLabel("Some important message")
                .messageParams("param1", "param2")
                .plant("PlantCode")
                .alertToBiz(true)
                .saveToDatabase(true)
                .build();

        log.info("{}", message);
        return "Logged successfully!";
    }

    @GetMapping("/message")
    public KnapLoggingMessage logMessage() {
        KnapLoggingMessage message = KnapLoggingMessage.builder()
                .messageLabel("Some important message")
                .messageParams("param1", "param2")
                .plant("PlantCode")
                .alertToBiz(true)
                .saveToDatabase(true)
                .build();

        log.info("{}", message);
        return message;
    }

    @GetMapping("/errmessage")
    public KnapLoggingMessage logErrorMessage() {
        Exception simulatedException = new RuntimeException("Simulated error occurred");

        KnapLoggingMessage message = KnapLoggingMessage.builder()
                .messageLabel("An error occurred in the system")
                .messageParams("param2", "param4", "param6")
                .plant("PlantCode")
                .exception(simulatedException)
                .build();

        log.error("Error: {}", message);
        return message;
    }

    @GetMapping("/requestparams")
    public KnapLoggingMessage reqParamsMessage(
            @RequestParam String messageLabel,
            @RequestParam(required = false) String plant,
            @RequestParam(required = false) String... messageParams) {

        KnapLoggingMessage message = KnapLoggingMessage.builder()
                .messageLabel(messageLabel)
                .messageParams(messageParams)
                .plant(plant)
                .alertToBiz(true)
                .saveToDatabase(true)
                .build();

        log.info("{}", message);
        return message;
    }

    @GetMapping("/test")
    public void test() {
        log.info("Test endpoint called");
    }
}
