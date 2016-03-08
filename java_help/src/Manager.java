
public class Manager extends Employee {
	private Float bonus;
	
	public float getBonus(){
		return(this.bonus);
	}
	
	public void setBonus(float bonus){
		this.bonus = bonus > 0 ? bonus : 0.0f;
	}
	
	public float getSalary(){
		return(this.Salary * (1 + this.bonus/100));
	}
	
	public float getSalaryRaw(){
		return this.Salary;
	}
	
	public static Manager createManager(long inn, String name, String surname, float salary, float bonus){
		if (isValidManager(inn, name, surname, salary, bonus)){
			Manager m = new Manager();
			m.setINN(inn);
			m.setName(name);
			m.setSurname(surname);
			m.setSalary(salary);
			m.setBonus(bonus);
			return(m);
		} else {
			return(null);
		}
	}
	
	private static boolean isValidManager(long inn, String name, String surname, float salary, float bonus){
		if(inn/1000000000 > 0 && inn/1000000000 < 10 && name.length() >= 1 && surname.length() >= 1 && salary > 0){
			return(true);
		} else {
			return(false);
		}
	}
	
	public String toString(){
		return(this.getINN() + " * " + this.getName() + " " + this.getSurname() + " " + this.getSalary() + "(Manager bonus = " + this.bonus + "%)");
	}
}
