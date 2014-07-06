package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Project
 *
 */
@Entity
@Table(name="Tprojects")
public class Project implements Serializable {

	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int idProject;
	
	@Column
	private String nameProject;
	
	@Column
	private String description;
	
	@OneToMany(mappedBy="project")
	private List<Affectation> affectations;
	


	public Project() {
		
	}   
	
	
	public Project(String nameProject, String description) {
	
		this.nameProject = nameProject;
		this.description = description;
	}


	
	public int getIdProject() {
		return this.idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}   
	public String getNameProject() {
		return this.nameProject;
	}

	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	public List<Affectation> getAffectations() {
		return affectations;
	}
	public void setAffectations(List<Affectation> affectations) {
		this.affectations = affectations;
	}
   
}
