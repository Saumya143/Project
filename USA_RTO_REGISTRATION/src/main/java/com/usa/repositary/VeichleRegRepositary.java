package com.usa.repositary;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.usa.entity.VeichleRegDetailsEntity;

public interface VeichleRegRepositary extends JpaRepository<VeichleRegDetailsEntity, Serializable> {
	@Query("from VeichleRegDetailsEntity e where e.veichlOwnerId.VIECHLE_OWNER_ID = :oid")
	Optional<VeichleRegDetailsEntity> findByOwnerID(int oid);
}
