package com.example.knap_aop_v2.loghandle;

import com.example.knap_aop_v2.model.KnapLoggingMessage;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class LoggingInterceptor {

    private static final String POINT_CUT = "execution(* com.example.knapappaop.loghandle.KnapMessageController..*(..))";

    @Before(POINT_CUT)
    public void logBefore(JoinPoint joinPoint) {
        log.info("The method {} is about to log info.", joinPoint.getSignature().getName());

        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            log.info("Method parameters: ");
            for (Object arg : args) {
                log.info(" - {}", arg);
            }
        }
    }

    @AfterReturning(value = POINT_CUT, returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        log.info("Successfully executed info logging: {}", joinPoint.getSignature().getName());
    }

    @AfterThrowing(value = POINT_CUT, throwing = "exception")
    public void logError(JoinPoint joinPoint, Exception exception) {
        log.error("Exception while logging: {}", joinPoint.getSignature().getName());
        KnapLoggingMessage errorLoggingMessage = KnapLoggingMessage.builder()
                .messageLabel("Error in " + joinPoint.getSignature().getName())
                .exception(exception)
                .alertToTec(true)
                .saveToDatabase(true)
                .build();

        log.error("Error Log Message: {}", errorLoggingMessage);
        if (errorLoggingMessage.isSaveToDatabase()) {
            log.info("Saving error log message to the database...");
        }
    }
}
