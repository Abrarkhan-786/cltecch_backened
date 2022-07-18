package com.example.demo.servicesTest;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import com.cltech.model.ProjectModel;
import com.cltech.repository.ProjectModelRepository;

@DataJpaTest
@SpringBootTest
public class ProjectRepositoryTests {
	
	@Autowired
    private ProjectModelRepository projectModelRepository;
	

	/*
	 * @Order(1)9
	 * 
	 * @Rollback(value = false)
	 */
	@Test
    public void saveProjectTest(){

		ProjectModel projectModel = com.cltech.model.ProjectModel.builder()
				
                .projectId(1L)
                .projectName("React Js")
                .projectDescription("I happy to learn project Rract js") 
                .build();

		projectModelRepository.save(projectModel);

        Assertions.assertThat(projectModel.getProjectId()).isGreaterThan(0);
    }
	
	@Test
	 public void getExperienceTest(){

		ProjectModel projectModel = projectModelRepository.findById(1L).get();

	        Assertions.assertThat(projectModel.getProjectId()).isEqualTo(1L);

	    }
	
	@Test
	 public void getProjectList(){

	        List<ProjectModel> projectList = projectModelRepository.findAll();

	        Assertions.assertThat(projectList.size()).isGreaterThan(0);

	    }
	
	   @Test
	   public void updateProjectTest(){

		   ProjectModel projectModel = projectModelRepository.findById(1L).get();

		   projectModel.setProjectId(2L);

		   ProjectModel ProjectModel =  projectModelRepository.save(projectModel);

	        Assertions.assertThat(ProjectModel.equals(projectModel));

	    }
	   
	    @Test
	    public void deleteEmployeeTest(){

	    	ProjectModel projectModel = projectModelRepository.findById(1L).get();

	    	projectModelRepository.delete(projectModel);

	        //employeeRepository.deleteById(1L);

	    	ProjectModel projectModel1 = null;

	        Optional<ProjectModel> optionalEmployee = projectModelRepository.findById(1L);

	        if(optionalEmployee.isPresent()){
	        	projectModel1 = optionalEmployee.get();
	        }

	        Assertions.assertThat(projectModel1).isNull();
	    }



}
