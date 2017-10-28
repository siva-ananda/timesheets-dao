package be.steformations.data.timesheets.dao.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.steformations.data.timesheets.entities.Project;
import be.steformations.data.timesheets.service.TimesheetsDataService;

public class _07_TestFindAllProjects extends TestsUtils {

	private TimesheetsDataService service;
	
	@Before
	public void setUp() throws Exception {
		service = TestsFactory.createTimesheetsDataService();
		assertNotNull(service);
	}

	@Test
	public void testFindAllProjects() {
		java.util.List<? extends Project> list = this.service.findAllProjects();
		assertNotNull(list);
		assertEquals(2, list.size());
		for (Project p : list) {
			assertNotNull(p);
			assertNotNull(p.getId());
			assertEquals(p, this.service.findOneProjectById(p.getId()));
		}
	}
}
