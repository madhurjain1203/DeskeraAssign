package dao;

import static utils.DBUtils.fetchDBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.Employee;

public class EmployeeDaoImpl implements IEmployeeDao{
	
	private Connection conn;
	private PreparedStatement pst1,pst2;
	
	public EmployeeDaoImpl() throws Exception
	{
		conn = fetchDBConnection();
		pst1 = conn.prepareStatement("select * from employee where id=?");
		pst2 = conn.prepareStatement("insert into employee values (?,?,?,?)");
	}
	
	@Override
	public Employee fetchEmployeeById(int id) throws SQLException
	{
		pst1.setInt(1, id);
		try(ResultSet rst=pst1.executeQuery())
		{
			while(rst.next())
				return new Employee(rst.getInt(1),rst.getString(2), rst.getString(3), 
						rst.getDate(4));
		}
		return null;
	}
	
	@Override
	public String hireEmployee(Employee e) throws SQLException
	{
		
		
		return "Employee Added..";
	}
	
	public void cleanUp() throws SQLException
	{
		if(pst1 != null)
			pst1.close();
		/*
		 * if(pst2 != null) pst2.close();
		 */
		if(conn != null)
			conn.close();
		System.out.println("Employee dao cleaned up...");
			
	}

}
