package com.example.knap_web_v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// pentru path general
@RestController
@RequestMapping("/api/v1")
public class KnapMessageController {

    private static final Logger log = LoggerFactory.getLogger(KnapMessageController.class);

    // GET request la /log
    @GetMapping("/log")
    public String log() {
        // construirea mesaj de logare
        KnapLoggingMessage knapLoggingMessage = new KnapLoggingMessageBuilder()
                .messageLabel("Some important message")
                .messageParams("param1", "param2")
                .plant("PlantCode")
                .alertToBiz()  // alertToTec()
                .saveToDb()
                .build();

        // log mesaj
        log.info("{}", knapLoggingMessage);

        return "Logged successfully!";
    }

    @GetMapping("/message")
    public KnapLoggingMessage logMessage() {
        KnapLoggingMessage knapLoggingMessage = new KnapLoggingMessageBuilder()
                .messageLabel("Some important message")
                .messageParams("param1", "param2")
                .plant("PlantCode")
                .alertToBiz()
                .saveToDb()
                .build();

        log.info("{}", knapLoggingMessage);

        // return mesaj
        return knapLoggingMessage;
    }

    @GetMapping("/requestparams")
    public KnapLoggingMessage reqParamsMessage(
            @RequestParam String messageLabel, 
            @RequestParam(required = false) String plant,
            @RequestParam(required = false) String... messageParams) {

        KnapLoggingMessage knapLoggingMessage = new KnapLoggingMessageBuilder()
                .messageLabel(messageLabel)
                .messageParams(messageParams)
                .plant(plant)
                .alertToBiz()
                .saveToDb()
                .build();

        log.info("{}", knapLoggingMessage);

        return knapLoggingMessage;
    }

}

