package com.example.knap_i18n_modif_v4;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum KnapConstants {

    // Specific Headers for HTTP request
    CALLER_IPN("Caller-IPN"),

    // Specific logs keys
    KEY_PLT_CODE("plant_api_code"),

    MSG_CODE("message_code"),

    // Specific constants for CENTRAL plant
    PLANT_CENTRAL("CENTRAL"), PLANT_CENTRAL_DB("---");

    private final String label;

    public static String convertPlantToDB(String plantCode) {
        return PLANT_CENTRAL.getLabel().equalsIgnoreCase(plantCode) ? PLANT_CENTRAL_DB.getLabel() : plantCode;
    }

    public static String convertPlantFromDB(String plantCode) {
        return StringUtils.isEmpty(plantCode) || PLANT_CENTRAL_DB.getLabel().equalsIgnoreCase(plantCode) ? PLANT_CENTRAL.getLabel() : plantCode;
    }

}

