package com.example.knap_i18n_modif_v4.loggingservice;


import com.example.knap_i18n_modif_v4.KibanaMsgNotFoundException;
import com.example.knap_i18n_modif_v4.model.I18nMsgTxtEntity;
import com.example.knap_i18n_modif_v4.model.KnapLoggingMessage;
import com.example.knap_i18n_modif_v4.repository.I18nMsgTxtRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoggingServiceImpl implements ILoggingService {
    
    private final I18nMsgTxtRepository i18NMsgRepository;
    
    @Override
    public void logInfo(KnapLoggingMessage message) {
        logMessage(message, log::info);
    }
    
    @Override
    public void logDebug(KnapLoggingMessage message) {
        logMessage(message, log::debug);
    }
    
    @Override
    public void logWarn(KnapLoggingMessage message) {
        logMessage(message, log::warn);
    }
    
    @Override
    public void logError(KnapLoggingMessage message) {
        logMessage(message, (msg) -> log.error(msg, message.getException()));
    }
    
    private void logMessage(KnapLoggingMessage message, LoggerFunction loggerFunction) {
        try {
            String msgText = retrieveMsgText(message);
            String formattedMessage = formatText(msgText, message.getMessageParams());
            loggerFunction.log(formattedMessage);
            if (message.isSaveToDatabase()) {
                // Call a method to save the log message to the database if needed
                saveLogMessageToDatabase(message, formattedMessage);
            }
        } catch (KibanaMsgNotFoundException e) {
            log.error("Message code not found: {}", message.getMessageCode(), e);
        }
    }
    
    private String retrieveMsgText(KnapLoggingMessage message) throws KibanaMsgNotFoundException {
        List<I18nMsgTxtEntity> msgEntities = i18NMsgRepository.findByMsgCodeAndLanguageCode(message.getMessageCode(), message.getPlant());
        if (msgEntities.size() == 1) {
            return msgEntities.get(0).getTxt();
        } else if (msgEntities.isEmpty()) {
            throw new KibanaMsgNotFoundException("Text not found for given msg code", message.getMessageCode());
        } else {
            throw new KibanaMsgNotFoundException("Multiple messages found for given msg code", message.getMessageCode());
        }
    }
    
    private String formatText(String txt, String[] params) {
        return String.format(txt, (Object[]) params); // Adjust formatting as necessary
    }
    
    private void saveLogMessageToDatabase(KnapLoggingMessage message, String formattedMessage) {
        // Implement logic to save the message to the database, if required
    }
    
    @FunctionalInterface
    private interface LoggerFunction {
        void log(String message);
    }
}
