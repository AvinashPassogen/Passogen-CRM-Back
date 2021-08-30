package country.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LoggedInUser")
public class LoggedInUser {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String first_name;
	private String last_name;
	private String email;
	private String username;
	private String job_title;
	private String company;
	private String employees;
	private String phone_number;
	private String country;
	private String password;
	private String rol;
    private boolean enabled;
    private int otp;
    

    public LoggedInUser() {
		
	}
    
    
	

	public LoggedInUser(Long id, String first_name, String last_name, String email, String username, String job_title,
			String company, String employees, String phone_number, String country, String password, String rol,
			boolean enabled, int otp) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.username = username;
		this.job_title = job_title;
		this.company = company;
		this.employees = employees;
		this.phone_number = phone_number;
		this.country = country;
		this.password = password;
		this.rol = rol;
		this.enabled = enabled;
		this.otp = otp;
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmployees() {
		return employees;
	}

	public void setEmployees(String employees) {
		this.employees = employees;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}




	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", username=" + username + ", job_title=" + job_title + ", company=" + company + ", employees="
				+ employees + ", phone_number=" + phone_number + ", country=" + country + ", password=" + password
				+ ", rol=" + rol + ", enabled=" + enabled + ",otp="+otp+"]";
	}




	public LoggedInUser orElseThrow() {
		// TODO Auto-generated method stub
		return null;
	}


}
