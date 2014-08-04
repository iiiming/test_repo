package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("meServiceHistory")
public class ModuleExporterServiceHistory extends ModuleExporterAbstract implements ModuleDataExporter {

	@Override
	protected List<DataExportCell> applyNow(String moduleName,	Map<String, String> moduleVars, VeteranAssessment assessment) {
		return Arrays.asList(createDataExportCellFor(moduleVars, "serv_type1", null),//
				createDataExportCellFor(moduleVars, "serv_branch1", null),//
				createDataExportCellFor(moduleVars, "serv_start1", null),//
				createDataExportCellFor(moduleVars, "serv_stop1", null),//
				createDataExportCellFor(moduleVars, "serv_discharge1", null),//
				createDataExportCellFor(moduleVars, "serv_rank1", null),//
				createDataExportCellFor(moduleVars, "serv_job1", null),//
				createDataExportCellFor(moduleVars, "serv_type2", null),//
				createDataExportCellFor(moduleVars, "serv_branch2", null),//
				createDataExportCellFor(moduleVars, "serv_start2", null),//
				createDataExportCellFor(moduleVars, "serv_stop2", null),//
				createDataExportCellFor(moduleVars, "serv_discharge2", null),//
				createDataExportCellFor(moduleVars, "serv_rank2", null),//
				createDataExportCellFor(moduleVars, "serv_job2", null),//
				createDataExportCellFor(moduleVars, "serv_type3", null),//
				createDataExportCellFor(moduleVars, "serv_branch3", null),//
				createDataExportCellFor(moduleVars, "serv_start3", null),//
				createDataExportCellFor(moduleVars, "serv_stop3", null),//
				createDataExportCellFor(moduleVars, "serv_discharge3", null),//
				createDataExportCellFor(moduleVars, "serv_rank3", null),//
				createDataExportCellFor(moduleVars, "serv_job3", null),//
				createDataExportCellFor(moduleVars, "serv_oper_none", null),//
				createDataExportCellFor(moduleVars, "serv_oper_OEF", null),//
				createDataExportCellFor(moduleVars, "serv_oper_OIF", null),//
				createDataExportCellFor(moduleVars, "serv_oper_gwot", null),//
				createDataExportCellFor(moduleVars, "serv_oper_ond", null),//
				createDataExportCellFor(moduleVars, "serv_oper_caribbean", null),//
				createDataExportCellFor(moduleVars, "serv_oper_gulf", null),//
				createDataExportCellFor(moduleVars, "serv_oper_somalia", null),//
				createDataExportCellFor(moduleVars, "serv_oper_bosnia", null),//
				createDataExportCellFor(moduleVars, "serv_oper_kosovo", null),//
				createDataExportCellFor(moduleVars, "serv_oper_djibouti", null),//
				createDataExportCellFor(moduleVars, "serv_oper_libya", null),//
				createDataExportCellFor(moduleVars, "Serv_oper_vietnam", null),//
				createDataExportCellFor(moduleVars, "serv_oper_korea", null),//
				createDataExportCellFor(moduleVars, "serv_oper_other", null),//
				createDataExportCellFor(moduleVars, "serv_oper_other1spec", null),//
				createDataExportCellFor(moduleVars, "serv_oper_other2spec", null));
	}

}
