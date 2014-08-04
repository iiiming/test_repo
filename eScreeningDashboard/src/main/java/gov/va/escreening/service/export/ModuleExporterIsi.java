package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("meInsomnia")
public class ModuleExporterIsi extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "sleep1a_falling", null),//
				createDataExportCellFor(moduleVars, "sleep1b_staying", null),//
				createDataExportCellFor(moduleVars, "sleep1c_waking", null),//
				createDataExportCellFor(moduleVars, "sleep2_satisfied", null),//
				createDataExportCellFor(moduleVars, "sleep3_interfere", null),//
				createDataExportCellFor(moduleVars, "sleep4_noticeable", null),//
				createDataExportCellFor(moduleVars, "sleep5_worried", null),//
				createDataExportCellFor(moduleVars, "sleep_score", null));
	}

}
