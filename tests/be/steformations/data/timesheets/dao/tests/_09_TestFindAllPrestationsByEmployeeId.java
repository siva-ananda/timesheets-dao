package be.steformations.data.timesheets.dao.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.steformations.data.timesheets.entities.Prestation;
import be.steformations.data.timesheets.service.TimesheetsDataService;

public class _09_TestFindAllPrestationsByEmployeeId extends TestsUtils {

	private TimesheetsDataService service;
	
	@Before
	public void setUp() throws Exception {
		service = TestsFactory.createTimesheetsDataService();
		assertNotNull(service);
	}

	@Test
	public void testFindAllPrestationsByBatman() {
		java.util.List<? extends Prestation> list = this.service.findAllPrestationsByEmployeeId(1L);
		assertNotNull(list);
		assertEquals(1, list.size());
		Prestation p = list.get(0);
		this.isSendmail(p);
	}
	
	@Test
	public void testFindAllPrestationsByWonderwoman() {
		java.util.List<? extends Prestation> list = this.service.findAllPrestationsByEmployeeId(2L);
		assertNotNull(list);
		assertEquals(2, list.size());
		for (Prestation p : list) {
			assertNotNull(p);
			assertNotNull(p.getId());
			if (p.getId() == 2L) {
				isReadmail(p);
			} else {
				isRespondmail(p);
			}
		}
	}

}
