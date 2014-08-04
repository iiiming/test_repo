package gov.va.escreening.service;

import gov.va.escreening.entity.SurveyMeasureResponse;
import gov.va.escreening.repository.SurveyMeasureResponseRepository;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class SurveyMeasureResponseServiceImpl implements SurveyMeasureResponseService {

    @Autowired
    private SurveyMeasureResponseRepository surveyMeasureResponseRepository;

    @Transactional(readOnly = true)
    @Override
    public Hashtable<Integer, List<SurveyMeasureResponse>> findForVeteranAssessmentId(int veteranAssessmentId) {

        List<SurveyMeasureResponse> resultList = surveyMeasureResponseRepository
                .findForVeteranAssessmentId(veteranAssessmentId);

        Hashtable<Integer, List<SurveyMeasureResponse>> surveyMeasureResponseMap = new Hashtable<Integer, List<SurveyMeasureResponse>>();

        for (SurveyMeasureResponse surveyMeasureResponse : resultList) {

            if (surveyMeasureResponseMap.containsKey(surveyMeasureResponse.getMeasureAnswer().getMeasureAnswerId())) {
                List<SurveyMeasureResponse> responses = surveyMeasureResponseMap.remove(surveyMeasureResponse
                        .getMeasureAnswer().getMeasureAnswerId());
                responses.add(surveyMeasureResponse);
                surveyMeasureResponseMap.put(surveyMeasureResponse.getMeasureAnswer().getMeasureAnswerId(), responses);
            }
            else {
                List<SurveyMeasureResponse> responses = new ArrayList<SurveyMeasureResponse>();
                responses.add(surveyMeasureResponse);
                surveyMeasureResponseMap.put(surveyMeasureResponse.getMeasureAnswer().getMeasureAnswerId(), responses);
            }
        }
        return surveyMeasureResponseMap;
    }
 }