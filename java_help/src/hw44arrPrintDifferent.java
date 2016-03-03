//44. ƒано целое число N и массив из N целых чисел, упор€доченный по 
//возрастанию. ƒанный набор может содержать одинаковые элементы. ¬ывести в 
//том же пор€дке все различные элементы данного массива.

public class hw44arrPrintDifferent {
	public static void PrintDifferentArr(int [] arr){
		int i = 0;
		String res = "";
		while(i < arr.length){
			if (i==0 || arr[i] != arr[i-1]){
				res += Integer.toString(arr[i]) + " ";
			}
			i++;
		}
		System.out.println(res);
	}
}
