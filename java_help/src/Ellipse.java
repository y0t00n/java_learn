import java.util.Scanner;
public class Ellipse extends Shape {
	
	protected void setPerimeter(){
		this.perimeter = (float) 4*(((float)Math.PI)*this.getA()*this.getB() + (this.getA()-this.getB())*(this.getA()-this.getB()))/(this.getA()+this.getB()); 
	}
	
	protected void setArea(){
		this.area = (float) Math.PI * this.getA()*this.getB();
	}
	
	private float radA;
	private float radB;
	
	public float getA(){
		return(this.radA);
	}
	public float getB(){
		return(this.radB);
	}

	public void setA(float length){
		this.radA=length;
	}
	public void setB(float length){
		this.radB=length;
	}
	
	public String toString(){
		return("Ellipse (" + this.getA() + ", " + this.getB() + ") Area = " + this.getArea() + ", Circumference = " + this.getPerimeter());
	}
	
	private static boolean isValidEllipse(float a, float b){
		if(a>0 && b>0){
			return(true);
		} else {
			return(false);
		}
	}
	
	public static Ellipse createEllipse(float a, float b){
		if (isValidEllipse(a, b)){
			Ellipse e = new Ellipse();
			e.setA(a);
			e.setB(b);
			e.setPerimeter();
			e.setArea();
			return(e);
		} else {
			return(null);
		}
	}
	
	public Ellipse Generate(){
		Ellipse e = new Ellipse();
		float a = GetRndFloat(0.1f, 100.0f);
		float b = GetRndFloat(0.1f, 100.0f);
				
		e = Ellipse.createEllipse(a, b);
		return(e);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner keyboard = new Scanner(System.in);
//		System.out.println("Enter radius A:");
//		float a = keyboard.nextFloat();
//		System.out.println("Enter radius B:");
//		float b = keyboard.nextFloat();
				
//		Ellipse e;
//		e = Ellipse.createEllipse(a, b);
//		System.out.println(e);
		Ellipse [] arrE = new Ellipse[10]; 
		for(int i=0;i<10;i++){
			arrE[i] = new Ellipse();
			arrE[i] = arrE[i].Generate();
			System.out.println(arrE[i]);
		}
	}

}