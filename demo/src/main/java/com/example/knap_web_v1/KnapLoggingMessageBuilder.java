package com.example.knap_web_v1;

public class KnapLoggingMessageBuilder {
    private String messageLabel;
    private String[] messageParams = new String[0];
    private String plant;
    private boolean alertToBiz = false;
    private boolean alertToTec = false;
    private Exception exception;
    private boolean saveToDb = false;

    public KnapLoggingMessageBuilder messageLabel(String messageLabel) {
        this.messageLabel = messageLabel;
        return this;
    }
    //nr. variabil de param.
    public KnapLoggingMessageBuilder messageParams(String... messageParams) {
        this.messageParams = messageParams;
        return this;
    }

    public KnapLoggingMessageBuilder plant(String plant) {
        this.plant = plant;
        return this;
    }

    //biz alert
    public KnapLoggingMessageBuilder alertToBiz() {
        this.alertToBiz = true;
        return this;
    }

    //tec alert
    public KnapLoggingMessageBuilder alertToTec() {
        this.alertToTec = true;
        return this;
    }

    public KnapLoggingMessageBuilder withException(Exception exception) {
        this.exception = exception;
        return this;
    }

    public KnapLoggingMessageBuilder saveToDb() {
        this.saveToDb = true;
        return this;
    }

    public KnapLoggingMessage build() {
        return new KnapLoggingMessage(messageLabel, messageParams, plant, alertToBiz,
                alertToTec, exception, saveToDb);
    }
}

