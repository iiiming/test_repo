package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("meEduEmplIncome")
public class ModuleExporterEduEmplIncome extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	public List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "demo_income_gi", null),//
				createDataExportCellFor(moduleVars, "demo_income_retire", null),//
				createDataExportCellFor(moduleVars, "demo_income_other", null),//
				createDataExportCellFor(moduleVars, "demo_income_spec", null),//
				createDataExportCellFor(moduleVars, "demo_income_group", null),//
				createDataExportCellFor(moduleVars, "demo_relationship", null));
	}

}
