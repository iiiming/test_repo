package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("meOefOifReminder")
public class ModuleExporterOefOifReminder extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "serv_oef_oif", null),//
				createDataExportCellFor(moduleVars, "serv_oef_loc", null),//
				createDataExportCellFor(moduleVars, "serv_oef_otherspec", null),//
				createDataExportCellFor(moduleVars, "serv_oif_loc", null),//
				createDataExportCellFor(moduleVars, "serv_oif_otherspec", null));
	}

}
