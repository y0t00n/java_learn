//Note: Класс Employee должен содержать следующую информацию о сотруднике - 
//INN, Name, Surname, Salary 
import java.util.stream.IntStream;
public class Employee {
	protected long INN;
	protected String Name;
	protected String Surname;
	protected Float Salary;
	
	public long getINN(){
		return(this.INN);
	}
	public String getName(){
		return(this.Name);
	}
	public String getSurname(){
		return(this.Surname);
	}
	public float getSalary(){
		return(this.Salary);
	}
	
	public void setINN(long inn){
		this.INN=inn;
	}
	public void setName(String name){
		this.Name=name;
	}
	public void setSurname(String surname){
		this.Surname=surname;
	}
	public void setSalary(Float salary){
		this.Salary=salary;
	}
	
	public String toString(){
		return(this.getINN() + "   " + this.getName() + " " + this.getSurname() + " " + this.getSalary());
	}
	
	private static boolean isValidEmployee(long inn, String name, String surname, Float salary){
		if(inn/1000000000 > 0 && inn/1000000000 < 10 && name.length() >= 1 && surname.length() >= 1 && salary > 0){
			return(true);
		} else {
			return(false);
		}
	}
	
	public static Employee createEmployee(long inn, String name, String surname, Float salary){
		if (isValidEmployee(inn, name, surname, salary)){
			Employee e = new Employee();
			e.setINN(inn);
			e.setName(name);
			e.setSurname(surname);
			e.setSalary(salary);
			return(e);
		} else {
			return(null);
		}
	}
	
	public static Employee[] sortEmployeesByINN(Employee [] input){
		Employee [] res = new Employee[input.length];
		long max = input[0].getINN();
		int ind,maxInd;
		maxInd=0;
		for(int i = 0; i<input.length; i++){
			if (input[i].getINN()>= max){ 
				max = input[i].getINN(); 
				maxInd = i;
			}
		}
		int resI=0;
		// an array for sorted indexes match pattern
		int [] doneIndexes = new int[input.length];
		// to avoid faulty usage of index 0 - fill array with -1 
		for (int i = 0; i < input.length; i++){
			doneIndexes[i]=-1;
		}
		boolean indexed;
		long min;
		while(resI < input.length){
			min = max; // worst min value for check
			ind = maxInd;
			for (int i = 0; i < input.length; i++){
				int curIndex = i;
				//check if this index has already been indexed
				indexed = IntStream.of(doneIndexes).anyMatch(x -> x == curIndex);
				if (!indexed){
					if (input[i].getINN() <= min){
						ind = i;
						min = input[i].getINN();
					}
				}
			}
			// add current minIndex to array of indexes - sorted match pattern
			doneIndexes[resI] = ind;
			res[resI] = input[ind]; // copy from input to res according to matching pattern
			resI++;
		}
		return res;
	}
	
//	

	
	public static Employee[] sortEmployeesByName(Employee [] input){
		// get the max name and its index
		Employee [] res = new Employee[input.length];
		String max = input[0].getName() + " " + input[0].getSurname();
		int ind,maxInd;
		maxInd=0;
		for(int i = 0; i<input.length; i++){
			if ((input[i].getName() + " " + input[i].getSurname()).compareTo(max) >= 0){ 
				max = input[i].getName() + " " + input[i].getSurname(); 
				maxInd = i;
			}
		}
		int resI=0;
		// an array for sorted indexes match pattern
		int [] doneIndexes = new int[input.length];
		// to avoid faulty usage of index 0 - fill array with -1 
		for (int i = 0; i < input.length; i++){
			doneIndexes[i]=-1;
		}
		boolean indexed;
		String min;
		// go through input array "length" times to to get min value excluding previous min every iteration 
		while(resI < input.length){
			min = max; // worst min value for check
			ind = maxInd;
			for (int i = 0; i < input.length; i++){
				int curIndex = i;
				//check if this index has already been indexed
				indexed = IntStream.of(doneIndexes).anyMatch(x -> x == curIndex);
				if (!indexed){
					if (((input[i].getName() + " " + input[i].getSurname()).compareTo(min) <= 0)){
						ind = i;
						min = input[i].getName() + " " + input[i].getSurname();
					}
				}
			}
			// add current minIndex to array of indexes - sorted match pattern
			doneIndexes[resI] = ind;
			res[resI] = input[ind]; // copy from input to res according to matching pattern
			resI++;
		}
		//:OBSOLETE: copy input to res by sorted match pattern
//		for(int i = 0; i<input.length; i++){
//			res[i] = input[doneIndexes[i]];
//		}
		return res;
	}

	public static Employee[] sortEmployeesBySalary(Employee [] input){
		Employee [] res = new Employee[input.length];
		float max = input[0].getSalary();
		int ind,maxInd;
		maxInd=0;
		for(int i = 0; i<input.length; i++){
			if (input[i].getSalary()>= max){ 
				max = input[i].getSalary(); 
				maxInd = i;
			}
		}
		int resI=0;
		// an array for sorted indexes match pattern
		int [] doneIndexes = new int[input.length];
		// to avoid faulty usage of index 0 - fill array with -1 
		for (int i = 0; i < input.length; i++){
			doneIndexes[i]=-1;
		}
		boolean indexed;
		float min;
		while(resI < input.length){
			min = max; // worst min value for check
			ind = maxInd;
			for (int i = 0; i < input.length; i++){
				int curIndex = i;
				//check if this index has already been indexed
				indexed = IntStream.of(doneIndexes).anyMatch(x -> x == curIndex);
				if (!indexed){
					if (input[i].getSalary() <= min){
						ind = i;
						min = input[i].getSalary();
					}
				}
			}
			// add current minIndex to array of indexes - sorted match pattern
			doneIndexes[resI] = ind;
			res[resI] = input[ind]; // copy from input to res according to matching pattern
			resI++;
		}
		return res;
	}
}
