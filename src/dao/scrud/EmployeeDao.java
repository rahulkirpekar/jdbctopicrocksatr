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
	public int update(int updatedId,EmployeeBean ebean) 
	{
		int rowsAffected = 0;
		String updateQuery = "UPDATE employee SET name = '"+ebean.getName()+"', salary ="+ebean.getSalary()+" ,dsgn='"+ebean.getDsgn()+"',orgName='"+ebean.getOrgname()+"' WHERE id="+updatedId;
		Statement stmt = null;
		Connection conn = DbConnection.getConnection();
		//  validate Connection object
		if (conn!=null) 
		{
			try 
			{
				stmt = conn.createStatement();
				rowsAffected = stmt.executeUpdate(updateQuery);
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("EmployeeDao--update() --Db not Connected : " + conn);
		}
		return rowsAffected;

	}
	public int delete(int id) 
	{
		String deleteQuery = "DELETE FROM employee WHERE id="+id;
		Connection conn = DbConnection.getConnection();
		Statement stmt= null;
		int rowsAffected = 0 ; 
		if (conn!=null) 
		{
			try 
			{
				stmt= conn.createStatement();
				rowsAffected = stmt.executeUpdate(deleteQuery);
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("EmployeeDao -- Db not connected");
		}
		return rowsAffected;
	}
	public void getAllRecords() 
	{

	}
	public static void main(String[] args) 
	{
		
		EmployeeDao dao = new EmployeeDao();
		EmployeeBean ebean1 = new EmployeeBean();
		ebean1.setName("Rahul");
		ebean1.setSalary(1000);
		ebean1.setDsgn("SE");
		ebean1.setOrgname("Royal");

		dao.insert(ebean1);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID which you want to update emp record : ");
		int id = sc.nextInt();
		sc.nextLine();
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
		ebean1 = new EmployeeBean();
		ebean1.setName(name);
		ebean1.setSalary(salary);
		ebean1.setDsgn(dsgn);
		ebean1.setOrgname(orgname);

		
		// create EmployeeDao 
		
		
		
		int rowsAffected = dao.update(id,ebean1);
		
		if (rowsAffected > 0)
		{
			System.out.println("Employee Record succcessfully Updated : " + rowsAffected);
		} else 
		{
			System.out.println("Employee Record not Updated : " + rowsAffected);
		}
	}
}
