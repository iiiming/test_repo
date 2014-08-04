package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("mePromisEmotionalSupport")
public class ModuleExporterPromisEmotionalSupport extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "es1_listen", null),//
				createDataExportCellFor(moduleVars, "es2_talk", null),//
				createDataExportCellFor(moduleVars, "es3_feel", null),//
				createDataExportCellFor(moduleVars, "es4_bad", null),//
				createDataExportCellFor(moduleVars, "es_score_promis", null));
	}

}
