/**
 * 
 */

/**
 * @author y0t00n
 */

//41. Дано целое число K и массив из десяти целых ненулевых чисел. Вывести
//номер первого числа в массиве, большего K. Если таких чисел нет, то 
//вывести 0.
//42. Дано целое число K и массив из десяти целых ненулевых чисел. Вывести 
//номер последнего числа в массиве, большего K. Если таких чисел нет, то 
//вывести 0.
//43. Дано вещественное число B, целое число N и массив из N целых чисел, 
//упорядоченных по возрастанию. Вывести элементы массива вместе с числом B, 
//сохраняя упорядоченность выводимых чисел.
//44. Дано целое число N и массив из N целых чисел, упорядоченный по 
//возрастанию. Данный набор может содержать одинаковые элементы. Вывести в 
//том же порядке все различные элементы данного массива.
//
//51. В компании "Фабрика Од Уа, ЛТД" работает 10 человек. Используя класс 
//Employee написать программу, которая создает список (массив) из 10 
//элементов и заполняет его данными о сотрудниках компании. Главбух 
//компании очень любит различные красивые отчеты и статистику. Для того, 
//чтобы сделать работу главбуха веселее, а себе выбить возможность 
//получения бонусов, реализовать в программе следующие функции:
//a. Печать отчета в виде: INN ФИО зряплата
//b. Вычислить ежемесечное количество денег, которое главбух должен
//оторвать от фонда заработной платы для выдачи сотрудникам.
//c. Вычислить сотрудника с минимальным окладом. Распечатать в виде:
//   INN ФИО зряплат
//d. Вычислить мажора с максимальным окладом. Распечатать в виде:
//   INN ФИО зряплат
//Note: Класс Employee должен содержать следующую информацию о сотруднике - 
//INN, Name, Surname, Salary 

import java.util.Random;
import java.util.Scanner;
//import java.util.Scanner;
//43
//41-4  import java.util.Arrays;
//41 public class WrapHW_41__44_51_52 extends hw41arrSearchFirstBigger {
//42	public class WrapHW_41__44_51_52 extends hw42arrSearchLastBigger {
//43	public class WrapHW_41__44_51_52 extends hw43arrSortInsertFloat {
//44	public class WrapHW_41__44_51_52 extends hw44arrPrintDifferent {
public class WrapHW_41__44_51_52 {
    public static int[] genIntArrayRand(int length, int low, int high) {
        int[] resArr = new int [length];
        Random rand = new Random();
        long range = (long)high - (long)low + 1;
        long fraction;
        for (int i= 0; i < length; i++){
        	fraction = (long)(range * rand.nextDouble());
            resArr[i] = (int)(fraction + low);
         }
        return(resArr);
    }
    
    public static int getRndIndex(int length){
    	Random rand = new Random();
    	int range = length;
    	int fraction = 1 + (int)(range * rand.nextDouble());
    	return fraction;
    }
    
    public static String stringArray(int[] arr) {
        if (arr.length>0){
            String res = "";
            for (int i= 0; i < arr.length; i++){
                res+=arr[i] + " ";
            }
            return(res);
        } else {
            return("");
        }
    }
	public static int[][] getBiggerItemsInArr(int [] arr,int k){
		int i = 0;
		int[][] resArr = new int [arr.length][2];
		int res = 0;
		while(i < arr.length){
			if (arr[i]>k){
				resArr[res][0] = i+1;
				resArr[res][1] = arr[i];
				res++;
			}
			i++;
		}
		return(resArr);
	}
	/**
	 * @param args
	 */
	
	public static Employee[] getRandEmployeeArr(int n){
		String [] names = {"John","Peter","Bill","Steave","Rick","Mike","Bigelow","Fizzwalts","Stephano","Rurik","Mistolz","Drevko","Zuban","Ivcheg","Sustronium","Abdzhek"};
		String [] surnames = {"Phills","Doms","Carks","Dood","Jort","Smith","Shushpanz","Sigurdson","Facepalm","Kickass","Drooz","Figoolinakis","Hatanatori","Ozheg","Fintz-Grebovski","Apsa","Eetoo","Gzhebzhezhinski"};
		Random rand = new Random();
		int prob;
		Employee [] e = new Employee [n];
		Scanner keyboard = new Scanner(System.in);
		for (int i=0; i<n; i++){
			prob = rand.nextInt(100);
			long inn = 1000000000 + i; 
			String name = names[getRndIndex(names.length-1)];
			String surname = surnames[getRndIndex(surnames.length-1)];
			float salary = getRndIndex(30) * 100;
			if (prob < 80){
				e[i] = Employee.createEmployee(inn, name, surname, salary);
			} else {
				float bonus = rand.nextFloat()*50;
				salary = 900 + getRndIndex(20) * 100;
				e[i] = Manager.createManager(inn, name, surname, salary, bonus);
			}
		}
		return(e);
	}
	
	public static Employee[] getEmployeeArr(int n){
		Employee [] e = new Employee [n];
		Scanner keyboard = new Scanner(System.in);
		for (int i=0; i<n; i++){
			System.out.println("Enter INN (10 digits):");
			Long inn = keyboard.nextLong();
			System.out.println("Enter Name (String):");
			String name = keyboard.next();
			System.out.println("Enter Surname (String):");
			String surname = keyboard.next();
			System.out.println("Enter Salary (Float):");
			float salary = keyboard.nextFloat();
			e[i] = Employee.createEmployee(inn, name, surname, salary);
		}
		return(e);
	}
	
	public static void printAllEmployeeArr(Employee [] e){
		System.out.println("Entire List: ");
		for (int i=0; i<e.length; i++){
			System.out.println(e[i].toString());
		}
	}
	
	public static float getSumEmployeeSalary(Employee [] e){
		float res = 0;
		for (int i=0; i<e.length; i++){
			res += e[i].getSalary();
		}
		return(res);
	}
	
	public static int [] getWinnerLooserEmployeeIndexes(Employee [] e){
		int [] res = new int [2];
		float min = e[0].getSalary();
		float max = e[0].getSalary();
		for (int i=0; i<e.length; i++){
			if (e[i].getSalary() > max) {
				max = e[i].getSalary();
				res[1] = i;
			}
			if (e[i].getSalary() < min) {
				min = e[i].getSalary();
				res[0] = i;
			}
		}
		return(res);
	}
	
	public static void printWinnerEmployee(Employee [] e){
		int index = getWinnerLooserEmployeeIndexes(e)[1];
		System.out.println("\nThe WINNER: " + e[index]);
	}
	
	public static void printLooserEmployee(Employee [] e){
		int index = getWinnerLooserEmployeeIndexes(e)[0];
		System.out.println("\nThe looser: " + e[index]);
	}
	
	public static void printSumEmployeeSalary(float sum){
		System.out.println("\nSalary total : " + sum);
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

//41-4		int[] arr = genIntArrayRand(10, 1,100);
//41-4		Arrays.sort(arr);
//41-4		System.out.println("\nArray:\n"+stringArray(arr));
		
//414243	Scanner keyboard = new Scanner(System.in);
//4142		System.out.println("Enter K to check:");
//43		System.out.println("Enter K (Double) to check:");
//4142		int k = keyboard.nextInt();
//43		Double k = keyboard.nextDouble();
//41		int n = getFirstBiggerItemInArr(arr,k);
//42		int n = getLastBiggerItemInArr(arr,k);
//43		PrintExtendedArr(arr,k);
		
//4142		int searchRes[][] = getBiggerItemsInArr(arr,k);
//41		System.out.println("The first Bigger item number is " + n);
//42		System.out.println("The last Bigger item number is " + n);
//4142		int i = 0;
//4142		while(i < arr.length && searchRes[i][0] != 0){
//4142			System.out.println("Element Nr " + searchRes[i][0] + " is " + searchRes[i][1] + " > " + k);
//4142			i++;
//4142		}
//44		PrintDifferentArr(arr);
//44		int [] arrM = new int[] {1,1,1,1,2,2,2,2,2,2};
//44		System.out.println("\n\nManual Array:\n"+stringArray(arrM));
//44		PrintDifferentArr(arrM);
		
		//Employee [] employees = getEmployeeArr(10);
		Employee [] employees = getRandEmployeeArr(15);
		printAllEmployeeArr(employees);
		printSumEmployeeSalary(getSumEmployeeSalary(employees));
		printWinnerEmployee(employees);
		printLooserEmployee(employees);
		
		
	}

}

