package interfaceprac;

public class InterfaceTest {
	public static void main(String[] args) {
		CompareCircle c1 = new CompareCircle(2.3);
		CompareCircle c2 = new CompareCircle(3.3);
		
		int result = c1.compareTo(c2);
		System.out.println(result);
	}
	

	
}
