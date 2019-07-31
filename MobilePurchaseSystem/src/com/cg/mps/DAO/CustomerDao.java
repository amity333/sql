package com.cg.mps.DAO;

import java.util.ArrayList;

import com.cg.mps.DTO.Customer;
import com.cg.mps.DTO.Mobile;
import com.cg.mps.Exception.CustomerException;

public interface CustomerDao
{
	public int addCust(Customer cust) throws CustomerException;
	
	public void updateMobileQunt();
	
	public ArrayList<Mobile> fetchAllMob() throws CustomerException;
	
	public void deleteMobile (int mobId);
	
	public void getMobileByPrice(int max, int min);
	
	public boolean checkMobileQuant(int mobId);
	
	public boolean validateMobileId(int MobId);
}
