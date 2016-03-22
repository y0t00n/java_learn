package into_OOP;

import java.util.*;
public class Multiply {
	// stupidly obvious table %)
//	int [][] table = new int [][]{
//		{0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0},
//		{0,	1,	2,	3,	4,	5,	6,	7,	8,	9,	10},
//		{0,	2,	4,	6,	8,	10,	12,	14,	16,	18,	20},
//		{0,	3,	6,	9,	12,	15,	18,	21,	24,	27,	30},
//		{0,	4,	8,	12,	16,	20,	24,	28,	32,	36,	40},
//		{0,	5,	10,	15,	20,	25,	30,	35,	40,	45,	50},
//		{0,	6,	12,	18,	24,	30,	36,	42,	48,	54,	60},
//		{0,	7,	14,	21,	28,	35,	42,	49,	56,	63,	70},
//		{0,	8,	16,	24,	32,	40,	48,	56,	64,	72,	80},
//		{0,	9,	18,	27,	36,	45,	54,	63,	72,	81,	90},
//		{0,	10,	20,	30,	40,	50,	60,	70,	80,	90,	100}
//	};
	private List<List<Integer>> table = new ArrayList<List<Integer>>();
	
	public void printMTable(){
		for(List<Integer> r : this.table){
			String row = "";
			for (Integer c : r){
				row += c + " ";
			}
			System.out.println(row);
		}
	}
	
	public static Multiply createMultiply(int n){
		Multiply m = new Multiply();
		if (n>0){
			for (int i = 0; i <= n; i++){
				List row = new ArrayList();
				for (int k = 0; k <= n; k++){
					row.add(k*i);					
				}
				m.table.add(row);
			}
		}
		return m;
	}
	
	public int getMul(int a, int b){
		return table.get(a).get(b);
	}
	
	public boolean isValidMul(int a, int b, int m){
		return (getMul(a,b) == m);
	}
}
