package com.example.knap_i18n_modif_v4.repository;


import com.example.knap_i18n_modif_v4.model.I18nMsgTxtEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface I18nMsgTxtRepository extends JpaRepository<I18nMsgTxtEntity, Long> {

    List<I18nMsgTxtEntity> findByMsgCodeAndLanguageCode(String msgCode, String languageCode);

    List<I18nMsgTxtEntity> findAllByLanguageCodeAndDeleteStatusIsFalse(String languageCode);
}

