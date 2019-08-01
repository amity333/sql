package com.cg.mps.Junit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.mps.DAO.CustomerDaoImpl;
import com.cg.mps.Service.CustomerServiceImpl;
import com.cg.mps.TestMpsDemo.TestCustMpsDemo;

public class JunitDemo
{
	CustomerDaoImpl cdi;
	TestCustMpsDemo tcmd=new TestCustMpsDemo();
	CustomerServiceImpl csi=new CustomerServiceImpl();
	
	
	@Test
	public void testIns()
	{
		//JunitCheck jc=new JunitCheck();
		Assert.assertTrue(JunitCheck.intCheck(TestCustMpsDemo.cusIns()));
	}
	@Test
	public void delTest()
	{
		Assert.assertTrue(JunitCheck.intCheck(TestCustMpsDemo.delMobile()));
	}
	
	@Test
	public void valName()
	{
		Assert.assertTrue(csi.validateName("Parth"));
	}
	
	@Test
	public void valMobileNum()
	{
		Assert.assertTrue(csi.validatePhoneNum("8018157255"));
	}
	@Test
	public void valEmailId()
	{
		Assert.assertTrue(csi.validateMailId("parth@gmail.com"));
	}
	@Test
	public void rangeTest()
	{
		Assert.assertNotNull(csi.getMobileByPrice(100000, 1000));
	}
}
