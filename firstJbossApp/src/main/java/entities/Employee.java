package entities;
import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
@Table(name="TEmployee")
public class Employee implements Serializable {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int idEmployee;
	
	@Column
	private String nameEmployee;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String job;
	
	

	public Employee() {

	}  
	
	
	
	public Employee(String nameEmployee, String username, String password,
			String job) {

		this.nameEmployee = nameEmployee;
		this.username = username;
		this.password = password;
		this.job = job;
	}



	
	public int getIdEmployee() {
		return this.idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}   
	public String getNameEmployee() {
		return this.nameEmployee;
	}

	public void setNameEmployee(String nameEmployee) {
		this.nameEmployee = nameEmployee;
	}   
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	
}
