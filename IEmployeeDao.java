package dao;

import java.sql.SQLException;

import pojo.Employee;

public interface IEmployeeDao {
	Employee fetchEmployeeById(int id) throws SQLException;
	public String hireEmployee(Employee e) throws SQLException;

}
