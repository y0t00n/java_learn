import java.util.Comparator;
public class EmpSortByINN implements Comparator<Employee>{
	public int compare(Employee o1, Employee o2) { 
		return (int) (o1.getINN() - o2.getINN()); 
	}
}
