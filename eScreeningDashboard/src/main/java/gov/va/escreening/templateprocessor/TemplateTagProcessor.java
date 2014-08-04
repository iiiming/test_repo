package gov.va.escreening.templateprocessor;

import gov.va.escreening.constants.TemplateConstants.ViewType;

public class TemplateTagProcessor {

    //Tag constants (if this is updated please update ClinicalNoteTemplateFunctions.ftl)
    public static final String BATTERY_HEADER_START = "<BATTERY_HEADER_START>";
    public static final String BATTERY_HEADER_END = "<BATTERY_HEADER_END>";
    
    public static final String BATTERY_FOOTER_START = "<BATTERY_FOOTER_START>";
    public static final String BATTERY_FOOTER_END = "<BATTERY_FOOTER_END>";
    
    public static final String SECTION_TITLE_START = "<SECTION_TITLE_START>";
    public static final String SECTION_TITLE_END = "<SECTION_TITLE_END>";
    
    public static final String SECTION_START = "<SECTION_START>";
    public static final String SECTION_END = "<SECTION_END>";
    
	public static final String MODULE_TITLE_START = "<MODULE_TITLE_START>";
	public static final String MODULE_TITLE_END = "<MODULE_TITLE_END>";
	
	public static final String MODULE_START = "<MODULE_START>";
	public static final String MODULE_END = "<MODULE_END>";
	
	public static final String LINE_BREAK = "<LINE_BREAK>";
	
	
	public static String resolveClinicalNoteTags(String noteText, ViewType viewType) {
		switch(viewType) {
			case HTML:
				noteText = resolveHtmlType(noteText);
				break;
			case TEXT:
				noteText = resolveTextType(noteText);
				break;
			default:
				throw new UnsupportedOperationException(String.format("resolveClinicalNoteTags view type: %s is not supported", viewType));
		}
		return noteText;
	}
	
	private static String resolveHtmlType(String noteText) {
	    noteText = noteText.replace(BATTERY_HEADER_START, "<div class='templateHeader'>");
        noteText = noteText.replace(BATTERY_HEADER_END, "</div>");
        
        noteText = noteText.replace(BATTERY_FOOTER_START, "<div class='templateFooter'>");
        noteText = noteText.replace(BATTERY_FOOTER_END, "</div>");
	    
	    noteText = noteText.replace(SECTION_TITLE_START, "<div class='templateSectionTitle'>");
	    noteText = noteText.replace(SECTION_TITLE_END, "</div>");

	    noteText = noteText.replace(SECTION_START, "<div class='templateSection'>");
        noteText = noteText.replace(SECTION_END, "</div>");
        
		noteText = noteText.replace(MODULE_TITLE_START, "<div class='moduleTemplateTitle'>");
		noteText = noteText.replace(MODULE_TITLE_END, "</div>");
		
		noteText = noteText.replace(MODULE_START, "<div class='moduleTemplateText'>");
    	noteText = noteText.replace(MODULE_END, "</div>");
    	
    	noteText = noteText.replace(LINE_BREAK, "<br>");
    	return noteText;
	}
	
	private static String resolveTextType(String noteText) {
	    noteText = noteText.replace(BATTERY_HEADER_START, "\n");
        noteText = noteText.replace(BATTERY_HEADER_END, "");
        
        noteText = noteText.replace(BATTERY_FOOTER_START, "\n");
        noteText = noteText.replace(BATTERY_FOOTER_END, "");
	    
	    noteText = noteText.replace(SECTION_TITLE_START, "\n");
	    noteText = noteText.replace(SECTION_TITLE_END, "");
	    
	    noteText = noteText.replace(SECTION_START, "\n");
	    noteText = noteText.replace(SECTION_END, "");
        
        noteText = noteText.replace(MODULE_TITLE_START, "\n");
        noteText = noteText.replace(MODULE_TITLE_END, "\n");

        noteText = noteText.replace(MODULE_START, "");
        noteText = noteText.replace(MODULE_END, "");
        
        noteText = noteText.replace(LINE_BREAK, "\n");
        return noteText;
    }
}