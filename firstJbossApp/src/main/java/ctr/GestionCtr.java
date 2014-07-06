package ctr;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.primefaces.event.RowEditEvent;

import service.interfaces.GestionServicesLocal;

import entities.Affectation;
import entities.Employee;
import entities.Project;
import entities.Tache;


@ManagedBean
@RequestScoped
public class GestionCtr {
	
	private Employee employee = new Employee();
	private List<Employee> employees = new ArrayList<Employee>();
	private DataModel<Employee> dataModel = new ListDataModel<Employee>();
	
	private Project project =new Project();
	private List<Project> projects = new ArrayList<Project>();
	private DataModel<Project> dataModelProject = new ListDataModel<Project>();
	
	private Tache tache = new Tache();
	private List<Tache> taches = new ArrayList<Tache>();
	private DataModel<Tache> dataModelTache = new ListDataModel<Tache>();
	
	
	private Affectation affectation = new Affectation();
	private List<Affectation> affectations = new ArrayList<Affectation>();
	private DataModel<Affectation> dataModelAffectation = new ListDataModel<Affectation>();
	
	
	
	
	@EJB
	private GestionServicesLocal gestionServicesLocal ;
	
	public String doAddEmployee(){
		gestionServicesLocal.addEmployee(employee);
		return "";
	}
	
	public String doDeleteEmployee(){
		Employee employeeSelected = dataModel.getRowData();
		gestionServicesLocal.deleteEmployee(employeeSelected.getIdEmployee());
		return "";
	}
	
	public String doUpdateEmployee(){
		gestionServicesLocal.updateEmployee(employee);
		return "";
	}
	

	
	public String doAddProject(){
		gestionServicesLocal.addTproject(project);
		return "";
	}
	
	public String doDeleteProject(){
		Project projectSelected = dataModelProject.getRowData();
		gestionServicesLocal.deleteTproject(projectSelected.getIdProject());
		return "";
	}
	
	public String doUpdateProject(){
		gestionServicesLocal.updateProject(project);
		return "";
	}
	
	
	
	/****************/
	
	public void onEdit(RowEditEvent event) {  
		//gestionServicesLocal.updateProject(project);
		Project projectSelected = (Project) event.getObject();
		//project = projectSelected;
		project = gestionServicesLocal.findTprojectById(projectSelected.getIdProject());
		
		//System.out.println(project.getIdProject() +" "+project.getNameProject());
		gestionServicesLocal.updateProject(project);
		//System.out.println("++++++++++++++"+projectSelected.getIdProject());
        FacesMessage msg = new FacesMessage("Car Edited", ((Project) event.getObject()).getNameProject());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
      
    public void onCancel(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Car Cancelled", ((Project) event.getObject()).getNameProject());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    } 
	/***************/
	
	
	
	
	public String doAddTache(){
		gestionServicesLocal.addTtach(tache);
		return "";
	}
	
	public String doDeleteTache(){
		Tache tacheSelected = dataModelTache.getRowData();
		gestionServicesLocal.deleteTtach(tacheSelected.getIdTache());
		return "";
	}
	
	public String doUpdateTache(){
		gestionServicesLocal.updateTtach(tache);
		return "";
	}
	
	
	
	
	public String doAddAffectation(){
		System.out.println("affectaion test");
		System.out.println(affectation.getRole());
		System.out.println(project.getIdProject());
		
		java.util.Date datedebut = new java.util.Date();
		java.util.Date datefin = new java.util.Date();
		datefin.setMonth(20);
		datefin.setYear(113);
		datefin.setDate(12);
		
		project = gestionServicesLocal.findTprojectById(project.getIdProject());
		tache = gestionServicesLocal.finTtachById(tache.getIdTache());
		employee = gestionServicesLocal.findEmployeeById(employee.getIdEmployee());
		Affectation newAffectation = new Affectation(affectation.getRole(), new Date(datedebut.getTime()), new Date(datefin.getTime()),employee, project, tache);
		
		affectation = newAffectation;
		
		gestionServicesLocal.addTaffectation(affectation);
		return "";
	}
	
	public String doDeleteAffectation(){
		Affectation affectationSelected = dataModelAffectation.getRowData();
		gestionServicesLocal.deleteAffectation(affectationSelected.getIdAffectation());
		return "";
	} 
	
	public String doUpdateAffectation(){
		gestionServicesLocal.updateAffectation(affectation);
		return "";
	}
	
	
	public String redirectToUpdatePage(){
		Employee employeeSelected = dataModel.getRowData();
		employee = employeeSelected;
		return "/pages/updateEmployee.jsf";
	}
	

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Employee> getEmployees() {
		employees = gestionServicesLocal.findAllEmployees();
		
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public DataModel<Employee> getDataModel() {
		dataModel.setWrappedData(gestionServicesLocal.findAllEmployees());
		return dataModel;
	}

	public void setDataModel(DataModel<Employee> dataModel) {
		this.dataModel = dataModel;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Project> getProjects() {
		projects = gestionServicesLocal.listProject();
		
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public DataModel<Project> getDataModelProject() {
		dataModelProject.setWrappedData(gestionServicesLocal.listProject());
		
		return dataModelProject;
	}

	public void setDataModelProject(DataModel<Project> dataModelProject) {
		this.dataModelProject = dataModelProject;
	}

	public Tache getTache() {
		return tache;
	}

	public void setTache(Tache tache) {
		this.tache = tache;
	}

	public List<Tache> getTaches() {
		taches = gestionServicesLocal.listTache();
		return taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}

	public DataModel<Tache> getDataModelTache() {
		dataModelTache.setWrappedData(gestionServicesLocal.listTache());

		return dataModelTache;
	}

	public void setDataModelTache(DataModel<Tache> dataModelTache) {
		this.dataModelTache = dataModelTache;
	}

	public Affectation getAffectation() {
		return affectation;
	}

	public void setAffectation(Affectation affectation) {
		this.affectation = affectation;
	}

	public List<Affectation> getAffectations() {
		affectations = gestionServicesLocal.listAfectation();
		return affectations;
	}

	public void setAffectations(List<Affectation> affectations) {
		this.affectations = affectations;
	}

	public DataModel<Affectation> getDataModelAffectation() {
		dataModelAffectation.setWrappedData(gestionServicesLocal.listAfectation());
		return dataModelAffectation;
	}

	public void setDataModelAffectation(DataModel<Affectation> dataModelAffectation) {
		this.dataModelAffectation = dataModelAffectation;
	}
	


}
