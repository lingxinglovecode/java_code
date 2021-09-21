package inheritance;

public class Circle {
	private double radius;
	
	public Circle() {
		radius = 1.0;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return this.radius;
		
	}
	
	public double findArea() {
		return Math.PI * this.radius * this.radius;
		
	}
	
	
	
	
	
	
}
