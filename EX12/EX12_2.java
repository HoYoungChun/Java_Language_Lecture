package cse3040ex12;

class Employee{
	private String name;
	protected int salary;
	public Employee(String name, int salary) { this.name = name; this.salary = salary; }
	public String getName() { return this.name; }
	public int getSalary() { return this.salary; }
	public int hashCode() {
		return this.name.hashCode() + salary;
	}
}

public class EX12_2 {
	public static void main(String[] args) {
		Employee e1 = new Employee(new String("John"),50000);
		Employee e2 = new Employee(new String("John"),50000);
		System.out.println(e1.equals(e2));
		System.out.println(e1.hashCode() +" "+ e2.hashCode());
	}
}
