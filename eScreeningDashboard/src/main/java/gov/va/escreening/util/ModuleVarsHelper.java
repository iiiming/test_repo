package gov.va.escreening.util;

import gov.va.escreening.entity.MeasureAnswer;
import gov.va.escreening.entity.Survey;
import gov.va.escreening.entity.SurveyMeasureResponse;
import gov.va.escreening.entity.VeteranAssessment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("moduleVarsHelper")
public class ModuleVarsHelper {

	public Map<String, String> prepareModuleVars(
			List<SurveyMeasureResponse> smrLst) {
		Map<String, String> varsMap = new HashMap<String, String>();

		for (SurveyMeasureResponse smr : smrLst) {
			MeasureAnswer ma = smr.getMeasureAnswer();

			String xportName = ma.getExportName();
			String textValue = smr.getTextValue();
			Boolean boolValue = smr.getBooleanValue();
			
			if(textValue==null && boolValue==null){
				continue;
			}
			varsMap.put(xportName, textValue == null ? (boolValue ? "1" : "0") : textValue);
		}

		return varsMap;
	}

	public Survey getBtbisSurvey(VeteranAssessment veteranAssessment) {
		for (Survey survey : veteranAssessment.getSurveys()) {
			if ("BTBIS".equals(survey.getName())) {
				for (SurveyMeasureResponse smr : survey.getSurveyMeasureResponseList()) {
					MeasureAnswer ma = smr.getMeasureAnswer();
					if ("tbi_consult".equals(ma.getExportName()) && "Yes, place a consult".equals(ma.getAnswerText()) && smr.getBooleanValue()) {
						return survey;
					}
				}
			}
		}
		return null;
	}

	public Map<String, String> prepareModuleVars(String moduleName,
			VeteranAssessment assessment) {
		for (Survey survey : assessment.getSurveys()) {
			if (moduleName.equals(survey.getName())) {
				return prepareModuleVars(survey.getSurveyMeasureResponseList());
			}
		}
		return null;
	}
}
