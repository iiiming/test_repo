package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("meHomelessnessReminder")
public class ModuleExporterHomelessnessReminder extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "HomelessCR_stable_house", null),//
				createDataExportCellFor(moduleVars, "HomelessCR_stable_worry", null),//
				createDataExportCellFor(moduleVars, "HomelessCR_live_2mos", null),//
				createDataExportCellFor(moduleVars, "HomelessCR_homenogov_spec", null),//
				createDataExportCellFor(moduleVars, "HomelessCR_homewgov_spec", null),//
				createDataExportCellFor(moduleVars, "HomelessCR_friendfam_spec", null),//
				createDataExportCellFor(moduleVars, "HomelessCR_hotel_spec", null),//
				createDataExportCellFor(moduleVars, "HomelessCR_shortins_spec", null),//
				createDataExportCellFor(moduleVars, "HomelessCR_shel_spec", null),//
				createDataExportCellFor(moduleVars, "HomelessCR_out_spec", null),//
				createDataExportCellFor(moduleVars, "HomelessCR_oth_spec", null),//
				createDataExportCellFor(moduleVars, "HomelessCR_house_ref", null),//
				createDataExportCellFor(moduleVars, "HomelessCR_howreach", null));
	}

}
