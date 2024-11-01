# i18n_refactoring

## Overview
This project focuses on refactoring the logging system to improve clarity and efficiency. The new implementation uses a builder pattern to construct log messages, replacing the older i18n service method.

## Initial Logging Example
The initial logging implementation using the `i18nService` is shown below:
```java
/*i18nService.log(log, LogLevel.ERROR, i18nService.generateLog(PlantApiI18nMsgEnum.HEADER_PARAM_NOT_FOUND, 
                new String[]{sysProps.getFullTreatmentName(), ex.getMissingParameters().toString()}, 
                sysProps.getPlantApiCode(), null, null, 
                MessageTypeEnum.TEC, ex), true);*/
```

## The generateLog function implementation:
``` java
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
```

## The final logging call:
``` java 
log.info("{}",KnapLoggingMessage.builder()
                .messageLabel("Some important message")
                .messageParams("param1", "param2")
                .plant("PlantCode")
                .alertToBiz(true)
                .saveToDatabase(true)
                .build());
```

## Initial approach v1:
- replace LogMessageDto with a new structure KnapLoggingMessage
- add a Builder to the class
- create a controller with different elements (return a String, return the constructed message,call usiong params)
- create an interceptor for different actions (preHandle,postHandle,afterCompletion)

## Next phase v2:
- implement aop principals on interceptor
- capture all methods called in the controller
- attempted to generalise interception, but it can't intercept all types of logs
- cannot separate log types in order to perform different actions

## Next step v3:
- decided to use a custom logging function
- create an interface with all types of logs
- implement the interface attributing the corresponding logs

## Breaking point v4:
- change the service implementation to have the same checks and functionality as the class that needed refactoring
- add the other necessary classes the implementation is dependent on

