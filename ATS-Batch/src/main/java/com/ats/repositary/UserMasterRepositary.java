package com.ats.repositary;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.entity.UserMasterEntity;

@Repository
public interface UserMasterRepositary extends JpaRepository<UserMasterEntity, Integer>{

}
