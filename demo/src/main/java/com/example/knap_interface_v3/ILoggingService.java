package com.example.knap_interface_v3;

public interface ILoggingService {
    void logInfo(KnapLoggingMessage message);
    void logDebug(KnapLoggingMessage message);
    void logWarn(KnapLoggingMessage message);
    void logError(KnapLoggingMessage message);
}

