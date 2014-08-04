package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("meMoodDisorder")
public class ModuleExporterMdq extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "hyp1a_good", null),//
				createDataExportCellFor(moduleVars, "hyp1b_irritable", null),//
				createDataExportCellFor(moduleVars, "hyp1c_confident", null),//
				createDataExportCellFor(moduleVars, "hyp1d_sleep", null),//
				createDataExportCellFor(moduleVars, "hyp1e_talkative", null),//
				createDataExportCellFor(moduleVars, "hyp1f_thoughts", null),//
				createDataExportCellFor(moduleVars, "hyp1g_distracted", null),//
				createDataExportCellFor(moduleVars, "hyp1h_energy", null),//
				createDataExportCellFor(moduleVars, "hyp1i_active", null),//
				createDataExportCellFor(moduleVars, "hyp1j_social", null),//
				createDataExportCellFor(moduleVars, "hyp1k_sex", null),//
				createDataExportCellFor(moduleVars, "hyp1l_unusual", null),//
				createDataExportCellFor(moduleVars, "hyp1m_spend", null),//
				createDataExportCellFor(moduleVars, "hyp2_time", null),//
				createDataExportCellFor(moduleVars, "hyp3_problem", null),//
				createDataExportCellFor(moduleVars, "hyp4_relative", null),//
				createDataExportCellFor(moduleVars, "hyp5_disorder", null),//
				createDataExportCellFor(moduleVars, "hyp_score", null),//
				createDataExportCellFor(moduleVars, "hyp_criteria", null));
	}

}
