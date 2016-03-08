import java.util.Scanner;
public class Triangle extends Shape {
	
	protected void setPerimeter(){
		this.perimeter = this.getA()+this.getB()+this.getC();
	}
	
	protected void setArea(){
		float p=this.getPerimeter()/2;
		this.area = (float) Math.sqrt(p*(p-this.getA())*(p-this.getB())*(p-this.getC()));
	}
	
	private float sideA;
	private float sideB;
	private float sideC;
	
	public float getA(){
		return(this.sideA);
	}
	public float getB(){
		return(this.sideB);
	}
	public float getC(){
		return(this.sideC);
	}
	public void setA(float length){
		this.sideA=length;
	}
	public void setB(float length){
		this.sideB=length;
	}
	public void setC(float length){
		this.sideC=length;
	}
	
	public String toString(){
		return("Triangle (" + this.getA() + ", " + this.getB() + ", " + this.getC() + ") Area = " + this.getArea() + ", Perimeter = " + this.getPerimeter());
	}
	
	private static boolean isValidTriangle(float a, float b, float c){
		if(a!=0 && b!=0 && c!=0 && a<b+c && b<a+c && c<a+b && a>Math.abs(b-c) && b>Math.abs(a-c) && c>Math.abs(a-b)){
			return(true);
		} else {
			return(false);
		}
	}
	
	public static Triangle createTriangle(float a, float b, float c){
		if (isValidTriangle(a, b, c)){
			Triangle t = new Triangle();
			t.setA(a);
			t.setB(b);
			t.setC(c);
			t.setPerimeter();
			t.setArea();
			return(t);
		} else {
			return(null);
		}
	}
	
	public Triangle Generate(){
		Triangle t = new Triangle();
		float a = GetRndFloat(0.1f, 100.0f);
		float b = GetRndFloat(0.1f, 100.0f);
		float c = GetRndFloat(Math.abs(a-b) * 1.01f, (a+b) * 0.99f);
		
		t = Triangle.createTriangle(a, b, c);
		return(t);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner keyboard = new Scanner(System.in);
//		System.out.println("Enter side A:");
//		float a = keyboard.nextFloat();
//		System.out.println("Enter side B:");
//		float b = keyboard.nextFloat();
//		System.out.println("Enter side C:");
//		float c = keyboard.nextFloat();
//		
//		Triangle t;
//		t = Triangle.createTriangle(a, b, c);
//		System.out.println(t);
		Triangle [] arrT = new Triangle[10]; 
		for(int i=0;i<10;i++){
			arrT[i] = new Triangle();
			arrT[i] = arrT[i].Generate();
			System.out.println(arrT[i]);
		}

	}

}
