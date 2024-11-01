# i18n_refactoring

Initial logging example: 
i18nService.log(log, LogLevel.ERROR, i18nService.generateLog(PlantApiI18nMsgEnum.HEADER_PARAM_NOT_FOUND, 
                new String[]{sysProps.getFullTreatmentName(), ex.getMissingParameters().toString()}, 
                sysProps.getPlantApiCode(), null, null, 
                MessageTypeEnum.TEC, ex), true); 

The generateLog function implementation:
public LogMessageDto generateLog(ExtendI18nEum msgCode, String[] params, String plant, String tableSrcName, Long srcRowIdt, MessageTypeEnum type, Throwable exception) { 
        LogMessageDto logMessageDto = new LogMessageDto(); 
        logMessageDto.setMsgCode(msgCode.getDescription()); 
        logMessageDto.setParams(params); 
        if (plant != null) { 
            logMessageDto.setPlant(plant.toUpperCase()); 
        } else { 
            logMessageDto.setPlant(KnapConstants.PLANT_CENTRAL.getLabel()); 
        } 
        logMessageDto.setTableSrcName(tableSrcName); 
        logMessageDto.setSrcRowIdt(srcRowIdt); 
        logMessageDto.setType(type); 
        logMessageDto.setException(exception); 
        return logMessageDto; 
    } 

The final logging call:
log.info("{}",KnapLoggingMessage.builder()
                .messageLabel("Some important message")
                .messageParams("param1", "param2")
                .plant("PlantCode")
                .alertToBiz(true)
                .saveToDatabase(true)
                .build());
