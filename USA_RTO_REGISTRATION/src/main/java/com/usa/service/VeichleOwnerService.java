package com.usa.service;

import com.usa.bo.VeichleDetailsBO;
import com.usa.bo.VeichleOwnerAddresBO;
import com.usa.bo.VeichleOwnerBO;
import com.usa.bo.VeichleRegistrationBO;

public interface VeichleOwnerService {
	public int insert(VeichleOwnerBO veichleOwnerDetails);
    public void edit( Integer veichleOwnerId);
    public int insertOwnerAddress(VeichleOwnerAddresBO bo,Integer ownerID);
    public int insertVeichleDetails(VeichleDetailsBO bo,Integer ownerID);
    public int insertVeichleReg(VeichleRegistrationBO bo,Integer ownerID);
}
