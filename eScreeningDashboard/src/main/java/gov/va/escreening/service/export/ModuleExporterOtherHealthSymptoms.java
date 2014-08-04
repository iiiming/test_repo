package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("meOtherHealthSymptoms")
public class ModuleExporterOtherHealthSymptoms extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,	Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(
				createDataExportCellFor(moduleVars, "health16_hearing", null),//
				createDataExportCellFor(moduleVars, "health17_tinnitus", null),//
				createDataExportCellFor(moduleVars, "health_score_hearing", null),//
				createDataExportCellFor(moduleVars, "health20_vision", null),//
				createDataExportCellFor(moduleVars, "health_score_vision", null),//
				createDataExportCellFor(moduleVars, "health21_wghtgain", null),//
				createDataExportCellFor(moduleVars, "health22_wghtloss", null),//
				createDataExportCellFor(moduleVars, "health_score_weight", null),//
				createDataExportCellFor(moduleVars, "health23_forgetfulness", null),//
				createDataExportCellFor(moduleVars, "health_score_forget", null));
	}

}
