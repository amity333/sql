package com.cg.mps.Junit;

import com.cg.mps.DAO.CustomerDaoImpl;
import com.cg.mps.TestMpsDemo.TestCustMpsDemo;

public class JunitCheck 
{
	//CustomerDaoImpl cdi=new CustomerDaoImpl();
	public static boolean intCheck(int i)
	{
		String s=Integer.toString(i);
		if(s.matches("\\d+"))
			return true;
			else
				return false;
	}
	public static void main(String[] args) 
	{
		System.out.println(JunitCheck.intCheck(TestCustMpsDemo.cusIns()));
		//System.out.println(TestCustMpsDemo.cusIns());
	}
	
}
