//42. Дано целое число K и массив из десяти целых ненулевых чисел. Вывести 
//номер последнего числа в массиве, большего K. Если таких чисел нет, то 
//вывести 0.

public class hw42arrSearchLastBigger {

		public static int getLastBiggerItemInArr(int [] arr,int k){
			int i = arr.length;
			int res = 0;
			while(i > 0 ){
				if (arr[i-1]>k){
					res = i;
					break;
				}
				i--;
			}
			return(res);
		}

}
