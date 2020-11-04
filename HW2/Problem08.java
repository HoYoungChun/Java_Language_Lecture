package cse3040_hw2_20191656;

interface Shape{
	abstract public double retArea();
}

class Circle implements Shape{
	private double area = 0;
	public Circle(double num) {
		area = num * num * Math.PI;
	}
	public double retArea() {
		return area;
	}
}

class Square implements Shape{
	private double area = 0;
	public Square(double num) {
		area = num * num;
	}
	public double retArea() {
		return area;
	}
}

class Rectangle implements Shape{
	private double area = 0;
	public Rectangle(double num1,double num2) {
		area = num1 * num2;
	}
	public double retArea() {
		return area;
	}
}

public class Problem08 {
	public static void main(String[] args) {
		Shape[] arr = { new Circle(5.0), new Square(4.0),
						new Rectangle(3.0, 4.0), new Square(5.0) };
		System.out.println("Total area of the shapes is: " + sumArea(arr));
		}
	
	public static double sumArea(Shape[] arr) {
		double totalSum = 0;
		for(int i = 0; i< arr.length; i++) {
			totalSum += arr[i].retArea();
		}
		return totalSum;
	}
}

