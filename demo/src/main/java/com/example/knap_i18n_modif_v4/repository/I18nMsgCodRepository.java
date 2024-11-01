package com.example.knap_i18n_modif_v4.repository;


import com.example.knap_i18n_modif_v4.model.I18nMsgCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface I18nMsgCodRepository extends JpaRepository<I18nMsgCodeEntity, Long> {

    Optional<I18nMsgCodeEntity> findByMsgCode(String msgCode);
}

