package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("meDemographics")
public class ModuleExporterDemographics extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	public List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "demo_gender", null),//
				createDataExportCellFor(moduleVars, "demo_DOB", null),//
				createDataExportCellFor(moduleVars, "demo_heightft", null),//
				createDataExportCellFor(moduleVars, "demo_heightinch", null),//
				createDataExportCellFor(moduleVars, "demo_weight", null),//
				createDataExportCellFor(moduleVars, "demo_totalheightin", null),//
				createDataExportCellFor(moduleVars, "demo_BMI", null),//
				createDataExportCellFor(moduleVars, "demo_score_BMI", null),//
				createDataExportCellFor(moduleVars, "demo_ethnic", null),//
				createDataExportCellFor(moduleVars, "demo_racewhite", null),//
				createDataExportCellFor(moduleVars, "demo_race_amind", null),//
				createDataExportCellFor(moduleVars, "demo_race_pacisl", null),//
				createDataExportCellFor(moduleVars, "demo_race_black", null),//
				createDataExportCellFor(moduleVars, "demo_race_asian", null),//
				createDataExportCellFor(moduleVars, "demo_race_oth", null),//
				createDataExportCellFor(moduleVars, "demo_race_othspec", null),//
				createDataExportCellFor(moduleVars, "demo_race_decline", null));
	}

}
