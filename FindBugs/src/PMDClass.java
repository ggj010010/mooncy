
public class as {
	int radius;
	String name;
	
	public double GetArea() {
		return 3.14*radius*radius;
	}
	public static void main(String[] args) {
		PMDClass pizza;
		pizza = new PMDClass();
		pizza.radius = 10;
		pizza.name = "자바피자";
		double area = pizza.GetArea();
		System.out.println(pizza.name + "의 면적은 "+area);
	}
}
