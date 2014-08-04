package gov.va.escreening.service.export;

import gov.va.escreening.domain.ExportDataDefaultValuesEnum;
import gov.va.escreening.dto.dashboard.DataExportCell;
import gov.va.escreening.entity.VeteranAssessment;
import gov.va.escreening.util.ModuleVarsHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ModuleExporterAbstract implements ModuleDataExporter {
	protected final Logger logger = LoggerFactory.getLogger(ModuleExporterAbstract.class);
	protected static final DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	private static final String MISSING_DEFAULT = String.valueOf(ExportDataDefaultValuesEnum.MISSINGVALUE.getDefaultValueNum());

	@Resource(name = "moduleVarsHelper")
	protected ModuleVarsHelper moduleVarsHelper;

	protected String miss() {
		return MISSING_DEFAULT;
	}

	protected String getOrMiss(String data) {
		return (data != null && !data.isEmpty()) ? data : miss();
	}

	protected String getStrFromInt(Integer intData) {
		return intData == null ? miss() : intData.toString();
	}

	@Override
	public List<DataExportCell> apply(ModuleEnum moduleEnum,
			VeteranAssessment assessment) {
		if (logger.isDebugEnabled()) {
			logger.debug(String.format("Enter:%s--%s--%s--%s", moduleEnum.getCategory(), moduleEnum.name(), moduleEnum.getModuleName(), moduleEnum.getDescription()));
		}

		Map<String, String> moduleVars = moduleVarsHelper.prepareModuleVars(moduleEnum.getModuleName(), assessment);

		return applyNow(moduleEnum.getModuleName(), moduleVars, assessment);
	}

	protected DataExportCell createDataExportCellFor(
			Map<String, String> moduleVars, String tbiXportKeyName,
			CellValueExtractor cellValueExtractor) {
		
		return new DataExportCell(tbiXportKeyName, getOrMiss(moduleVars == null ? null : cellValueExtractor == null ? moduleVars.get(tbiXportKeyName) : cellValueExtractor.apply(tbiXportKeyName, moduleVars)));
	}

	protected abstract List<DataExportCell> applyNow(String moduleName,	Map<String, String> moduleVars, VeteranAssessment assessment);

}
