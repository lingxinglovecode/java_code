package object;


public class Circle extends GeometricObject{
	public static void main(String[] args) {
		Circle c1 = new Circle(2.0);
		Circle c2 = new Circle(3.0);
		
		System.out.println("Two circles are equal:"+c1.equals(c2));
		System.out.print("Circle 1 radius is "+c1);
		
		
		GeometricObject g1 = new Circle();
		g1.test1();
	}
	
	

	private double radius;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}
	public Circle(double radius,String color,double weight) {
		super();
		this.radius = radius;
		this.color = color;
		this.weight = weight;
	}
	public Circle() {
		super();
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double findArea() {
		return 3.14 * radius * radius;
		
	}
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		}
		if(obj instanceof Circle) {
			Circle circle = (Circle)obj;
			return this.radius == circle.getRadius();
		}
		return false;
		
	}
	
	public String toString() {
//		return this.radius+"";
		return String.valueOf(this.radius);
		
	}
	public static void test1() {
		System.out.print("circle");
	}
	
	
	
}
