package com.cg.mps.DAO;

public interface QueryMapper 
{
	//public static final String EMP_INSERT_QRY="INSERT into Emp_Parth(empId,empName,empSal) Values (?,?,?)";
	public static final String EMP_INSERT_QRY="INSERT into purchasedetails  values(?,?,?,?,?,?)";
	
	public static final String MOB_DEL_QRY="DELETE from MOBILES WHERE MOBILEID=?";
	
	public static final String PUR_DEL_QRY="DELETE from purchasedetails WHERE MOBILEID=?";
	
	public static final String MOB_SELECTALL="SELECT * from MOBILES";
	
	public static final String EMP_SEL_BYID="SELECT * from Emp_Parth WHERE empId=?";
	
	public static final String MOB_SEL_BYSALRANGE=  "SELECT  *  from  MOBILES WHERE  price>= ? and price<=?";
	
	public static final String CUS_UPD_MOB=  "SELECT  *  from  Mobiles WHERE MobileId = ? ";
}
