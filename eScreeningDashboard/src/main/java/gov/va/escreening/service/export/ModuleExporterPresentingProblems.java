package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("mePresentingProblems")
public class ModuleExporterPresentingProblems extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	public List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "demo_va_enroll", null),//
				createDataExportCellFor(moduleVars, "demo_va_physhealth", null),//
				createDataExportCellFor(moduleVars, "demo_va_menthealth", null),//
				createDataExportCellFor(moduleVars, "demo_va_primcare", null),//
				createDataExportCellFor(moduleVars, "demo_va_other", null),//
				createDataExportCellFor(moduleVars, "demo_va_otherspec", null),//
				createDataExportCellFor(moduleVars, "demo_info_prost", null),//
				createDataExportCellFor(moduleVars, "demo_info_sex", null),//
				createDataExportCellFor(moduleVars, "demo_info_ment", null),//
				createDataExportCellFor(moduleVars, "demo_info_subst", null),//
				createDataExportCellFor(moduleVars, "demo_info_visual", null),//
				createDataExportCellFor(moduleVars, "demo_info_health_none", null),//
				createDataExportCellFor(moduleVars, "demo_info_comp", null),//
				createDataExportCellFor(moduleVars, "demo_info_gi", null),//
				createDataExportCellFor(moduleVars, "demo_info_loan", null),//
				createDataExportCellFor(moduleVars, "demo_info_ben_none", null),//
				createDataExportCellFor(moduleVars, "demo_info_rehab", null),//
				createDataExportCellFor(moduleVars, "demo_info_unemp", null),//
				createDataExportCellFor(moduleVars, "demo_info_work", null),//
				createDataExportCellFor(moduleVars, "demo_info_emp_none", null),//
				createDataExportCellFor(moduleVars, "demo_info_comm", null),//
				createDataExportCellFor(moduleVars, "demo_info_fin_none", null),//
				createDataExportCellFor(moduleVars, "demo_info_adj", null),//
				createDataExportCellFor(moduleVars, "demo_info_relat", null),//
				createDataExportCellFor(moduleVars, "demo_info_support", null),//
				createDataExportCellFor(moduleVars, "demo_info_soc_none", null),//
				createDataExportCellFor(moduleVars, "demo_info_parole", null),//
				createDataExportCellFor(moduleVars, "demo_info_probat", null),//
				createDataExportCellFor(moduleVars, "demo_info_warrant", null),//
				createDataExportCellFor(moduleVars, "demo_info_bank", null),//
				createDataExportCellFor(moduleVars, "demo_info_legal_none", null),//
				createDataExportCellFor(moduleVars, "demo_info_home", null),//
				createDataExportCellFor(moduleVars, "demo_info_forcl", null),//
				createDataExportCellFor(moduleVars, "demo_info_house_none", null),//
				createDataExportCellFor(moduleVars, "demo_info_other", null),//
				createDataExportCellFor(moduleVars, "demo_info_otherspec", null));
	}
}
