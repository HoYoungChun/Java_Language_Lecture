package cse3040ex07;

class Employee{
	
	// instance variables
	private String name;
	
	// constructors
	public Employee(){
		this.name="anonymous";
	}
	public Employee(String s){
		this.name = s;
	}
	
	// instance methods
	public void setName(String s){
		this.name=s;
	}
	public String getName() {
		return this.name;
	}
}

public class EX07_1 {
	public static void main(String[] args) {
		Employee e1 = new Employee("Harry");
		Employee e2 = new Employee();
		System.out.println(e1.getName());
		System.out.println(e2.getName());
		e2.setName(e1.getName()+" Potter");
		System.out.println(e2.getName());
	}
}
