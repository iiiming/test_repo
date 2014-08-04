package gov.va.escreening.service;

import gov.va.escreening.domain.SurveyDto;
import gov.va.escreening.dto.editors.SurveyInfo;
import gov.va.escreening.dto.editors.SurveySectionInfo;
import gov.va.escreening.entity.*;
import gov.va.escreening.repository.SurveyRepository;

import java.util.ArrayList;
import java.util.List;

import gov.va.escreening.repository.SurveySectionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class SurveyServiceImpl implements SurveyService {

	private static final Logger logger = LoggerFactory.getLogger(SurveyServiceImpl.class);

	private SurveyRepository surveyRepository;
	@Autowired
	private SurveySectionRepository surveySectionRepository;

	@Autowired
	public void setSurveyRepository(SurveyRepository surveyRepository) {
		this.surveyRepository = surveyRepository;
	}

	@Transactional(readOnly = true)
	@Override
	public List<SurveyDto> getAssignableSurveys() {
		logger.debug("getAssignableSurveys()");

		List<Survey> surveys = surveyRepository.getAssignableSurveys();

		// create adapter object for view
		List<SurveyDto> surveyDtoList = new ArrayList<SurveyDto>();
		for (Survey survey : surveys) {
			surveyDtoList.add(new SurveyDto(survey));
		}

		return surveyDtoList;
	}

	@Transactional(readOnly = true)
	@Override
	public List<SurveyDto> getRequiredSurveys() {
		logger.debug("getRequiredSurveys()");

		List<Survey> surveys = surveyRepository.getRequiredSurveys();

		List<SurveyDto> surveyDtoList = new ArrayList<SurveyDto>();
		for (Survey survey : surveys) {
			surveyDtoList.add(new SurveyDto(survey));
		}

		return surveyDtoList;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Survey> findForVeteranAssessmentId(int veteranAssessmentId) {

		List<Survey> surveyList = surveyRepository.findForVeteranAssessmentId(veteranAssessmentId);

		// We need to iterate through the collections until we can get eager fetch working using JQL or find a
		// workaround for it.
		if (surveyList != null) {
			for (Survey survey : surveyList) {
				// logger.debug(survey.getName());

				List<SurveyPage> spLst = survey.getSurveyPageList();
				if (spLst != null) {
					for (SurveyPage surveyPage : spLst) {
						// logger.debug(surveyPage.getTitle());

						List<Measure> mLst = surveyPage != null ? surveyPage.getMeasures() : null;
						if (mLst != null) {
							for (Measure measure : mLst) {
								// logger.debug(measure.getMeasureText());

								List<MeasureAnswer> maLst = measure != null ? measure.getMeasureAnswerList() : null;
								if (maLst != null) {
									for (MeasureAnswer measureAnswer : maLst) {
										// logger.debug(measureAnswer.getAnswerText());
									}
								}
							}
						}
					}
				}
			}
		}

		return surveyList;
	}

	@Transactional(readOnly = true)
	@Override
	public List<SurveyDto> getSurveyListForVeteranAssessment(
			int veteranAssessmentId) {
		logger.debug("getVeteranAssessmentSurveys()");

		List<Survey> surveys = surveyRepository.findForVeteranAssessmentId(veteranAssessmentId);

		List<SurveyDto> surveyDtoList = new ArrayList<SurveyDto>();
		for (Survey survey : surveys) {
			surveyDtoList.add(new SurveyDto(survey));
		}

		return surveyDtoList;
	}

	@Transactional(readOnly = true)
	@Override
	public List<SurveyDto> getSurveyList() {
		logger.debug("getSurveyList()");

		List<Survey> surveys = surveyRepository.getSurveyList();

		List<SurveyDto> surveyDtoList = new ArrayList<SurveyDto>();
		for (Survey survey : surveys) {
			surveyDtoList.add(new SurveyDto(survey));
		}

		return surveyDtoList;
	}

	@Transactional(readOnly = true)
	@Override
	public List<SurveyInfo> getSurveyItemList() {

		List<SurveyInfo> surveyInfoList = new ArrayList<SurveyInfo>();

		List<Survey> surveys = surveyRepository.getSurveyList();

		for (Survey survey : surveys) {
			surveyInfoList.add(convertToSurveyItem(survey));
		}

		return surveyInfoList;
	}

	@Override
	public SurveyInfo update(SurveyInfo surveyInfo) {
		Survey survey = surveyRepository.findOne(surveyInfo.getSurveyId());
		SurveySection surveySection = surveySectionRepository.findOne(surveyInfo.getSurveySectionInfo().getSurveySectionId());

		survey.setName(surveyInfo.getName());
		survey.setDescription(surveyInfo.getDescription());
		survey.setVersion(surveyInfo.getVersion());
		survey.setDisplayOrder(surveyInfo.getDisplayOrder());
		survey.setMha(surveyInfo.isMha());
		survey.setDateCreated(surveyInfo.getDateCreated());
		survey.setSurveySection(surveySection);

		survey = surveyRepository.update(survey);
		return convertToSurveyItem(survey);
	}

	@Override
	public SurveyInfo convertToSurveyItem(Survey survey) {

		if (survey == null) {
			return null;
		}

		SurveyInfo surveyInfo = new SurveyInfo();

		surveyInfo.setSurveyId(survey.getSurveyId());
		surveyInfo.setName(survey.getName());
		surveyInfo.setDescription(survey.getDescription());
		surveyInfo.setDisplayOrder(survey.getDisplayOrder());
		surveyInfo.setMha(survey.isMha());
		surveyInfo.setMhaResultGroupIen(survey.getMhaResultGroupIen());
		surveyInfo.setMhaTestName(survey.getMhaTestName());
		surveyInfo.setDateCreated(survey.getDateCreated());
		surveyInfo.setVersion(survey.getVersion());

		if (survey.getSurveySection() != null) {
			SurveySectionInfo surveySectionInfo = new SurveySectionInfo();

			surveySectionInfo.setSurveySectionId(survey.getSurveySection().getSurveySectionId());
            surveySectionInfo.setDescription(survey.getSurveySection().getDescription());
			surveySectionInfo.setName(survey.getSurveySection().getName());
			surveySectionInfo.setDisplayOrder(survey.getSurveySection().getDisplayOrder());
            surveySectionInfo.setDateCreated(survey.getSurveySection().getDateCreated());

			surveyInfo.setSurveySectionInfo(surveySectionInfo);
		}

		return surveyInfo;
	}

	@Override
	public Survey findOne(int surveyId) {

		return surveyRepository.findOne(surveyId);
	}

}
