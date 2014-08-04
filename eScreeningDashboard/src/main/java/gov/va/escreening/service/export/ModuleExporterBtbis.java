package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.Survey;
import gov.va.escreening.entity.VeteranAssessment;
import gov.va.escreening.util.ModuleVarsHelper;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("meBtbis")
public class ModuleExporterBtbis extends ModuleExporterAbstract implements ModuleDataExporter {

	public ModuleExporterBtbis() {
		int i=0;
	}

	@Override
	protected List<DataExportCell> applyNow(String moduleName, Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(
				createDataExportCellFor(moduleVars, "tbi_blast", null),//
				createDataExportCellFor(moduleVars, "tbi_vehicle", null),//
				createDataExportCellFor(moduleVars, "tbi_fragment", null),//
				createDataExportCellFor(moduleVars, "tbi_fall", null),//
				createDataExportCellFor(moduleVars, "tbi_blow", null),//
				createDataExportCellFor(moduleVars, "tbi_otherinj", null),//
				createDataExportCellFor(moduleVars, "tbi_none", null),//
				createDataExportCellFor(moduleVars, "tbi_q1_score", null),//
				createDataExportCellFor(moduleVars, "tbi_immed_loss", null),//
				createDataExportCellFor(moduleVars, "tbi_immed_dazed", null),//
				createDataExportCellFor(moduleVars, "tbi_immed_memory", null),//
				createDataExportCellFor(moduleVars, "tbi_immed_concussion", null),//
				createDataExportCellFor(moduleVars, "tbi_immed_headinj", null),//
				createDataExportCellFor(moduleVars, "tbI_immed_none", null),//
				createDataExportCellFor(moduleVars, "tbi_q2_score", null),//
				createDataExportCellFor(moduleVars, "tbi_worse_memory", null),//
				createDataExportCellFor(moduleVars, "tbi_worse_balance", null),//
				createDataExportCellFor(moduleVars, "tbi_worse_light", null),//
				createDataExportCellFor(moduleVars, "tbi_worse_irritable", null),//
				createDataExportCellFor(moduleVars, "tbi_worse_headache", null),//
				createDataExportCellFor(moduleVars, "tbi_worse_sleep", null),//
				createDataExportCellFor(moduleVars, "tbi_worse_none", null),//
				createDataExportCellFor(moduleVars, "tbi_q3_score", null),//
				createDataExportCellFor(moduleVars, "tbi_week_memory", null),//
				createDataExportCellFor(moduleVars, "tbi_week_balance", null),//
				createDataExportCellFor(moduleVars, "tbi_week_light", null),//
				createDataExportCellFor(moduleVars, "tbi_week_irritable", null),//
				createDataExportCellFor(moduleVars, "tbi_week_headache", null),//
				createDataExportCellFor(moduleVars, "tbi_week_sleep", null),//
				createDataExportCellFor(moduleVars, "tbi_week_none", null),//
				createDataExportCellFor(moduleVars, "tbi_q4_score", null),//
				createDataExportCellFor(moduleVars, "tbi_consult", null),//
				createDataExportCellFor(moduleVars, "tbi_score1", null),//
				createDataExportCellFor(moduleVars, "tbi_score2", null),//
				createDataExportCellFor(moduleVars, "TBI_consult_where", null),//
				createDataExportCellFor(moduleVars, "TBI_consult_when", null),//
				createDataExportCellFor(moduleVars, "TBI_consult_how", null));
	}

}
