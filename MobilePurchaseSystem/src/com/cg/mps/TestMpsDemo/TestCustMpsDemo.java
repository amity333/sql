package com.cg.mps.TestMpsDemo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.mps.DTO.Customer;
import com.cg.mps.DTO.Mobile;
import com.cg.mps.Exception.CustomerException;
import com.cg.mps.Service.CustomerServiceImpl;
import com.cg.mps.util.MyStringDateUtil;

public class TestCustMpsDemo
{
	static Scanner sc=new Scanner(System.in);
	static Customer cust=null;
	static CustomerServiceImpl csi=null;
	public static void main(String[] args) 
	{
		System.out.println("What do you want to do---> 1:insert new customer\t\t2:get the mobile by price\t\t3:fetch details of all the mobiles\t\t4:delete a mobile detail\t\t");
		
		while(true)
		{
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1: cusIns();break;
			case 2: mobRange(); break;
			case 3: fetchDetails(); break;
			case 4: delMobile(); break;
			default: System.exit(1);
			}
		}
	}
	private static void fetchDetails() 
	{//System.out.println("hello22");
		csi=new CustomerServiceImpl();
		ArrayList<Mobile> arr=new ArrayList<Mobile>();
		try 
		{
			arr=csi.fetchAllMob();
			for(Mobile m:arr)
			{
				System.out.println(m);
			}
			
		}
		catch (CustomerException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void delMobile() 
	{
		csi=new CustomerServiceImpl();
		System.out.println("Enter the mobid to be deleted");
		int mobId=sc.nextInt();
		csi.deleteMobile(mobId);
	}
	private static void mobRange() 
	{
		System.out.println("Enter the Min price");
		int min=sc.nextInt();
		System.out.println("Enter the Max price");
		int max=sc.nextInt();
		csi=new CustomerServiceImpl();
		csi.getMobileByPrice(max, min);
		
	}
	
	
	private static void cusIns()
	{
		csi=new CustomerServiceImpl();
		
		System.out.println("Enter the Mobile ID");
		int mid=sc.nextInt();
		
		if(csi.checkMobileQuant(mid))
		{
		System.out.println("Enter the purchaseId number");
		int pidNum=sc.nextInt(); 
		
		System.out.println("Enter the Name of the Customer");
		String cus=sc.next();
		
		if(csi.validateName(cus))
		{
			System.out.println("Enter the Email");
			String email=sc.next();
			if(csi.validateMailId(email))
			{
				System.out.println("Enter the Phone number");
				String phNum=sc.next();
				
				if(csi.validatePhoneNum(phNum))
				{
					try {
					System.out.println("Enter the purchase Date indd-mm-yyyy format");
					String dt=sc.next();
					LocalDate lDate;
					lDate=MyStringDateUtil.fromStringToLocalDate(dt);
					cust=new Customer(pidNum, cus, email,phNum,lDate, mid);
					
					
						int recIns=csi.addCust(cust);
					}
					catch (CustomerException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else
					System.out.println("Invalid phone number");
			}
			else
				System.out.println("Invalid email");
		}
		else
			System.out.println("Invalid Name");
	}
	 else
		System.out.println("Mobile not available");
	}
}
