package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("meMilitarySexualTrauma")
public class ModuleExporterMst extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "mst1_2", null),//
				createDataExportCellFor(moduleVars, "mst3a_childhood", null),//
				createDataExportCellFor(moduleVars, "mst3b_adulthood", null),//
				createDataExportCellFor(moduleVars, "Mst_consult", null));
	}

}
