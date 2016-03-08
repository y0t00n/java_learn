//
// Top Class Shape
//
import java.util.Random;
public abstract class Shape {
	protected float area;
	protected float perimeter;
	
	abstract protected void setArea();
	
	abstract protected void setPerimeter();
	
	abstract protected Shape Generate();
	
	public float getArea(){
		return(this.area);
	}
	public float getPerimeter(){
		return(this.perimeter);
	}
	public static float GetRndFloat(float min, float max){
		Random rand = new Random();
		
		float res = rand.nextFloat() * (max - min) + min;
		return res;
	}
}
