package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("mePromisPainIntensityInterference")
public class ModuleExporterPromisPainIntensityInterference extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,	Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "pain_intensity", null),//
				createDataExportCellFor(moduleVars, "pain_average", null),//
				createDataExportCellFor(moduleVars, "pain_score_intensity", null),//
				createDataExportCellFor(moduleVars, "pain_interfere_life", null),//
				createDataExportCellFor(moduleVars, "pain_interfere_conc", null),//
				createDataExportCellFor(moduleVars, "pain_interfere_day", null),//
				createDataExportCellFor(moduleVars, "pain_interfere_rec", null),//
				createDataExportCellFor(moduleVars, "pain_interfere_task", null),//
				createDataExportCellFor(moduleVars, "pain_interfere_social", null),//
				createDataExportCellFor(moduleVars, "pain_score_interference", null));
	}

}
