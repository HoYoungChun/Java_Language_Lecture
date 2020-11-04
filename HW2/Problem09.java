package cse3040_hw2_20191656;

class Point{
	private int dim = 0;
	private double[] myArr;
	public Point(double[] arr) {
		dim = arr.length;
		myArr = arr;
	}
	public int getdim() {
		return dim;
	}
	public double getarr(int i) {
		return myArr[i];
	}
}

class EuclideanDistance{
	public static double getDist(Point p1, Point p2) {
		if(p1.getdim() != p2.getdim()) {
			return -1.0;
		}
		else {
			double d = 0;
			for(int i = 0; i<p1.getdim(); i++) {
				d += Math.pow(p1.getarr(i)-p2.getarr(i), 2);
			}
			d = Math.sqrt(d);
			return d;
		}
	}
}

class ManhattanDistance{
	public static double getDist(Point p1, Point p2) {
		if(p1.getdim() != p2.getdim()) {
			return -1.0;
		}
		else {
			double d = 0;
			for(int i = 0; i<p1.getdim(); i++) {
				d += Math.abs(p1.getarr(i)-p2.getarr(i));
			}
			return d;
		}
	}
}

public class Problem09 {
	public static void main(String[] args) {
		Point p1 = new Point(new double[] {1.0, 2.0, 3.0});
		Point p2 = new Point(new double[] {4.0, 5.0, 6.0});
		System.out.println("Euclidean Distance: " + EuclideanDistance.getDist(p1,p2));
		System.out.println("Manhattan Distance: " + ManhattanDistance.getDist(p1,p2));
		Point p3 = new Point(new double[] {1.0, 2.0, 3.0});
		Point p4 = new Point(new double[] {4.0, 5.0});
		System.out.println("Euclidean Distance: " + EuclideanDistance.getDist(p3,p4));
		System.out.println("Manhattan Distance: " + ManhattanDistance.getDist(p3,p4));
	}
}
