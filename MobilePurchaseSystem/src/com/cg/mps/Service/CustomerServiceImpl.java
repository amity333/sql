package com.cg.mps.Service;

import java.util.ArrayList;
import java.util.regex.Pattern;

import com.cg.mps.DAO.CustomerDaoImpl;
import com.cg.mps.DTO.Customer;
import com.cg.mps.DTO.Mobile;
import com.cg.mps.Exception.CustomerException;

public class CustomerServiceImpl implements CustomerService
{
	
	CustomerDaoImpl cdi=new CustomerDaoImpl();
	
	@Override
	public int addCust(Customer cust) throws CustomerException {
		// TODO Auto-generated method stub
		return cdi.addCust(cust);
	}

	@Override
	public void updateMobileQunt() {
		// TODO Auto-generated method stub
		cdi.updateMobileQunt();
	}

	@Override
	public ArrayList<Mobile> fetchAllMob() throws CustomerException {
		// TODO Auto-generated method stub
		return cdi.fetchAllMob();
	}

	@Override
	public void deleteMobile(int mobId) {
		// TODO Auto-generated method stub
		cdi.deleteMobile(mobId);
	}

	@Override
	public void getMobileByPrice(int max, int min) {
		// TODO Auto-generated method stub
		cdi.getMobileByPrice(max, min);
	}
//---------------------------------//
	@Override
	public boolean validateName(String name) 
	{
		// TODO Auto-generated method stub
		if(name.matches("[A-Z][a-z]{1,19}"))
		{
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean validateMailId(String mid)
	{
		if(mid.matches("^(.+)@(.+)$"))
			return true;
		else
			return false;
	}

	@Override
	public boolean validatePhoneNum(String phoneNum) 
	{
		// TODO Auto-generated method stub
		if(phoneNum.matches("[7-9][0-9]{9}"))
			return true;
		else
			return false;
	}

	@Override
	public boolean validateMobileId(int mobId) 
	{
		return cdi.validateMobileId(mobId);
	}

	@Override
	public boolean checkMobileQuant(int mobId) {
		// TODO Auto-generated method stub
		return cdi.checkMobileQuant(mobId);
	}
	
}
