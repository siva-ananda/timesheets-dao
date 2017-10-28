package be.steformations.data.timesheets.entities;

public interface Prestation {

	Long getId();

	java.util.Date getDay();

	Employee getEmployee();

	Project getProject();

	int getDuration();

	String getComment();

}
