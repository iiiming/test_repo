package gov.va.escreening.service.export;

import gov.va.escreening.dto.dashboard.AssessmentDataExport;
import gov.va.escreening.form.ExportDataFormBean;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public interface ExportDataService {
	
	//AssessmentDataExport getDataExportTest();
	
	AssessmentDataExport getAssessmentDataExport(ExportDataFormBean exportDataFormBean);
	
	void saveDataExport(HSSFWorkbook workbook, AssessmentDataExport dataExport) throws Exception;
}