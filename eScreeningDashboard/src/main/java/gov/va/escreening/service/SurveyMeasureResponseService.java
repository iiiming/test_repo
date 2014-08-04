package gov.va.escreening.service;

import gov.va.escreening.entity.SurveyMeasureResponse;

import java.util.Hashtable;
import java.util.List;

public interface SurveyMeasureResponseService {

    /**
     * Retrieves any responses from the veteran for a survey measure.
     * @param veteranAssessmentId
     * @return
     */
    Hashtable<Integer, List<SurveyMeasureResponse>> findForVeteranAssessmentId(int veteranAssessmentId);

}