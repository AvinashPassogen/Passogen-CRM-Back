package country.persistence.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="lead_management")
public class Leads {
	
	private long plid;
	private String Salutation;
	private String First_Name;
	private String Middle_Name;
	private String Last_Name;
	private String Title;
	private String Company;
    private String Industry;
    private String Phone_Number;
    private String Mobile_Number;
    private String Email;
    private String Lead_Status;
    private String Owner;
    private String No_Of_Employees;
    private String Lead_Source;
    private String Address;
    private String Pincode;
    private String Country;
    private String State;
    private String City;
    private String Rating;
    @Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime CreationDate;

	

	public Leads() {
		
	}

	  public Leads(long plid, String salutation, String first_Name, String middle_Name, String last_Name, String title,
	      String company, String industry, String phone_Number, String mobile_Number, String email,
	      String lead_Status, String owner, String no_Of_Employees, String lead_Source, String address,
	      String pincode, String country, String state, String city, String rating) {
	    super();
	    this.plid = plid;
	    Salutation = salutation;
	    First_Name = first_Name;
	    Middle_Name = middle_Name;
	    Last_Name = last_Name;
	    Title = title;
	    Company = company;
	    Industry = industry;
	    Phone_Number = phone_Number;
	    Mobile_Number = mobile_Number;
	    Email = email;
	    Lead_Status = lead_Status;
	    Owner = owner;
	    No_Of_Employees = no_Of_Employees;
	    Lead_Source = lead_Source;
	    Address = address;
	    Pincode = pincode;
	    Country = country;
	    State = state;
	    City = city;
	    Rating = rating;
	  }
	  
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	  public long getPlid() {
	    return plid;
	  }

	  public void setPlid(long plid) {
	    this.plid = plid;
	  }

	  @Column(name="Salutation",nullable=false)
	  public String getSalutation() {
	    return Salutation;
	  }

	  public void setSalutation(String salutation) {
	    Salutation = salutation;
	  }

	  @Column(name="First_Name",nullable=false)
	  public String getFirst_Name() {
	    return First_Name;
	  }

	  public void setFirst_Name(String first_Name) {
	    First_Name = first_Name;
	  }

	  @Column(name="Middle_Name",nullable=false)
	  public String getMiddle_Name() {
	    return Middle_Name;
	  }

	  public void setMiddle_Name(String middle_Name) {
	    Middle_Name = middle_Name;
	  }

	  @Column(name="Last_Name",nullable=false)
	  public String getLast_Name() {
	    return Last_Name;
	  }

	  public void setLast_Name(String last_Name) {
	    Last_Name = last_Name;
	  }

	  @Column(name="Title",nullable=false)
	  public String getTitle() {
	    return Title;
	  }

	  public void setTitle(String title) {
	    Title = title;
	  }

	  @Column(name="Company",nullable=false)
	  public String getCompany() {
	    return Company;
	  }

	  public void setCompany(String company) {
	    Company = company;
	  }

	  @Column(name="Industry",nullable=false)
	  public String getIndustry() {
	    return Industry;
	  }

	  public void setIndustry(String industry) {
	    Industry = industry;
	  }

	  @Column(name="Phone_Number",nullable=false)
	  public String getPhone_Number() {
	    return Phone_Number;
	  }

	  
	  public void setPhone_Number(String phone_Number) {
	    Phone_Number = phone_Number;
	  }

	  @Column(name="Mobile_Number",nullable=false)
	  public String getMobile_Number() {
	    return Mobile_Number;
	  }

	  public void setMobile_Number(String mobile_Number) {
	    Mobile_Number = mobile_Number;
	  }

	  @Column(name="Email",nullable=false)
	  public String getEmail() {
	    return Email;
	  }

	  public void setEmail(String email) {
	    Email = email;
	  }

	  @Column(name="Lead_Status",nullable=false)
	  public String getLead_Status() {
	    return Lead_Status;
	  }

	  public void setLead_Status(String lead_Status) {
	    Lead_Status = lead_Status;
	  }

	  @Column(name="Owner",nullable=false)
	  public String getOwner() {
	    return Owner;
	  }

	  public void setOwner(String owner) {
	    Owner = owner;
	  }

	  @Column(name="No_Of_Employees",nullable=false)
	  public String getNo_Of_Employees() {
	    return No_Of_Employees;
	  }

	  public void setNo_Of_Employees(String no_Of_Employees) {
	    No_Of_Employees = no_Of_Employees;
	  }

	  @Column(name="Lead_Source",nullable=false)
	  public String getLead_Source() {
	    return Lead_Source;
	  }

	  public void setLead_Source(String lead_Source) {
	    Lead_Source = lead_Source;
	  }

	  @Column(name="Address",nullable=false)
	  public String getAddress() {
	    return Address;
	  }

	  public void setAddress(String address) {
	    Address = address;
	  }

	  @Column(name="Pincode",nullable=false)
	  public String getPincode() {
	    return Pincode;
	  }

	  public void setPincode(String pincode) {
	    Pincode = pincode;
	  }

	  @Column(name="Country",nullable=false)
	  public String getCountry() {
	    return Country;
	  }

	  public void setCountry(String country) {
	    Country = country;
	  }

	  @Column(name="State",nullable=false)
	  public String getState() {
	    return State;
	  }

	  public void setState(String state) {
	    State = state;
	  }

	  @Column(name="City",nullable=false)
	  public String getCity() {
	    return City;
	  }

	  public void setCity(String city) {
	    City = city;
	  }

	  @Column(name="Rating",nullable=false)
	  public String getRating() {
	    return Rating;
	  }

	  public void setRating(String rating) {
	    Rating = rating;
	  }
	  public LocalDateTime getCreationDate() {
			return CreationDate;
		}

		public void setCreationDate(LocalDateTime creationDate) {
			CreationDate = creationDate;
		}
	 
	  @Override
	      public String toString() {
	          return " [plid=" + plid + ","
	                  + " Salutation=" +Salutation + ","
	              + " First_Name=" +First_Name + ","
	                  + " Middle_Name=" + Middle_Name+ ","
	              + " Last_Name=" +Last_Name + ","
	              + " Title=" + Title + ","
	              + " Company=" + Company + ","
	              + " Industry=" +Industry + ","
	              + " Phone_Number=" + Phone_Number + ","
	              + " Mobile_Number=" + Mobile_Number + ","
	              + " Email=" + Email + ","
	              + " Lead_Status=" +Lead_Status + ","
	              + " Owner=" + Owner + ","
	              + " No_Of_Employees=" + No_Of_Employees + ","
	              + " Lead_Source=" + Lead_Source + ","
	              + " Address=" +Address + ","
	              + " Pincode=" + Pincode + ","
	              + " Country=" + Country + ","
	              + " State=" +State + ","
	              + " City=" + City + ","
	                + " Rating=" + Rating + "]";
	          
	        }

	}
