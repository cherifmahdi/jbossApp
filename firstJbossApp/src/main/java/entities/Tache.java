package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tache
 *
 */
@Entity
@Table(name="TTaches")
public class Tache implements Serializable {

	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int idTache;
	@Column
	private String nameTache;
	
	@Column
	private String description;
	
	@OneToMany(mappedBy="tache")
	private List<Affectation> affectations;
	


	public Tache() {

	}  
	
	
	public Tache(String nameTache, String description) {
	
		this.nameTache = nameTache;
		this.description = description;
	}


	
	public int getIdTache() {
		return this.idTache;
	}

	public void setIdTache(int idTache) {
		this.idTache = idTache;
	}   
	public String getNameTache() {
		return this.nameTache;
	}

	public void setNameTache(String nameTache) {
		this.nameTache = nameTache;
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
