package country.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sales")
public class Sales {
	
	private long Sid;
	private String Month;
	private int TotalSales;
	
	public Sales(long Sid, String Month, int TotalSales) {
		super();
		this.Sid = Sid;
		this.Month = Month;
		this.TotalSales = TotalSales;
		// TODO Auto-generated constructor stub
	}
	
	public Sales() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getSid() {
		return Sid;
	}
	
	public void setSid(long sid) {
		Sid = sid;
	}
	public String getMonth() {
		return Month;
	}
	public void setMonth(String month) {
		Month = month;
	}
	public int getTotalSales() {
		return TotalSales;
	}
	public void setTotalSales(int totalSales) {
		TotalSales = totalSales;
	}


	@Override
	public String toString() {
		return "Sales [Sid=" + Sid + ", Month=" + Month + ", TotalSales=" + TotalSales + "]";
	}

}
