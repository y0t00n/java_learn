import java.util.Scanner;
public class Rect extends Shape {
	
	protected void setPerimeter(){
		this.perimeter = 2 * ( this.getA() + this.getB() ); 
	}
	
	protected void setArea(){
		this.area = this.getA() * this.getB();
	}
	
	private float sideA;
	private float sideB;
	
	public float getA(){
		return(this.sideA);
	}
	public float getB(){
		return(this.sideB);
	}

	public void setA(float length){
		this.sideA=length;
	}
	public void setB(float length){
		this.sideB=length;
	}
	
	public String toString(){
		return("Rectangle (" + this.getA() + ", " + this.getB() + ") Area = " + this.getArea() + ", Perimeter = " + this.getPerimeter());
	}
	
	private static boolean isValidRect(float a, float b){
		if(a>0 && b>0){
			return(true);
		} else {
			return(false);
		}
	}
	
	public static Rect createRect(float a, float b){
		if (isValidRect(a, b)){
			Rect r = new Rect();
			r.setA(a);
			r.setB(b);
			r.setPerimeter();
			r.setArea();
			return(r);
		} else {
			return(null);
		}
	}
	
	public Rect Generate(){
		Rect r = new Rect();
		float a = GetRndFloat(0.1f, 100.0f);
		float b = GetRndFloat(0.1f, 100.0f);
				
		r = Rect.createRect(a, b);
		return(r);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner keyboard = new Scanner(System.in);
//		System.out.println("Enter side A:");
//		float a = keyboard.nextFloat();
//		System.out.println("Enter side B:");
//		float b = keyboard.nextFloat();
//		Rect r;				
//		r = Rect.createRect(a, b);
//		System.out.println(r);
		
		Rect [] arrR = new Rect[10]; 
		for(int i=0;i<10;i++){
			arrR[i] = new Rect();
			arrR[i] = arrR[i].Generate();
			System.out.println(arrR[i]);
		}
	}

}
