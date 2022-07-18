package com.cltech.service.impl;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cltech.crud.bean.ResponseBean;

import com.cltech.model.ProjectModel;
import com.cltech.repository.ProjectModelRepository;
import com.cltech.service.ProjectService;
import com.cltech.service.PropertyService;
import com.springbootmysql.crud.constant.Status;

@Service
@Component

public class ProjectServiceImpl implements ProjectService {
	@Autowired
	@Qualifier("propertyServiceImpl")
	protected PropertyService propertyService;

	private static Logger LOGGER = LogManager.getLogger(ProjectServiceImpl.class);
	@Autowired
	ProjectModelRepository projectModelRepository;

	public ResponseBean getProject() {

		List<ProjectModel> projectList = projectModelRepository.findAll();

		if (projectList.isEmpty()) {
			return ResponseBean.builder().status(Status.FAIL).message("No Data Available").response(projectList)
					.build();
		}
		return ResponseBean.builder().status(Status.SUCCESS).message("All Records").response(projectList)
				.build();
	}

	@Override
	
	public ResponseBean saveProject(ProjectModel project_model) {
		// TODO Auto-generated method stub
		//System.out.println("Save Peoject called ");
		// propertyService.getAppProperty(GlobalConstant.ALLOWED_DECIMAL_POINTS);
		if (project_model == null) {
			return ResponseBean.builder().status(Status.FAIL).message("Data Is Null").build();
		}

		ProjectModel projectBean = projectModelRepository.save(project_model);
		return ResponseBean.builder().status(Status.SUCCESS).message("Record Added Succesfully").response(projectBean)
				.build();

	}


	@Override
	public ResponseBean getProjectList() {
	/*List<ProjectModel> list=new ArrayList<>();
	ProjectModel model=new ProjectModel();
			model.setProjectName("hello");
			list.add(model);*/
		List<ProjectModel> projectList = projectModelRepository.findAll();
		
		
		return ResponseBean.builder().status(Status.SUCCESS).message("Record Added Succesfully").response(projectList)
				.build();
		
	}

	@Override
	public ProjectModel updateProject(ProjectModel project_model) {
		
		return projectModelRepository.save(project_model);
		
	}

	@Override
	public ResponseBean DeleteById(Long id) {
		try {

			projectModelRepository.deleteById(id);
			return ResponseBean.builder().status(Status.SUCCESS).message("Deleted Successfully").build();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseBean.builder().status(Status.FAIL).message("Something Went Wrong").build();
		}

	}

	@Override
	public ResponseBean getProjectById(Long id) {
		
		ProjectModel e = projectModelRepository.findById(id).get();

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
	

	/*
	 * public ResponseBean saveAddress(AddressModel address_model) { // TODO
	 * Auto-generated method stub return null; }
	 */


