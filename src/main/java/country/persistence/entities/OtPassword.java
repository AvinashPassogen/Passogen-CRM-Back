package country.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OTP")
public class OtPassword {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int otp;
	private int userotp;
	private String email;

	public OtPassword() {
		
	}

	public OtPassword(Long id, int otp, int userotp, String email) {
		super();
		this.id = id;
		this.otp = otp;
		this.userotp = userotp;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}
	
	public int getUserotp() {
		return userotp;
	}

	public void setUserotp(int userotp) {
		this.userotp = userotp;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "OtPassword [id=" + id + ", otp=" + otp + ", email=" + email + "]";
	}
	
	

}
