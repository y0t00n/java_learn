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
			//return (this.getDate() + " : " + this.getText());
			return (this.getText());
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
	
	public Notepad(){}
	public Notepad(Record r){}
	
	public static Notepad createNotepad(){
		Notepad newNotepad = new Notepad();
		newNotepad.notes = new ArrayList<Record>();
		return newNotepad;
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
	
	public static Notepad generateNotepad(int n){
		
		//frazes:
		
		ArrayList<String> start = new ArrayList<>(Arrays.asList(
			"��������!", 
			"� ������ �������", 
			"������ �������", 
			"�� �������, ������, ��������, ���", 
			"����� �������", 
			"������������ �������� ����������, ���",
			"����������� ����� ��, ���",
			"����� �� ���� ���������� ���, ���",
			"��������, ���",
			"�� ������ �� �� ���, �� � ������� �����",
			"���� ������ �������, ���",
			"�� ����� ����� ������� ���������� ����� -",
			"����������, �� ���� -"
		));

		ArrayList<String> actor = new ArrayList<>(Arrays.asList(
			"���������� ���������� �������� �������", 
			"����� � ����� �������� ������", 
			"���������� �������������� ���� � ����� ����� ����������", 
			"����������� ��������� �����������", 
			"����� ������ ��������������� ������������", 
			"���������� �������� ��������� ���� ������������",
			"������������ �������������� ���������",
			"������ ����������������� ��������� ����������� ������",
			"�������� ����������� ������������ �������� ������� �������������� �������",
			"������������� ���� ������ ������������� � ����������� ��������",
			"������������ ������ � ������������� ���������� ��������� ������������������� � ���������������� ��������"
		));

		ArrayList<String> action = new ArrayList<>(Arrays.asList(
			"������ ������ ���� � ������������", 
			"������� �� ��� �������", 
			"������� ����������� � ���������", 
			"������������ ���������� � ����������", 
			"������������ �������� ����� (������������) ������� � ������������", 
			"��������� ��������� ������ ������� �� ����������",
			"���������� ����� �������� �� ������� � ����������",
			"�������� ������� �� ���������� ������������ ��������������",
			"������������� ��-��������� �������� ������ ��������",
			"��������������� ����������� ��������� ������������� ������������ � ���������"
		));

		ArrayList<String> result = new ArrayList<>(Arrays.asList(
			"������������ ���������� � ���������������� �������", 
			"���������� ����������� ��������", 
			"������� ��������� �������", 
			"�������, ���������� ����������� � ��������� ������������ �����", 
			"����� �����������", 
			"����������� �������������� ��������",
			"������������� ������������ � ����������������� �����",
			"������ �������� � ������"
			));
		
		Random random = new Random();

		int i1, i2, i3, i4, i1p, i2p, i3p, i4p;
		Notepad newNotepad = Notepad.createNotepad();
		
		for (int i=0;i<n;i++){
			
			i1 = i==0 ? 0 : random.nextInt(start.size());
			i2 = random.nextInt(actor.size());
			i3 = random.nextInt(action.size());
			i4 = random.nextInt(result.size());
				
			newNotepad.addRecord(start.get(i1) + " " + actor.get(i2) + " " + action.get(i3) + " " + result.get(i4) + ". ");
				
//				start.remove(i1);
//				actor.remove(i2);
//				action.remove(i3);
//				result.remove(i4);
				
			i1p = i1;
			i2p = i2;
			i3p = i3;
			i4p = i4;
		}
		return newNotepad;
	}
	
	
}
