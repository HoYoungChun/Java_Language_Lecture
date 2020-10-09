package cse3040ex10;

class Employee{
	private String name;
	private int salary;
	public Employee() {
		this.name="NoName";
		this.salary = 0;
	}
	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }
	public int getSalary() { return this.salary; }
	public void setSalary(int salary) { this.salary = salary; }
}

class Manager extends Employee{
	private int bonus;
	public void setBonus(int bonus) { this.bonus = bonus; }
	public int getSalary() {
		return super.getSalary() + bonus;
	}
}

public class EX10_3 {

	public static void main(String[] args) {
		Manager m = new Manager();
		System.out.println(m.getName()+" "+m.getSalary());

	}

}
