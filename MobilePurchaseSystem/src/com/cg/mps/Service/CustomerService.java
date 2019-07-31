package com.cg.mps.Service;

import java.util.ArrayList;

import com.cg.mps.DAO.CustomerDao;
import com.cg.mps.DTO.Customer;
import com.cg.mps.DTO.Mobile;
import com.cg.mps.Exception.CustomerException;

public interface CustomerService
{
	public int addCust(Customer cust) throws CustomerException;
	
	public void updateMobileQunt();
	
	public ArrayList<Mobile> fetchAllMob() throws CustomerException;
	
	public void deleteMobile (int mobId);
	
	public void getMobileByPrice(int max, int min);
	
	//Validation functions
	public boolean checkMobileQuant(int mobId);
	
	public boolean validateName(String name);
	
	public boolean validateMailId(String mid);
	
	public boolean validatePhoneNum(String phoneNum);
	
	public boolean validateMobileId(int MobId);
	
}
