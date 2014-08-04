package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("meAlcoholConsumption")
public class ModuleExporterAuditC extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "alc_drinkyr", null),//
				createDataExportCellFor(moduleVars, "alc_drinkday", null),//
				createDataExportCellFor(moduleVars, "alc_drink6", null),//
				createDataExportCellFor(moduleVars, "alc_score_audit", null));
	}

}
