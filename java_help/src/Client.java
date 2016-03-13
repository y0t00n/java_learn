//
//Sozdat klass Customer: 
//	id
//	Familiya
//	Imya
//	Otchestvo
//	Adres
//	Nomer kreditnoy kartochki
//	Nomer bankovskogo scheta.
//
//Opredelit konstruktoryi i metodyi setTip() , getTip() , toString() .
//
//Opredelit dopolnitelno metodyi v klasse, sozdayuschem massiv ob'ektov. Zadat kriteriy vyibora dannyih i vyivesti eti dannyie na konsol.
//
//Sozdat massiv ob'ektov. Vyivesti:
//   a) spisok pokupateley v alfavitnom poryadke;
//   b) spisok pokupateley, u kotoryih nomer kreditnoy kartochki nahoditsya v zadannom intervale.

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
public class Client implements Comparable<Client>, Comparator<Client>{
	protected long ID;
	protected String Name;
	protected String Surname;
	protected String Fathername;
	protected String Address;
	protected long CardNum;
	protected long Account;
	
	public int compareTo(Client o) { 
		return (this.getName() + this.getSurname() + this.getFathername()).compareTo(o.getName() + o.getSurname() + o.getFathername()); 
	}
	
	public int compare(Client o1, Client o2) {
		return (o1.getName() + o1.getSurname() + o1.getFathername()).compareTo(o2.getName() + o2.getSurname() + o2.getFathername()); 
	}
	
	public long getID(){
		return(this.ID);
	}
	public String getName(){
		return(this.Name);
	}
	public String getSurname(){
		return(this.Surname);
	}
	public String getFathername(){
		return(this.Fathername);
	}
	public String getAddress(){
		return(this.Address);
	}
	public long getCardNum(){
		return(this.CardNum);
	}
	public long getAccount(){
		return(this.Account);
	}
	
	public void setID(long id){
		this.ID=id;
	}
	public void setName(String name){
		this.Name=name;
	}
	public void setSurname(String surname){
		this.Surname=surname;
	}
	public void setFathername(String fathername){
		this.Fathername=fathername;
	}
	public void setAddress(String address){
		this.Address=address;
	}
	public void setCardNum(long cardnum){
		this.CardNum=cardnum;
	}
	public void setAccount(long account){
		this.Account=account;
	}
	
	private static boolean isValidClient(long id, String name, String surname, String fathername, String address, Long cardnum, Long account){
		if(id > 0 && name.length() >= 1 && surname.length() >= 1 && fathername.length() >= 1 && address.length() > 0 && cardnum > 0 && account > 0){
			return(true);
		} else {
			return(false);
		}
	}
    
	public static int getRndIndex(int length){
    	Random rand = new Random();
    	int range = length;
    	int fraction = 1 + (int)(range * rand.nextDouble());
    	return fraction;
    }
    
	public static Client createClient(long id, String name, String surname, String fathername, String address, Long cardnum, Long account){
		if (isValidClient(id, name, surname, fathername, address, cardnum, account)){
			Client c = new Client();
			c.setID(id);
			c.setName(name);
			c.setSurname(surname);
			c.setFathername(fathername);
			c.setAddress(address);
			c.setCardNum(cardnum);
			c.setAccount(account);
			return(c);
		} else {
			return(null);
		}
	}
	
	public String toString(){
		return(	  this.getID() 			+ "   " 
				+ this.getName() 		+ " " 
				+ this.getSurname() 	+ " " 
				+ this.getFathername() 	+ " " 
				+ this.getCardNum() 	+ " " 
				+ this.getAccount() 	+ " " 
				+ this.getAddress());
	}
	
	public static Client[] getRandClientArr(int n){
		String [] names = {"John","Peter","Bill","Steave","Rick","Mike","Bigelow","Fizzwalts","Stephano","Rurik","Mistolz","Drevko","Zuban","Ivcheg","Sustronium","Abdzhek"};
		String [] surnames = {"Phills","Doms","Carks","Dood","Jort","Smith","Shushpanz","Sigurdson","Facepalm","Kickass","Drooz","Figoolinakis","Hatanatori","Ozheg","Fintz-Grebovski","Apsa","Eetoo","Gzhebzhezhinski"};
		String [] fathernames = {"BibleBrock","Jubeelee","Hoho","Moses","Alexander","Shobo","Arts","Fiz-Stinz","Palamar","Teeloon","Soros","Mahatma","Suzuki","Buzz","Zhi-zhi","Saltan","Bibik","Root-Idun"};
		Random rand = new Random();
		int prob;
		Client [] c = new Client [n];
//		Scanner keyboard = new Scanner(System.in);
		for (int i=0; i<n; i++){
			
			long id = 1000000000 + i; 
			String name = names[getRndIndex(names.length-1)];
			String surname = surnames[getRndIndex(surnames.length-1)];
			String fathername = fathernames[getRndIndex(fathernames.length-1)];
			String address = "Address " + (n-i);
			Long cardnum = 20000000 + (long)i;
			Long account = 30000000 + (long)i;
			
			c[i] = Client.createClient(id, name, surname, fathername, address, cardnum, account);
			
		}
		return(c);
	}
	
	public static void printAllClientArr(Client [] c){
		System.out.println("Entire List: ");
		for (int i=0; i<c.length; i++){
			System.out.println(c[i].toString());
		}
	}
	
	public static void printRangeClientArr(Client [] c, long min, long max){
		System.out.println("\nFiltered List (Range " + min + " .. " + max + "):");
		for (int i=0; i<c.length; i++){
			if (c[i].getCardNum() >= min && c[i].getCardNum() <= max){
				System.out.println(c[i].toString());
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client [] clients = getRandClientArr(15);
		Arrays.sort(clients);
		printAllClientArr(clients);
		printRangeClientArr(clients, 20000006, 20000013);
		Arrays.sort(clients, new ClientSortByID());
		printAllClientArr(clients);
		Arrays.sort(clients, new ClientSortByAddress());
		printAllClientArr(clients);
	}

}
