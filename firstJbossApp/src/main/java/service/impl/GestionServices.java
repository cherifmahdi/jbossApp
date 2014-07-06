package service.impl;

import java.sql.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import service.interfaces.GestionServicesLocal;
import entities.Affectation;
import entities.Employee;
import entities.Project;
import entities.Tache;

@Stateless
public class GestionServices implements GestionServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	public GestionServices() {

		// TODO Auto-generated constructor stub
	}

	/*@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		entityManager.persist(employee);

	}

	@Override
	public void deleteEmployee(int idEmployee) {
		entityManager.remove(entityManager.find(Employee.class, idEmployee));

	}

	@Override
	public void updateEmployee(Employee employee) {
		entityManager.merge(employee);

	}

	@Override
	public List<Employee> findAllEmployees() {
		return entityManager.createQuery("select e from Employee e").getResultList();
	}*/
	
	
	@Override
	public void addEmployee(Employee employee) {
		entityManager.persist(employee);

	}

	@Override
	public void addTproject(Project project) {
		entityManager.persist(project);

	}

	@Override
	public void addTtach(Tache tache) {
		entityManager.persist(tache);
		
	}

	@Override
	public void addTaffectation(Affectation affectation) {
		entityManager.persist(affectation);
		
	}

	/*@Override
	public Employee finTemployeeById(int idTemployee) {
		return entityManager.find(Employee.class, idTemployee);
	}*/

	@Override
	public Project findTprojectById(int idTproject) {
		return entityManager.find(Project.class, idTproject);
	}

	@Override
	public Tache finTtachById(int idTtach) {
		return entityManager.find(Tache.class, idTtach);
	}

	@Override
	public Affectation findTaffectationById(int idTaffectation) {
		return entityManager.find(Affectation.class, idTaffectation);
	}

	@Override
	public void updateEmployee(Employee Temployee) {
		boolean b = false;

		try {
			entityManager.merge(Temployee);
			b = true;
		} catch (Exception e) {
			System.out.println("Erreur!!");
		}

		//return b;
	}

	@Override
	public void updateProject(Project Tproject) {
		boolean b = false;

		try {
			System.out.println(Tproject.getIdProject() +" "+Tproject.getNameProject());
			//entityManager.detach(Tproject);
			entityManager.merge(entityManager.find(Project.class, Tproject.getIdProject()));
			//entityManager.flush();
			b = true;
		} catch (Exception e) {
			System.out.println("Erreur!!");
		}

		//return b;
	}

	@Override
	public void updateTtach(Tache Ttach) {
		boolean b = false;

		try {
			entityManager.merge(Ttach);
			b = true;
		} catch (Exception e) {
			System.out.println("Erreur!!");
		}

		//return b;
	}

	@Override
	public void updateAffectation(Affectation affectation) {
		boolean b = false;

		try {
			entityManager.merge(affectation);
			b = true;
		} catch (Exception e) {
			System.out.println("Erreur!!");
		}

		//return b;
	}

	@Override
	public void deleteEmployee(int idEmployee) {
		entityManager.remove(entityManager.find(Employee.class, idEmployee));

	}

	@Override
	public void deleteTproject(int idProject) {
		entityManager.remove(entityManager.find(Project.class, idProject));
	}

	@Override
	public void deleteTtach(int idTache) {
		entityManager.remove(entityManager.find(Tache.class, idTache));
	}

	@Override
	public void deleteAffectation(int idAffectation) {
		entityManager.remove(entityManager.find(Affectation.class, idAffectation));
	}

	@Override
	public List<Employee> findAllEmployees() {
		Query query = entityManager.createQuery("SELECT e FROM Employee e");
		return query.getResultList();
	}

	@Override
	public List<Project> listProject() {
		Query query = entityManager.createQuery("SELECT e FROM Project e");
		return query.getResultList();
	}

	@Override
	public List<Tache> listTache() {
		Query query = entityManager.createQuery("SELECT e FROM Tache e");
		return query.getResultList();
	}

	@Override
	public List<Affectation> listAfectation() {
		Query query = entityManager.createQuery("SELECT e FROM Affectation e");
		return query.getResultList();
	}

	@Override
	public List<Affectation> listAffectationsFini() {
		java.util.Date datefin = new java.util.Date();
		Date date = new Date(datefin.getTime());
		Query query = entityManager
				.createQuery("SELECT e FROM Affectation e where e.dateFin < '"
						+ date + "' ");

		return query.getResultList();
	}

	@Override
	public List<Affectation> listeTacheByEmployee(Employee employee) {

		Query query = entityManager
				.createQuery("SELECT a FROM Affectation a JOIN a.employe e where e.idEmployee = "
						+ employee.getIdEmployee());

		return query.getResultList();

	}

	@Override
	public List<Affectation> listeTacheByProject(Project project) {
		Query query = entityManager
				.createQuery("SELECT a FROM Affectation a JOIN a.project e where e.idProject = "
						+ project.getIdProject());

		return query.getResultList();

	}

	@Override
	public List<Affectation> etatProject(Project project) {
		Query query = entityManager
				.createQuery("SELECT a FROM Affectation a JOIN a.project e where e.idProject = "
						+ project.getIdProject());

		return query.getResultList();
	}

	@Override
	public List<Affectation> getTachebyJob(Project project, String job) {
		Query query = entityManager
				.createQuery("SELECT a FROM Affectation a JOIN a.employe e JOIN a.project p where e.job ='"
						+ job
						+ "' and  p.idProject = "
						+ project.getIdProject());

		return query.getResultList();

	}

	@Override
	public Employee findEmployeeById(int idEmployee) {
		return entityManager.find(Employee.class, idEmployee);
	}

}
