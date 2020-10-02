package cse3040ex08;

class Employee{
	private static int lastId = 0;
	private int id;
	public Employee() { id = ++lastId; }
	public int getId() { return this.id; }
	public static int getLastId() { return lastId; }
	
}

public class EX08_2 {

	public static void main(String[] args) {
		Employee m = new Employee();
		Employee n = new Employee();
		System.out.println(m.getId());
		System.out.println(n.getId());
		System.out.println(Employee.getLastId());
		System.out.println(Employee.getLastId());
	}

}
