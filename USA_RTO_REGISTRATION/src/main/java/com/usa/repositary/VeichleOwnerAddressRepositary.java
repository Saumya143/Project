package com.usa.repositary;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usa.entity.VeclOwnerAddressDtlsEntity;
import com.usa.entity.VeichleOwnerDetailsEntity;

@Repository
public interface VeichleOwnerAddressRepositary extends JpaRepository<VeclOwnerAddressDtlsEntity,Serializable>{

}
