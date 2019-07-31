package com.cg.mps.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.mps.DTO.Customer;
import com.cg.mps.DTO.Mobile;
import com.cg.mps.Exception.CustomerException;
import com.cg.mps.util.DBUtil;
import com.cg.mps.util.MyStringDateUtil;

public class CustomerDaoImpl implements CustomerDao
{

	Connection con=null;
	PreparedStatement pst,pst1=null;
	Statement st=null;
	ResultSet rs,rs1=null;
	
	@Override
	public int addCust(Customer cust) throws CustomerException 
	{
		CustomerDaoImpl cdi=new CustomerDaoImpl();
		
		int mobId=cust.getMobileId();
		
		int recIns=0;
		try 
		{
			con=DBUtil.getCon();
			PreparedStatement pstq=con.prepareStatement("select * from Mobiles where mobileid=?");
			
			pstq.setInt(1, mobId);
			int o=pstq.executeUpdate();
			ResultSet rsq=pstq.executeQuery();
			boolean b=rsq.next();
			
			int quant=rsq.getInt(4);
			PreparedStatement psto=con.prepareStatement("update Mobiles set quantity=? Where Mobileid=?");
			psto.setInt(2, mobId);
			psto.setInt(1, quant-1);
			
			o=psto.executeUpdate();
			System.out.println(quant);
			
			
			if(pstq!=null && cdi.checkMobileQuant(mobId))
			{
				
				pst=con.prepareStatement(QueryMapper.EMP_INSERT_QRY);
				
				pst.setInt(1, cust.getPurchaseIdNumber());
				pst.setString(2, cust.getCname());
				pst.setString(3, cust.getMailId());
				pst.setString(4,cust.getPhoneNo());
				pst.setDate(5,MyStringDateUtil.fromLocalToSqlDate(cust.getLd()));
				pst.setInt(6, cust.getMobileId());
				
				
				//pstq.setInt(4, quant-1);
				System.out.println("Table updated");
				recIns=pst.executeUpdate();
			}
			else
			{
				System.out.println("Mobile not found");
			}
			
		} 
		catch (ClassNotFoundException | IOException | SQLException e) 
		{	
			e.printStackTrace();
		}
		
		return recIns;
	}
	
	@Override
	public void updateMobileQunt()
	{
		/*try 
		{
			con=DBUtil.getCon();
			pst=con.prepareStatement("Select * from purchasedetails");
			rs=pst.executeQuery();
			
			pst1=con.prepareStatement("Select * from Mobiles ");
			rs1=pst1.executeQuery();
			
			ArrayList<Integer> ar=new ArrayList<Integer>();
			while(rs.next() && rs1.next())
			{
				ar.add(rs.getInt(6));
				if(rs.getInt(6)==rs1.getInt(1))
				{
					pst
				}
			}
		}
		catch (ClassNotFoundException | CustomerException | IOException
				| SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
	}

	@Override
	public ArrayList<Mobile> fetchAllMob() throws CustomerException
	{
		ArrayList<Mobile> arr=new ArrayList<Mobile>();
		try {
			con=DBUtil.getCon();
			pst=con.prepareStatement(QueryMapper.MOB_SELECTALL);
			rs=pst.executeQuery();
			while(rs.next())
			{
				arr.add(new Mobile(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
			}
		} 
		catch (ClassNotFoundException | IOException | SQLException e) 
		{
			e.printStackTrace();
		}
	
		return arr;
	}

	@Override
	public void deleteMobile(int mobId)
	{	
		
		try
		{
				con=DBUtil.getCon();
				pst1=con.prepareStatement(QueryMapper.PUR_DEL_QRY);
				pst1.setInt(1,mobId);
				pst1.executeQuery();
				pst=con.prepareStatement(QueryMapper.MOB_DEL_QRY);
				pst.setInt(1,mobId);
				pst.executeQuery();
		} 
		catch (ClassNotFoundException | CustomerException | IOException| SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void getMobileByPrice(int max, int min) 
	{
		try
		{
			con=DBUtil.getCon();
			pst=con.prepareStatement(QueryMapper.MOB_SEL_BYSALRANGE);
			pst.setInt(1, min);
			pst.setInt(2,max);
			rs=pst.executeQuery();
			while(rs.next())	
			{
				System.out.println(rs.getString("Name"));
			}
		}
		catch (ClassNotFoundException | CustomerException | IOException| SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public boolean checkMobileQuant(int mobId) 
	{
		try 
		{
			con=DBUtil.getCon();
			pst=con.prepareStatement("select * from Mobiles where mobileid=?");
			pst.setInt(1,mobId);
			
			rs=pst.executeQuery();
			boolean b=rs.next();
			if(rs.getInt(4)>0)
				return true;
			
			else 
				return false;
		} 
		catch (ClassNotFoundException | CustomerException | IOException
				| SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean validateMobileId(int MobId) 
	{ 
		boolean f=false;
		try 
		{
			con=DBUtil.getCon();
			
			pst=con.prepareStatement("select * from Mobiles where mobileid=?");
			pst.setInt(1, MobId);
			
			rs=pst.executeQuery();
			
			
			ArrayList<Integer> ar=new ArrayList<Integer>();
			if(rs!=null)
			while(rs.next())
			{
				ar.add(rs.getInt(1));
			}
			//&& ar.get(i)==MobId
			String mobileId=Integer.toString(MobId);
			for(Integer i:ar)
			{
				if(mobileId.matches("\\d{4}") )
				{
					f= true;
				}
				else
					f=false;
				} 
			}
		catch (ClassNotFoundException | CustomerException | IOException| SQLException e) 
		{
		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
		
	}


	

}
