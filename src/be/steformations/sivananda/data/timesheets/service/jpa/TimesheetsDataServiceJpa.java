package be.steformations.sivananda.data.timesheets.service.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import be.steformations.data.timesheets.entities.Employee;
import be.steformations.data.timesheets.entities.Prestation;
import be.steformations.data.timesheets.entities.Project;
import be.steformations.data.timesheets.service.TimesheetsDataService;
import be.steformations.sivananda.data.timesheets.entities.EmployeeImpl;
import be.steformations.sivananda.data.timesheets.entities.PrestationImpl;
import be.steformations.sivananda.data.timesheets.entities.ProjectImpl;

public class TimesheetsDataServiceJpa implements TimesheetsDataService {

	private EntityManager entityManager;

	public TimesheetsDataServiceJpa() {
		super();
		this.entityManager = Persistence.createEntityManagerFactory("postgresql_eclipselink").createEntityManager();
	}

	@Override
	public List<? extends Employee> findAllEmployees() {
		TypedQuery<EmployeeImpl> query = entityManager.createNamedQuery("findAllEmployees", EmployeeImpl.class);
		return query.getResultList();
	}

	@Override
	public Employee findOneEmployeeById(long id) {
		return entityManager.find(EmployeeImpl.class, id);
	}

	@Override
	public Employee findOneEmployeeByFirstnameAndName(String firstname, String name) {
		EmployeeImpl employee = null;
		TypedQuery<EmployeeImpl> query = entityManager.createNamedQuery("findOneEmployeeByFirstnameAndName",
				EmployeeImpl.class);
		query.setParameter(1, firstname);
		query.setParameter(2, name);
		try {
			employee = query.getSingleResult();
		} catch (NoResultException e) {
		}
		return employee;
	}

	@Override
	public Employee findOneEmployeeByLoginAndPassword(String login, String password) {
		EmployeeImpl employee = null;
		TypedQuery<EmployeeImpl> query = entityManager.createNamedQuery("findOneEmployeeByLoginAndPassword",
				EmployeeImpl.class);
		query.setParameter(1, login);
		query.setParameter(2, password);
		try {
			employee = query.getSingleResult();
		} catch (NoResultException e) {
		}
		return employee;
	}

	@Override
	public List<? extends Project> findAllProjects() {
		TypedQuery<ProjectImpl> query = entityManager.createNamedQuery("findAllProjects", ProjectImpl.class);
		return query.getResultList();
	}

	@Override
	public Project findOneProjectById(long id) {
		return entityManager.find(ProjectImpl.class, id);
	}

	@Override
	public Project findOneProjectByName(String name) {
		ProjectImpl project = null;
		TypedQuery<ProjectImpl> query = entityManager.createNamedQuery("findOneProjectByName", ProjectImpl.class);
		query.setParameter(1, name);
		try {
			project = query.getSingleResult();
		} catch (NoResultException e) {
		}
		return project;
	}

	@Override
	public Prestation findOnePrestationById(long id) {
		return entityManager.find(PrestationImpl.class, id);
	}

	@Override
	public List<? extends Prestation> findAllPrestationsByEmployeeId(long id) {
		TypedQuery<PrestationImpl> query = entityManager.createNamedQuery("findAllPrestationsByEmployeeId",
				PrestationImpl.class);
		query.setParameter(1, id);
		return query.getResultList();
	}

	@Override
	public List<? extends Prestation> findAllPrestationsByProjectId(long id) {
		TypedQuery<PrestationImpl> query = entityManager.createNamedQuery("findAllPrestationsByProjectId",
				PrestationImpl.class);
		query.setParameter(1, id);
		return query.getResultList();
	}

	@Override
	public Prestation addPrestation(long employeeId, long projectId, String comment, Date day, int duration) {
		PrestationImpl prestation = null;

		if (day != null && duration >= 0 && this.findOneEmployeeById(employeeId) != null
				&& this.findOneProjectById(projectId) != null) {
			prestation = new PrestationImpl();
			prestation.setEmployee((EmployeeImpl) this.findOneEmployeeById(employeeId));
			prestation.setProject((ProjectImpl) this.findOneProjectById(projectId));
			prestation.setComment(comment);
			prestation.setDay(day);
			prestation.setDuration(duration);

			this.entityManager.getTransaction().begin();
			this.entityManager.persist(prestation);
			this.entityManager.getTransaction().commit();
		}
		return prestation;
	}

	@Override
	public Prestation deletePrestation(long id) {
		PrestationImpl p = (PrestationImpl) this.findOnePrestationById(id);
		if (p != null) {
			this.entityManager.getTransaction().begin();
			this.entityManager.remove(p);
			this.entityManager.getTransaction().commit();
		}
		return p;
	}

}
