package cse3040ex10;

class Employee{
	private String name;
	protected Employee supervisor;
	protected Employee() { this.name = "NoName"; }
	public boolean worksFor(Employee supervisor) {
		System.out.println("Employee.worksFor");
		return (this.supervisor == supervisor);
	}
}

class Manager extends Employee{
	public boolean worksFor(Manager supervisor) {
		System.out.println("Manager.worksFor");
		return (this.supervisor == supervisor);
	}
}

public class EX10_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean rv;
		Manager m = new Manager();
		Manager n = new Manager();
		Employee e = new Employee();
		rv = m.worksFor(n);
		rv = m.worksFor(e);
	}

}
