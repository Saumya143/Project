package com.st.ats.service;

import java.util.List;
import com.st.ats.model.AtsUser;

public interface AdminService {

	
	public List<AtsUser> findBasedOnRoles(String role);
	
	public List<AtsUser> findDeActiveBasedOnRoles(String role);
	
	public List<AtsUser> findActiveBasedOnRoles(String role);
	
	public List<AtsUser> deactivateBasedOnRole(String role);
	
	public List<AtsUser> activateBasedOnRole(String role);
	
}
