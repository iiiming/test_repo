package gov.va.escreening.delegate;

import gov.va.escreening.domain.BatterySurveyDto;
import gov.va.escreening.dto.editors.BatteryInfo;
import gov.va.escreening.dto.editors.SurveyInfo;
import gov.va.escreening.dto.editors.SurveySectionInfo;

import java.util.List;

public interface EditorsViewDelegate {

    Integer createBattery(BatteryInfo batteryInfo);
    BatteryInfo getBattery(int batteryId);
    List<BatteryInfo> getBatteries();
    void updateBattery(BatteryInfo batteryInfo);
    void deleteBattery(Integer batteryId);
    
    List<SurveyInfo> getSurveys();

    
    Integer createSection(SurveySectionInfo surveySection);
   	SurveySectionInfo getSection(Integer sectionId);
   	List<SurveySectionInfo> getSections();
    SurveySectionInfo updateSection(SurveySectionInfo surveySectionInfo);
   	void deleteSection(Integer surveySectionId);
}
