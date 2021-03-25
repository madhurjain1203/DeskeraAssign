package tester;
import java.util.Date;
import java.util.Scanner;

import dao.EmployeeDaoImpl;
import pojo.Employee;

public class TestCrud {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			// dao inst
			EmployeeDaoImpl dao = new EmployeeDaoImpl();
			while (!exit) {
				System.out.println("Options : \n 1 Add New Employee \n 2 Find Employee by id \n 10 : Exit");
				try {
					switch (sc.nextInt()) {
					case 1: // find
						System.out.println("Enter email and password");
						// invoke DAO's method
						System.out.println(dao.fetchEmployeeById(sc.nextInt()));
						break;
						
					case 2: // insert
					    System.out.println("Enter employee details : id, firstname, lastname and birth date(yr-mon-day)");
						System.out.println(dao.hireEmployee(new Employee(sc.nextInt(), sc.next(),
						sc.next(),Date.parse(sc.next())))); 
						 break;
					
					case 3:
						
						break;
						
					case 10:
						System.exit(0);
						break;
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
							 

	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
	
