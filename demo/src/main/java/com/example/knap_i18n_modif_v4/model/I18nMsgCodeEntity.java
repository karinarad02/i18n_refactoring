package com.example.knap_i18n_modif_v4.model;

import com.example.knap_i18n_modif_v4.RepositoryConstants;
import com.example.knap_i18n_modif_v4.AuditableEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Getter
@Setter
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = RepositoryConstants.I18N_MSG_COD_ENTITY, schema = RepositoryConstants.SCHEMA_KNP)
public class I18nMsgCodeEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "knp06_i18n_msg_row_idt_seq")
    @SequenceGenerator(name = "knp06_i18n_msg_row_idt_seq", sequenceName = "knp06_i18n_msg_row_idt_seq", schema = RepositoryConstants.SCHEMA_KNP, allocationSize = 1)
    @Column(name = "row_idt")
    private Long rowIdt;

    @Column(name = "msg_cod")
    private String msgCode;
}

