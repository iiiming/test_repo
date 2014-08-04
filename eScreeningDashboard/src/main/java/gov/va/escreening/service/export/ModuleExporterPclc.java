package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("mePclc")
public class ModuleExporterPclc extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "pcl1_memories", null),//
				createDataExportCellFor(moduleVars, "pcl2_dreams", null),//
				createDataExportCellFor(moduleVars, "pcl3_acting", null),//
				createDataExportCellFor(moduleVars, "pcl4_remind", null),//
				createDataExportCellFor(moduleVars, "pcl5_reaction", null),//
				createDataExportCellFor(moduleVars, "pcl6_think", null),//
				createDataExportCellFor(moduleVars, "pcl7_activity", null),//
				createDataExportCellFor(moduleVars, "pcl8_trouble", null),//
				createDataExportCellFor(moduleVars, "pcl9_interest", null),//
				createDataExportCellFor(moduleVars, "pcl10_distant", null),//
				createDataExportCellFor(moduleVars, "pcl11_emotion", null),//
				createDataExportCellFor(moduleVars, "pcl12_future", null),//
				createDataExportCellFor(moduleVars, "pcl13_asleep", null),//
				createDataExportCellFor(moduleVars, "pcl14_irritable", null),//
				createDataExportCellFor(moduleVars, "pcl15_concentrate", null),//
				createDataExportCellFor(moduleVars, "pcl16_alert", null),//
				createDataExportCellFor(moduleVars, "pcl17_jumpy", null),//
				createDataExportCellFor(moduleVars, "pcl_score", null));
	}

}
