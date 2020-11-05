package cse3040ex11;

class Employee{
	private String name;
	protected int salary;
	public Employee(String name, int salary) { this.name = name; this.salary = salary; }
	public String getName() { return this.name; }
	public int getSalary() { return this.salary; }
	public String toString() {
		return (name+", Employee, salary: "+salary);
	}
}

class Manager extends Employee{
	private int bonus;
	public Manager(String name, int salary) {
		super(name,salary);
		this.bonus = 10000;
	}
	public void setBonus(int bonus) { this.bonus = bonus; }
	public int getSalary() { return salary + bonus; }
	public String toString() {
		return (super.getName()+", Manager, salary: "+salary+", bonus: "+bonus);
	}
}

public class EX11_3 {
	public static void main(String[] args) {
		Employee e1 = new Employee("John",50000);
		Manager e2 = new Manager("Peter",100000);
		System.out.println(e1);
		System.out.println(e2);
	}
}
