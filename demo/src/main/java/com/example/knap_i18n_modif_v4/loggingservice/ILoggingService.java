package com.example.knap_i18n_modif_v4.loggingservice;

import com.example.knap_i18n_modif_v4.model.KnapLoggingMessage;

public interface ILoggingService {
    void logInfo(KnapLoggingMessage message);
    void logDebug(KnapLoggingMessage message);
    void logWarn(KnapLoggingMessage message);
    void logError(KnapLoggingMessage message);
}

