package com.example.knap_web_v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(LoggingInterceptor.class);

    //anunta ca urmeaza un request
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // logare inainte de manipularea cererii
        KnapLoggingMessage knapLoggingMessage = new KnapLoggingMessageBuilder()
                .messageLabel("Incoming request: " + request.getRequestURI())
                .plant("DefaultPlant")
                .alertToBiz()  // alertToTec()
                .build();

        log.info("{}", knapLoggingMessage);

        return true;  // continua manipularea cererii
    }

//    Spring MVC
//    -> when a controller method processes a web request, it can return a ModelAndView object
//    this tells Spring:
//    -which view to render (by specifying the view name)
//    -what data to include in the rendering process (by adding objects to the model)
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // logare dupa manipularea cu succes a cererii
        KnapLoggingMessage knapLoggingMessage = new KnapLoggingMessageBuilder()
                .messageLabel("Request handled successfully: " + request.getRequestURI())
                .alertToBiz()  // alertToTec()
                .build();

        log.info("{}", knapLoggingMessage);
    }

    //indica erori daca au aparut dupa request
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        if (ex != null) {
            // in caz de eroare
            KnapLoggingMessage knapLoggingMessage = new KnapLoggingMessageBuilder()
                    .messageLabel("Error handling request: " + request.getRequestURI())
                    .withException(ex)
                    .alertToTec()
                    .saveToDb()
                    .build();

            log.error("{}", knapLoggingMessage);
        }
    }
}

