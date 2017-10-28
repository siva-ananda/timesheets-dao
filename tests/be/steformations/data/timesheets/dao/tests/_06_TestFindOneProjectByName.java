package be.steformations.data.timesheets.dao.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.steformations.data.timesheets.entities.Project;
import be.steformations.data.timesheets.service.TimesheetsDataService;

public class _06_TestFindOneProjectByName extends TestsUtils {

	private TimesheetsDataService service;
	
	@Before
	public void setUp() throws Exception {
		service = TestsFactory.createTimesheetsDataService();
		assertNotNull(service);
	}

	@Test
	public void testFindJusticeLeagueByName() {
		Project p = this.service.findOneProjectByName("Justice League");
		this.isJusticeLeague(p);
	}
}
