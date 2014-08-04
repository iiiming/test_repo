package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("meDepression")
public class ModuleExporterPhq9 extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "dep1_interest", null),//
				createDataExportCellFor(moduleVars, "dep2_down", null),//
				createDataExportCellFor(moduleVars, "dep3_sleep", null),//
				createDataExportCellFor(moduleVars, "dep4_tired", null),//
				createDataExportCellFor(moduleVars, "dep5_appetite", null),//
				createDataExportCellFor(moduleVars, "dep6_feelbad", null),//
				createDataExportCellFor(moduleVars, "dep7_concentrate", null),//
				createDataExportCellFor(moduleVars, "dep8_moveslow", null),//
				createDataExportCellFor(moduleVars, "dep9_dead", null),//
				createDataExportCellFor(moduleVars, "dep10_difficult", null),//
				createDataExportCellFor(moduleVars, "dep_score_phq9", null));
	}

}
