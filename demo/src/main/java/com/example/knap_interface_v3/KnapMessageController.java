package com.example.knap_interface_v3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KnapMessageController {

    private final ILoggingService loggingService;

    @Autowired
    public KnapMessageController(ILoggingService loggingService) {
        this.loggingService = loggingService;
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

        loggingService.logInfo(message);
        return message;
    }

    @GetMapping("/log-info")
    public String logInfo() {
        KnapLoggingMessage message = KnapLoggingMessage.builder()
                .messageLabel("Info message")
                .messageParams("param1", "param2")
                .plant("PlantCode")
                .alertToBiz(true)
                .saveToDatabase(true)
                .build();

        loggingService.logInfo(message);
        return "Info log created successfully!";
    }

    @GetMapping("/log-warn")
    public String logWarn() {
        KnapLoggingMessage message = KnapLoggingMessage.builder()
                .messageLabel("Warning message")
                .messageParams("param3", "param4")
                .plant("PlantCode")
                .alertToTec(true)
                .saveToDatabase(true)
                .build();

        loggingService.logWarn(message);
        return "Warning log created successfully!";
    }

    @GetMapping("/log-error")
    public String logError() {
        Exception simulatedException = new RuntimeException("Simulated error for testing");

        KnapLoggingMessage message = KnapLoggingMessage.builder()
                .messageLabel("Error message")
                .messageParams("param5", "param6")
                .plant("PlantCode")
                .exception(simulatedException)
                .saveToDatabase(true)
                .build();

        loggingService.logError(message);
        return "Error log created successfully!";
    }

    @GetMapping("/log-debug")
    public String logDebug() {
        KnapLoggingMessage message = KnapLoggingMessage.builder()
                .messageLabel("Debug message")
                .messageParams("debugParam1", "debugParam2")
                .plant("DebugPlant")
                .alertToBiz(false)
                .alertToTec(true)
                .saveToDatabase(false)
                .build();

        loggingService.logDebug(message);
        return "Debug log created successfully!";
    }
}
