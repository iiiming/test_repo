package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("meExposures")
public class ModuleExporterExposures extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "serv_exposed", null),//
				createDataExportCellFor(moduleVars, "serv_exp_chemical", null),//
				createDataExportCellFor(moduleVars, "serv_exp_bio", null),//
				createDataExportCellFor(moduleVars, "serv_exp_jp8", null),//
				createDataExportCellFor(moduleVars, "serv_exp_asbestos", null),//
				createDataExportCellFor(moduleVars, "serv_exp_nerve", null),//
				createDataExportCellFor(moduleVars, "serv_exp_radio", null),//
				createDataExportCellFor(moduleVars, "serv_exp_sand", null),//
				createDataExportCellFor(moduleVars, "serv_exp_uranium", null),//
				createDataExportCellFor(moduleVars, "serv_exp_industrial", null),//
				createDataExportCellFor(moduleVars, "serv_exp_fumes", null),//
				createDataExportCellFor(moduleVars, "serv_exp_paint", null),//
				createDataExportCellFor(moduleVars, "serv_exp_bite", null),//
				createDataExportCellFor(moduleVars, "serv_exp_burn", null),//
				createDataExportCellFor(moduleVars, "serv_exp_pest", null),//
				createDataExportCellFor(moduleVars, "serv_exp_other", null),//
				createDataExportCellFor(moduleVars, "serv_exp_oth1spec", null),//
				createDataExportCellFor(moduleVars, "serv_exp_oth2spec", null),//
				createDataExportCellFor(moduleVars, "serv_animal_bite", null),//
				createDataExportCellFor(moduleVars, "serv_animal_blood", null),//
				createDataExportCellFor(moduleVars, "serv_animal_bat", null),//
				createDataExportCellFor(moduleVars, "serv_combat", null),//
				createDataExportCellFor(moduleVars, "serv_comb_none", null),//
				createDataExportCellFor(moduleVars, "serv_comb_attack", null),//
				createDataExportCellFor(moduleVars, "serv_comb_fire", null),//
				createDataExportCellFor(moduleVars, "serv_comb_hand", null),//
				createDataExportCellFor(moduleVars, "serv_comb_wounded", null),//
				createDataExportCellFor(moduleVars, "serv_comb_interro", null),//
				createDataExportCellFor(moduleVars, "serv_comb_rocket", null),//
				createDataExportCellFor(moduleVars, "serv_comb_seebody", null),//
				createDataExportCellFor(moduleVars, "serv_comb_clear", null),//
				createDataExportCellFor(moduleVars, "serv_comb_ship", null),//
				createDataExportCellFor(moduleVars, "serv_comb_detain", null),//
				createDataExportCellFor(moduleVars, "serv_comb_recdfire", null),//
				createDataExportCellFor(moduleVars, "serv_comb_handbody", null),//
				createDataExportCellFor(moduleVars, "serv_comb_killed", null),//
				createDataExportCellFor(moduleVars, "serv_comb_enemy", null));
	}

}
