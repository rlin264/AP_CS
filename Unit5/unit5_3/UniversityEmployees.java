package unit5_3;

import java.text.DecimalFormat;

public class UniversityEmployees 
{
	public static void main(String[] args)
	{
		Faculty m = new Faculty("Marie Curie", 182000, "Physics", "Tenure");
		Staff a = new Staff("Alex Smith", 65820, "Maintenance");
		System.out.println(m.toString());
		System.out.println("Monthly Salary: " + m.monthlySalary());
		System.out.println(a.toString());
		System.out.println("Monthly Salary: " + a.monthlySalary());
	}
}
class UEmployee
{
	private String employeeName;
	private double salary;
	DecimalFormat df = new DecimalFormat("#.##");
	
	public UEmployee(String employeeName, double salary)
	{
		this.employeeName = employeeName;
		this.salary = salary;
	}
	public String getEmployeeName()
	{
		return employeeName;
	}
	public double getSalary()
	{
		return Double.valueOf(df.format(salary));
	}
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
}
class Faculty extends UEmployee
{
	private String departmentName;
	private boolean tenure;
	public Faculty(String employeeName, double salary, String departmentName, String tenure)
	{
		super(employeeName, salary);
		this.departmentName = departmentName;
		if(tenure.equals("Tenure")) this.tenure = true;
		else this.tenure = false;
	}
	public String getDeparment()
	{
		return departmentName;
	}
	public double monthlySalary()
	{
		return Double.valueOf(df.format(super.getSalary()/12));
	}
	public String toString()
	{
		return "Employee Name: " + super.getEmployeeName() + "\nDepartment: " + this.getDeparment();
	}
}
class Staff extends UEmployee
{
	private String jobTitle;
	
	public Staff(String employeeName, double salary, String jobTitle)
	{
		super(employeeName, salary);
		this.jobTitle = jobTitle;
	}
	public String getJobTitle()
	{
		return jobTitle;
	}
	public void setJobTitle(String jobTitle)
	{
		this.jobTitle = jobTitle;
	}
	public double monthlySalary()
	{
		return Double.valueOf(df.format(super.getSalary()/12));
	}
	public String toString()
	{
		return "Employee Name: " + super.getEmployeeName() + "\nJob Title: " + this.getJobTitle();
	}
}
