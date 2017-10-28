package be.steformations.data.timesheets.dao.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.steformations.data.timesheets.entities.Prestation;
import be.steformations.data.timesheets.service.TimesheetsDataService;

public class _10_TestFindAllPrestationsByProjectId extends TestsUtils {

	private TimesheetsDataService service;
	
	@Before
	public void setUp() throws Exception {
		service = TestsFactory.createTimesheetsDataService();
		assertNotNull(service);
	}

	@Test
	public void testFindAllPrestationsByProjectId() {
		java.util.List<? extends Prestation> list = this.service.findAllPrestationsByProjectId(1L);
		assertNotNull(list);
		assertEquals(3, list.size());
		for (Prestation p : list) {
			assertNotNull(p);
			assertEquals(p, this.service.findOnePrestationById(p.getId()));
		}
	}

}
