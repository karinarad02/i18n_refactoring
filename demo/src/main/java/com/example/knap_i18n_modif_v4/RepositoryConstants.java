package com.example.knap_i18n_modif_v4;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Application constants.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RepositoryConstants {

    public static final String POINT = ".";
    public static final String SEPARATOR = "_";
    public static final String SCHEMA_KNP = "knp";
    public static final String TABLE_KNP_05_TRT_PRM = "knp05_trt_prm";
    public static final String I18N_MSG_TXT_ENTITY = "knp04_i18n_msg";
    public static final String I18N_MSG_COD_ENTITY = "knp06_msg";

    public static final String SCHEMA_KNP_ASN_OUT = "knp_asn_out";
    public static final String SEQUENCE_NAME_SUFFIX = "_row_idt_seq";

    public static final String TABLE_PRM_PAU = "table_prm_pau";
    public static final String SCHEMA_PRM_PAU = "schema_prm_pau";

    public static final String DBMS_VERSION = "DBMS VERSION";
    public static final String DBMS_NAME = "DBMS NAME";

    public static final String UPD_ID_AUDITING_ENTITY = "updId";
    public static final String CRE_ID_AUDITING_ENTITY = "creId";
    public static final String UPD_DAT_AUDITING_ENTITY = "updDat";
    public static final String CRE_DAT_AUDITING_ENTITY = "creDat";
    public static final String DEL_STS_AUDITING_ENTITY = "delSts";

    public static final String UPD_ID_AUDITABLE_ENTITY = "updateBy";
    public static final String CRE_ID_AUDITABLE_ENTITY = "createBy";
    public static final String UPD_DAT_AUDITABLE_ENTITY = "updateDate";
    public static final String CRE_DAT_AUDITABLE_ENTITY = "creationDate";
    public static final String DEL_STS_AUDITABLE_ENTITY = "deleteStatus";

}

