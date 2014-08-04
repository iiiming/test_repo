package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("meEmbeddedFragment")
public class ModuleExporterEmbeddedFragment extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "infect1a_gastro", null),//
				createDataExportCellFor(moduleVars, "infect1b_gastrosympt", null),//
				createDataExportCellFor(moduleVars, "infect2a_fever", null),//
				createDataExportCellFor(moduleVars, "infect2b_feversympt", null),//
				createDataExportCellFor(moduleVars, "infect3a_rash", null),//
				createDataExportCellFor(moduleVars, "infect3b_rashsympt", null),//
				createDataExportCellFor(moduleVars, "infect4a_fragment", null),//
				createDataExportCellFor(moduleVars, "infect4b_fragmentsympt", null),//
				createDataExportCellFor(moduleVars, "infect_score", null));
	}

}
