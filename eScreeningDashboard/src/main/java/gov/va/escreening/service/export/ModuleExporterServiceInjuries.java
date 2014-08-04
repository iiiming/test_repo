package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("meServiceInjuries")
public class ModuleExporterServiceInjuries extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,	Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "serv_blast_none", null),//
				createDataExportCellFor(moduleVars, "serv_spine_none", null),//
				createDataExportCellFor(moduleVars, "serv_burn_none", null),//
				createDataExportCellFor(moduleVars, "serv_nerve_none", null),//
				createDataExportCellFor(moduleVars, "serv_vision_none", null),//
				createDataExportCellFor(moduleVars, "serv_hearing_none", null),//
				createDataExportCellFor(moduleVars, "serv_amput_none", null),//
				createDataExportCellFor(moduleVars, "serv_bone_none", null),//
				createDataExportCellFor(moduleVars, "serv_joint_none", null),//
				createDataExportCellFor(moduleVars, "serv_internal_none", null),//
				createDataExportCellFor(moduleVars, "serv_other1_none", null),//
				createDataExportCellFor(moduleVars, "serv_other2_none", null),//
				createDataExportCellFor(moduleVars, "serv_blast_comb", null),//
				createDataExportCellFor(moduleVars, "serv_spine_comb", null),//
				createDataExportCellFor(moduleVars, "serv_burn_comb", null),//
				createDataExportCellFor(moduleVars, "serv_nerve_comb", null),//
				createDataExportCellFor(moduleVars, "serv_vision_comb", null),//
				createDataExportCellFor(moduleVars, "serv_hearing_comb", null),//
				createDataExportCellFor(moduleVars, "serv_amput_comb", null),//
				createDataExportCellFor(moduleVars, "serv_bone_comb", null),//
				createDataExportCellFor(moduleVars, "serv_joint_comb", null),//
				createDataExportCellFor(moduleVars, "serv_internal_comb", null),//
				createDataExportCellFor(moduleVars, "serv_other1_comb", null),//
				createDataExportCellFor(moduleVars, "serv_other2_comb", null),//
				createDataExportCellFor(moduleVars, "serv_blast_other", null),//
				createDataExportCellFor(moduleVars, "serv_spine_other", null),//
				createDataExportCellFor(moduleVars, "serv_burn_other", null),//
				createDataExportCellFor(moduleVars, "serv_nerve_other", null),//
				createDataExportCellFor(moduleVars, "serv_vision_other", null),//
				createDataExportCellFor(moduleVars, "serv_hearing_other", null),//
				createDataExportCellFor(moduleVars, "serv_amput_other", null),//
				createDataExportCellFor(moduleVars, "serv_bone_other", null),//
				createDataExportCellFor(moduleVars, "serv_joint_other", null),//
				createDataExportCellFor(moduleVars, "serv_internal_other", null),//
				createDataExportCellFor(moduleVars, "serv_other1_other", null),//
				createDataExportCellFor(moduleVars, "serv_other2_other", null),//
				createDataExportCellFor(moduleVars, "serv_other1_spec", null),//
				createDataExportCellFor(moduleVars, "serv_other2_spec", null),//
				createDataExportCellFor(moduleVars, "serv_inj_comp", null));
	}

}
