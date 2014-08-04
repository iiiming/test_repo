package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("meMedications")
public class ModuleExporterMedications extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "med1", null),//
				createDataExportCellFor(moduleVars, "med1_dose", null),//
				createDataExportCellFor(moduleVars, "med1_freq", null),//
				createDataExportCellFor(moduleVars, "med1_dur", null),//
				createDataExportCellFor(moduleVars, "med1_doc", null),//
				createDataExportCellFor(moduleVars, "med2", null),//
				createDataExportCellFor(moduleVars, "med2_dose", null),//
				createDataExportCellFor(moduleVars, "med2_freq", null),//
				createDataExportCellFor(moduleVars, "med2_dur", null),//
				createDataExportCellFor(moduleVars, "med2_doc", null),//
				createDataExportCellFor(moduleVars, "med3", null),//
				createDataExportCellFor(moduleVars, "med3_dose", null),//
				createDataExportCellFor(moduleVars, "med3_freq", null),//
				createDataExportCellFor(moduleVars, "med3_dur", null),//
				createDataExportCellFor(moduleVars, "med3_doc", null),//
				createDataExportCellFor(moduleVars, "med4", null),//
				createDataExportCellFor(moduleVars, "med4_dose", null),//
				createDataExportCellFor(moduleVars, "med4_freq", null),//
				createDataExportCellFor(moduleVars, "med4_dur", null),//
				createDataExportCellFor(moduleVars, "med4_doc", null),//
				createDataExportCellFor(moduleVars, "med5", null),//
				createDataExportCellFor(moduleVars, "med5_dose", null),//
				createDataExportCellFor(moduleVars, "med5_freq", null),//
				createDataExportCellFor(moduleVars, "med5_dur", null),//
				createDataExportCellFor(moduleVars, "med5_doc", null));
	}

}
