package white_cow_gui;
import java.io.PrintWriter;
import java.util.List;

public class MyGlobals {

	public static MyGlobals temp = null;
	
	List<PrintWriter> listWriters;
	int priceSum = 0;
	String id;
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getPriceSum() {
		return priceSum;
	}


	public void setPriceSum(int priceSum) {
		this.priceSum = priceSum;
	}


	public static MyGlobals getInstance()
	{
		
			if(temp!=null)
				return temp;
			else
			{
					temp = new MyGlobals();
				return temp;
			}
			
	}
	
	
	public List<PrintWriter> getListWriters() {
		return listWriters;
	}

	public void setListWriters(List<PrintWriter> listWriters) {
		this.listWriters = listWriters;
	}
	
	public void addWriter(PrintWriter writer) {
		this.listWriters.add(writer);
	}
	
	public void removeWriter(PrintWriter writer) {
		this.listWriters.remove(writer);
	}


	
}
