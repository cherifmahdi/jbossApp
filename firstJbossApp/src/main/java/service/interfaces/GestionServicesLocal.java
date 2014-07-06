package service.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Affectation;
import entities.Employee;
import entities.Project;
import entities.Tache;

@Local
public interface GestionServicesLocal {
	
	
	public void addEmployee(Employee employee);
	public void deleteEmployee(int idEmployee);
	public void updateEmployee(Employee employee);
	public Employee findEmployeeById(int idEmployee);
	public List<Employee> findAllEmployees();
	
	
	public void addTproject(Project project);
	public void updateProject(Project Tproject);
	public Project findTprojectById(int idTproject);
	public void deleteTproject(int idProject);
	public List<Project> listProject();
	
	
	public void addTtach(Tache tache);
	public void updateTtach(Tache Ttach);
	public Tache finTtachById(int idTtach);
	public void deleteTtach(int idTache);
	public List<Tache> listTache();
	
	public void addTaffectation(Affectation affectation);
	public void updateAffectation(Affectation affectation);
	public Affectation findTaffectationById(int idTaffectation);
	public void deleteAffectation(int idAffectation);
	public List<Affectation> listAfectation();
	
	public List<Affectation> listAffectationsFini();
	public List<Affectation> listeTacheByEmployee(Employee employee);
	public List<Affectation> listeTacheByProject(Project project );

	
	public List<Affectation> etatProject(Project project );
	public List<Affectation> getTachebyJob(Project project,String job);

}
