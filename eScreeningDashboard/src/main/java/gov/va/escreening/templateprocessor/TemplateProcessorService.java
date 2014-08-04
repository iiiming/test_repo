package gov.va.escreening.templateprocessor;

import gov.va.escreening.constants.TemplateConstants.ViewType;
import gov.va.escreening.exception.IllegalSystemStateException;
import gov.va.escreening.exception.TemplateProcessorException;

public interface TemplateProcessorService {
	String processTemplate(Integer templateId, Integer assessmentId) throws IllegalSystemStateException;

	/**
	 * Generates the CPRS Note for the given assessment
	 * @param veteranAssessmentId
	 * @param viewType from {@link TemplateTagProcessor}
	 * @return the rendered CPRS Note
     * @throws IllegalSystemStateException if the system is missing a required template or template property. These 
     * errors can be fixed by updating the database.
     * @throws TemplateProcessorException if a bug was found in code (including template code), or a needed resource cannot be found. 
	 * @throws Exception 
	 */
    String generateClinicalNote(Integer veteranAssessmentId, ViewType viewType) throws Exception;
	
	
}
