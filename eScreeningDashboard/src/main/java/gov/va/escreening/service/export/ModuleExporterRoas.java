package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("meAggression")
public class ModuleExporterRoas extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "ang1_noise", null),//
				createDataExportCellFor(moduleVars, "ang2_yell", null),//
				createDataExportCellFor(moduleVars, "ang3_curse", null),//
				createDataExportCellFor(moduleVars, "ang4_threat", null),//
				createDataExportCellFor(moduleVars, "ang5_slamdoor", null),//
				createDataExportCellFor(moduleVars, "ang6_throw", null),//
				createDataExportCellFor(moduleVars, "ang7_break", null),//
				createDataExportCellFor(moduleVars, "ang8_setfire", null),//
				createDataExportCellFor(moduleVars, "ang9_gesture", null),//
				createDataExportCellFor(moduleVars, "ang10_strike", null),//
				createDataExportCellFor(moduleVars, "ang11_injury", null),//
				createDataExportCellFor(moduleVars, "ang12_severeinjury", null),//
				createDataExportCellFor(moduleVars, "ang13_pick", null),//
				createDataExportCellFor(moduleVars, "ang14_banghead", null),//
				createDataExportCellFor(moduleVars, "ang15_cut", null),//
				createDataExportCellFor(moduleVars, "ang16_hurt", null),//
				createDataExportCellFor(moduleVars, "ang_recode_1", null),//
				createDataExportCellFor(moduleVars, "ang_recode_2", null),//
				createDataExportCellFor(moduleVars, "ang_score1", null));
	}

}
