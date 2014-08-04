package gov.va.escreening.dto.ae;

import gov.va.escreening.entity.MeasureAnswer;
import gov.va.escreening.entity.SurveyMeasureResponse;

import java.io.Serializable;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Strings;

public class Answer implements Serializable {
    /* Possible answer types
     * These should all be lower case */
    public enum Type{
        NONE, OTHER, HEIGHT_FEET, HEIGHT_INCHES, TABLE_COLUMN;
        
        public static Type fromString(String name){
            if(name == null)
                return null;
            String lowerName = name.toLowerCase();
            if(lowerName.equals("none"))
                return NONE;
            if(lowerName.equals("other"))
                return OTHER;
            
            if(lowerName.equals("feet"))
                return HEIGHT_FEET;
            
            if(lowerName.equals("inches"))
                return HEIGHT_INCHES;
            
            if(lowerName.equals("tablecolumn"))
                return TABLE_COLUMN;
            
            throw new IllegalArgumentException("Invalid Answer type: " + name);
        }
    }
	
    private static final long serialVersionUID = 1L;

    private Integer answerId;
    private String answerText;
    private String answerType;
    private String answerResponse;
    private String otherAnswerResponse;
    private Integer rowId;

	public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(String type) {
        this.answerType = type;
    }

    public String getAnswerResponse() {
        return answerResponse;
    }

    public void setAnswerResponse(String answerResponse) {
        this.answerResponse = answerResponse;
    }

    public String getOtherAnswerResponse() {
        return otherAnswerResponse;
    }

    public void setOtherAnswerResponse(String otherAnswerResponse) {
        this.otherAnswerResponse = otherAnswerResponse;
    }
    
    public Integer getRowId() {
        return rowId;
    }

    public void setRowId(Integer rowId) {
        this.rowId = rowId;
    }

    public Answer() {}
    
    public Answer(MeasureAnswer measureAnswer, 
            @Nullable SurveyMeasureResponse measureResponse){
       
        answerId = measureAnswer.getMeasureAnswerId();
        answerText = measureAnswer.getAnswerText();
        answerType = measureAnswer.getAnswerType();
        
        //set user response
        if(measureResponse != null){
            rowId = measureResponse.getTabularRow();
            
            if (StringUtils.isNotBlank(measureResponse.getOtherValue())) {
                otherAnswerResponse = measureResponse.getOtherValue();
            }
    
            if (measureResponse.getNumberValue() != null) {                   
                answerResponse = measureResponse.getNumberValue().toString();
            }
            else if (measureResponse.getBooleanValue() != null) {
                answerResponse = measureResponse.getBooleanValue().toString();
            }
            else if (!Strings.isNullOrEmpty(measureResponse.getTextValue())) {
                answerResponse = measureResponse.getTextValue();
            }
        }
    }

    public Answer(Integer answerId, String answerText, String answerResponse) {
        this.answerId = answerId;
        this.answerText = answerText;
        this.answerResponse = answerResponse;
    }

    @Override
    public String toString() {
        return "Answer [answerId=" + answerId + ", answerText=" + answerText + ", hasOther=" + answerType
                + ", answerResponse=" + answerResponse + ", otherAnswerResponse=" + otherAnswerResponse + ", rowId:" + rowId + "]";
    }

}
