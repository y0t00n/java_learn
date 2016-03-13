import java.util.Comparator;
public class ClientSortByAddress  implements Comparator<Client>{
	public int compare(Client o1, Client o2) { 
		return (o1.getAddress().compareTo(o2.getAddress())); 
	}
}