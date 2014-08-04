package gov.va.escreening.service;

import gov.va.escreening.domain.BatteryDto;
import gov.va.escreening.dto.DropDownObject;
import gov.va.escreening.dto.editors.BatteryInfo;
import gov.va.escreening.dto.editors.SurveyInfo;
import gov.va.escreening.entity.Battery;
import gov.va.escreening.entity.Program;
import gov.va.escreening.entity.ProgramBattery;
import gov.va.escreening.entity.Survey;
import gov.va.escreening.repository.BatteryRepository;
import gov.va.escreening.repository.ProgramBatteryRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class BatteryServiceImpl implements BatteryService {

	private BatteryRepository batteryRepository;
	private ProgramBatteryRepository programBatteryRepository;
	private SurveyService surveyService;

	@Autowired
	public void setBatteryRepository(BatteryRepository batteryRepository) {
		this.batteryRepository = batteryRepository;
	}

	@Autowired
	public void setSurveyService(SurveyService surveyService) {
		this.surveyService = surveyService;
	}

	public BatteryServiceImpl() {
		// Default constructor
	}

	@Transactional(readOnly = true)
	@Override
	public List<DropDownObject> getBatteryList() {

		List<DropDownObject> dropDownObjectList = new ArrayList<DropDownObject>();

		List<Battery> batteryList = batteryRepository.getBatteryList();

		for (Battery battery : batteryList) {
			dropDownObjectList.add(new DropDownObject(battery.getBatteryId().toString(), battery.getName()));
		}

		return dropDownObjectList;
	}

	@Override
	public BatteryInfo create(BatteryInfo batteryInfo) {
		Battery battery = new Battery();

		battery.setName(batteryInfo.getName());
		battery.setDescription(batteryInfo.getDescription());
		battery.setDisabled(batteryInfo.isDisabled());

		if (batteryInfo.getSurveys() != null && batteryInfo.getSurveys().size() > 0) {
			List<Survey> surveyList = new ArrayList<Survey>();

			for (SurveyInfo surveyInfo : batteryInfo.getSurveys()) {
				if (surveyInfo.getIsIncludedInBattery()) {
					surveyList.add(surveyService.findOne(surveyInfo.getSurveyId()));
				}
			}

			if (surveyList.size() > 0) {
				battery.setSurveys(new HashSet<Survey>(surveyList));
			}
		}

		batteryRepository.create(battery);

		batteryInfo.setBatteryId(battery.getBatteryId());

		return batteryInfo;
	}

	@Transactional(readOnly = true)
	@Override
	public List<BatteryInfo> getBatteryItemList() {

		List<BatteryInfo> batteryInfoList = new ArrayList<BatteryInfo>();

		List<Battery> batteryList = batteryRepository.getBatteryList();

		for (Battery battery : batteryList) {
			batteryInfoList.add(convertToBatteryItem(battery));
		}

		return batteryInfoList;
	}

	@Override
	public void update(BatteryInfo batteryInfo) {

		Battery battery = batteryRepository.findOne(batteryInfo.getBatteryId());

		battery.setName(batteryInfo.getName());
		battery.setDescription(batteryInfo.getDescription());
		battery.setDisabled(batteryInfo.isDisabled());
        //battery.setSurveys(batteryInfo.getSurveys());

		/*// Get only the ones we want to keep/add.
		HashSet<Integer> newIds = new HashSet<Integer>();

		if (batteryInfo.getSurveys() != null && batteryInfo.getSurveys().size() > 0) {
			for (SurveyInfo surveyInfo : batteryInfo.getSurveys()) {
				if (surveyInfo.getIsIncludedInBattery()) {
					newIds.add(surveyInfo.getSurveyId());
				}
			}
		}

		if (newIds.size() > 0 && battery.getSurveys() == null) {
			battery.setSurveys(new HashSet<Survey>());
		}

		//
		HashSet<Integer> existingIds = new HashSet<Integer>();

		// Remove old
		if (battery.getSurveys() != null && battery.getSurveys().size() > 0) {

			Iterator<Survey> itr = battery.getSurveys().iterator();

			while (itr.hasNext()) {
				Survey survey = itr.next();

				if (!newIds.contains(survey.getSurveyId())) {
					itr.remove();
				} else {
					existingIds.add(survey.getSurveyId());
				}

			}
		}

		// Add new
		for (Integer surveyId : newIds) {
			if (!existingIds.contains(surveyId)) {
				battery.getSurveys().add(surveyService.findOne(surveyId));
			}
		}*/

		batteryRepository.update(battery);
	}

	public BatteryInfo convertToBatteryItem(Battery battery) {

		if (battery == null) {
			return null;
		}

		BatteryInfo batteryInfo = new BatteryInfo();
		batteryInfo.setBatteryId(battery.getBatteryId());
		batteryInfo.setName(battery.getName());
		batteryInfo.setDisabled(battery.isDisabled());
		batteryInfo.setDescription(battery.getDescription());
		batteryInfo.setDateCreated(battery.getDateCreated());

		return batteryInfo;
	}

	@Transactional(readOnly = true)
	@Override
	public List<BatteryDto> getBatteryDtoList() {

		List<BatteryDto> batteryDtoList = new ArrayList<BatteryDto>();

		List<Battery> batteryList = batteryRepository.getBatteryList();

		for (Battery battery : batteryList) {
			BatteryDto batterycDto = new BatteryDto();
			batterycDto.setBatteryId(battery.getBatteryId());
			batterycDto.setBatteryName(battery.getName());
			batteryDtoList.add(batterycDto);
		}

		return batteryDtoList;

	}

	@Override
	public List<Program> getProgramsForBattery(int batteryId) {
		List<ProgramBattery> progBatts = this.programBatteryRepository.findAllByBatteryId(batteryId);
		List<Program> ps = new ArrayList<Program>();
		for (ProgramBattery pb : progBatts) {
			ps.add(pb.getProgram());
		}
		return ps;
	}

	@Autowired
	public void setProgramBatteryRepository(
			ProgramBatteryRepository programBatteryRepository) {
		this.programBatteryRepository = programBatteryRepository;
	}

	@Transactional
	@Override
	public void delete(Integer batteryId) {
		batteryRepository.deleteById(batteryId);
	}
}
