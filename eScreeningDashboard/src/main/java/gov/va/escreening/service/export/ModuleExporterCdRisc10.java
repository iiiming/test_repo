package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("meResilience")
public class ModuleExporterCdRisc10 extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "res1_adapt", null),//
				createDataExportCellFor(moduleVars, "res2_deal", null),//
				createDataExportCellFor(moduleVars, "res3_humor", null),//
				createDataExportCellFor(moduleVars, "res4_cope", null),//
				createDataExportCellFor(moduleVars, "res5_bounce", null),//
				createDataExportCellFor(moduleVars, "res6_goals", null),//
				createDataExportCellFor(moduleVars, "res7_pressure", null),//
				createDataExportCellFor(moduleVars, "res8_discouraged", null),//
				createDataExportCellFor(moduleVars, "res9_strong", null),//
				createDataExportCellFor(moduleVars, "res10_unpleasant", null),//
				createDataExportCellFor(moduleVars, "res_score", null));
	}

}
