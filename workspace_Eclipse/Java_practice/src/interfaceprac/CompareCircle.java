package interfaceprac;

public class CompareCircle extends Circle implements CompareObject{
	
	
	
	
	public CompareCircle(double radius) {
		super(radius);
	}

	@Override
	public int compareTo(Object o) {
		double r2 = ((CompareCircle) o).getRadius();
		if(r2<this.getRadius()) {
			return 1;
		}
		else if (r2>this.getRadius()) {
			return -1;
			
		}
		
		return 0;
	}
	
	
	
	
}
