package country.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contacts")
public class Contacts {

public Contacts() {
		
	}
	public Contacts(long id,String salutation, String first_Name,String middle_Name,String last_Name,String contacts_owner,
			String account_Name,String reports_To,String title,String department,String email,
			String fax,String phone_Number, String mobile_Number,String address,String street,
			String city,String state,String pincode,String country) {
		this.salutation=salutation;
		this.first_Name=first_Name;
		this.middle_Name=middle_Name;
		this.last_Name=last_Name;
		this.contacts_owner=contacts_owner;
		this.account_Name=account_Name;
		this.reports_To=reports_To;
		this.title=title;
		this.department=department;
		this.email=email;
		this.fax=fax;
		this.phone_Number=phone_Number;
		this.mobile_Number=mobile_Number;
		this.address=address;
		this.street=street;
		this.city=city;
		this.state=state;
		this.pincode=pincode;
		this.country=country;
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "salutation")
	private String salutation;
	
	@Column(name = "first_Name")
	private String first_Name;
	
	@Column(name = "middle_Name")
	private String middle_Name;
	
	@Column(name = "last_Name")
	private String last_Name;
	
	@Column(name = "contacts_owner")
	private String contacts_owner;
	
	@Column(name = "account_Name")
	private String account_Name;
	
	@Column(name = "reports_To")
	private String reports_To;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "fax")
	private String fax;
	
	@Column(name = "phone_Number")
	private String phone_Number;
	
	@Column(name = "mobile_Number")
	private String mobile_Number;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "pincode")
	private String pincode;
	
	@Column(name = "country")
	private String country;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="first_Name",nullable=false)
	
	public String getsalutation() {
		return salutation;
	}
	public void setsalutation(String salutation) {
		this.salutation = salutation;
	}
	
	public String getfirst_Name() {
		return first_Name;
	}
	public void setfirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}
	public String getmiddle_Name() {
		return middle_Name;
	}
	public void setmiddle_Name(String middle_Name) {
		this.middle_Name = middle_Name;
	}
	public String getlast_Name() {
		return last_Name;
	}
	public void setlast_Name(String last_Name) {
		this.last_Name = last_Name;
	}
	public String getcontacts_owner() {
		return contacts_owner;
	}
	public void setcontacts_owner(String contacts_owner) {
		this.contacts_owner = contacts_owner;
	}
	public String getaccount_Name() {
		return account_Name;
	}
	public void setaccount_Name(String account_Name) {
		this.account_Name = account_Name;
	}
	public String getreports_To() {
		return reports_To;
	}
	public void setreports_To(String reports_To) {
		this.reports_To = reports_To;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getphone_Number() {
		return phone_Number;
	}
	public void setphone_Number(String phone_Number) {
		this.phone_Number = phone_Number;
	}
	public String getmobile_Number() {
		return mobile_Number;
	}
	public void setmobile_Number(String mobile_Number) {
		this.mobile_Number = mobile_Number;
	}
	public String getaddress() {
		return address;
	}
	public void setaddress(String address) {
		this.address = address;
	}
	public String getstreet() {
		return street;
	}
	public void setstreet(String street) {
		this.street = street;
	}
	public String getcity() {
		return city;
	}
	public void setcity(String city) {
		this.city = city;
	}
	public String getstate() {
		return state;
	}
	public void setstate(String state) {
		this.state = state;
	}
	public String getpincode() {
		return pincode;
	}
	public void setpincode(String pincode) {
		this.pincode = pincode;
	}
	public String getcountry() {
		return country;
	}
	public void setcountry(String country) {
		this.country = country;
	}

	
	@Override
    public String toString() {
        return "contacts [id=" + id + ",salutation=" + salutation + ", first_Name=" + first_Name + ",middle_Name=" + middle_Name +", last_Name=" + last_Name + ",contacts_owner = " + contacts_owner +",account_Name = "+ account_Name + ",reports_To =" + reports_To + ",title = " + title +",department = " + department + ", email=" + email+ ",fax =" + fax +",phone_Number = " + phone_Number + ",mobile_Number = "+ mobile_Number +",address = "+ address +",street = "+ street +",city = "+ city +",state ="+ state +"pincode="+ pincode +",country="+ country +"]";
    }
}
