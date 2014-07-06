package entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
/**
 * Entity implementation class for Entity: Affectation
 * 
 */
@Entity
@Table(name = "TAffectation")
public class Affectation implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int idAffectation;
	private String role;
	private Date dateDebut;
	private Date dateFin;
	
	
	@ManyToOne
	@JoinColumn(name="idEmployee")
	private Employee employe;
	
	@ManyToOne
	@JoinColumn(name="idProject")
	private Project project;
	
	@ManyToOne
	@JoinColumn(name="idTache")
	private Tache tache;

	public Affectation() {

	}
	
	

	public Affectation(String role, Date dateDebut, Date dateFin,
			Employee employee, Project project, Tache tache) {

		this.role = role;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.employe= employee;
		this.project = project;
		this.tache = tache;
	}




	public int getIdAffectation() {
		return this.idAffectation;
	}

	public void setIdAffectation(int idAffectation) {
		this.idAffectation = idAffectation;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	

	public Employee getEmploye() {
		return employe;
	}



	public void setEmploye(Employee employe) {
		this.employe = employe;
	}




	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}


	public Tache getTache() {
		return tache;
	}

	public void setTache(Tache tache) {
		this.tache = tache;
	}

}
