package unit5_3;

import java.text.DecimalFormat;

public class UniversityEmployees 
{
	public static void main(String[] args)
	{
		
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
}
class Faculty extends UEmployee
{
	private String departmentName;
	private boolean tenure;
	public Faculty(String employeeName, double salary, String departmentName, String tenure)
	{
		super(employeeName, salary);
		this.departmentName = departmentName;
		if(tenure.equals("Tenure")) tenure
	}
}
