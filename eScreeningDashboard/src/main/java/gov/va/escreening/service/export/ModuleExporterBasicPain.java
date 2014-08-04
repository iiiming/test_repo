package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("meBasicPain")
public class ModuleExporterBasicPain extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,	Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(new DataExportCell("pain_number", miss()),//
				new DataExportCell("pain_area_1", miss()),//
				new DataExportCell("pain_area_2", miss()),//
				new DataExportCell("pain_area_3", miss()),//
				new DataExportCell("pain_area_4", miss()),//
				new DataExportCell("pain_area_5", miss()));
	}

}
