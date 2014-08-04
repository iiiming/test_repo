package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("meMilitaryHistory")
public class ModuleExporterMilitaryHistory extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "serv_discipline_none", null),//
				createDataExportCellFor(moduleVars, "serv_discipline_couns", null),//
				createDataExportCellFor(moduleVars, "serv_discipline_art15", null),//
				createDataExportCellFor(moduleVars, "serv_discipline_martial", null),//
				createDataExportCellFor(moduleVars, "serv_discipline_other", null),//
				createDataExportCellFor(moduleVars, "serv_discipline_otherspec", null),//
				createDataExportCellFor(moduleVars, "serv_award_none", null),//
				createDataExportCellFor(moduleVars, "serv_award_honor", null),//
				createDataExportCellFor(moduleVars, "serv_award_distservcross", null),//
				createDataExportCellFor(moduleVars, "serv_award_distservmedal", null),//
				createDataExportCellFor(moduleVars, "serv_award_meritservmedal", null),//
				createDataExportCellFor(moduleVars, "serv_award_legionmerit", null),//
				createDataExportCellFor(moduleVars, "serv_distflycross", null),//
				createDataExportCellFor(moduleVars, "serv_award_bronzstar", null),//
				createDataExportCellFor(moduleVars, "serv_award_purpheart", null),//
				createDataExportCellFor(moduleVars, "serv_award_airmedal", null),//
				createDataExportCellFor(moduleVars, "serv_award_silvstar", null),//
				createDataExportCellFor(moduleVars, "serv_award_soldiermedal", null),//
				createDataExportCellFor(moduleVars, "serv_award_achievmedal", null),//
				createDataExportCellFor(moduleVars, "serv_award_commedal", null),//
				createDataExportCellFor(moduleVars, "serv_award_other", null),//
				createDataExportCellFor(moduleVars, "serv_award_otherspec", null),//
				createDataExportCellFor(moduleVars, "serv_deployno", null),//
				createDataExportCellFor(moduleVars, "serv_deploy_loc_1", null),//
				createDataExportCellFor(moduleVars, "serv_deploy_1_from_mo", null),//
				createDataExportCellFor(moduleVars, "serv_deploy_1_from_yr", null),//
				createDataExportCellFor(moduleVars, "serv_deploy_1_to_mo", null),//
				createDataExportCellFor(moduleVars, "serv_deploy_1_to_yr", null),//
				createDataExportCellFor(moduleVars, "serv_deploy_loc_2", null),//
				createDataExportCellFor(moduleVars, "serv_deploy_2_from_mo", null),//
				createDataExportCellFor(moduleVars, "serv_deploy_2_from_yr", null),//
				createDataExportCellFor(moduleVars, "serv_deploy_2_to_mo", null),//
				createDataExportCellFor(moduleVars, "serv_deploy_2_to_yr", null),//
				createDataExportCellFor(moduleVars, "serv_deploy_loc_3", null),//
				createDataExportCellFor(moduleVars, "serv_deploy_3_from_mo", null),//
				createDataExportCellFor(moduleVars, "serv_deploy_3_from_mo", null),//
				createDataExportCellFor(moduleVars, "serv_deploy_3_to_mo", null),//
				createDataExportCellFor(moduleVars, "serv_deploy_3_to_yr", null),//
				createDataExportCellFor(moduleVars, "serv_deploy_loc_4", null),//
				createDataExportCellFor(moduleVars, "serv_deploy_4_from_mo", null),//
				createDataExportCellFor(moduleVars, "serv_deploy_4_from_yr", null),//
				createDataExportCellFor(moduleVars, "serv_deploy_4_to_mo", null),//
				createDataExportCellFor(moduleVars, "serv_deploy_4_to_yr", null),//
				createDataExportCellFor(moduleVars, "serv_deploy_loc_5", null),//
				createDataExportCellFor(moduleVars, "serv_deploy_5_from_mo", null),//
				createDataExportCellFor(moduleVars, "serv_deploy_5_from_yr", null),//
				createDataExportCellFor(moduleVars, "serv_deploy_5_to_mo", null),//
				createDataExportCellFor(moduleVars, "serv_deploy_5_to_yr", null));
	}

}
