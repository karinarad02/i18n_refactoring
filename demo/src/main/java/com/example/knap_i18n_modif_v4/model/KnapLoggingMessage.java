package com.example.knap_i18n_modif_v4.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "BuilderWithString")
public class KnapLoggingMessage {
    private String messageCode;
    private String[] messageParams;
    private String plant;
    private String tableSrcName;
    private Long srcRowIdt;
    private boolean alertToBiz = false;
    private boolean alertToTec = true;
    private Exception exception;
    private boolean saveToDatabase = true;

    public static class BuilderWithString{
        public BuilderWithString messageParams(String... params){
            this.messageParams = params;
            return this;
        }
    }
}


