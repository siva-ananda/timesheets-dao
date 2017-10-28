package be.steformations.data.timesheets.dao.tests;

import be.steformations.data.timesheets.service.TimesheetsDataService;
import be.steformations.sivananda.data.timesheets.service.jpa.TimesheetsDataServiceJpa;

public class TestsFactory {

	public static TimesheetsDataService createTimesheetsDataService() {
		return new TimesheetsDataServiceJpa();
	}
}
