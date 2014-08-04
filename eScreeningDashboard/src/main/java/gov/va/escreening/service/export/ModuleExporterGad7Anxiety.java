package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("meAnxiety")
public class ModuleExporterGad7Anxiety extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "gad1_nervous", null),//
				createDataExportCellFor(moduleVars, "gad2_notable", null),//
				createDataExportCellFor(moduleVars, "gad3_worry", null),//
				createDataExportCellFor(moduleVars, "gad4_trouble", null),//
				createDataExportCellFor(moduleVars, "gad5_restless", null),//
				createDataExportCellFor(moduleVars, "gad6_annoyed", null),//
				createDataExportCellFor(moduleVars, "gad7_afraid", null),//
				createDataExportCellFor(moduleVars, "gad7_score", null),//
				createDataExportCellFor(moduleVars, "gad8_difficult", null));
	}

}
