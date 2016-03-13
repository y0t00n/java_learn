import java.util.Comparator;
public class ClientSortByID  implements Comparator<Client>{
	public int compare(Client o1, Client o2) { 
		return (int) (o1.getID() - o2.getID()); 
	}
}
