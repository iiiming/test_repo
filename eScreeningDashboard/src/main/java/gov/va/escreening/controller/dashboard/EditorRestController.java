package gov.va.escreening.controller.dashboard;

import gov.va.escreening.delegate.EditorsViewDelegate;
import gov.va.escreening.domain.ErrorCodeEnum;
import gov.va.escreening.dto.ae.ErrorResponse;
import gov.va.escreening.dto.editors.*;
import gov.va.escreening.exception.AssessmentEngineDataValidationException;
import gov.va.escreening.security.CurrentUser;
import gov.va.escreening.security.EscreenUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.format.ISODateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.ws.rs.NotFoundException;

@Controller
@RequestMapping(value = "/dashboard")
public class EditorRestController {

	private static final Logger logger = LoggerFactory.getLogger(EditorRestController.class);

	private EditorsViewDelegate editorsViewDelegate;

	@Autowired
	public void setEditorsViewDelegate(EditorsViewDelegate editorsViewDelegate) {
		this.editorsViewDelegate = editorsViewDelegate;
	}

	@RequestMapping(value = "/services/battery", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map addBattery(@RequestBody BatteryInfo battery,
			@CurrentUser EscreenUser escreenUser) {
		/*logger.debug("addBattery");

		if (battery != null) {
			logger.debug(battery.toString());
		}

		ErrorResponse errorResponse = new ErrorResponse();

		// Data validation.
		if (StringUtils.isBlank(battery.getName())) {
			// throw data validation exception
			errorResponse.setCode(ErrorCodeEnum.DATA_VALIDATION.getValue()).reject("data", "Battery Name", "Battery Name is required.");
		} else if (battery.getName().length() > 50) {
			// throw data validation exception
			errorResponse.setCode(ErrorCodeEnum.DATA_VALIDATION.getValue()).reject("data", "Battery Name", "Battery Name should be less than 50 characters.");
		}

		if (errorResponse.getErrorMessages() != null && errorResponse.getErrorMessages().size() > 0) {
			throw new AssessmentEngineDataValidationException(errorResponse);
		}

		// Call service class here.
		Integer batteryId = editorDelegate.createBattery(battery);
		logger.debug("batteryId: " + batteryId);*/

		return createBatteryResponse(battery);
	}

    @RequestMapping(value = "/services/batteries/{batteryId}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Map updateBattery(
            @PathVariable("batteryId") Integer batteryId,
            @RequestBody BatteryInfo battery,
            @CurrentUser EscreenUser escreenUser) {
		/*logger.debug("updateBattey");

		ErrorResponse errorResponse = new ErrorResponse();

		// Data validation.
		if (StringUtils.isBlank(battery.getName())) {
			// throw data validation exception
			errorResponse.setCode(ErrorCodeEnum.DATA_VALIDATION.getValue()).reject("data", "Battery Name", "Battery Name is required.");
		} else if (battery.getName().length() > 50) {
			// throw data validation exception
			errorResponse.setCode(ErrorCodeEnum.DATA_VALIDATION.getValue()).reject("data", "Battery Name", "Battery Name should be less than 50 characters.");
		}

		if (errorResponse.getErrorMessages() != null && errorResponse.getErrorMessages().size() > 0) {
			throw new AssessmentEngineDataValidationException(errorResponse);
		}

		// Call service class here.
		battery.setBatteryId(batteryId);
		editorDelegate.updateBattery(battery);

		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse.setCode(HttpStatus.OK.value());

		return serviceResponse;*/
        return createBatteryResponse(battery);
    }

	@RequestMapping(value = "/services/batteries/{batteryId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Map getBattery(@PathVariable("batteryId") Integer batteryId,
			@CurrentUser EscreenUser escreenUser) {
		logger.debug("getBattery");

		// Call service class here instead of hard coding it.
		BatteryInfo batteryInfo = editorsViewDelegate.getBattery(batteryId);

		return createBatteryResponse(batteryInfo);
	}

	@RequestMapping(value = "/services/batteries", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Map getBatteries(@CurrentUser EscreenUser escreenUser) {
		logger.debug("getBatteries");

		List<BatteryInfo> batteryInfoList = editorsViewDelegate.getBatteries();

		return createBatteriesResponse(batteryInfoList);
	}

    @RequestMapping(value = "/services/batteries/{batteryId}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public Map deleteBattery(@PathVariable("batteryId") Integer batteryId, @CurrentUser EscreenUser escreenUser) {
    	editorsViewDelegate.deleteBattery(batteryId);
    	return createDeleteBatterySuccessfulResponse();
    }

	@RequestMapping(value = "/services/editors/r/surveys", method = RequestMethod.GET, consumes = "*/*", produces = "application/json")
	@ResponseBody
	public List<SurveyInfo> getSurveys(@CurrentUser EscreenUser escreenUser) {
		logger.debug("getSurveys");

		List<SurveyInfo> surveyInfoList = editorsViewDelegate.getSurveys();

		return surveyInfoList;
	}

	@ExceptionHandler(AssessmentEngineDataValidationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public Map handleException(
			AssessmentEngineDataValidationException ex) {

		logger.debug(ex.toString());
		logger.debug(ex.getErrorResponse().toString());

		// returns the error response which contains a list of error messages
		//return ex.getErrorResponse().setStatus(HttpStatus.BAD_REQUEST.value());
        return createRequestFailureResponse(ex.getLocalizedMessage());
	}

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public Map handleException(NotFoundException e) {
        ErrorResponse er = new ErrorResponse();

        logger.debug(e.toString());
        logger.debug(e.getMessage());

        er.setDeveloperMessage(e.getMessage());
        er.setStatus(HttpStatus.NOT_FOUND.value());
        // returns the error response which contains a list of error messages
        //return er;
        return createRequestFailureResponse(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map handleException(Exception e) {
        ErrorResponse er = new ErrorResponse();

        logger.debug(e.toString());
        logger.debug(e.getMessage());

        er.setDeveloperMessage(e.getMessage());
        er.setStatus(HttpStatus.BAD_REQUEST.value());
        // returns the error response which contains a list of error messages
        //return er;
        return createRequestFailureResponse(e.getMessage());
    }

    @RequestMapping(value = "/services/surveySections", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map getSections(@CurrentUser EscreenUser escreenUser) {
        logger.debug("getSections");

        List<SurveySectionInfo> surveySectionInfoList = editorsViewDelegate.getSections();

        return createSectionsResponse(surveySectionInfoList);
    }

    @RequestMapping(value = "/services/surveySections/{sectionId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map getSection(
            @PathVariable("sectionId") Integer sectionId,
            @CurrentUser EscreenUser escreenUser) {
        logger.debug("getSection");

        // Call service class here instead of hard coding it.
        SurveySectionInfo surveySectionInfo = editorsViewDelegate.getSection(sectionId);

        return createSectionResponse(surveySectionInfo);
    }

    @RequestMapping(value = "/services/surveySection", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Map addSection(
            @RequestBody SurveySectionInfo surveySectionInfo,
            @CurrentUser EscreenUser escreenUser) {
        /*logger.debug("addSection");
        ErrorResponse errorResponse = new ErrorResponse();
        if (surveySectionItem != null) {
            logger.debug(surveySectionItem.toString());

            // Data validation.
            if (StringUtils.isBlank(surveySectionItem.getName())) {
                // throw data validation exception
                errorResponse.setCode(ErrorCodeEnum.DATA_VALIDATION.getValue()).reject("data", "Section Name", "Section Name is required.");
            } else if (surveySectionItem.getName().length() > 50) {
                // throw data validation exception
                errorResponse.setCode(ErrorCodeEnum.DATA_VALIDATION.getValue()).reject("data", "Section Name", "Secion Name should be less than 50 characters.");
            }

            // Call service class here.
            Integer surveySectionId = editorDelegate.createSection(surveySectionItem);
            logger.debug("surveySectionId: " + surveySectionId);
        } else {
            errorResponse.setCode(ErrorCodeEnum.DATA_VALIDATION.getValue()).reject("data", "Section Object", "Cannot be null.");
        }

        if (errorResponse.getErrorMessages() != null && errorResponse.getErrorMessages().size() > 0) {
            throw new AssessmentEngineDataValidationException(errorResponse);
        }*/

        return createSectionResponse(surveySectionInfo);
    }

	@RequestMapping(value = "/services/surveySections/{sectionId}", method = {RequestMethod.PUT}, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map updateSection(
			@PathVariable("sectionId") Integer sectionId,
			@RequestBody SurveySectionInfo surveySectionInfo,
			@CurrentUser EscreenUser escreenUser) {
		logger.debug("updateSection");
		ErrorResponse errorResponse = new ErrorResponse();
        SurveySectionInfo updatedSurveySectionInfo = null;
        if(sectionId != null) {
            // Data validation.
            if (StringUtils.isBlank(surveySectionInfo.getName())) {
                // throw data validation exception
                errorResponse.setCode(ErrorCodeEnum.DATA_VALIDATION.getValue()).reject("data", "Survey Section Name", "Section Name is required.");
            } else if (surveySectionInfo.getName().length() > 50) {
                // throw data validation exception
                errorResponse.setCode(ErrorCodeEnum.DATA_VALIDATION.getValue()).reject("data", "Survey Section Name", "Section Name should be less than 50 characters.");
            }

            if (errorResponse.getErrorMessages() != null && errorResponse.getErrorMessages().size() > 0) {
                throw new AssessmentEngineDataValidationException(errorResponse);
            }

            // Call service class here.
            surveySectionInfo.setSurveySectionId(sectionId);
            updatedSurveySectionInfo = editorsViewDelegate.updateSection(surveySectionInfo);
        }

        return createSectionResponse(updatedSurveySectionInfo);
	}

	@RequestMapping(value = "/services/surveySections/{sectionId}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public Map deleteSection(
			@PathVariable("sectionId") Integer sectionId,
			@CurrentUser EscreenUser escreenUser) {
		editorsViewDelegate.deleteSection(sectionId);
        return createDeleteSectionSuccessfulResponse();
	}

	private Map createSectionsResponse(List<SurveySectionInfo> surveySectionInfoList) {

		Map status = new HashMap();
		status.put("message", "The Quick Brown fox jumps over the lazy dog");
		status.put("status", surveySectionInfoList != null && !surveySectionInfoList.isEmpty() ? "succeeded" : "failed");

		Map surveySectionItems = new HashMap();
		//surveySectionItems.put("surveySections", createSurveySectionList(surveySectionItemList));
        surveySectionItems.put("surveySections", surveySectionInfoList);

		Map responseMap = new HashMap();
		responseMap.put("status", status);
		responseMap.put("payload", surveySectionItems);

		return responseMap;
	}

    private Map createRequestFailureResponse(String message) {
        Map status = new HashMap();
        status.put("message", message);
        status.put("status", "failed");

        Map responseMap = new HashMap();
        responseMap.put("status", status);
        responseMap.put("payload", new HashMap());

        return responseMap;
    }

    private Map createDeleteSectionSuccessfulResponse() {
        Map status = new HashMap();
        status.put("message", "Section deleted successfully.");
        status.put("status", "succeeded");

        Map responseMap = new HashMap();
        responseMap.put("status", status);
        responseMap.put("payload", new HashMap());

        return responseMap;
    }

    private Map createDeleteBatterySuccessfulResponse() {
        Map status = new HashMap();
        status.put("message", "Battery deleted successfully.");
        status.put("status", "succeeded");

        Map responseMap = new HashMap();
        responseMap.put("status", status);
        responseMap.put("payload", new HashMap());

        return responseMap;
    }


    private Map createSectionResponse(SurveySectionInfo surveySection) {
        Map status = new HashMap();
        status.put("message", "The Quick Brown fox jumps over the lazy dog");
        status.put("status", (surveySection != null && surveySection.getSurveySectionId() != null)? "succeeded" : "failed");

        Map surveySectionItems = new HashMap(           );
        surveySectionItems.put("surveySection", surveySection);

        Map responseMap = new HashMap();
        responseMap.put("status", status);
        responseMap.put("payload", surveySectionItems);

        return responseMap;
    }

    private Map createBatteryResponse(BatteryInfo batteryInfo) {
        Map status = new HashMap();
        status.put("message", (batteryInfo != null && batteryInfo.getBatteryId() != null)? null : "The Quick Brown fox jumps over the lazy dog");
        status.put("status", (batteryInfo != null && batteryInfo.getBatteryId() != null)? "succeeded" : "failed");

        Map batteryMap = new HashMap();
        batteryMap.put("battery", batteryInfo);

        Map responseMap = new HashMap();
        responseMap.put("status", status);
        responseMap.put("payload", batteryMap);

        return responseMap;
    }

    private Map createBatteriesResponse(List<BatteryInfo> batteryInfoList) {
        Map status = new HashMap();
        status.put("message", batteryInfoList != null && !batteryInfoList.isEmpty() ? null : "The Quick Brown fox jumps over the lazy dog");
        status.put("status", batteryInfoList != null && !batteryInfoList.isEmpty() ? "succeeded" : "failed");

        Map surveySectionItems = new HashMap();
        surveySectionItems.put("batteries", batteryInfoList);

        Map responseMap = new HashMap();
        responseMap.put("status", status);
        responseMap.put("payload", surveySectionItems);

        return responseMap;
    }
}
