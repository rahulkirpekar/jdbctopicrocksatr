package dao.scrud;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import bean.EmployeeBean;
import util.DbConnection;

// Employee---create method---[Statement Interface]
public class EmployeeDao 
{
	public  int insert(EmployeeBean ebean) 
	{
		int rowsAffected = 0;
		String insertQuery = "INSERT INTO employee(name,salary,dsgn,orgname) VALUE ('"+ebean.getName()+"',"+ebean.getSalary()+" ,'"+ebean.getDsgn()+"','"+ebean.getOrgname()+"')";
		Statement stmt = null;
		Connection conn = DbConnection.getConnection();
		//  validate Connection object
		if (conn!=null) 
		{
			try 
			{
				stmt = conn.createStatement();
				rowsAffected = stmt.executeUpdate(insertQuery);
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("EmployeeDao--insert() --Db not Connected : " + conn);
		}
		return rowsAffected;
	}
	public  void update() 
	{

	}
	public void delete() {

	}
	public void getAllRecords() 
	{

	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name : ");
		String name = sc.nextLine();
		System.out.println("Enter Salary : ");
		int salary = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Dsgn : ");
		String dsgn = sc.nextLine();
		System.out.println("Enter OrgName : ");
		String orgname = sc.nextLine();
		
		
		// Create EmployeeBean 
		EmployeeBean ebean = new EmployeeBean();
		ebean.setName(name);
		ebean.setSalary(salary);
		ebean.setDsgn(dsgn);
		ebean.setOrgname(orgname);

		
		// create EmployeeDao 
		
		EmployeeDao dao = new EmployeeDao();
		
		int rowsAffected = dao.insert(ebean);
		
		if (rowsAffected > 0)
		{
			System.out.println("Employee Record succcessfully Inserted : " + rowsAffected);
		} else 
		{
			System.out.println("Employee Record not Inserted : " + rowsAffected);
		}
	}
}
