package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("meAdvanceDirective")
public class ModuleExporterAdvanceDirective extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {

		return Arrays.asList(
				createDataExportCellFor(moduleVars, "demo_language", null),//
				createDataExportCellFor(moduleVars, "demo_language_otherspec", null),//
				createDataExportCellFor(moduleVars, "demo_will", null),//
				createDataExportCellFor(moduleVars, "demo_will_info", null));
	}

}
