package com.ats.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.entity.TagMasterEntity;

public interface TagMasterRepositary extends JpaRepository<TagMasterEntity, Integer> {

}
