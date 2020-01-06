package com.usa.repositary;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usa.entity.VeichleDetailsEntity;

public interface VeichleDetaisRepositary extends JpaRepository<VeichleDetailsEntity, Serializable>{

}
