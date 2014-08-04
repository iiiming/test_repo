package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("meSocialEnvironment")
public class ModuleExporterSocialEnvironment extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	public List<DataExportCell> applyNow(String moduleName,	Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "demo_children", null),//
				createDataExportCellFor(moduleVars, "child_agegroup1", null),//
				createDataExportCellFor(moduleVars, "child_agegroup2", null),//
				createDataExportCellFor(moduleVars, "child_agegroup3", null),//
				createDataExportCellFor(moduleVars, "child_agegroup4", null),//
				createDataExportCellFor(moduleVars, "child_agegroup5", null),//
				createDataExportCellFor(moduleVars, "child_agegroup6", null),//
				createDataExportCellFor(moduleVars, "child_agegroup7", null),//
				createDataExportCellFor(moduleVars, "child_agegroup8", null),//
				createDataExportCellFor(moduleVars, "child_agegroup9", null),//
				createDataExportCellFor(moduleVars, "child_agegroup10", null),//
				createDataExportCellFor(moduleVars, "demo_livewith_parent", null),//
				createDataExportCellFor(moduleVars, "demo_livewith_alone", null),//
				createDataExportCellFor(moduleVars, "demo_livewith_friend", null),//
				createDataExportCellFor(moduleVars, "demo_livewith_spouse", null),//
				createDataExportCellFor(moduleVars, "demo_livewith_child", null),//
				createDataExportCellFor(moduleVars, "demo_livewith_other", null),//
				createDataExportCellFor(moduleVars, "demo_livewith_otherspec", null),//
				createDataExportCellFor(moduleVars, "demo_emo_parents", null),//
				createDataExportCellFor(moduleVars, "demo_emo_friends", null),//
				createDataExportCellFor(moduleVars, "demo_emo_spouse", null),//
				createDataExportCellFor(moduleVars, "demo_emo_therapist", null),//
				createDataExportCellFor(moduleVars, "demo_emo_spiritual", null),//
				createDataExportCellFor(moduleVars, "demo_emo_children", null),//
				createDataExportCellFor(moduleVars, "demo_emo_other", null),//
				createDataExportCellFor(moduleVars, "demo_emo_other_spec", null),//
				createDataExportCellFor(moduleVars, "demo_emo_none", null),//
				createDataExportCellFor(moduleVars, "demo_rel_hurt", null));
	}

}
