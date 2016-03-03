//Note: Класс Employee должен содержать следующую информацию о сотруднике - 
//INN, Name, Surname, Salary 
public class Employee {
	private long INN;
	private String Name;
	private String Surname;
	private Float Salary;
	
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
}
