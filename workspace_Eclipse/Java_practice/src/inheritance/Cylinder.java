package inheritance;

public class Cylinder extends Circle{
	public static void main(String[] args) {
		Cylinder cylinder = new Cylinder();
		cylinder.setRadius(3.2);
		cylinder.setLength(2.0);
		System.out.print(cylinder.findVolumn());
		System.out.print(cylinder.findArea());
		
	}
	
	
	
	private double length;
	public Cylinder(){
		this.length = 1.0;
	}
	
	public void setLength(double length) {
		this.length = length;
		
	}
	
	public double getLength() {
		return this.length;
		
	}
	
	public double findVolumn() {
		return super.findArea() * this.length;
		
	}
	
	public double findArea() {
		return getRadius() * Math.PI * this.length;
		
	}
	
	
	
}
