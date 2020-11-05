package cse3040ex11;

abstract class Person{
	private String name;
	public Person(String name) { this.name = name; }
	public final String getName() { return name; }
	public abstract int getId();//subclass에서 반드시 override
}

class Student extends Person{
	private int Id;
	public Student(String name, int Id) {
		super(name);
		this.Id = Id;
	}
	public int getId() { return this.Id; }
}

public class EX11_2 {
	public static void main(String[] args) {
		Person p = new Student("Fred",1729);
		System.out.println(p.getName() + " " + p.getId());
	}
}
