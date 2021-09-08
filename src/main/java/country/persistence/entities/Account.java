package country.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account_management")
public class Account {
	
	private long id;
	private String name;
	private String account_owner;
	private String type;
	private String website;
	private String Parent_account;
	private String description;
    private String industry;
    private String Phone_Number;
    private String address;
    private String email;
    private String country;
    private String state;
    private String city;
    private String employee;
    private String pincode;

	public Account() {
	
	}

	public Account(long id, String name, String account_owner, String type, String website,
			String parent_account, String description, String industry, String phone_Number, String address,
			String email, String country, String state, String city, String employee, String pincode) {
		super();
		this.id = id;
		this.name = name;
		this.account_owner = account_owner;
		this.type = type;
		this.website = website;
		Parent_account = parent_account;
		this.description = description;
		this.industry = industry;
		Phone_Number = phone_Number;
		this.address = address;
		this.email = email;
		this.country = country;
		this.state = state;
		this.city = city;
		this.employee = employee;
		this.pincode = pincode;
	}

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	@Column(name="account_owner")
	public String getAccount_owner() {
		return account_owner;
	}

	public void setAccount_owner(String account_owner) {
		this.account_owner = account_owner;
	}

	
	@Column(name="type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name="website")
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	
	@Column(name="Parent_account")
	public String getParent_account() {
		return Parent_account;
	}

	public void setParent_account(String parent_account) {
		Parent_account = parent_account;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="industry")
	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	@Column(name="Phone_Number")
	public String getPhone_Number() {
		return Phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		Phone_Number = phone_Number;
	}

	
	@Column(name="address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	@Column(name="country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name="state")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	@Column(name="city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name="employee")
	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}
	
	@Column(name="pincode")
	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
    public String toString() {
        return " [id=" + id + ","
                + " name=" + name+ ","
        		+ " account_owner=" +account_owner + ","
                + " type=" + type+ ","
        		+ " website=" +website + ","
        		+ " Parent_account=" + Parent_account + ","
        		+ " description=" + description + ","
        		+ " industry=" +industry + ","
        		+ " Phone_Number=" + Phone_Number + ","
        		+ " address=" + address + ","
        		+ " email=" + email + ","
        		+ " country=" + country + ","
        		+ " state=" +state + ","
        		+ " city=" + city + ","
        		+ " employee=" + employee + ","
        	    + " pincode=" + pincode + "]";
        
      }
}
