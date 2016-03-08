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
		return(this.getINN() + " " + this.getName() + " " + this.getSurname() + " " + this.getSalary());
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
	
	public static Employee filterEmployeesByINN(long inn, String name, String surname, Float salary){
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
	
//	

	
	public static Employee[] filterEmployeesByName(Employee [] input){
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
		int [] doneIndexes = new int[input.length];
		for (int i = 0; i < input.length; i++){
			doneIndexes[i]=-1;
		}
		boolean done = false;
		boolean indexed;
		String min;
		while(resI < input.length){
			min = max;
			ind = maxInd;
			for (int i = 0; i < input.length; i++){
				indexed = IntStream.of(doneIndexes).anyMatch(x -> x == i);
				if (!indexed){
					if (((input[i].getName() + " " + input[i].getSurname()).compareTo(min) <= 0)){
						ind = i;
						min = input[i].getName() + " " + input[i].getSurname();
					}
				}
			}
			doneIndexes[resI] = ind;
			resI++;
		}
	}

	public static Employee filterEmployeesBySalary(long inn, String name, String surname, Float salary){
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
}
