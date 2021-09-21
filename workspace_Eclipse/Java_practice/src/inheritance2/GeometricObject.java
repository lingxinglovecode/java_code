package inheritance2;

public class GeometricObject {
	public static void main(String[] args) {
		GeometricObject g1= new GeometricObject(null, 0);
		GeometricObject c1 = new Circle(2.0, "white", 1);
		GeometricObject c2 = new Circle(3.0, "black", 2);
		System.out.println(c1.findArea());
		System.out.println(c2.findArea());
		
		MyRectangle r1 = new MyRectangle(2.3, 3.1, "white", 0);
		
		System.out.println(c1.equalsArea(c2, c1));
		
		
	}
	
	
	protected String color;
	protected double weight;
	
	protected GeometricObject(String color,double weight) {
		this.color = color;
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double findArea() {
		return 1.0;
	}
	
	public boolean equalsArea (GeometricObject o1,GeometricObject o2) {
		return o1.findArea() == o2.findArea();
		
	}
	
	
}
