package com.cltech.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cltech.model.ExeperienceModel;
import com.cltech.repository.ExperienceModelRepository;
import com.cltech.service.ExperienceService;
import com.cltech.service.PropertyService;
import com.springbootmysql.crud.bean.ResponseBean;
import com.springbootmysql.crud.constant.Status;

@Component
public class ExperienceServiceImpl implements ExperienceService {
	@Autowired
	@Qualifier("propertyServiceImpl")
	protected PropertyService propertyService;

	private static Logger LOGGER = LogManager.getLogger(ExperienceServiceImpl.class);
	@Autowired
	ExperienceModelRepository experienceModelRepository;

	@Override
	public List<ExeperienceModel> getAllExperience() {
		// TODO Auto-generated method stub
		return experienceModelRepository.findAll();
	}

	@Override
	public ResponseBean saveExperience(ExeperienceModel experience_model) {
		// TODO Auto-generated method stub
		try {
			// propertyService.getAppProperty(GlobalConstant.ALLOWED_DECIMAL_POINTS);
			if (experience_model == null) {
				return ResponseBean.builder().status(Status.FAIL).message("Data Is Null").build();
			}

			ExeperienceModel employeeBean = experienceModelRepository.save(experience_model);
			return ResponseBean.builder().status(Status.SUCCESS).message("Record Added Succesfully")
					.response(employeeBean).build();

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseBean.builder().status(Status.FAIL).message("Something Went Wrong").build();
		}

	}

	@Override
	public List<ExeperienceModel> getExperience() {
		// TODO Auto-generated method stub
		return experienceModelRepository.findAll();
	}

	@Override
	public Optional<ExeperienceModel> findById(Long expId) {

		return experienceModelRepository.findById(expId);
	}

	@Override
	public ExeperienceModel updateExperience(ExeperienceModel e) {

		return experienceModelRepository.save(e);
	}

	public ExperienceServiceImpl(ExperienceModelRepository experienceModelRepository) {
		super();
		this.experienceModelRepository = experienceModelRepository;
	}

	@Override
	public ResponseBean deleteById(Long id) {

		try {

			experienceModelRepository.deleteById(id);
			return ResponseBean.builder().status(Status.SUCCESS).message("Deleted Successfully").build();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseBean.builder().status(Status.FAIL).message("Something Went Wrong").build();
		}

	}

	@Override
	public ResponseBean getExperienceDetailsById(Long id) {
		ExeperienceModel e = experienceModelRepository.findById(id).get();

		try {
			if (e == null) {
				return ResponseBean.builder().status(Status.FAIL).message("No Data Found With This ID").build();
			} else {
				return ResponseBean.builder().status(Status.SUCCESS).message("This is the which found from database")
						.response(e).build();

			}

		} catch (Exception e1) {
			LOGGER.error(e1.getMessage(), e);
			return ResponseBean.builder().status(Status.FAIL).message("Something Went Wrong").build();
		}
	}

}
