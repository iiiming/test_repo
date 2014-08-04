package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("meTobaccoUse")
public class ModuleExporterTobaccoUse extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "tob_use", null),//
				createDataExportCellFor(moduleVars, "tob_quit_when", null),//
				createDataExportCellFor(moduleVars, "tob_quit_month", null),//
				createDataExportCellFor(moduleVars, "tob_quit_date", null),//
				createDataExportCellFor(moduleVars, "tob_ciggs", null),//
				createDataExportCellFor(moduleVars, "tob_cigar", null),//
				createDataExportCellFor(moduleVars, "tob_smokeless", null),//
				createDataExportCellFor(moduleVars, "tob_cigg_quant_length", null),//
				createDataExportCellFor(moduleVars, "tob_pipe_quant_length", null),//
				createDataExportCellFor(moduleVars, "tob_chew_quant_length", null));
	}

}
