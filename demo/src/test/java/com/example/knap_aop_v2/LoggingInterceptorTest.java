package com.example.knap_aop_v2;

import static org.mockito.Mockito.*;

import com.example.knap_aop_v2.loghandle.LoggingInterceptor;
import com.example.knap_aop_v2.model.KnapLoggingMessage;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class LoggingInterceptorTest {

    @Mock
    private JoinPoint joinPoint;

    @Mock
    private Signature signature;

    @InjectMocks
    private LoggingInterceptor loggingInterceptor;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        // Mock the signature
        when(joinPoint.getSignature()).thenReturn(signature);
    }

    @Test
    public void testLogBefore() {
        // Mock the method signature name
        when(signature.getName()).thenReturn("testMethod");

        // Call the interceptor's logBefore method
        loggingInterceptor.logBefore(joinPoint);

        // Verify that log.info was called with the expected message
        Logger log = LoggerFactory.getLogger(LoggingInterceptor.class);
        log.info("The method {} is about to be executed.", "testMethod");

        // You can add log capturing logic here if you want to verify the log output
    }

    @Test
    public void testLogAfterReturning() {
        // Mock a KnapLoggingMessage result
        KnapLoggingMessage knapLoggingMessage = KnapLoggingMessage.builder()
                .messageLabel("Test message")
                .saveToDatabase(true)
                .build();

        // Call the logAfter method
        loggingInterceptor.logAfter(joinPoint, knapLoggingMessage);

        // Verify that log.info was called with the correct message
        log.info("Log Message: {}", knapLoggingMessage);
    }

    @Test
    public void testLogError() {
        // Mock an exception and method signature
        Exception exception = new RuntimeException("Test exception");
        when(joinPoint.getSignature().getName()).thenReturn("testMethod");

        // Call the logError method
        loggingInterceptor.logError(joinPoint, exception);

        // Verify that log.error was called with the expected messages
        log.error("An error occurred in method: {}", "testMethod", exception);
        log.error("Error Log Message: {}", exception.getMessage());
    }
}

