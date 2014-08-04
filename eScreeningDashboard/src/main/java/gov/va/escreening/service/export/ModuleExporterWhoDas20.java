package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("meWHODAS20")
public class ModuleExporterWhoDas20 extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,
			Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "whodas1_1_concentrate", null),//
				createDataExportCellFor(moduleVars, "whodas1_2_remember", null),//
				createDataExportCellFor(moduleVars, "whodas1_3_solution", null),//
				createDataExportCellFor(moduleVars, "whodas1_4_new", null),//
				createDataExportCellFor(moduleVars, "whodas1_5_understand", null),//
				createDataExportCellFor(moduleVars, "whodas1_6_conversation", null),//
				createDataExportCellFor(moduleVars, "whodas_understand_score", null),//
				createDataExportCellFor(moduleVars, "whodas_understand_mean", null),//
				createDataExportCellFor(moduleVars, "whodas2_1_stand", null),//
				createDataExportCellFor(moduleVars, "whodas2_2_standup", null),//
				createDataExportCellFor(moduleVars, "whodas2_3_move", null),//
				createDataExportCellFor(moduleVars, "whodas2_4_getout", null),//
				createDataExportCellFor(moduleVars, "whodas2_5_walk", null),//
				createDataExportCellFor(moduleVars, "whodas_mobility_score", null),//
				createDataExportCellFor(moduleVars, "whodas_mobility_mean", null),//
				createDataExportCellFor(moduleVars, "whodas3_1_wash", null),//
				createDataExportCellFor(moduleVars, "whodas3_2_dressed", null),//
				createDataExportCellFor(moduleVars, "whodas3_3_eat", null),//
				createDataExportCellFor(moduleVars, "whodas3_4_stay", null),//
				createDataExportCellFor(moduleVars, "whodas_selfcare_score", null),//
				createDataExportCellFor(moduleVars, "whodas_selfcare_mean", null),//
				createDataExportCellFor(moduleVars, "whodas4_1_deal", null),//
				createDataExportCellFor(moduleVars, "whodas4_2_friend", null),//
				createDataExportCellFor(moduleVars, "whodas4_3_getalong", null),//
				createDataExportCellFor(moduleVars, "whodas4_4_newfriend", null),//
				createDataExportCellFor(moduleVars, "whodas4_5_sexual", null),//
				createDataExportCellFor(moduleVars, "whodas_people_score", null),//
				createDataExportCellFor(moduleVars, "whodas_people_mean", null),//
				createDataExportCellFor(moduleVars, "whodas5_1_housecare", null),//
				createDataExportCellFor(moduleVars, "whoda5_2_housetask", null),//
				createDataExportCellFor(moduleVars, "whodas5_3_housedone", null),//
				createDataExportCellFor(moduleVars, "whodas5_4_housequickly", null),//
				createDataExportCellFor(moduleVars, "whodas_household_score", null),//
				createDataExportCellFor(moduleVars, "whodas_household_mean", null),//
				createDataExportCellFor(moduleVars, "whodas_work", null),//
				createDataExportCellFor(moduleVars, "whodas5_5_daily", null),//
				createDataExportCellFor(moduleVars, "whodas5_6_workwell", null),//
				createDataExportCellFor(moduleVars, "whodas5_7_workdone", null),//
				createDataExportCellFor(moduleVars, "whodas5_8_workquickly", null),//
				createDataExportCellFor(moduleVars, "whodas_work_score", null),//
				createDataExportCellFor(moduleVars, "whodas_work_mean", null),//
				createDataExportCellFor(moduleVars, "whodas6_1_community", null),//
				createDataExportCellFor(moduleVars, "whodas6_2_barriers", null),//
				createDataExportCellFor(moduleVars, "whodas6_3_dignity", null),//
				createDataExportCellFor(moduleVars, "whodas6_4_time", null),//
				createDataExportCellFor(moduleVars, "whodas6_5_emotion", null),//
				createDataExportCellFor(moduleVars, "whodas6_6_finance", null),//
				createDataExportCellFor(moduleVars, "whodas6_7_family", null),//
				createDataExportCellFor(moduleVars, "whodas6_8_relax", null),//
				createDataExportCellFor(moduleVars, "whodas_society_score", null),//
				createDataExportCellFor(moduleVars, "whodas_society_mean", null),//
				createDataExportCellFor(moduleVars, "whodas_h1_daysdiff", null),//
				createDataExportCellFor(moduleVars, "whodas_h2_daysunable", null),//
				createDataExportCellFor(moduleVars, "whodas_h3_daysreduce", null));
	}

}
