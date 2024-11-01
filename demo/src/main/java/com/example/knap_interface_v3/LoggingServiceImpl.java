package com.example.knap_interface_v3;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class LoggingServiceImpl implements ILoggingService {

    @Override
    public void logInfo(KnapLoggingMessage message) {
        log.info("Info Log: {}", message.getMessageLabel());
        if (message.getMessageParams() != null) {
            log.info("Parameters: {}", (Object[]) message.getMessageParams());
        }
    }

    @Override
    public void logDebug(KnapLoggingMessage message) {
        log.debug("Debug Log: {}", message.getMessageLabel());
        if (message.getMessageParams() != null) {
            log.debug("Parameters: {}", (Object[]) message.getMessageParams());
        }
    }

    @Override
    public void logWarn(KnapLoggingMessage message) {
        log.warn("Warning Log: {}", message.getMessageLabel());
        if (message.getMessageParams() != null) {
            log.warn("Parameters: {}", (Object[]) message.getMessageParams());
        }
    }

    @Override
    public void logError(KnapLoggingMessage message) {
        log.error("Error Log: {}", message.getMessageLabel(), message.getException());
        if (message.isSaveToDatabase()) {
            log.info("Saving error log to the database...");
            // Implement database save logic here if needed
        }
    }
}
