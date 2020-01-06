package com.usa.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.bo.VeichleDetailsBO;
import com.usa.bo.VeichleOwnerAddresBO;
import com.usa.bo.VeichleOwnerBO;
import com.usa.bo.VeichleRegistrationBO;
import com.usa.entity.VeclOwnerAddressDtlsEntity;
import com.usa.entity.VeichleDetailsEntity;
import com.usa.entity.VeichleOwnerDetailsEntity;
import com.usa.entity.VeichleRegDetailsEntity;
import com.usa.repositary.VeichleDetaisRepositary;
import com.usa.repositary.VeichleOwnerAddressRepositary;
import com.usa.repositary.VeichleOwnerRepositary;
import com.usa.repositary.VeichleRegRepositary;

@Service
public class VeichleOwnerServiceImpl implements VeichleOwnerService {

	@Autowired
	VeichleOwnerRepositary veichleOwnerRepositary;
	@Autowired
	VeichleOwnerAddressRepositary veichleOwnerAddressRepositary;
	@Autowired
	VeichleDetaisRepositary veichleDetaisRepositary;
	@Autowired
	VeichleRegRepositary veichleRegRepositary;

	@Override
	public int insert(VeichleOwnerBO bo) {
		System.out.println("VeichleOwnerServiceImpl.insert()");
		VeichleOwnerDetailsEntity entity = null;
		entity = new VeichleOwnerDetailsEntity();
		BeanUtils.copyProperties(bo, entity);
		VeichleOwnerDetailsEntity save = veichleOwnerRepositary.save(entity);
		int ownerId = save.getVeichleOwnerId();
		return ownerId;
	}

	@Override
	public void edit(Integer veichleOwnerId) {
		Optional<VeichleOwnerDetailsEntity> optional = veichleOwnerRepositary.findById(veichleOwnerId);
		if (optional.isPresent()) {
			VeichleOwnerDetailsEntity veichleOwnerDetailsEntity = optional.get();
			VeichleOwnerBO bo = new VeichleOwnerBO();
			BeanUtils.copyProperties(veichleOwnerDetailsEntity, bo);
		}
	}

	@Override
	public int insertOwnerAddress(VeichleOwnerAddresBO bo, Integer ownerID) {
		VeclOwnerAddressDtlsEntity ownerAddrsEntity = null;
		ownerAddrsEntity = new VeclOwnerAddressDtlsEntity();
		Optional<VeichleOwnerDetailsEntity> findById = veichleOwnerRepositary.findById(ownerID);
		BeanUtils.copyProperties(bo, ownerAddrsEntity);
		if (findById.isPresent()) {
			VeichleOwnerDetailsEntity vchl_owner_Dtls = null;
			vchl_owner_Dtls = findById.get();
			ownerAddrsEntity.setVeichlOwnerId(vchl_owner_Dtls);
		}
		VeclOwnerAddressDtlsEntity save = veichleOwnerAddressRepositary.save(ownerAddrsEntity);

		return ownerID;

	}

	@Override
	public int insertVeichleDetails(VeichleDetailsBO bo,Integer ownerID) {
		VeichleDetailsEntity veichleEntity = null;
		veichleEntity = new VeichleDetailsEntity();
		Optional<VeichleOwnerDetailsEntity> findById = veichleOwnerRepositary.findById(ownerID);
		BeanUtils.copyProperties(bo, veichleEntity);
		if(findById.isPresent()) {
           //VeichleDetailsEntity veclDtlsEntity=null;
		VeichleOwnerDetailsEntity veichleOwnerDetailsEntity = findById.get();
		veichleEntity.setVeichlOwnerId(veichleOwnerDetailsEntity);
		}
		veichleDetaisRepositary.save(veichleEntity);
		return ownerID;
	}

	@Override
	public int insertVeichleReg(VeichleRegistrationBO bo, Integer ownerID) {
        VeichleRegDetailsEntity entity=null;
        entity=new VeichleRegDetailsEntity();
        Optional<VeichleOwnerDetailsEntity> findById = veichleOwnerRepositary.findById(ownerID);
        BeanUtils.copyProperties(bo, entity);
        if(findById.isPresent()) {
        	VeichleOwnerDetailsEntity veichleRegDetailsEntity = findById.get();
        	entity.setVeichlOwnerId(veichleRegDetailsEntity);
        }
        veichleRegRepositary.save(entity);
        return ownerID;

	}

}
