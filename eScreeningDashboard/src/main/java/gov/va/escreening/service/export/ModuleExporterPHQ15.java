package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("mePHQ15")
public class ModuleExporterPHQ15 extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "health1_stomach", null),//
				createDataExportCellFor(moduleVars, "health2_back", null),//
				createDataExportCellFor(moduleVars, "health3_arm", null),//
				createDataExportCellFor(moduleVars, "health4_cramp", null),//
				createDataExportCellFor(moduleVars, "health5_headache", null),//
				createDataExportCellFor(moduleVars, "health6_chest", null),//
				createDataExportCellFor(moduleVars, "health7_dizzy", null),//
				createDataExportCellFor(moduleVars, "health8_faint", null),//
				createDataExportCellFor(moduleVars, "health9_heart", null),//
				createDataExportCellFor(moduleVars, "health10_breath", null),//
				createDataExportCellFor(moduleVars, "health11_sex", null),//
				createDataExportCellFor(moduleVars, "health12_constipation", null),//
				createDataExportCellFor(moduleVars, "health13_nausea", null),//
				createDataExportCellFor(moduleVars, "health14_tired", null),//
				createDataExportCellFor(moduleVars, "health15_sleeping", null),//
				createDataExportCellFor(moduleVars, "health_score_phq15", null));
	}

}
