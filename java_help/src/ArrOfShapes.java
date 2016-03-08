
import java.util.Random;
public class ArrOfShapes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape [] arrS = new Shape[10];
		int ind;
		Random rand = new Random();
		for (int i=0;i<10;i++){
			ind = rand.nextInt(3);
			switch (ind) {
			case 0:
				arrS[i] = new Triangle();
				break;
			case 1:
				arrS[i] = new Ellipse();
				break;
			case 2:
				arrS[i] = new Rect();
				break;
			default:
				i--;
				break;
			}
			arrS[i] = arrS[i].Generate();
		}
		
		for(int i=0;i<arrS.length;i++){
			System.out.println("Shape #" + (i+1) + " is " + arrS[i]);
		}
		
	}

}
