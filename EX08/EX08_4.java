package cse3040ex08;

class Employee{
	String name;
	public Employee(String name) {
		this.name = name;
	}
}

public class EX08_4 {
	public static void changeName(Employee e, String newName) {
		e.name = newName;
	}
	public static void setName(String oldName, String newName) {
		oldName = newName;
	}
	
	public static void main(String[] args) {
		Employee m = new Employee("Peter");
		System.out.println(m.name);
		changeName(m, "John");
		System.out.println(m.name);
		setName(m.name, "James");
		System.out.println(m.name);
	}
}
