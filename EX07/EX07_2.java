package cse3040ex07;

class Employee{
	private String name;
	private int salary;
	
	public Employee() {
		this.name = "Employee";
		this.salary = 50000;
	}
	public Employee(String s) {
		this.name = s;
		this.salary = 50000;
	}
	public Employee(String s, int sal) {
		this.name = s;
		this.salary = sal;
	}
	
	public String getName() {
		return this.name;
	}
	public int getSalary() {
		return this.salary;
	}
	public void setSalary(int sal) {
		this.salary = sal;
	}
}

public class EX07_2 {
	public static void main(String[] args) {
		Employee e1 = new Employee("John", 100000);
		Employee e2 = new Employee("Peter");
		Employee e3 = new Employee();
		System.out.println("Salary of "+e1.getName()+" is "+e1.getSalary());
		System.out.println("Salary of "+e2.getName()+" is "+e2.getSalary());
		System.out.println("Salary of "+e3.getName()+" is "+e3.getSalary());
		e1.setSalary(150000);
		System.out.println("Salary of "+e1.getName()+" is "+e1.getSalary());
	}
}
