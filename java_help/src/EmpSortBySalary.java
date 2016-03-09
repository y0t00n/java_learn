import java.util.Comparator;
public class EmpSortBySalary implements Comparator<Employee>{
	public int compare(Employee o1, Employee o2) {
		if (o1.getSalary() == o2.getSalary()){
			return 0;
		} else {
			return (int)((o1.getSalary() - o2.getSalary())/Math.abs(o1.getSalary() - o2.getSalary()));
		}
	}
}