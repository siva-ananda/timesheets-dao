package be.steformations.sivananda.data.timesheets.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import be.steformations.data.timesheets.entities.Employee;
import be.steformations.data.timesheets.entities.Prestation;
import be.steformations.data.timesheets.entities.Project;

@Entity(name="Employee")
@Table(name = "employee")
public class EmployeeImpl implements Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name="id")
	private Long id;

	// @Basic
	// @Column(name="firstname")
	private String firstname;

	private String name;

	private String login;

	private String password;

	@OneToMany(mappedBy = "manager")
	private List<ProjectImpl> managedProjects;

	@OneToMany(mappedBy = "employee")
	private List<PrestationImpl> prestations;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getFirstname() {
		return firstname;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getLogin() {
		return login;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public List<? extends Project> getManagedProjects() {
		if (managedProjects == null) {
			managedProjects = new java.util.ArrayList<ProjectImpl>();
		}
		return managedProjects;
	}

	@Override
	public List<? extends Prestation> getPrestations() {
		if (prestations == null) {
			prestations = new java.util.ArrayList<PrestationImpl>();
		}
		return prestations;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setManagedProjects(List<ProjectImpl> managedProjects) {
		this.managedProjects = managedProjects;
	}

	public void setPrestations(List<PrestationImpl> prestations) {
		this.prestations = prestations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((managedProjects == null) ? 0 : managedProjects.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((prestations == null) ? 0 : prestations.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeImpl other = (EmployeeImpl) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (managedProjects == null) {
			if (other.managedProjects != null)
				return false;
		} else if (!managedProjects.equals(other.managedProjects))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (prestations == null) {
			if (other.prestations != null)
				return false;
		} else if (!prestations.equals(other.prestations))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeImpl [id=" + id + ", firstname=" + firstname + ", name=" + name + ", login=" + login
				+ ", password=" + password + ", managedProjects=" + managedProjects + ", prestations=" + prestations
				+ "]";
	}

}
