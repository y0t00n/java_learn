//43. ƒано вещественное число B, целое число N и массив из N целых чисел, 
//упор€доченных по возрастанию. ¬ывести элементы массива вместе с числом B, 
//сохран€€ упор€доченность выводимых чисел.

public class hw43arrSortInsertFloat {
	public static void PrintExtendedArr(int [] arr,double k){
		int i = arr.length;
		String res = "";
		boolean added = false;
		while(i > 0){
			if ((double)arr[i-1] < k && !added){
				res = Double.toString(k) + " " + res;
				added = true;
			}
			res = Integer.toString(arr[i-1]) + " " + res;
			i--;
		}
		if (!added) {
			res = Double.toString(k) + " " + res;
		}
		System.out.println(res);
	}
}
