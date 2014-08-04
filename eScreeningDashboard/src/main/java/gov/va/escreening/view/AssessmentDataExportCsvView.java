package gov.va.escreening.view;

import gov.va.escreening.dto.dashboard.AssessmentDataExport;
import gov.va.escreening.dto.dashboard.DataExportCell;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.AbstractView;

public class AssessmentDataExportCsvView extends AbstractView {

	private static final Logger logger = LoggerFactory.getLogger(AssessmentDataExportCsvView.class);

	private final String defaultErrorMsg = "An error occured while generating the requested export.  Please contact technical support for assistance.";

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		BufferedWriter writer = new BufferedWriter(response.getWriter());
		
		String csvFileName=String.format("va_export_data_as_of_ts_%s.csv", System.nanoTime());
		response.setHeader("Content-Disposition", "attachment; filename=\""+csvFileName+"\"");

		AssessmentDataExport dataExport = (AssessmentDataExport) model.get("dataExportList");

		try {
			setCsvHeader(writer, dataExport.getTableContent());
			setCsvRows(writer, dataExport.getTableContent());
		} finally {
			writer.flush();
			writer.close();
		}
	}

	private void setCsvRows(BufferedWriter writer,
			List<List<DataExportCell>> tableContent) throws IOException {

		for (List<DataExportCell> row : tableContent) {
			for (DataExportCell cell : row) {
				writer.write(cell.getCellValue());
				writer.write(",");
			}
			writer.newLine();
		}
	}

	private void setCsvHeader(BufferedWriter writer,
			List<List<DataExportCell>> tableContent) throws IOException {

		List<DataExportCell> firstRow = tableContent.iterator().next();

		for (DataExportCell header : firstRow) {
			writer.write(header.getColumnName());
			writer.write(",");
		}
		writer.newLine();
	}

}