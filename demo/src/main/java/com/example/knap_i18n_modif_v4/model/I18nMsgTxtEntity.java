package com.example.knap_i18n_modif_v4.model;


import com.example.knap_i18n_modif_v4.RepositoryConstants;
import com.example.knap_i18n_modif_v4.AuditableEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;


@Getter
@Setter
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = RepositoryConstants.I18N_MSG_TXT_ENTITY, schema = RepositoryConstants.SCHEMA_KNP)
public class I18nMsgTxtEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "knp04_i18n_msg_row_idt_seq")
    @SequenceGenerator(name = "knp04_i18n_msg_row_idt_seq", sequenceName = "knp04_i18n_msg_row_idt_seq", schema = RepositoryConstants.SCHEMA_KNP, allocationSize = 1)
    @Column(name = "row_idt")
    private Long rowIdt;

    @Column(name = "msg_cod")
    private String msgCode;

    @Column(name = "lng_639_1")
    private String languageCode;

    private String txt;

    @Column(name = "msg_prm_cmt")
    private String msgPrmCmt;
}

