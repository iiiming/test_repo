package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("mePcptsd")
public class ModuleExporterPcptsd extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "pcptsdA_nightmare", null),//
				createDataExportCellFor(moduleVars, "pcptsdB_notthink", null),//
				createDataExportCellFor(moduleVars, "pcptsdC_onguard", null),//
				createDataExportCellFor(moduleVars, "pcptsdD_numb", null),//
				createDataExportCellFor(moduleVars, "pcptsd_score", null));
	}

}
