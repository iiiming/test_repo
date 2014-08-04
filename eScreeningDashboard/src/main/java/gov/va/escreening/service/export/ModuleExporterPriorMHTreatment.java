package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("mePriorMentalHealthTreatment")
public class ModuleExporterPriorMHTreatment extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "prior_dx_dep", null),//
				createDataExportCellFor(moduleVars, "prior_dx_ptsd", null),//
				createDataExportCellFor(moduleVars, "Prior_dx_none", null),//
				createDataExportCellFor(moduleVars, "prior_dx_oth", null),//
				createDataExportCellFor(moduleVars, "prior_dx_oth_spec", null),//
				createDataExportCellFor(moduleVars, "prior_dx_score", null),//
				createDataExportCellFor(moduleVars, "prior_tx_inpt", null),//
				createDataExportCellFor(moduleVars, "prior_tx_thpy", null),//
				createDataExportCellFor(moduleVars, "prior_tx_med", null),//
				createDataExportCellFor(moduleVars, "prior_tx_ect", null),//
				createDataExportCellFor(moduleVars, "Prior_tx_none", null),//
				createDataExportCellFor(moduleVars, "prior_tx_oth", null),//
				createDataExportCellFor(moduleVars, "prior_tx_oth_spec", null),//
				createDataExportCellFor(moduleVars, "prior_tx_score", null),//
				createDataExportCellFor(moduleVars, "Prior_hx_tx_req_appt", null));
	}

}
