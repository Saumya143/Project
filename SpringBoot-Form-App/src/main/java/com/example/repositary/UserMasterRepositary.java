package com.example.repositary;
import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.UserEntity;

@Repository
public interface UserMasterRepositary extends JpaRepository<UserEntity, Serializable> {
	
	@Query(value="select email from UserEntity")
	public List<String> findAllEmailId();

	/*
	 * @Query(value="select email from UserEntity where UserId=:uid") public
	 * List<String> findEmailById();
	 */

}
