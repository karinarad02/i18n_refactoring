package com.example.knap_i18n_modif_v4;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Clock;
import java.time.OffsetDateTime;

/**
 * Base abstract class for entities which will hold definitions for created, last modified by and created,
 * last modified by date.
 */
@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class AuditableEntity implements Serializable {

    /**
     * Delete status (true if deleted)
     */
    @Builder.Default
    @Column(name = "del_sts", length = 1, precision = 1, nullable = false)
    protected Boolean deleteStatus = Boolean.FALSE;

    /**
     * Creator ID
     */
    @Column(name = "cre_id", length = 20, precision = 20, nullable = false, updatable = false)
    protected String createBy;

    /**
     * Creation date
     */
    @Builder.Default
    @Column(name = "cre_dat", precision = 35, nullable = false, columnDefinition = "TIMESTAMP WITH TIME " +
            "ZONE", updatable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    protected OffsetDateTime creationDate = OffsetDateTime.now(Clock.systemUTC());

    /**
     * Updater ID
     */
    @Column(name = "upd_id", length = 20, precision = 20, nullable = false)
    protected String updateBy;

    /**
     * Updated date
     */
    @Builder.Default
    @Column(name = "upd_dat", precision = 35, nullable = false, columnDefinition = "TIMESTAMP WITH TIME " +
            "ZONE")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    protected OffsetDateTime updateDate = OffsetDateTime.now(Clock.systemUTC());

}

