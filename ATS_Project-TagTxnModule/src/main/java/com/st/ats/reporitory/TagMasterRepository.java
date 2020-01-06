package com.st.ats.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.st.ats.entity.TagMasterEntity;

public interface TagMasterRepository extends JpaRepository<TagMasterEntity, Long>{

	@Query("select userId  from TagMasterEntity where tagId=:tagId")
	public Long findUserId(Long tagId);
	
	
}
