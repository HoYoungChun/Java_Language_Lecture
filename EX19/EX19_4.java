package cse3040ex19;

import java.util.HashSet;

class Person {
	String name;
	int age;
	Person(String name, int age) { this.name = name; this.age = age; }
	public String toString() { return name + ":" + age; }
	public boolean equals(Object obj) {
		if( obj instanceof Person) {
			Person tmp = (Person)obj;
			return name.equals(tmp.name)&& age == tmp.age; 
		}
		return false;
	}
	public int hashCode() { return (name+age).hashCode();}
}
public class EX19_4 {
	public static void main(String[] args) {
		HashSet<Person> set = new HashSet<>();
		set.add(new Person("David", 10));
		set.add(new Person("David", 10));
		System.out.println(set);
	}
}
