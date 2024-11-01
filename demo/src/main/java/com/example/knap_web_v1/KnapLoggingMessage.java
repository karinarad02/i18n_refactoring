package com.example.knap_web_v1;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KnapLoggingMessage {
    private String messageLabel;
    private String[] messageParams;
    private String plant;
    private boolean alertToBiz = Boolean.FALSE;
    private boolean alertToTec = Boolean.TRUE;
    private Exception exception;
    private boolean saveToDb = Boolean.FALSE;
}


