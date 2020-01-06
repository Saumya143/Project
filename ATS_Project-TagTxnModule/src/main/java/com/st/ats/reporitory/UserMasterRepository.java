package com.st.ats.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.st.ats.entity.UserMasterEntity;

/**
 * this  repository is used  for perform database side operation for atsuser data 
 * 
 * @author SAUMYA
 *
 */
public interface UserMasterRepository extends  JpaRepository<UserMasterEntity, Long>{
	
}
