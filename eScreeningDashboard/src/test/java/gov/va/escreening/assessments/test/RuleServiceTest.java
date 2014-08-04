package gov.va.escreening.assessments.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import gov.va.escreening.delegate.AssessmentDelegate;
import gov.va.escreening.delegate.CreateAssessmentDelegate;
import gov.va.escreening.entity.AssessmentStatus;
import gov.va.escreening.entity.Battery;
import gov.va.escreening.entity.Clinic;
import gov.va.escreening.entity.Measure;
import gov.va.escreening.entity.MeasureAnswer;
import gov.va.escreening.entity.Rule;
import gov.va.escreening.entity.Survey;
import gov.va.escreening.entity.SurveyMeasureResponse;
import gov.va.escreening.entity.User;
import gov.va.escreening.entity.Veteran;
import gov.va.escreening.entity.VeteranAssessment;
import gov.va.escreening.repository.RuleRepository;
import gov.va.escreening.repository.VeteranAssessmentRepository;
import gov.va.escreening.service.RuleService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@Transactional //this is to ensure all tests do not leave trace, so they are repeatable.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class RuleServiceTest {
    
    private static final int OOO_BATTERY_ID = 5;
    private static final int TEST_USER_ID = 5;
    private static final int TEST_VET_ID = 18;

    @Resource
    private AssessmentDelegate assessmentDelegate;
    
    @Resource
    RuleService ruleService;
    
    @Resource
    VeteranAssessmentRepository vetAssessmentRepo;
    
    @Resource
    RuleRepository ruleRepo;
    
    @Resource
    CreateAssessmentDelegate createAsses;
   
    
    @Test
    public void testSetup() {
        assertNotNull(assessmentDelegate);
        assertNotNull(vetAssessmentRepo);
    }
    
    @Test
    public void testRuleRepository()
    {
        List<Rule> rules = ruleRepo.getRuleForAssessment(1);
        assertNotNull(rules);
    }
    
    @Test
    @Transactional
    public void testRule103()
    {
        int ruleId = 103;
        
        VeteranAssessment assessment = createTestAssessment();
        assertNotNull(assessment);
        
        
        Rule r = ruleRepo.findOne(103);
        
        assertFalse(ruleService.evaluate(assessment.getVeteranAssessmentId(), r));
        
        SurveyMeasureResponse res = createResponse(240, 2401, true, assessment.getVeteranAssessmentId(), 22);
        assessment.setSurveyMeasureResponseList(new ArrayList<SurveyMeasureResponse>());
        assessment.getSurveyMeasureResponseList().add(res);
        
        res = createResponse(9, 81, true, assessment.getVeteranAssessmentId(), 22);
        assessment.getSurveyMeasureResponseList().add(res);
        
        res = createResponse(241, 2411, true, assessment.getVeteranAssessmentId(), 22);
        assessment.getSurveyMeasureResponseList().add(res);
        
        res = createResponse(10, 93, true, assessment.getVeteranAssessmentId(), 22);
        assessment.getSurveyMeasureResponseList().add(res);
        
        res = createResponse(241, 2412, true, assessment.getVeteranAssessmentId(), 22);
        assessment.getSurveyMeasureResponseList().add(res);
        
        res = createResponse(240, 2402, false, assessment.getVeteranAssessmentId(), 22);
        assessment.getSurveyMeasureResponseList().add(res);
        
        res = createResponse(240, 2404, false, assessment.getVeteranAssessmentId(), 22);
        res.setTextValue("test_test");
        assessment.getSurveyMeasureResponseList().add(res);
        
        res = createResponse(241, 2413, false, assessment.getVeteranAssessmentId(), 22);
        assessment.getSurveyMeasureResponseList().add(res);
        
        res = createResponse(241, 2414, false, assessment.getVeteranAssessmentId(), 22);
        assessment.getSurveyMeasureResponseList().add(res);
        
        res = createResponse(241, 2415, false, assessment.getVeteranAssessmentId(), 22);
        assessment.getSurveyMeasureResponseList().add(res);
        
        
        
        vetAssessmentRepo.update(assessment);
        
        assertTrue(ruleService.evaluate(assessment.getVeteranAssessmentId(), r));
    }
    
    private SurveyMeasureResponse createResponse(int measureId, int measureAnswerId, boolean value, 
            int assessmentId, int surveyId)
    {
        SurveyMeasureResponse res = new SurveyMeasureResponse();
        res.setBooleanValue(value);
        res.setMeasure(new Measure(measureId));
        res.setMeasureAnswer(new MeasureAnswer(measureAnswerId));
        res.setVeteranAssessment(new VeteranAssessment(assessmentId));
        res.setSurvey(new Survey(surveyId));
        return res;
    }

    @Test
    @Transactional
    public void testRule105()
    {   
        VeteranAssessment assessment = createTestAssessment();
        assertNotNull(assessment);
         
        Rule r = ruleRepo.findOne(105);
        
        assertFalse(ruleService.evaluate(assessment.getVeteranAssessmentId(), r));
        
        SurveyMeasureResponse res = createResponse(542, 5421, true, assessment.getVeteranAssessmentId(), 22);
        assessment.setSurveyMeasureResponseList(new ArrayList<SurveyMeasureResponse>());
        assessment.getSurveyMeasureResponseList().add(res);
        
        res = createResponse(543, 5431, true, assessment.getVeteranAssessmentId(), 22);
        assessment.getSurveyMeasureResponseList().add(res);
        
        res = createResponse(544, 5441, true, assessment.getVeteranAssessmentId(), 22);
        assessment.getSurveyMeasureResponseList().add(res);
        
        res = createResponse(545, 5450, true, assessment.getVeteranAssessmentId(), 22);
        assessment.getSurveyMeasureResponseList().add(res);
        
        vetAssessmentRepo.update(assessment);
        
        assertTrue(ruleService.evaluate(assessment.getVeteranAssessmentId(), r));
    }

    private VeteranAssessment createTestAssessment() {
        VeteranAssessment assessment = new VeteranAssessment();
        assessment.setBattery(new Battery(1));
        assessment.setClinic(new Clinic(20)); //Observation
        assessment.setClinician(new User(TEST_USER_ID));
        assessment.setCreatedByUser(new User(TEST_USER_ID));
        assessment.setVeteran(new Veteran(TEST_VET_ID));
        assessment.setDateCreated(Calendar.getInstance().getTime());
        assessment.setAssessmentStatus(new AssessmentStatus(2));
        
        vetAssessmentRepo.create(assessment);
        //vetAssessmentRepo.commit();
        
        assessment = vetAssessmentRepo.findByVeteranId(TEST_VET_ID).get(0);
        return assessment;
    }
}
