package be.steformations.data.timesheets.entities;

public interface Project {

	Long getId();

	String getName();

	String getDescription();

	java.util.Date getStartDate();

	java.util.Date getEndDate();

	Employee getManager();

}
