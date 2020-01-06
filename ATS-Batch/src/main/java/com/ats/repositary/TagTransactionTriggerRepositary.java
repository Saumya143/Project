package com.ats.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.entity.TagTransactionTriggerEntity;
@Repository
public interface TagTransactionTriggerRepositary extends JpaRepository<TagTransactionTriggerEntity, Integer> {

}
