package gov.va.escreening.entity;

import java.util.Date;

/**
 * Created by pouncilt on 8/2/14.
 */
public interface SurveyBaseProperties {
    Integer getSurveyId();
    void setSurveyId(Integer surveyId);
    String getName();
    void setName(String name);
    String getDescription();
    void setDescription(String description);
    Integer getVersion();
    void setVersion(Integer version);
    Integer getDisplayOrder();
    void setDisplayOrder(Integer displayOrder);
    Boolean isMha();
    void setMha(Boolean mha);
    String getMhaTestName();
    void setMhaTestName(String mhaTestName);
    String getMhaResultGroupIen();
    void setMhaResultGroupIen(String mhaResultGroupIen);
    Date getDateCreated();
    void setDateCreated(Date dateCreated);

}
