package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("meSpiritualHealth")
public class ModuleExporterSpiritualHealth extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,	Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "spirit_rel_important", null),//
				createDataExportCellFor(moduleVars, "spirit_combat_change", null),//
				createDataExportCellFor(moduleVars, "spirit_faith_comm", null),//
				createDataExportCellFor(moduleVars, "spirit_chap_referral", null));
	}

}
