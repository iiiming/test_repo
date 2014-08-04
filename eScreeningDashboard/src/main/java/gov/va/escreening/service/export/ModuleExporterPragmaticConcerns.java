package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("mePragmaticConcerns")
public class ModuleExporterPragmaticConcerns extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "demo_legal_civil", null),//
				createDataExportCellFor(moduleVars, "demo_legal_child", null),//
				createDataExportCellFor(moduleVars, "demo_legal_tax", null),//
				createDataExportCellFor(moduleVars, "demo_legal_bank", null),//
				createDataExportCellFor(moduleVars, "demo_legal_ticket", null),//
				createDataExportCellFor(moduleVars, "demo_legal_arrest", null),//
				createDataExportCellFor(moduleVars, "demo_legal_restrain", null),//
				createDataExportCellFor(moduleVars, "demo_legal_dui", null),//
				createDataExportCellFor(moduleVars, "demo_legal_prob", null),//
				createDataExportCellFor(moduleVars, "demo_legal_parole", null),//
				createDataExportCellFor(moduleVars, "demo_legal_jag", null),//
				createDataExportCellFor(moduleVars, "demo_legal_cps", null),//
				createDataExportCellFor(moduleVars, "demo_legal_none", null),//
				createDataExportCellFor(moduleVars, "demo_legal_other", null),//
				createDataExportCellFor(moduleVars, "demo_legal_otherspec", null));
	}

}
