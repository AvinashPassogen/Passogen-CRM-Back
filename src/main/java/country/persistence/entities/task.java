package country.persistence.entities;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="task_table")
public class task {
	
	private static final String DEFAULT_PRIORITY = "Normal";	
	private static final String DEFAULT_STATUS = "Open";
	
	
public task() {
		
	}
	
	
	public task(long id, String subject , String assigned , String t_name, String comments, String status, String priority,Date date1,Date date2,Time time1)	{
		this.subject=subject;
		this.assigned=assigned;
		this.t_name=t_name;
		this.comments=comments;
		this.status=status;
		this.priority=priority;
		this.date1=date1;
		this.date2=date2;
		this.time1=time1;
		
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="assigned")
	private String assigned;
	
	@Column(name="date1")
	private Date date1;
	
	@Column(name="t_name")
	private String t_name;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="priority")
	private String priority = DEFAULT_PRIORITY;
	
	@Column(name="status")
	private String status = DEFAULT_STATUS;
	
	@Column(name="date2")
	private Date date2;
	
	@Column(name="time1")
	private Time time1;
	
	
	
	
	public long getid() {
		return id;
	}
	public void setid(long id) {
		this.id = id;
	}
	public String getsubject() {
		return subject;
	}
	public void setsubject(String subject) {
		this.subject = subject;
	}
	public String getassigned() {
		return assigned;
	}
	public void setassigned(String assigned) {
		this.assigned = assigned;
	}
	public Date getdate1() {
		return date1;
	}
	public void setdate1(Date date1) {
		this.date1 = date1;
	}
	public String gett_name() {
		return t_name;
	}
	public void sett_name(String t_name) {
		this.t_name = t_name;
	}
	public String getcomments() {
		return comments;
	}
	public void setcomments(String comments) {
		this.comments = comments;
	}
	public String getstatus() {
		return status;
	}
	public void setstatus(String status) {
		this.status = status;
	}
	public Date getdate2() {
		return date2;
	}
	public void setdate2(Date date2) {
		this.date2 = date2;
	}
	public Time gettime1() {
		return time1;
	}
	public void settime1(Time time1) {
		this.time1 = time1;
	}
	public String getpriority() {
		return priority;
	}
	public void setpriority(String priority) {
		this.priority = priority;
	}
	@Override
	public String toString() {
		return "task [id=" + id + ", subject=" + subject + ", assigned=" + assigned + ", date1=" + date1 + ", t_name="
				+ t_name + ", comments=" + comments + ", status=" + status + ", date2=" + date2 + ", time1=" + time1
				+ ", priority=" + priority + ", getid()=" + getid() + ", getsubject()=" + getsubject()
				+ ", getassigned()=" + getassigned() + ", getdate1()=" + getdate1() + ", gett_name()=" + gett_name()
				+ ", getcomments()=" + getcomments() + ", getstatus()=" + getstatus() + ", getdate2()=" + getdate2()
				+ ", gettime1()=" + gettime1() + ", getpriority()=" + getpriority() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
