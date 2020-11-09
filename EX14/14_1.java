package cse3040ex14;

class A{ public String toString() { return "Class A object"; }}
class B{ public String toString() { return "Class B object"; }}
class C{ public String toString() { return "Class C object"; }}

class Box <T>{
	T item;
	public Box(T item) {
		this.item = item;
	}
	public void setItem(T item) { this.item = item; }
	public T getItem() { return item; }
}


public class EX14_1 {
	public static void main(String[] args) {
		Box<A> boxa = new Box<>(new A());
		//boxa.setItem(new A());
		Box<B> boxb = new Box<>(new B());
		//boxb.setItem(new B());
		Box<C> boxc = new Box<>(new C());
		//boxc.setItem(new C());
		
		System.out.println(boxa.getItem());
		System.out.println(boxb.getItem());
		System.out.println(boxc.getItem());
	}
}
