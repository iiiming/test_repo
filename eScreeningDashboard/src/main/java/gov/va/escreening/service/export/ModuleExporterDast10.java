package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("meDrugAbuse")
public class ModuleExporterDast10 extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "DAST1_other", null),//
				createDataExportCellFor(moduleVars, "DAST2_abuse", null),//
				createDataExportCellFor(moduleVars, "DAST3_ablestop", null),//
				createDataExportCellFor(moduleVars, "DAST4_blackout", null),//
				createDataExportCellFor(moduleVars, "DAST5_guilty", null),//
				createDataExportCellFor(moduleVars, "DAST6_complain", null),//
				createDataExportCellFor(moduleVars, "DAST7_neglect", null),//
				createDataExportCellFor(moduleVars, "DAST8_illegal", null),//
				createDataExportCellFor(moduleVars, "DAST9_withdraw", null),//
				createDataExportCellFor(moduleVars, "DAST10_medical", null),//
				createDataExportCellFor(moduleVars, "DAST_score", null));
	}

}
