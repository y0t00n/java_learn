package into_OOP;
import java.util.*;

public class Notepad {
	
	public static class Record {
		String Text;
//		int ID;
		Date Date;
		
		public Record(){}
		public Record(String t){}
		
		public static Record createRecord(String t){
			Record res = new Record();
			if (t.length()>0){
				res.setText(t);
				Date d = new Date();
				res.setDate(d);
			}
			return res;
		}
		
		public String toString(){
			return (this.getDate() + " : " + this.getText());
		}
		
		public void setText(String t){
			this.Text = t;
		}
//		public void setID(int n){
//			this.ID = n;
//		}
		public void setDate(Date d){
			this.Date = d;
		}
		
		public String getText(){
			return(this.Text);
		}
//		public int getID(){
//			return(this.ID);
//		}
		public Date getDate(){
			return(this.Date);
		}
		
	}
	
	ArrayList<Record> notes = new ArrayList<Record>();
	
//	String Owner;
	
	public void addRecord(String t){
		if(t.length()>0){
			Record r = Record.createRecord(t);
			this.notes.add(r);
			}		
	}
	
	public String toString(){
		return("Notepad [" + this.notes.size() + " records]");
	}
	
	public void printNotepad(){
		int i=0;
		for (Record r : this.notes){
			System.out.println(i++ + " " + r);
		}
	}
	
}
